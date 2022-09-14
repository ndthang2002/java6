package com.thang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class SecurityController {
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message","vui long dang nhap!");
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message","dang nhap thanh cong!");
		return "security/login";
	}
	
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message","sai thong tin dang nhap!");
		return "security/login";
	}
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message","không có quyền truy xuất ");
		return "security/login";
	}
	
	@GetMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Bạn đã đăng xuất!");
		return "security/login";
	}

}
