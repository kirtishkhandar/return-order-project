package com.returnordermanagementsystem.componentprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.returnordermanagementsystem.componentprocessing.entity.ProcessEntity;

public interface ProcessEntityRepository extends JpaRepository<ProcessEntity, String> {

}
