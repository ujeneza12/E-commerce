package com.rca.ac.rw.Ecommerce.service;

import com.rca.ac.rw.Ecommerce.api.model.ProductModel;
import com.rca.ac.rw.Ecommerce.model.Product;
import com.rca.ac.rw.Ecommerce.model.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {

        this.productDAO = productDAO;
    }

    public Product addNewProduct(ProductModel productModel) {

    Product product = new Product();

    product.setCode(productModel.getCode());
    product.setName(productModel.getName());
    product.setPrice(productModel.getPrice());
    product.setProductType(productModel.getProductType());
    product.setInDate(productModel.getInDate());

     return productDAO.save(product);

    }


    public List<Product> getProducts(){
        return productDAO.findAll();
    }
}