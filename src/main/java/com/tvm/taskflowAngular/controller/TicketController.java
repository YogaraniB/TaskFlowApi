package com.tvm.taskflowAngular.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tvm.taskflowAngular.Service.ClientService;
import com.tvm.taskflowAngular.Service.EmployeeService;
import com.tvm.taskflowAngular.Service.ExcelImportService;
import com.tvm.taskflowAngular.Service.JobService;
import com.tvm.taskflowAngular.Service.LocationService;
import com.tvm.taskflowAngular.Service.SiteService;
import com.tvm.taskflowAngular.Service.TicketService;
import com.tvm.taskflowAngular.model.Client;
import com.tvm.taskflowAngular.model.Employee;

import com.tvm.taskflowAngular.model.ExcelImport;
import com.tvm.taskflowAngular.model.Jobs;
import com.tvm.taskflowAngular.model.Location;
import com.tvm.taskflowAngular.model.Site;
import com.tvm.taskflowAngular.model.Tickets;
import com.tvm.taskflowAngular.model.File.FileModel;
import com.tvm.taskflowAngular.model.File.FileService;
import com.tvm.taskflowAngular.web.Response;
import com.tvm.taskflowAngular.web.ResponseAPI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Api(value = "Ticket Controller", description = "REST Apis related to Ticket Entity!!!!")
@org.springframework.web.bind.annotation.RestController
@CrossOrigin("http:localhost:4200")

@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class TicketController {


	@Autowired
	TicketService ticketService;

	
	
	private static Logger logger = Logger.getLogger(TicketController.class);
	

	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	@GetMapping("/Tickets")
	public List<Tickets> getAllTicket() {
		logger.debug("Getting all Tickets");
		return ticketService.findAll();
	}

	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	@GetMapping("/Ticket/{id}")
	public Tickets getByIdTicket(@PathVariable(value = "id") String id) {
		logger.debug("Getting an Ticket " + id);
		return ticketService.findOne(id);
	}

	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	@PostMapping("/Tickets")
	public Tickets insert(@RequestBody Tickets i) {
		logger.debug("Posting an Ticket " + i.getTicketId());

		return ticketService.save(i);
	}

	// @PutMapping("/Ticket/{id}")
	// public Client update(@PathVariable(value="id") Integer id,@RequestBody Ticket
	// emp) {
	// logger.debug("Updating an Ticket" +id);
	// return clientService.update(emp);
	// }

	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	@DeleteMapping("/Ticket/{id}")
	public void deleteTicket(@PathVariable(value = "id") String id) {
		logger.debug("Deleting an Ticket " + id);
		ticketService.delete(id);
	}

}
