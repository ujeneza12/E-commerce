package com.rca.ac.rw.Ecommerce.api.controller.auth;

import com.rca.ac.rw.Ecommerce.api.model.ProductModel;
import com.rca.ac.rw.Ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ProductController {

    private ProductService productService;


    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/prod-reg")
    public ResponseEntity registerProduct(@RequestBody ProductModel productModel){

            productService.addNewProduct(productModel);
            return ResponseEntity.ok().build();

    }
}