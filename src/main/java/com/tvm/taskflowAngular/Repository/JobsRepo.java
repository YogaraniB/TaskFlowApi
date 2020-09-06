package com.tvm.taskflowAngular.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvm.taskflowAngular.model.Jobs;

public interface JobsRepo extends JpaRepository<Jobs, Integer> {

}
