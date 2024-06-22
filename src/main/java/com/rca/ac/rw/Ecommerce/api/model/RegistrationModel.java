package com.rca.ac.rw.Ecommerce.api.model;

import com.rca.ac.rw.Ecommerce.model.dao.AllowedEmailDomains;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationModel {

    @NotNull
    private String firstname;

    @NotNull
    @Email
    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    @AllowedEmailDomains(domains = {"gmail.com", "outlook.com","yahoo.com"})
    private String email;

    @NotNull
    private String phone;

    @NotNull
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
//    @Size(min=8,max=32)
    private String password;



}
