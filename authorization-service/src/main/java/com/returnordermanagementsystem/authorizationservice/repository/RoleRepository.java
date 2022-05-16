package com.returnordermanagementsystem.authorizationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnordermanagementsystem.authorizationservice.models.ERole;
import com.returnordermanagementsystem.authorizationservice.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
