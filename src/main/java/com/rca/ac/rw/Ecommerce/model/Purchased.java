package com.rca.ac.rw.Ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "purchased")
public class Purchased {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantity;
    private Float total;
    private Date date;

    //product_code | unit_price
    @ManyToOne
    @JoinColumn(name = "product_code", referencedColumnName = "code")
    private Product productCode;

    @ManyToOne
    @JoinColumn(name = "unit_price", referencedColumnName = "price")
    private Product productUnitPrice;

    //customer_id
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private LocalUser customer;
}