package com.contact.form.service;

import com.contact.form.entity.Order;
import com.contact.form.request.OrderRequest;

public interface OrderInterface {
    Order saveOrder(OrderRequest orderRequest);
}
