package com.example.servicecatalog.service;

import com.example.servicecatalog.db.Executor;
import com.example.servicecatalog.db.Serv;
import com.example.servicecatalog.repository.ExecutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExecutorService {

    @Autowired
    private ExecutorRepository executorRepository;

    // get all executors through repository
    public List<Executor> listAllExecutor() {
        return (List<Executor>) executorRepository.findAll();
    }

    // save executor in date base
    public Executor saveExecutor(Executor executor) {
        return executorRepository.save(executor);
    }

    // delete executor on id
    public void deleteExecutorById(Integer id) {
        // 1. find executor for delete
        Optional<Executor> deleted = executorRepository.findById(id);
        // 2. if this executor exist -> delete it
        deleted.ifPresent(executor -> executorRepository.delete(executor));
    }

    // get executor by id
    public Executor getExecutorById(Integer id){
        Optional<Executor> executor = executorRepository.findById(id);
        return executor.orElse(null);
    }

    // update executor
    public Executor updateExecutor (Executor executor) {
        return executorRepository.save(executor);
    }
}
