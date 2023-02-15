package com.mateus.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.demo.entities.Contract;
import com.mateus.demo.services.ContractService;

@RestController
@RequestMapping(value = "/contracts")
public class ContractResource {

    @Autowired
    private ContractService service;

    @GetMapping
    public ResponseEntity<List<Contract>> findAll(){
        List<Contract> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Contract> findById(@PathVariable long id){
        Contract contract = service.findById(id);
        return ResponseEntity.ok().body(contract);
    }

    

}
