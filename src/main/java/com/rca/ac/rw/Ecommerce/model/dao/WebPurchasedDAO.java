package com.rca.ac.rw.Ecommerce.model.dao;

import com.rca.ac.rw.Ecommerce.model.LocalUser;
import com.rca.ac.rw.Ecommerce.model.Purchased;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WebPurchasedDAO extends ListCrudRepository<Purchased,Long> {

    List<Purchased> findByUser(LocalUser user);

}
