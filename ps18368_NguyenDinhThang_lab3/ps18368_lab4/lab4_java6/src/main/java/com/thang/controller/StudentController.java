package com.thang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.Dao.StudentDao;
import com.thang.bean.Student;
import com.thang.bean.StudentMap;

@Controller
public class StudentController {

	
	@Autowired
	StudentDao dao;
	
	@RequestMapping("/student/index")
	public String index(Model model) {
		Student student = new Student("","",0.0,true,"VN");
		model.addAttribute("form",student);
		StudentMap map = dao.findAll();
		model.addAttribute("items",map);
		return "student/index";
	}
	
	@RequestMapping("/student/edit/{key}")
	public String edit(Model model,@PathVariable("key") String key) {
		model.addAttribute("key",key);
		Student student = dao.findByKey(key);
		model.addAttribute("form",student);	
		StudentMap map = dao.findAll();
		model.addAttribute("items", map);
		return "student/index";
	}
//	@RequestMapping("/student/delete/${key}")
//	public String delete(Model model ,@PathVariable("key") String key) {
//		Student student = dao.findByKey(key);
//		dao.delete);
//		model.addAttribute("message","Xóa thành công");
//		return "student/index";
//		
//	}
	@RequestMapping("/student/reset")
	public String reset() {
		return "student/index";
	}
	//theem moi 1
	@PostMapping("/student/create")
	public String create(Model model,@ModelAttribute("form") Student stu) {
		dao.create(stu);
		model.addAttribute("message", "thanh cong");
		StudentMap student = dao.findAll();
		model.addAttribute("items", student);		
		return "redirect:/student/index";
	}
	// thêm mới 2
//	@RequestMapping("/student/create")
//	public String create(Student student) {
//		dao.create(student);
//		return "redirect:/student/index";
//	}
	
	//sửa dữ liệu form
	@RequestMapping("/student/update/{key}")
	public String update(@PathVariable("key")String key, Student student) {
		dao.update(key,student);
		return "redirect:/student/edit/"+key;
		
	}
	
	@RequestMapping("/student/delete/{key}")
	public String delete(@PathVariable("key") String key) {
		dao.delete(key);
		return "redirect:/student/index";
	}
}

