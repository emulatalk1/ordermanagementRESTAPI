package com.vnspectre.ordermanagement.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {

    private final long id;
    private final String description;
    private final long costInCents;
    private final boolean isCompleate;

    public OrderResource(long id, String description, long costInCents, boolean isCompleate) {
        this.id = id;
        this.description = description;
        this.costInCents = costInCents;
        this.isCompleate = isCompleate;
    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getCostInCents() {
        return costInCents;
    }

    public boolean isCompleate() {
        return isCompleate;
    }
}
