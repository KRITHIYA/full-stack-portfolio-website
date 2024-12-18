package com.contact.form.service;

import com.contact.form.entity.Order;
import com.contact.form.repository.OrderRepository;
import com.contact.form.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Save order with "Pending Payment" status
    public Order saveOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setName(orderRequest.getName());
        order.setEmail(orderRequest.getEmail());
        order.setInstructions(orderRequest.getInstructions());
        order.setDeadline(orderRequest.getDeadline());
        order.setAmount(orderRequest.getAmount());
        order.setPlantype(orderRequest.getPlanType());
        order.setStatus("Pending Payment");
        return orderRepository.save(order);
    }

    // Mark the order as "Paid"
    public boolean markOrderAsPaid(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus("Pending");
            orderRepository.save(order);
            return true;
        }
        return false;
    }
}

