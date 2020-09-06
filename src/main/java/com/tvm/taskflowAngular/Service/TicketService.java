package com.tvm.taskflowAngular.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.taskflowAngular.Repository.TicketRepo;
import com.tvm.taskflowAngular.model.Tickets;




@Service
public class TicketService {


	
	@Autowired
	TicketRepo TicketsRepository;
	
	

	// To save an Tickets
	public Tickets save(Tickets emp) {
		return TicketsRepository.save(emp);
	}

	// search all Ticketss
	public List<Tickets> findAll() {
		return TicketsRepository.findAll();
	}

	// update an Tickets
//	public Tickets update(Tickets emp) {
//		Optional<Tickets> ob = TicketsRepository.findById(emp.getId());
//
//		if (ob.isPresent()) {
//			Tickets newb = ob.get();
//			newb.setTickets(emp.getTickets());
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
//			newb = TicketsRepository.save(newb);
//			return newb;
//		} else {
//			emp = TicketsRepository.save(emp);
//			return emp;
//		}
//	}

	// get an Tickets by id
	public Tickets findOne(String empid) {
		return TicketsRepository.getOne(empid);
	}

	// delete an Tickets
	public void delete(String empid) {
		TicketsRepository.deleteById(empid);
	}
	
//	public List<Tickets> getbyemailAndPassword(String email, String password) {
//		List<Tickets> l = TicketsRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	
	
}
