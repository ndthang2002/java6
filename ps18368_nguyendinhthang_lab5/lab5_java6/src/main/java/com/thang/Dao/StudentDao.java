package com.thang.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thang.Entity.Student;



public interface StudentDao extends JpaRepository<Student,String>{

}
