package com.example.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.dao.mallrepository;
import com.example.mall.entity.service;

@Controller
public class mallcontroller {
	@Autowired
	private mallrepository a;
	@GetMapping("/")
	public String signupPage(Model model){
		model.addAttribute("user", new service());
		return "login";
	}
	@PostMapping ("/login")
		public String loginPage(service ser) {
		a.save(ser);
		return "login";
	}
	@GetMapping("/dashboard")
	public String dashboardPage(Model model) {
		model.addAttribute("user", new service());
		return "dashboard";
	}
	@PostMapping("/dashboard")
	public String validate(@RequestParam("mail") String mail,@RequestParam("password") String password, Model model) {
		if(isValidUser(mail, password)) {
			return "dashboard";
		}
		else {
			model.addAttribute("error","Invalid");
			return "login";
		}
	}
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new service());
		return "index";
	}
	
	private boolean isValidUser(String mail, String password) {
		service ser= a.findByMail(mail);
		if(ser !=null && ser.getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
}

	
 