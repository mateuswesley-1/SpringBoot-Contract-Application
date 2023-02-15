package com.mateus.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.demo.entities.Contract;
import com.mateus.demo.entities.Installment;
import com.mateus.demo.repositories.ContractRepository;

@Service
public class ContractService {

    @Autowired
    private ContractRepository repository;

    /*
    @Autowired
    private OnlinePaymentService paymentService;
*/


    public void processContract(Contract contract, Integer months){
        contract.getInstallments().add(new Installment(LocalDate.now(), 1500.0, contract));
    }


    public List<Contract> findAll(){
        return repository.findAll();
    }

    public Contract findById(Long id){
        Optional<Contract> obj = repository.findById(id);
        return obj.get();
    }
}
