package com.tvm.taskflowAngular.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvm.taskflowAngular.model.Tickets;

public interface TicketRepo extends JpaRepository<Tickets, String> {

}
