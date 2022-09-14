package com.thang.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thang.Entity.Product;

public interface ProductsDAO extends JpaRepository<Product, Integer>{

}
