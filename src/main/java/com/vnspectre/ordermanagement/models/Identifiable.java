package com.vnspectre.ordermanagement.models;

public interface Identifiable extends org.springframework.hateoas.Identifiable<Long> {
    void setId(Long id);
}
