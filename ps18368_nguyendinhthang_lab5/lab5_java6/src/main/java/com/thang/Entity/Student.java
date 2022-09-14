package com.thang.Entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the Students database table.
 * 
 */
@Data
@Entity
@Table(name="Students")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String country;

	private String fullname;

	private boolean gender;

	private double marks;

	
}