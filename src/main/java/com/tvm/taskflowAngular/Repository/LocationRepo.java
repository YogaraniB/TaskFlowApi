package com.tvm.taskflowAngular.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvm.taskflowAngular.model.Location;

public interface LocationRepo extends JpaRepository<Location, Integer> {

}
