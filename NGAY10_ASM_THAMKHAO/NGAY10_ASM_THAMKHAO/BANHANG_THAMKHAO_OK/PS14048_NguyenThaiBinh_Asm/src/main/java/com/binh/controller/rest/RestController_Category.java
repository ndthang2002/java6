package com.binh.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binh.entity.Category;
import com.binh.service.Service_Category;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/categories")
public class RestController_Category {
	@Autowired private Service_Category cateService;
	
	@GetMapping()
	public List<Category> findAll() {
		return cateService.findAll();
	}
}
