package com.thang.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thang.Entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{

}
