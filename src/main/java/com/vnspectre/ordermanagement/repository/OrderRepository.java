package com.vnspectre.ordermanagement.repository;

import com.vnspectre.ordermanagement.domain.Order;

public class OrderRepository extends InMemoryRepository<Order> {
    @Override
    protected void updateIfExists(Order original, Order updated) {
        original.setDescription(updated.getDescription());
        original.setCostInCents(updated.getCostInCents());
        original.setComplete(updated.isComplete());
    }
}
