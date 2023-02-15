package com.mateus.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.demo.entities.Installment;

public interface InstallmentRepository extends JpaRepository<Installment, Long>{

}
