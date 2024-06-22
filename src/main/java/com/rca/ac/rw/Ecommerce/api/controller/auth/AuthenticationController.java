package com.rca.ac.rw.Ecommerce.api.controller.auth;

import com.rca.ac.rw.Ecommerce.api.model.LoginModel;
import com.rca.ac.rw.Ecommerce.api.model.LoginResponse;
import com.rca.ac.rw.Ecommerce.api.model.RegistrationModel;
import com.rca.ac.rw.Ecommerce.exception.UserExistsException;
import com.rca.ac.rw.Ecommerce.model.LocalUser;
import com.rca.ac.rw.Ecommerce.service.UserServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserServices userServices;

    public AuthenticationController(UserServices userServices){
        this.userServices = userServices;
    }

    //router for registering a user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationModel registrationModel) {

        try {
            userServices.registerUser(registrationModel);
            return ResponseEntity.ok().build();
        }catch (UserExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    //router for login and getting a jwt token that expires in an hour
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginModel loginModel){
        String jwt = userServices.loginUser(loginModel);
        if(jwt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            return ResponseEntity.ok(response);
        }
    }



    //getting alogged in user's profile data but this is for the system's admin
    @GetMapping("/get")
    public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user){

        return user;


    }

}
