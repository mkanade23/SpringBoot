package com.example.shippingapp.controller;

import com.example.shippingapp.model.Staff;
import com.example.shippingapp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class StaffController {
    private final StaffService staffService;
    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    
    @RequestMapping("/")
    public String home(){
        return "staffHome";
    }
    
    @PostMapping("/createStaff")
    public String createStaff(Staff staff){
        staffService.createStaff(staff);
        return "createStaffSuccess";
    }
    
    @PostMapping("/updateStaffById")
    public String updateStaff(Staff staff, Model model){
        boolean bool = staffService.updateStaff(staff);
        model.addAttribute("isUpdated", bool);
        return "updateStaffSuccess";
    }
    
    @GetMapping("/getStaffById")
    public String getStaffById(Integer staffId, Model model){
        Staff staff = staffService.viewStaffById(staffId);
        if(staff != null) {
            model.addAttribute("staffId", staff.getId());
            model.addAttribute("staffName", staff.getName());
            model.addAttribute("staffPhone", staff.getPhone());
        }
        return "getStaffSuccess";
    }
    
    @PostMapping("/removeStaffByStaffId")
    public String removeStaffByStaffId(Integer staffId, Model model){
        boolean bool = staffService.removeStaffById(staffId);
        model.addAttribute("isRemoved", bool);
        return "removeStaffSuccess";
    }
    
   
    
    @GetMapping("/getAvailableStaff")
    public String getAvailableStaff(@RequestParam("datetime") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime, Model model){
        List<Integer> staffList = staffService.getAvailableStaff(dateTime);
        model.addAttribute("staffList", staffList);
        return "availableStaffSuccess";
    }
    
    
    
    @PostMapping("/checkAvailability")
    public String checkAvailability(){
        return "getAvailableStaff";
    }
    
    @PostMapping("/addStaff")
    public String addStaff(){
        return "createStaff";
    }
    
    @PostMapping("/getStaff")
    public String getStaff(){
        return "getStaff";
    }
    
    @PostMapping("/removeStaff")
    public String removeStaff(){
        return "removeStaff";
    }
    @PostMapping("/updateStaff")
    public String updateStaff(){
        return "updateStaff";
    }
    
    @PostMapping("/createAvailability")
    public String createAvailability(){
        return "createAvailability";
    }
    
    @PostMapping("/getAvailability")
    public String getAvailability(){
        return "getAvailability";
    }
    
    @PostMapping("/getAllStaff")
    public String getAllStaff(Model model){
        List<Staff> staffList= staffService.viewAllStaff();
        model.addAttribute("staffList", staffList);
        return "viewAllStaff";
    }
    
}
