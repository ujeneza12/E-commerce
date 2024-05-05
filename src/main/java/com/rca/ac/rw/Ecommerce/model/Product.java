package com.rca.ac.rw.Ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String productType;
    private Float price;
    private Date inDate;

    //purchases - product_code
    @OneToMany(mappedBy = "productCode")
    private List<Purchased> purchasesCode;

    //purchases - unit_price
    @OneToMany(mappedBy = "productUnitPrice")
    private List<Purchased> purchasesUnitPrice;

    //quantities
    @OneToMany(mappedBy = "product")
    private List<Quantity> quantities;
}
