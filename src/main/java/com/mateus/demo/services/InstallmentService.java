package com.mateus.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.demo.entities.Installment;
import com.mateus.demo.repositories.InstallmentRepository;

@Service
public class InstallmentService {

    @Autowired
    private InstallmentRepository repository;

    public List<Installment> findAll(){
        return repository.findAll();
    }

    public Installment findById(Long id){
        Optional<Installment> obj = repository.findById(id);
        return obj.get();
    }
}

