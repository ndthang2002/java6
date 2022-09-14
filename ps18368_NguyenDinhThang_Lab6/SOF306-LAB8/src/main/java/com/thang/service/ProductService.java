package com.thang.service;

import java.util.List;

import com.thang.entity.Product;

public interface ProductService {

	List<Product> findAll();
	
	Product findById(Integer id);

	List<Product> findbycategoryId(String cid);

    Product create (Product product) ;

	Product update(Product product);

	void detete(Integer id);

}
		 
	 
	
		 
	 
	
	

