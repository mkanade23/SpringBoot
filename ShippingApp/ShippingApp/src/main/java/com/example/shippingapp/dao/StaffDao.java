package com.example.shippingapp.dao;

import com.example.shippingapp.model.Staff;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StaffDao {
    
    private final DataSource dataSource;
    @Autowired
    public StaffDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void createStaff(Staff staff)  {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT into staff VALUES (default,?,?)")){
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getPhone());
            preparedStatement.executeUpdate();
            
        }
        catch(SQLException e){
            System.out.println("Exception has ooccuref"+ e.toString());
        }
    
    }
    
    public Staff findById(Integer staffId){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from staff where id=?")){
            preparedStatement.setInt(1, staffId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Staff staff = new Staff(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)) ;
                return staff;
            }
            
        }
        catch(SQLException e){
            System.out.println("Exception has ooccuref"+ e.toString());
        }
        return null;
        
    }
    
    public  List<Integer> getAvailableStaff(LocalDateTime dateTime){
        List<Integer> staffIds = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select DISTINCT  staffId from availability where (availableDateStart <= ? AND availableDateEnd>=? )")){
            preparedStatement.setTimestamp(1, Timestamp.valueOf(dateTime));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(dateTime));
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer staffId= resultSet.getInt(1) ;
                 staffIds.add(staffId);
            }
            
        }
        catch(SQLException e){
            System.out.println("Exception has ooccuref"+ e.toString());
        }
        return staffIds;
        
    }
    
    public boolean removeStaffById(Integer staffId){
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
    
    
    
    
}
