package com.rca.ac.rw.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="product-quantity", referencedColumnName = "id")
    private Product product;



}