package com.rca.ac.rw.Ecommerce.service;

import com.rca.ac.rw.Ecommerce.model.LocalUser;
import com.rca.ac.rw.Ecommerce.model.Purchased;
import com.rca.ac.rw.Ecommerce.model.dao.WebPurchasedDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {


    private WebPurchasedDAO webPurchasedDAO;

    public PurchaseService(WebPurchasedDAO webPurchasedDAO){
        this.webPurchasedDAO=webPurchasedDAO;
    }


    public List<Purchased> getPurchased(LocalUser user){
        return webPurchasedDAO.findByUser(user);
    }


}
