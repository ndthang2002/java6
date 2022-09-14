package com.thangtq.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Students")
public class Student {
	@Id
	String email;
	String fullname;
	Double marks;
	Boolean gender;
	String country;
}
