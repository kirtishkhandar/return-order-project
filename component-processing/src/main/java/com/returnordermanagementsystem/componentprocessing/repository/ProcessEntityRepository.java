package com.returnordermanagementsystem.componentprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.returnordermanagementsystem.componentprocessing.entity.ProcessEntity;

public interface ProcessEntityRepository extends JpaRepository<ProcessEntity, String> {
	/*@Modifying
	@Query("select * from process_entity where request_Id = ")
	ProcessEntity findbyRequestId(UUID requestId);*/

}
