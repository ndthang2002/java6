package com.thang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thang.entity.Category;
import com.thang.jparepository.CategoryJparepository;
import com.thang.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
 @Autowired
 CategoryJparepository catejpa;

 @Override
 public List<Category> findAll() {
	// TODO Auto-generated method stub
	return catejpa.findAll();
	
 }
 }