package com.green.greenGotell.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.greenGotell.domain.entity.EmployeesEntity;

public interface EmployeesEntityRepository extends JpaRepository<EmployeesEntity, Long> {
	
	Optional<EmployeesEntity> findByEmail(String email);

}
