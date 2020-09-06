package com.tvm.taskflowAngular.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.taskflowAngular.Repository.ExcelImportRepo;

import com.tvm.taskflowAngular.model.ExcelImport;

@Service
public class ExcelImportService {


	
	@Autowired
	ExcelImportRepo ExcelImportRepository;
	
	

	// To save an ExcelImport
	public List<ExcelImport> save(List<ExcelImport> emp) {
		return ExcelImportRepository.saveAll(emp);
	}

	// search all ExcelImports
	public List<ExcelImport> findAll() {
		return ExcelImportRepository.findAll();
	}

	// update an ExcelImport
//	public ExcelImport update(ExcelImport emp) {
//		Optional<ExcelImport> ob = ExcelImportRepository.findById(emp.getId());
//
//		if (ob.isPresent()) {
//			ExcelImport newb = ob.get();
//			newb.setExcelImport(emp.getExcelImport());
//			newb.setCompany(emp.getCompany());
//			newb.setConfirmPassword(emp.getConfirmPassword());
//            newb.setDep(emp.getDep());
//            newb.setEmail(emp.getEmail());
//            newb.setFirstName(emp.getFirstName());
//            newb.setGender(emp.getGender());
//            newb.setJtitle(emp.getJtitle());
//            newb.setLastName(emp.getLastName());
//            newb.setLoc(emp.getLoc());
//            newb.setPassword(emp.getPassword());
//            newb.setPo(emp.getPo());
//            newb.setSkill(emp.getSkill());
//            newb.setTitle(emp.getTitle());
//			newb = ExcelImportRepository.save(newb);
//			return newb;
//		} else {
//			emp = ExcelImportRepository.save(emp);
//			return emp;
//		}
//	}

	// get an ExcelImport by id
	public ExcelImport findOne(Integer empid) {
		return ExcelImportRepository.getOne(empid);
	}

	// delete an ExcelImport
	public void delete(Integer empid) {
		ExcelImportRepository.deleteById(empid);
	}
	
//	public List<ExcelImport> getbyemailAndPassword(String email, String password) {
//		List<ExcelImport> l = ExcelImportRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	
	
}
