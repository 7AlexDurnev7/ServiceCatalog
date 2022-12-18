package com.example.servicecatalog.repository;

import com.example.servicecatalog.db.Executor;
import com.example.servicecatalog.db.Recall;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecallRepository extends CrudRepository<Recall, Integer> {
    List<Recall> findAllByExecutor(Executor executor);
}
