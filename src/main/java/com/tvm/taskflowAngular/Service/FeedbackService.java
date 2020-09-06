package com.tvm.taskflowAngular.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.taskflowAngular.Repository.FeedbackRepo;
import com.tvm.taskflowAngular.Repository.LocationRepo;
import com.tvm.taskflowAngular.model.Feedback;
import com.tvm.taskflowAngular.model.Location;

@Service
public class FeedbackService {


	
	@Autowired
	FeedbackRepo feedbackRepository;
	
	

	// To save an Location
	public Feedback save(Feedback emp) {
		return feedbackRepository.save(emp);
	}

	// search all Locations
	public List<Feedback> findAll() {
		return feedbackRepository.findAll();
	}

	// update an Location
//	public Location update(Location emp) {
//		Optional<Location> ob = LocationRepository.findById(emp.getId());
//
//		if (ob.isPresent()) {
//			Location newb = ob.get();
//			newb.setClient(emp.getClient());
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
//			newb = LocationRepository.save(newb);
//			return newb;
//		} else {
//			emp = LocationRepository.save(emp);
//			return emp;
//		}
//	}

	// get an Location by id
	public Feedback findOne(Integer empid) {
		return feedbackRepository.getOne(empid);
	}

	// delete an Location
	public void delete(Integer empid) {
		feedbackRepository.deleteById(empid);
	}
	
//	public List<Location> getbyemailAndPassword(String email, String password) {
//		List<Location> l = LocationRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	
	
}
