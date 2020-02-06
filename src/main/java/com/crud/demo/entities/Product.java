package com.crud.demo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {
    private String id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private String status;
}
