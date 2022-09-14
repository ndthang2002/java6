package com.thang.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thang.bean.Student;

@Controller
public class StudentController {

	@RequestMapping("/student")
	public String index(Model model, @RequestParam("index") Optional<Integer> index) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		java.io.File path = ResourceUtils
				.getFile("C:\\dev\\tools\\workspace\\lab2_java6\\src\\main\\resources\\students.json");
		TypeReference<List<Student>> typeref = new TypeReference<>() {};		
		List<Student> students = mapper.readValue(path, typeref);
		int i = index.orElse(0);
		
		
			model.addAttribute("disableN","class=disabled");
		
		model.addAttribute("n", i);
		model.addAttribute("sv", students.get(i));
		return "scope/student";
		
	}
}
