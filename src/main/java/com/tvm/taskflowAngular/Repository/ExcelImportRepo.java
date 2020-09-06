package com.tvm.taskflowAngular.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvm.taskflowAngular.model.Client;
import com.tvm.taskflowAngular.model.ExcelImport;

public interface ExcelImportRepo extends JpaRepository<ExcelImport,Integer>{

}
