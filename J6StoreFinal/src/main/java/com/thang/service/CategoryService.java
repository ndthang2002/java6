package com.thang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thang.entity.Category;
@Service
public interface CategoryService {

	List<Category> findAll();
}
