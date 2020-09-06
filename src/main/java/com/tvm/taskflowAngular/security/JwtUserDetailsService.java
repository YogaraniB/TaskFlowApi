package com.tvm.taskflowAngular.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tvm.taskflowAngular.Service.EmployeeService;
import com.tvm.taskflowAngular.model.Employee;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		Employee e=employeeService.findByName(username);
//		if(e==null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(e.getFullName(), bcryptEncoder.encode(e.getPassword()),
//				new ArrayList<>());
		if ("tvminfotech".equals(username)) {
			return new User("tvminfotech", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}