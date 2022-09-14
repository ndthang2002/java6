package com.thang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thang.entity.Product;
import com.thang.jparepository.ProductJparepository;
import com.thang.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired
ProductJparepository productjpa;

@Override
public List<Product> findAll() {
	// TODO Auto-generated method stub
	
	return productjpa.findAll();
}

@Override
public Product findById(Integer id) {
	// TODO Auto-generated method stub
	return productjpa.findById(id).get();
}

@Override
public List<Product> findbycategoryId(String cid) {
	// TODO Auto-generated method stub
	return productjpa.findByCategoryId(cid);
}

@Override
public Product create(Product product) {
	// TODO Auto-generated method stub
	return productjpa.save(product);
}

@Override
public Product update(Product product) {
	// TODO Auto-generated method stub
	return productjpa.save(product);
}

@Override
public void detete(Integer id) {
	productjpa.deleteById(id);
}


}
