package com.tvm.taskflowAngular.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.taskflowAngular.Repository.SiteRepo;
import com.tvm.taskflowAngular.Repository.SiteRepo;
import com.tvm.taskflowAngular.model.Site;

@Service
public class SiteService {


	
	@Autowired
	SiteRepo SiteRepository;
	
	

	// To save an Site
	public Site save(Site emp) {
		return SiteRepository.save(emp);
	}

	// search all Sites
	public List<Site> findAll() {
		return SiteRepository.findAll();
	}

	// update an Site
//	public Site update(Site emp) {
//		Optional<Site> ob = SiteRepository.findById(emp.getId());
//
//		if (ob.isPresent()) {
//			Site newb = ob.get();
//			newb.setSite(emp.getSite());
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
//			newb = SiteRepository.save(newb);
//			return newb;
//		} else {
//			emp = SiteRepository.save(emp);
//			return emp;
//		}
//	}

	// get an Site by id
	public Site findOne(Integer empid) {
		return SiteRepository.getOne(empid);
	}

	// delete an Site
	public void delete(Integer empid) {
		SiteRepository.deleteById(empid);
	}
	
//	public List<Site> getbyemailAndPassword(String email, String password) {
//		List<Site> l = SiteRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	
	
}
