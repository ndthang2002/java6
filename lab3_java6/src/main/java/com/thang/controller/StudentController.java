package com.thang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thang.bean.Student;

@Controller
public class StudentController {

	@GetMapping("student/form")
	public String form(Model model) {
		Student student = new Student();
		student.setFullname("nguyen dinh thang");
		student.setCountry("VN");
		student.setGender(true);
		model.addAttribute("sv",student);
		return "student/form";
	}
	@GetMapping("/student/save")
	public String save( Model model ,@Validated @ModelAttribute("sv") Student form,Errors errors) {
		if(errors.hasErrors()) {
			model.addAttribute("message","vui long sua cac loi sau:");
			return "student/form";
		}
		return "student/success";
	}
}
