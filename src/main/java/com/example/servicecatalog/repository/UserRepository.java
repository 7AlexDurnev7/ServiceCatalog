package com.example.servicecatalog.repository;

import com.example.servicecatalog.db.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
