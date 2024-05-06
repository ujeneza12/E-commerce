package com.rca.ac.rw.Ecommerce.api.controller.auth;

import com.rca.ac.rw.Ecommerce.model.LocalUser;
import com.rca.ac.rw.Ecommerce.model.Purchased;
import com.rca.ac.rw.Ecommerce.service.PurchaseService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchased")
public class PurchasedController {

    private PurchaseService purchaseService;

    public PurchasedController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<Purchased> getPurchased(@AuthenticationPrincipal LocalUser user){
        return purchaseService.getPurchased(user);
    }

}
