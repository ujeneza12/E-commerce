package com.rca.ac.rw.Ecommerce.api.model;

import com.rca.ac.rw.Ecommerce.model.dao.AllowedEmailDomains;
import jakarta.validation.constraints.*;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationModel {

    @NotNull
    @NotEmpty(message = "firstname is required")
    private String firstname;

    @NotNull
    @Email
    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    @AllowedEmailDomains(domains = {"gmail.com", "outlook.com","yahoo.com"})
    private String email;

    @NotNull
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String phone;

    @NotNull
    @NotEmpty(message = "password is required")
    @Size(min=8,max=32)
    private String password;



}
