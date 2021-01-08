package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.entites.Order;
import com.gen.com.Insurance_portal.repositories.OrderRepository;
import com.gen.com.Insurance_portal.services.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService<Order> implements IOrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }
}
