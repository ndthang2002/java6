package com.thang.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thang.entity.Product;

public interface ProductJparepository extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.category.id=?1")
	List<Product> findByCategoryId(String cid);

}
