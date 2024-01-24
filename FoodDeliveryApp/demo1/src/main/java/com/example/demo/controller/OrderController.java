package com.example.demo.controller;


import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    
    private final OrderService orderService;
    
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @RequestMapping("/")
    public String home() {
        return "index";
    }
    
    
    @PostMapping("/createOrder")
    public String createOrder(Order order, Model model) {
        orderService.createOrder(order);
        model.addAttribute("orderId", order.getId());
        return "createOrderSuccess";
    }
    
    
    @PostMapping("/updateOrder")
    public String updateOrder(Order order, Model model) {
        
        boolean isUpdated = orderService.updateOrder(order);
        model.addAttribute("isUpdated", isUpdated);
        return "updateOrderSuccess";
       
    }
    
    @GetMapping("/viewOrder")
    public String viewOrder( Integer orderId, Model model) {
        
        Order order = orderService.viewOrder(orderId);
        if(order == null){
            model.addAttribute("orderId", null);
            
        } else {
            model.addAttribute("orderId", order.getId());
            model.addAttribute("userId", order.getUserId());
            model.addAttribute("itemId", order.getItemId());
            model.addAttribute("amount", order.getOrderAmount());
            model.addAttribute("quantity", order.getQuantity());
        }
        
        return "getOrderSuccess";
        
    }
    
    @PostMapping("/removeOrder")
    public String deleteOrder(Integer removeOrderId) {
        orderService.removeOrder(removeOrderId);
        return "deleteOrderSuccess";
    }
    
    @GetMapping("/viewAllOrders")
    public String viewAllOrders(Model model){
        List<Order> orderList = orderService.viewAllOrders();
        model.addAttribute("orderList", orderList);
        return "viewAllOrder";
        
    }
    
    @PostMapping("/createOrderForm")
    public String createOrderForm() {
        return "createOrderForm";
    }
    
    @PostMapping("/deleteOrderForm")
    public String deleteOrderForm() {
        return "deleteOrderForm";
    }
    
    @PostMapping("/getOrderForm")
    public String getOrderForm() {
        return "getOrderForm";
    }
    @PostMapping("/updateOrderForm")
    public String updateOrderForm() {
        return "updateOrderForm";
    }
    @PostMapping("/orderHome")
    public String viewOrderHome() {
        return "home";
    }
    @PostMapping("/foodItemHome")
    public String viewFoodItemHome() {
        return "foodItemHome";
    }
}