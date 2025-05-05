package com.ecommerce.ecommerce_product_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce_product_service.entity.ProductEntity;
import com.ecommerce.ecommerce_product_service.request.ProductRequest;
import com.ecommerce.ecommerce_product_service.response.SuccessResponse;
import com.ecommerce.ecommerce_product_service.service.ProductService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("v1/all")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("v1/add")
    public ResponseEntity<SuccessResponse> addProduct(@RequestBody ProductRequest product) {
        return productService.addProduct(product);
    }

    @PutMapping("v1/{id}")
    public ResponseEntity<SuccessResponse> updateProduct(@RequestBody ProductRequest product,@PathVariable int id) {
        product.setId(id);
        return productService.updateProduct(product);
    }


    @DeleteMapping("v1/{id}")
    public ResponseEntity<SuccessResponse> deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
    
}
