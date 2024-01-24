package com.example.shippingapp.dao;

import com.example.shippingapp.model.Availability;
import com.example.shippingapp.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AvailabilityDao {
    
    private final DataSource dataSource;
    @Autowired
    public AvailabilityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void createAvailability(Availability availability)  {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT into availability VALUES (default,?,?,?)")){
            preparedStatement.setInt(1, availability.getStaffId());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(availability.getAvailableDateStart()));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(availability.getAvailableDateEnd()));
            
            preparedStatement.executeUpdate();
            
        }
        catch(SQLException e){
            System.out.println("Exception has ooccuref"+ e.toString());
        }
    
    }
    
    public  List<Availability> findById(Integer staffId){
        List<Availability> availabilityList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from availability where staffId=?")){
            preparedStatement.setInt(1, staffId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Timestamp start = resultSet.getTimestamp(3);
                Timestamp end = resultSet.getTimestamp(4);
                Availability availability = new Availability(resultSet.getInt(1),staffId, start.toLocalDateTime(),end.toLocalDateTime()) ;
                availabilityList.add(availability);
            }
            
        }
        catch(SQLException e){
            System.out.println("Exception has ooccuref"+ e.toString());
        }
        return availabilityList;
        
    }
    
    
    
    /*public boolean removeAvailabilityById(Integer staffId){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete  from staff where id=?")){
            preparedStatement.setInt(1, staffId);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows>=1){
                return true;
            }
            
            
        }
        catch(SQLException e){
            System.out.println("Exception has ooccuref"+ e.toString());
        }
        return false;
    }
    
    public boolean updateStaff(Staff staff){
         Staff existingStaff = findById(staff.getId());
        if(existingStaff == null)
            return false;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update staff set name=?, phone=? where id=?")){
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getPhone());
            preparedStatement.setInt(3, staff.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows>=1){
                return true;
            }
            
            
        }
        catch(SQLException e){
            System.out.println("Exception has ooccuref"+ e.toString());
        }
        return false;
    }
    
    public List<Staff> viewAllStaff(){
        List<Staff> staffList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from staff")) {
        while(resultSet.next()){
            Staff staff = new Staff(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)) ;
            staffList.add(staff);
        }
        }
        
        
        catch(SQLException e){
            System.out.println("Exception has ooccuref"+ e.toString());
        }
        return staffList;
    }
    */
    
    
    
}
