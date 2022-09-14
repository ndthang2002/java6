package com.thangtq.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thangtq.entity.Student;

public interface StudentDAO extends JpaRepository <Student, String>  {

}
