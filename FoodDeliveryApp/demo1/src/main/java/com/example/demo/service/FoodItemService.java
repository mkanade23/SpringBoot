package com.example.demo.service;

import com.example.demo.dao.FoodItemDao;
import com.example.demo.model.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {
    private final FoodItemDao foodItemDao;
    
    @Autowired
    public FoodItemService(FoodItemDao foodItemDao) {
        this.foodItemDao = foodItemDao;
    }
    
    public FoodItem createFoodItem(FoodItem foodItem) {
        foodItemDao.createFoodItem(foodItem);
        return foodItem;
    }
    
    public FoodItem viewFoodItem(Integer itemId)  {
        Optional<FoodItem> opt = foodItemDao.findById(itemId);
        if(opt.isPresent()) {
            FoodItem foodItem = opt.get();
            return foodItem;
        }
        return null;
    }
    
    public boolean removeFoodItem(Integer itemId)  {
        return foodItemDao.removeFoodItemById(itemId);
        
    }
    
    public boolean updateFoodItem(FoodItem foodItem) {
        boolean isUpdated = foodItemDao.updateFoodItemById(foodItem);
        return isUpdated;
    }
    
    public List<FoodItem> viewAllFoodItems()  {
        List<FoodItem> foodItemList = foodItemDao.viewAllFoodItems();
        return foodItemList;
        
    }
}
