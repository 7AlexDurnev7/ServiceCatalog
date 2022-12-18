package com.example.servicecatalog.repository;

import com.example.servicecatalog.db.Serv;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Serv, Integer> {
}
