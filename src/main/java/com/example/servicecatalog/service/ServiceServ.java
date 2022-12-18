package com.example.servicecatalog.service;

import com.example.servicecatalog.db.Serv;
import com.example.servicecatalog.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServ {
    @Autowired
    private ServiceRepository serviceRepository;

    // get all service's through repository
    public List<Serv> listAllService() {
        return (List<Serv>) serviceRepository.findAll();
    }

    // save service in date base
    public Serv saveServ(Serv service) {
        return serviceRepository.save(service);
    }

    // delete service on id
    public void deleteServById(Integer id) {
        // 1. find service for delete
        Optional<Serv> deleted = serviceRepository.findById(id);
        // 2. if this service exist -> delete it
        deleted.ifPresent(service -> serviceRepository.delete(service));
    }

    // get service by id
    public Serv getServiceById(Integer id){
        Optional<Serv> service = serviceRepository.findById(id);
        return service.orElse(null);
    }

    // update service
    public Serv updateService (Serv service) {
        return serviceRepository.save(service);
    }

    // get service's by string
//    public List<Serv> findByContains(String match) {
//        if (match == null || match.equals(""))
//            return (List<Serv>)serviceRepository.findAll();
//        return ((List<Serv>)serviceRepository.findAll())
//                .stream()
//                .filter(s -> s.getServiceName().contains(match))
//                .toList();
//    }
}
