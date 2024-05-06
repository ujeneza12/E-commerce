package com.rca.ac.rw.Ecommerce.model.dao;

import com.rca.ac.rw.Ecommerce.model.LocalUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface LocalUserDAO  extends ListCrudRepository<LocalUser,Long> {
//    Optional<LocalUser> findByUsernameIgnoreCase(String username);
    Optional<LocalUser> findByEmailIgnoreCase(String email);

}

//public interface LocalUserDAO  extends CrudRepository<LocalUser,Long> {
//    //    Optional<LocalUser> findByUsernameIgnoreCase(String username);
//    Optional<LocalUser> findByEmailIgnoreCase(String email);
//
//}