package com.thang.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thang.entity.Category;

@Repository
public interface CategoryJparepository extends JpaRepository<Category, String>{

}
