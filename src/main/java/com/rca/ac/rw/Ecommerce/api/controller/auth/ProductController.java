package com.rca.ac.rw.Ecommerce.api.controller.auth;

import com.rca.ac.rw.Ecommerce.api.model.ProductModel;
import com.rca.ac.rw.Ecommerce.model.Product;
import com.rca.ac.rw.Ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get-Prod")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

}