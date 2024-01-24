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
public class OrderDAO {
    
    private final DataSource dataSource;
    private final FoodItemDao foodItemDao;
    
    @Autowired
    public OrderDAO(DataSource dataSource, FoodItemDao foodItemDao) {
        this.dataSource = dataSource;
        this.foodItemDao = foodItemDao;
    }
    
    public void createOrder(Order order) {
        
        try (Connection connection = dataSource.getConnection();
             
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO `order` VALUES (default,?,?,?,?)",Statement.RETURN_GENERATED_KEYS )) {
            Optional<FoodItem> item = foodItemDao.findById(order.getItemId());
            if(item.isEmpty())
                return;
            double amount = item.get().getCost() * order.getQuantity();
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setInt(2, order.getItemId());
            preparedStatement.setDouble(3, amount);
            preparedStatement.setInt(4, order.getQuantity());
            
            int affectedRows = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                int orderId = resultSet.getInt(1);
                order.setId(orderId);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
    }
    
    public Optional<Order> findById(Integer orderId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from `order` where id=?")) {
            preparedStatement.setInt(1, orderId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               Order order = new Order(resultSet.getInt(1), resultSet.getInt(3),resultSet.getInt(2), resultSet.getDouble(4), resultSet.getInt(5));
               return Optional.of(order);
           }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
        return Optional.empty();
    }
    
    public boolean removeOrderById(Integer orderId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "delete from `order` where id=?")) {
            preparedStatement.setInt(1, orderId);
            
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows >1 ){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }
        return false;
    }
    
    public boolean updateOrderById(Order order) {
        Optional<Order> optionalOrder = findById(order.getId());
        Optional<FoodItem> item = foodItemDao.findById(order.getItemId());
        if(item.isEmpty())
            return false;
        double amount = item.get().getCost() * order.getQuantity();
        if(optionalOrder.isPresent()) {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "update `order` set itemId=?, amount=? , quantity=? where id=?")) {
                preparedStatement.setDouble(1, order.getItemId());
                preparedStatement.setDouble(2, amount);
                preparedStatement.setInt(3, order.getQuantity());
                preparedStatement.setInt(4, order.getId());
                
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
    
    public List<Order> viewAllOrders(){
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from `order`")) {
            while (resultSet.next()) {
                Order order = new Order(resultSet.getInt(1), resultSet.getInt(3), resultSet.getInt(2), resultSet.getDouble(4), resultSet.getInt(5));
                orderList.add(order);
            }
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
     
        return orderList;
    }
    
    
    // Other methods...
}
