package com.rca.ac.rw.Ecommerce.api.model;


import jakarta.validation.constraints.NotNull;

import lombok.Getter;

import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductModel {

    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    private String productType;
    @NotNull
    private Float price;
    @NotNull
    private Date inDate;



}