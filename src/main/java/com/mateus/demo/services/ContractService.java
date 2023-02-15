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

    @Autowired
    private OnlinePaymentService paymentService;


    public void processContract(Contract contract, Integer months){
        double basicQuota = contract.getTotalValue()/months;

        for(int i = 1; i<months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i);

            // juros calculado para esse mes
            double interest = paymentService.interest(basicQuota, i);

            // juros padrao calculado em cima do valor mensal com juros mensal
            double fee = paymentService.paymentFee(basicQuota + interest);

            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, quota, contract));
        }

    }


    public List<Contract> findAll(){
        return repository.findAll();
    }

    public Contract findById(Long id){
        Optional<Contract> obj = repository.findById(id);
        return obj.get();
    }
}
