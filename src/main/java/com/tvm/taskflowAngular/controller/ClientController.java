package com.tvm.taskflowAngular.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import com.tvm.taskflowAngular.Service.ExcelHelper;
import com.tvm.taskflowAngular.Service.ExcelImportService;
import com.tvm.taskflowAngular.Service.ExcelService;
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

@Api(value = "Client Controller", description = "REST Apis related to Client Entity!!!!")
@org.springframework.web.bind.annotation.RestController
@CrossOrigin("http:localhost:4200")

@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class ClientController {

	@Autowired
	ClientService clientService;

	
	
	private static Logger logger = Logger.getLogger(ClientController.class);
	

	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	@GetMapping("/Clients")
	public List<Client> getAllClient() {
		logger.debug("Getting all Clients");
		System.out.println(clientService.findAll());
		List<Client> clients = clientService.findAll();
		Collections.sort(clients, (o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt()));
		Collections.reverse(clients);
		return clients;
	}

	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	@GetMapping("/Client/{id}")
	public Client getByIdClient(@PathVariable(value = "id") Integer id) {
		logger.debug("Getting an Employee " + id);

		return clientService.findOne(id);
	}

	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	@PostMapping("/Clients")
	public Client insert(@RequestBody Client i) {
		logger.debug("Posting an Client " + i.getFirstName());

		return clientService.save(i);
	}

	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	 @PutMapping("/Client/{id}")
	 public Client update(@PathVariable(value="id") Integer id,@RequestBody Client
	 emp) {
	 logger.debug("Updating an Client " +id);
	 return clientService.update(emp);
	 }



	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	@DeleteMapping("/Client/{id}")
	public void deleteClient(@PathVariable(value = "id") Integer id) {
		logger.debug("Deleting an Client " + id);
		clientService.delete(id);
	}
	
	
	@Autowired
	  ExcelService fileService;
	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	  @PostMapping("/uploadClient")
	  public ResponseEntity<ResponseAPI> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	        fileService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseAPI(message));
	      } catch (Exception e) {
	    	  System.out.println(e);
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseAPI(message));
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseAPI(message));
	  }
	@ApiOperation(value="",authorizations= {@Authorization(value="jwtToken")})
	@GetMapping("/ClientListDownloadToExcel")
	  public ResponseEntity<Resource> getFile() {
		//LocalDate today=LocalDate.now();
		//String formattedDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
//	https://howtodoinjava.com/java/date-time/localdate-format-example/
		//SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
//		final String stringDate = formatter.format(l);
////	l.format(formatter);
////		l.format("dd/mm/yyyy");
	    String filename = "Clients.xlsx";
	    InputStreamResource file = new InputStreamResource(fileService.ClientsToExcel());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	  }
}
