package com.tvm.taskflowAngular.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.tvm.taskflowAngular.Service.EmployeeService;
import com.tvm.taskflowAngular.model.Employee;
import com.tvm.taskflowAngular.web.Response;
import com.tvm.taskflowAngular.web.ResponseAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Api(value = "Employee Controller", description = "REST Apis related to Employee Entity!!!!")
@org.springframework.web.bind.annotation.RestController
@CrossOrigin("http:localhost:4200")

@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	private static Logger logger = Logger.getLogger(EmployeeController.class);

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@GetMapping("/Employees")
	public ResponseAPI getAll() {
		logger.debug("Getting all Employees");
		List<Employee> employees = employeeService.findAll();
		Collections.sort(employees,
				Comparator.nullsLast(Comparator.comparing(Employee::getCreatedAt,
						Comparator.nullsLast(Comparator.reverseOrder()))));
		//Collections.sort(employees, (o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt()));
		//Collections.reverse(employees);
		//Comparator.nullsFirst(Comparator.comparing(Employee::getCreatedAt,Comparator.nullsFirst(Comparator.reverseOrder())));
		ResponseAPI res1 = new ResponseAPI("Success", Boolean.TRUE, employees, employees.size());
		return res1;
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@GetMapping("/Employee/{id}")
	public Employee getById(
			@PathVariable @Min(value = 1, message = "id must be greater than or equal to 1") @Max(value = 100000000, message = "id must be lower than or equal to 100000000") Integer id) {
		logger.debug("Getting an Employee " + id);
		return employeeService.findOne(id);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@PostMapping("/Employees")
	public Employee insert(@RequestBody Employee i) {
		logger.debug("Posting an Employee " + i.getFirstName());

		return employeeService.save(i);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@GetMapping("/employeesByName1.8/{site}/{client}")
	public List<Employee> EmployeeByRange(@PathVariable(value = "site") String site,@PathVariable(value = "client") String client) {
//		return	employeeService.findAll().stream().peek(x->{
//			if(x.getClient() == null) {
//				throw new ResourceNotFoundException("null");
//			}
//		}).filter(x -> x.getSite().equalsIgnoreCase(name) && x.getClient().equalsIgnoreCase(client)).collect(Collectors.toList());
		return employeeService.findAll().stream().filter(x -> x.getSite().equalsIgnoreCase(site) && x.getClient().equalsIgnoreCase(client))
				.collect(Collectors.toList());
	}
	
	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@GetMapping("/employeesByName1.8/{name}")
	public List<Employee> EmployeeAutocomplete(@PathVariable(value = "name") String name) {
//		return	employeeService.findAll().stream().peek(x->{
//			if(x.getClient() == null) {
//				throw new ResourceNotFoundException("null");
//			}
//		}).filter(x -> x.getSite().equalsIgnoreCase(name) && x.getClient().equalsIgnoreCase(client)).collect(Collectors.toList());
		String lowerStr=name.toLowerCase();
		String upperStr=name.toUpperCase();
		return employeeService.findAll().stream().filter(x -> x.getFirstName().startsWith(lowerStr) || x.getFirstName().startsWith(upperStr) )
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@GetMapping("/employeeByName/{name}")
	public Employee EmployeeByName(@PathVariable(value = "name") String name) {
		return employeeService.findByName(name);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@PutMapping("/Employee/{id}")
	public Employee update(@PathVariable(value = "id") Integer id, @RequestBody Employee emp) {
		logger.debug("Updating an Employee " + id);
		employeeService.findOne(id);
		return employeeService.update(emp);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@DeleteMapping("/Employee/{id}")
	public Response delete(@PathVariable(value = "id") Integer id) {
		logger.debug("Deleting an Employee " + id);

		employeeService.findOne(id);

		employeeService.delete(id);

		return new Response("Employee with id : " + id + " Deleted", Boolean.TRUE);

	}

}
