package com.example.shippingapp.service;

import com.example.shippingapp.dao.AvailabilityDao;
import com.example.shippingapp.model.Availability;
import com.example.shippingapp.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AvailabilityService {
    private final AvailabilityDao availabilityDao;
    @Autowired
    public AvailabilityService(AvailabilityDao availabilityDao) {
        this.availabilityDao = availabilityDao;
    }
    
    public void createAvailability(Availability availability){
        
        availabilityDao.createAvailability(availability);
    }
    
    public List<Availability> getAvailability(Integer staffId){
        
        return availabilityDao.findById(staffId);
    }
    
}
