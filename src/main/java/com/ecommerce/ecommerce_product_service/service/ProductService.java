package com.ecommerce.ecommerce_product_service.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce_product_service.entity.ProductEntity;
import com.ecommerce.ecommerce_product_service.exception.DetailsNotFoundException;
import com.ecommerce.ecommerce_product_service.repository.ProductRepository;
import com.ecommerce.ecommerce_product_service.request.ProductRequest;
import com.ecommerce.ecommerce_product_service.response.SuccessResponse;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<ProductEntity> getProductById(int id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        throw new DetailsNotFoundException("Product not found");
    }

    public ResponseEntity<SuccessResponse> addProduct(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productRequest.getName());
        productEntity.setDescription(productRequest.getDescription());
        productEntity.setPrice(productRequest.getPrice());
        productEntity.setMrp(productRequest.getMrp());
        productEntity.setStockQuantity(productRequest.getStockQuantity());
        productEntity.setCategory(productRequest.getCategory());
        productEntity.setSize(productRequest.getSize());
        productEntity.setColor(productRequest.getColor());
        productEntity.setImageUrl(productRequest.getImageUrl());
        productEntity.setActive(productRequest.isActive());
        productEntity.setUpdatedBy("Admin");
        productRepository.save(productEntity);
        return new ResponseEntity<>(new SuccessResponse("Product created successfully", "success"), HttpStatus.OK);
    }

    public ResponseEntity<SuccessResponse> updateProduct(ProductRequest productRequest) {
        Optional<ProductEntity> product = productRepository.findById(productRequest.getId());

        if(!product.isPresent()) {
            throw new DetailsNotFoundException("Product not found");
        }

        ProductEntity productEntity = product.get();
        productEntity.setId(productRequest.getId());
        productEntity.setName(productRequest.getName());
        productEntity.setDescription(productRequest.getDescription());
        productEntity.setPrice(productRequest.getPrice());
        productEntity.setMrp(productRequest.getMrp());
        productEntity.setStockQuantity(productRequest.getStockQuantity());
        productEntity.setCategory(productRequest.getCategory());
        productEntity.setSize(productRequest.getSize());
        productEntity.setColor(productRequest.getColor());
        productEntity.setImageUrl(productRequest.getImageUrl());
        productEntity.setActive(productRequest.isActive());
        
        productEntity.setUpdatedBy("Admin");
        productEntity.setUpdatedTime(new Date());
        productRepository.save(productEntity);
        return new ResponseEntity<>(new SuccessResponse("Product updated successfully", "success"), HttpStatus.OK);
    }

    public ResponseEntity<SuccessResponse> deleteProduct(int id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setDeletedTime(new Date());
            productRepository.save(product.get());

            return new ResponseEntity<>(new SuccessResponse("Product deleted successfully", "success"),
                    HttpStatus.OK);
        }
        throw new DetailsNotFoundException("Product not found");
    }
}
