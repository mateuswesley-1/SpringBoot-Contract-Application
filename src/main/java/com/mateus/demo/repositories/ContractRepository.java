package com.mateus.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.demo.entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long>{

}
