package com.thang.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thang.entity.Role;
import com.thang.jparepository.RoleJparepository;

@RestController
public class RoleRestController {

	@Autowired
	RoleJparepository rolejpa;
	@GetMapping("/rest/roles")
	public List<Role> get(){
		return rolejpa.findAll();
	}
}
