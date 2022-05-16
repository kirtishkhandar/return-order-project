package com.returnordermanagementsystem.componentprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.returnordermanagementsystem.componentprocessing.entity.PaymentEntity;

public interface PaymentEntityRepository extends JpaRepository<PaymentEntity, String> {

}
