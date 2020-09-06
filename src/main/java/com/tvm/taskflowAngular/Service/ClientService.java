package com.tvm.taskflowAngular.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.taskflowAngular.Repository.ClientRepo;
import com.tvm.taskflowAngular.Repository.ClientRepo;
import com.tvm.taskflowAngular.model.Client;

@Service
public class ClientService {


	
	@Autowired
	ClientRepo ClientRepository;
	
	

	// To save an Client
	public Client save(Client emp) {
		return ClientRepository.save(emp);
	}

	// search all Clients
	public List<Client> findAll() {
		return ClientRepository.findAll();
	}

	// update an Client
	public Client update(Client emp) {
		Optional<Client> ob = ClientRepository.findById(emp.getClientid());

		if (ob.isPresent()) {
			Client newb = ob.get();
			newb.setAddress(emp.getAddress());
			newb.setClientName(emp.getClientName());
			newb.setCreatedAt(emp.getCreatedAt());
            newb.setEmail(emp.getEmail());
            newb.setFirstName(emp.getFirstName());
            newb.setGroupName(emp.getGroupName());
            newb.setLastName(emp.getLastName());
            newb.setMobile(emp.getMobile());
            
			newb = ClientRepository.save(newb);
			return newb;
		} else {
			emp = ClientRepository.save(emp);
			return emp;
		}
	}

	// get an Client by id
	public Client findOne(Integer empid) {
		return ClientRepository.getOne(empid);
	}

	// delete an Client
	public void delete(Integer empid) {
		ClientRepository.deleteById(empid);
	}
	
//	public List<Client> getbyemailAndPassword(String email, String password) {
//		List<Client> l = ClientRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	
	
}
