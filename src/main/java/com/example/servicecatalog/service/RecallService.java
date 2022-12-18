package com.example.servicecatalog.service;

import com.example.servicecatalog.db.Executor;
import com.example.servicecatalog.db.Recall;
import com.example.servicecatalog.db.Serv;
import com.example.servicecatalog.repository.RecallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecallService {

    @Autowired
    private RecallRepository recallRepository;

    // get all recall's through repository
    public List<Recall> listAllService() {
        return (List<Recall>) recallRepository.findAll();
    }

    // save recall in date base
    public Recall saveRecall(Recall recall) {
        return recallRepository.save(recall);
    }

    // delete recall on id
    public void deleteRecallById(Integer id) {
        // 1. find recall for delete
        Optional<Recall> deleted = recallRepository.findById(id);
        // 2. if this recall exist -> delete it
        deleted.ifPresent(recall -> recallRepository.delete(recall));
    }
//    public void deleteRecall(Recall recall) {
////        recallRepository.delete(comment);
//    }

    // get recall by id
    public Recall getRecallById(Integer id){
        Optional<Recall> recall = recallRepository.findById(id);
        return recall.orElse(null);
    }

    // update service
    public Recall updateRecall (Recall recall) {
        return recallRepository.save(recall);
    }

    // find
    public List<Recall> findAllRecall(Executor executor) {
        return recallRepository.findAllByExecutor(executor);
    }
}
