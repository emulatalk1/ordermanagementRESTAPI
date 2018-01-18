package com.vnspectre.ordermanagement.controller;

import com.vnspectre.ordermanagement.domain.Order;
import com.vnspectre.ordermanagement.repository.OrderRepository;
import com.vnspectre.ordermanagement.resource.OrderResource;
import com.vnspectre.ordermanagement.resource.OrderResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") //provides for support of Cross Origin Resource Sharing (CORS)
@RestController
@ExposesResourceFor(Order.class) //denotes that if a link is needed to an Order object
@RequestMapping(value = "/order", produces = "application/json")
public class OrderController {

    @Autowired
    private OrderRepository mRepository;

    @Autowired
    private OrderResourceAssembler mAssember;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<OrderResource>> findAllOrders() {
        List<Order> orders = mRepository.findAll();
        return new ResponseEntity<>(mAssember.toResourceCollection(orders), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<OrderResource> createOrder(@RequestBody Order order) {
        Order createdOrder = mRepository.create(order);
        return new ResponseEntity<>(mAssember.toResource(createdOrder), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderResource> findOrderById(@PathVariable Long id) {
        Optional<Order> order = mRepository.findById(id);
        if (order.isPresent()) {
            return new ResponseEntity<>(mAssember.toResource(order.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean wasDeleted = mRepository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<OrderResource> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        boolean wasUpdated = mRepository.update(id, updatedOrder);
        if (wasUpdated) {
            return findOrderById(id);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
