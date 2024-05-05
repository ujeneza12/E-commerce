package com.rca.ac.rw.Ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name="quantity")
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productCode;
    private Integer quantity;
    private String operation;
    private Date date;

    @ManyToOne
    @JoinColumn(name ="product-quantity", referencedColumnName = "id")
    private Product product;



}