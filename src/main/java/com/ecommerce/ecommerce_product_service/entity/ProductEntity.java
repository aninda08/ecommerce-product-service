package com.ecommerce.ecommerce_product_service.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="PRICE")
    private int price;

    @Column(name="MRP")
    private int mrp;

    @Column(name="STOCK_QUANTITY")
    private int stockQuantity;

    @Column(name="CATEGORY")
    private String category;

    @Column(name="SIZE")
    private String size;

    @Column(name="COLOR")
    private String color;

    @Column(name="IMAGE_URL")
    private String imageUrl;

    @Column(name="IS_ACTIVE")
    private boolean isActive;

    @Column(name="UPDATED_BY")
    private String updatedBy;

    @Column(name = "CREATED_TIME", columnDefinition = "TIMESTAMP", insertable = false, updatable = false)
    @JsonFormat(shape = Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "UPDATED_TIME", columnDefinition = "TIMESTAMP", insertable = true, updatable = true)
    @JsonFormat(shape = Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "DELETED_TIME", columnDefinition = "TIMESTAMP")
    @JsonFormat(shape = Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedTime;
}
