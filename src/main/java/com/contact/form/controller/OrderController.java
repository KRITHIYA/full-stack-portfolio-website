    package com.contact.form.controller;

    import com.contact.form.entity.Order;
    import com.contact.form.request.ContactRequest;
    import com.contact.form.request.OrderRequest;
    import com.contact.form.service.OrderService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.HashMap;
    import java.util.Map;

    @Controller
    @RequestMapping("/order")
    public class OrderController {

        @Autowired
        OrderService orderService;

        @GetMapping("/{planType}")
        public String showForm(@PathVariable String planType, Model model) {
            OrderRequest orderRequest = new OrderRequest();
            orderRequest.setPlanType(planType);

            // Set amount based on the plan type
            switch (planType) {
                case "basic1":
                    orderRequest.setAmount("2999");
                    break;
                case "premium1":
                    orderRequest.setAmount("6999");
                    break;
                case "basic2":
                    orderRequest.setAmount("2000");
                    break;
                case "premium2":
                    orderRequest.setAmount("7999");
                    break;
            }

            model.addAttribute("order", orderRequest);
            return planType; // Use planType as the Thymeleaf template name
        }

        @PostMapping("/{planType}")
        public String createOrder(@ModelAttribute OrderRequest orderRequest, Model model) {
            Order savedOrder = orderService.saveOrder(orderRequest);

            // Generate UPI URL
            String upiID = "9342499334@ptaxis";
            String payeeName = "Krithiya";
            String transactionNote = "Service Payment: " + orderRequest.getPlanType();
            String upiURL = String.format(
                    "upi://pay?pa=%s&pn=%s&tn=%s&am=%s&cu=INR",
                    upiID, payeeName, transactionNote, orderRequest.getAmount()
            );

            // Pass data to frontend
            model.addAttribute("upiURL", upiURL);
            model.addAttribute("orderId", savedOrder.getId());
            model.addAttribute("message", "Order created successfully. Complete the payment to proceed.");

            return "submitsuccess";
        }
    }

