package com.tvm.taskflowAngular.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.taskflowAngular.Repository.EmployeeRepo;
import com.tvm.taskflowAngular.model.Employee;
import com.tvm.taskflowAngular.web.ResourceNotFoundException;

@Service
public class EmployeeService {


	
	@Autowired
	EmployeeRepo EmployeeRepository;
	
	

	// To save an Employee
	public Employee save(Employee emp) {
		return EmployeeRepository.save(emp);
	}

	// search all Employees
	public List<Employee> findAll() {
		return EmployeeRepository.findAll();
	}

	// update an Employee
	public Employee update(Employee emp) {
		Optional<Employee> ob = EmployeeRepository.findById(emp.getEmpid());

		if (ob.isPresent()) {
			Employee newb = ob.get();
			
			newb.setBlock(emp.getBlock());
			newb.setClient(emp.getClient());
			newb.setCreatedAt(new Date());
			newb.setDesignation(emp.getDesignation());
			newb.setEmail(emp.getEmail());
			newb.setFirstName(emp.getFirstName());
			newb.setFloor(emp.getFloor());
			newb.setLastName(emp.getLastName());
			newb.setMobile(emp.getMobile());
			newb.setSite(emp.getSite());
			newb.setUserRole(emp.getUserRole());
			newb.setZone(emp.getZone());
			newb = EmployeeRepository.save(newb);
			return newb;
		} else {
			emp = EmployeeRepository.save(emp);
			return emp;
		}
	}

	// get an Employee by id
	public Employee findOne(Integer empid) {
		Optional<Employee> userOptional = EmployeeRepository.findById(empid);

	    userOptional.orElseThrow(() -> new ResourceNotFoundException("No employee found with employee id " + empid));
		return EmployeeRepository.getOne(empid);
	}
	
	
	public Employee findByName(String name){
		return EmployeeRepository.findByFullName(name);
	}

	// delete an Employee
	public void delete(Integer empid) {
		EmployeeRepository.deleteById(empid);
	}
	
//	public List<Employee> getbyemailAndPassword(String email, String password) {
//		List<Employee> l = EmployeeRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	
	
}
