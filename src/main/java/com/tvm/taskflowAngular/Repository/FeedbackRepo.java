package com.tvm.taskflowAngular.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvm.taskflowAngular.model.Feedback;


public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

}
