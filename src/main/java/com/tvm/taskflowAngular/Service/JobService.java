package com.tvm.taskflowAngular.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.taskflowAngular.Repository.JobsRepo;
import com.tvm.taskflowAngular.model.Jobs;


@Service
public class JobService {


	
	@Autowired
	JobsRepo JobRepository;
	
	

	// To save an Job
	public Jobs save(Jobs emp) {
		return JobRepository.save(emp);
	}

	// search all Jobs
	public List<Jobs> findAll() {
		return JobRepository.findAll();
	}

	// update an Job
//	public Job update(Job emp) {
//		Optional<Job> ob = JobRepository.findById(emp.getId());
//
//		if (ob.isPresent()) {
//			Job newb = ob.get();
//			newb.setJob(emp.getJob());
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
//			newb = JobRepository.save(newb);
//			return newb;
//		} else {
//			emp = JobRepository.save(emp);
//			return emp;
//		}
//	}

	// get an Job by id
	public Jobs findOne(Integer empid) {
		return JobRepository.getOne(empid);
	}

	// delete an Job
	public void delete(Integer empid) {
		JobRepository.deleteById(empid);
	}
	
//	public List<Job> getbyemailAndPassword(String email, String password) {
//		List<Job> l = JobRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	
	
}
