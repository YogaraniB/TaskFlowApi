package com.tvm.taskflowAngular.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvm.taskflowAngular.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	public Employee findByFullName(String name);

}
