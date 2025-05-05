package com.ecommerce.ecommerce_product_service.exception;

import lombok.Getter;

public class ProductServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Getter
    protected final String code;

    public ProductServiceException(String message, String code) {
        super(message);
        this.code = code;
    }
}
