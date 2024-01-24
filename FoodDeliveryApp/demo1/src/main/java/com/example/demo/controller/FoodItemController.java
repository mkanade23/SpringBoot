package com.example.demo.controller;

import com.example.demo.model.FoodItem;
import com.example.demo.model.Order;
import com.example.demo.service.FoodItemService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FoodItemController {
    private final FoodItemService foodItemService;
    
    @Autowired
    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }
    
    @PostMapping("/createFoodItem")
    public String createFoodItem(FoodItem foodItem, Model model) {
        foodItemService.createFoodItem(foodItem);
        model.addAttribute("foodItemId", foodItem.getItemId());
        return "fooditem/createFoodItemSuccess";
    }
    
    
    @PostMapping("/updateFoodItem")
    public String updateFoodItem(FoodItem foodItem, Model model) {
        
        boolean isUpdated = foodItemService.updateFoodItem(foodItem);
        model.addAttribute("isUpdated", isUpdated);
        return "fooditem/updateFoodItemSuccess";
        
    }
    
    @GetMapping("/viewFoodItem")
    public String viewFoodItem( Integer itemId, Model model) {
        
        FoodItem foodItem = foodItemService.viewFoodItem(itemId);
        if(foodItem == null){
            model.addAttribute("itemId", null);
            
        } else {
            model.addAttribute("itemId", foodItem.getItemId());
            model.addAttribute("itemName", foodItem.getItemName());
            model.addAttribute("itemCost", foodItem.getCost());
        }
        
        return "/fooditem/getFoodItemSuccess";
        
    }
    
    @PostMapping("/removeFoodItem")
    public String deleteFoodItem(Integer removeItemId) {
        foodItemService.removeFoodItem(removeItemId);
        return "/fooditem/deleteFoodItemSuccess";
    }
    
    @GetMapping("/viewAllFoodItems")
    public String viewAllFoodItem(Model model){
        List<FoodItem> foodItemList = foodItemService.viewAllFoodItems();
        model.addAttribute("foodItemList", foodItemList);
        return "/fooditem/viewAllFoodItems";
        
    }
    
    @PostMapping("/createFoodItemForm")
    public String createFoodItemForm() {
        return "/fooditem/createFoodItemForm";
    }
    
    @PostMapping("/deleteFoodItemForm")
    public String deleteFoodItemForm() {
        return "/fooditem/deleteFoodItemForm";
    }
    
    @PostMapping("/getFoodItemForm")
    public String getFoodItemForm() {
        return "/fooditem/getFoodItemForm";
    }
    @PostMapping("/updateFoodItemForm")
    public String updateFoodItemForm() {
        return "/fooditem/updateFoodItemForm";
    }
    
}
