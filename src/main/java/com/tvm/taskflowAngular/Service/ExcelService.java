package com.tvm.taskflowAngular.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tvm.taskflowAngular.Repository.ClientRepo;
import com.tvm.taskflowAngular.model.Client;

@Service
public class ExcelService {
  @Autowired
  ClientRepo repository;

  public void save(MultipartFile file) {
    try {
      List<Client> Clients = ExcelHelper.excelToClients(file.getInputStream());
      repository.saveAll(Clients);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public List<Client> getAllClients() {
    return repository.findAll();
  }


  public ByteArrayInputStream ClientsToExcel() {
	    List<Client> clients = this.getAllClients();

	    ByteArrayInputStream in = ExcelHelper.ClientsToExcel(clients);
	    return in;
	  }
}