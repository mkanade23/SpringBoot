package com.example.shippingapp.controller;

import com.example.shippingapp.dao.AvailabilityDao;
import com.example.shippingapp.model.Availability;
import com.example.shippingapp.model.Staff;
import com.example.shippingapp.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AvailabilityController {
    private final AvailabilityService availabilityService;
    @Autowired
    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }
    
    @PostMapping("/createAvailabilityForStaff")
    public String createAvailability(Availability availability){
        availabilityService.createAvailability(availability);
        return "createAvailabilitySuccess";
    }
    
    @GetMapping("/getAvailabilityById")
    public String getAvailability( Integer staffId, Model model){
        List<Availability> availabilityList = availabilityService.getAvailability(staffId);
        model.addAttribute("availabilityList",availabilityList);
        return "getAvailabilitySuccess";
    }
}
