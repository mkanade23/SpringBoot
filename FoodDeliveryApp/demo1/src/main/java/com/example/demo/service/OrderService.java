package com.example.demo.service;


import com.example.demo.dao.OrderDAO;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    
    private final OrderDAO orderDAO;
    
    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    
    public Order createOrder(Order order) {
        orderDAO.createOrder(order);
        return order;
    }
    
    public Order viewOrder(Integer orderId)  {
        Optional<Order> opt = orderDAO.findById(orderId);
        if(opt.isPresent()) {
            Order order = opt.get();
            return order;
        }
        return null;
    }
    
    public boolean removeOrder(Integer orderId)  {
        return orderDAO.removeOrderById(orderId);
       
    }
    
    public boolean updateOrder(Order order) {
        boolean isUpdated = orderDAO.updateOrderById(order);
        return isUpdated;
    }
    
    
    
    public List<Order> viewAllOrders()  {
        List<Order> orderList = orderDAO.viewAllOrders();
        return orderList;
        
    }
    
    // Other methods...
}
