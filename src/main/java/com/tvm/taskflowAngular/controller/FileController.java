package com.tvm.taskflowAngular.controller;

import java.io.File;
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
import com.tvm.taskflowAngular.model.File.FileRepository;
import com.tvm.taskflowAngular.model.File.FileService;
import com.tvm.taskflowAngular.web.Response;
import com.tvm.taskflowAngular.web.ResponseAPI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Api(value = "File Controller", description = "REST Apis related to File Entity!!!!")
@org.springframework.web.bind.annotation.RestController
@CrossOrigin("http:localhost:4200")

@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class FileController {

	@Autowired
	ExcelImportService excelImportService;

	@Autowired
	FileService fileRepository;

	private static Logger logger = Logger.getLogger(FileController.class);

	

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@PostMapping("/import")
	public List<ExcelImport> mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile)
			throws IOException {
//-----------To save into POJO------------------
		List<ExcelImport> tempStudentList = new ArrayList<ExcelImport>();
		XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			ExcelImport tempStudent = new ExcelImport();

			XSSFRow row = worksheet.getRow(i);

			tempStudent.setEmpid((int) row.getCell(0).getNumericCellValue());
			tempStudent.setFirstName(row.getCell(1).getStringCellValue());
			tempStudent.setLastName(row.getCell(2).getStringCellValue());
			tempStudent.setMobile((int) row.getCell(3).getNumericCellValue());
			tempStudent.setEmail(row.getCell(4).getStringCellValue());
			tempStudent.setDesignation(row.getCell(5).getStringCellValue());
			tempStudent.setTotalDays((int) row.getCell(13).getNumericCellValue());
			tempStudent.setMonth(row.getCell(14).getStringCellValue());
			tempStudentList.add(tempStudent);
		}

		for (ExcelImport s : tempStudentList) {
			System.out.println(s.toString());
		}

		excelImportService.save(tempStudentList);
//----------To write in Internal Drive-----------------------------
		File convertFile = new File("C:/Users/rajue/Desktop/GitDownload/TaskFlow/TaskFlowAngular/src/main/resources"
				+ reapExcelDataFile.getOriginalFilename());
		convertFile.createNewFile();
		try (FileOutputStream fout = new FileOutputStream(convertFile)) {
			fout.write(reapExcelDataFile.getBytes());
			System.out.println("Successfully Saved!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
//-------------To Store in DB-----------------------------
		FileModel filemode = new FileModel(reapExcelDataFile.getOriginalFilename(), reapExcelDataFile.getContentType(),
				reapExcelDataFile.getBytes());
		fileRepository.save(filemode);
//------------------------------------------
		ResponseAPI res1 = new ResponseAPI("Success", Boolean.TRUE, tempStudentList, tempStudentList.size());

		return tempStudentList;
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@GetMapping("/ExcelImport")
	public List<ExcelImport> getAllExcelImport() {
		logger.debug("Getting all ExcelImport");
		return excelImportService.findAll();
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@PostMapping("/upload")
	public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
		try {
			FileModel filemode = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
			fileRepository.save(filemode);
			return "File uploaded Successfully! , FileName =" + file.getOriginalFilename() + "; Id=" + filemode.getId();

		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
		// Load file from database
		Optional<FileModel> dbFile = fileRepository.getFile(fileId);

		FileModel newb = dbFile.get();

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(newb.getMimetype()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + newb.getName() + "\"")
				.body(new ByteArrayResource(newb.getFile()));
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "jwtToken") })
	@GetMapping("/File/{id}")
	public FileModel getByFileId(@PathVariable(value = "id") Long id) {
		logger.debug("Getting an Employee " + id);
		Optional<FileModel> f = fileRepository.getFile(id);
		FileModel fm = f.get();
		return fm;
	}

}
