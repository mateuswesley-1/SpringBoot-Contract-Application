package com.mateus.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.demo.entities.Installment;
import com.mateus.demo.services.InstallmentService;

@RestController
@RequestMapping(value = "/installments")
public class InstallmentResource {

    @Autowired
    private InstallmentService service;

    @GetMapping
    public ResponseEntity<List<Installment>> findAll(){
        List<Installment> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Installment> findById(@PathVariable long id){
        Installment contract = service.findById(id);
        return ResponseEntity.ok().body(contract);
    }



}
