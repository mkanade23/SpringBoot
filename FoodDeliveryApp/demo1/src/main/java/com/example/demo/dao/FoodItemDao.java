package com.example.demo.dao;

import com.example.demo.model.FoodItem;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodItemDao {
    private final DataSource dataSource;
    @Autowired
    public FoodItemDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void createFoodItem(FoodItem foodItem) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO foodItem VALUES (default,?,?)", Statement.RETURN_GENERATED_KEYS )) {
            
            preparedStatement.setString(1, foodItem.getItemName());
            preparedStatement.setDouble(2, foodItem.getCost());
            
            int affectedRows = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                int itemId = resultSet.getInt(1);
                foodItem.setItemId(itemId);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
    }
    
    public Optional<FoodItem> findById(Integer itemId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from foodItem where itemId=?")) {
            preparedStatement.setInt(1, itemId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                FoodItem foodItem = new FoodItem(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
                return Optional.of(foodItem);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
        return Optional.empty();
    }
    
    public boolean removeFoodItemById(Integer itemId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "delete from foodItem where itemId=?")) {
            preparedStatement.setInt(1, itemId);
            
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows >=1 ){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
        return false;
    }
    
    public boolean updateFoodItemById(FoodItem foodItem) {
        Optional<FoodItem> optionalOrder = findById(foodItem.getItemId());
        if(optionalOrder.isPresent()) {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "update foodItem set itemName=? , cost=? where itemId=?")) {
                preparedStatement.setString(1, foodItem.getItemName());
                preparedStatement.setDouble(2, foodItem.getCost());
                preparedStatement.setInt(3, foodItem.getItemId());
                
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows >= 1) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception based on your application's needs
            }
        }
        return false;
    }
    
    public List<FoodItem> viewAllFoodItems(){
        List<FoodItem> foodItemList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from foodItem")) {
            while (resultSet.next()) {
                FoodItem foodItem = new FoodItem(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
                foodItemList.add(foodItem);
            }
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return foodItemList;
    }
}
