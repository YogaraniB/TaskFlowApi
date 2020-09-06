package com.tvm.taskflowAngular.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvm.taskflowAngular.model.Client;

public interface ClientRepo extends JpaRepository<Client,Integer>{

}
