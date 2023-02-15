package com.mateus.demo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mateus.demo.entities.Contract;
import com.mateus.demo.repositories.ContractRepository;
import com.mateus.demo.repositories.InstallmentRepository;


@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{


    @Autowired
    private ContractRepository ContractRepository;

    @Autowired
    private InstallmentRepository installmentRepository;

    @Override
    public void run(String... args) throws Exception {
       Contract c1 = new Contract( LocalDate.now(), 25000.0);
       Contract c2 = new Contract( LocalDate.now(), 50000.0);

       ContractRepository.saveAll(Arrays.asList(c1, c2));
    }



}
