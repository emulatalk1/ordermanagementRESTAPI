package com.vnspectre.ordermanagement.resource;

import com.vnspectre.ordermanagement.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;

public class OrderResourceAssembler extends ResourceAssembler<Order, OrderResource> {

    @Autowired
    protected EntityLinks mEntityLinks;

    private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";

    @Override
    public OrderResource toResource(Order order) {
        OrderResource resource = new OrderResource(order);
        final Link sefLink = mEntityLinks.linkToSingleResource(order);
        resource.add(sefLink.withSelfRel());
        resource.add(sefLink.withRel(UPDATE_REL));
        resource.add(sefLink.withRel(DELETE_REL));

        return resource;
    }
}
