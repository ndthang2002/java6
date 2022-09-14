package com.thang.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.File;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thang.bean.Student;

@Controller
public class Student2Controller {
	@RequestMapping("student2/list")
	public String list(Model model, @RequestParam("index") Optional<Integer> index) throws IOException {
		
		java.io.File file = new ClassPathResource("/static/students.json").getFile();
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Student>> type= new TypeReference<List<Student>>() {};
		List<Student> list = mapper.readValue(file, type);
		model.addAttribute("sv",list.get(index.orElse(0)));
		model.addAttribute("dssv",list);
		return "student/list";
		
	}

}
