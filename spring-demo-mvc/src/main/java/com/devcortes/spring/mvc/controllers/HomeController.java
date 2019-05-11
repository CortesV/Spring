package com.devcortes.spring.mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("main-menu")
	public String showMyHomePage() {
		return "main-menu";
	}
	
	@RequestMapping("show-form")
	public String showForm() {
		return "show-form";
	}
	
	@RequestMapping("process-form")
	public String processForm() {
		return "process-form";
	}
	
	@RequestMapping("process-form-version-two")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();
		String result = "Yo! " + theName;
		model.addAttribute("message", result);
		
		return "process-form";
	}
}