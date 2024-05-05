package com.rca.ac.rw.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="local_user")
public class LocalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String firstname;
    private String phone;
    private String email;
    private String password;



    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Purchased> purchased;



}
