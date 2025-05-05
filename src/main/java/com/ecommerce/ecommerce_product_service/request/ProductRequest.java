package com.ecommerce.ecommerce_product_service.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequest {
    private int id;
    private String name;
    private String description;
    private int price;
    private int mrp;
    private int stockQuantity;
    private String category;
    private String size;
    private String color;
    private String imageUrl;
    private boolean isActive;
}
