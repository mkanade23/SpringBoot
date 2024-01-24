package com.example.shippingapp.service;

import com.example.shippingapp.dao.StaffDao;
import com.example.shippingapp.model.Staff;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StaffService {
    private final StaffDao staffDao;
    @Autowired
    public StaffService(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public void createStaff(Staff staff){
        staffDao.createStaff(staff);
    }
    
    public Staff viewStaffById(Integer staffId){
        Staff staff = staffDao.findById(staffId);
        return staff;
    }
    
    public List<Integer> getAvailableStaff(LocalDateTime dateTime){
        List<Integer> staffList = staffDao.getAvailableStaff(dateTime);
        return staffList;
    }
    
    public boolean removeStaffById(Integer staffId){
       return staffDao.removeStaffById(staffId);
       
    }
    
    public boolean updateStaff(Staff staff){
        return staffDao.updateStaff(staff);
    }
    
    public List<Staff> viewAllStaff(){
        return  staffDao.viewAllStaff();
    }
}
