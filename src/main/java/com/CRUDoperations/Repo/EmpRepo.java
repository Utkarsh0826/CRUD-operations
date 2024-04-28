package com.CRUDoperations.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUDoperations.Entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Long> {
	
}
