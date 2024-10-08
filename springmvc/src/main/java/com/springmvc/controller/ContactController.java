package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
    public UserService userService;
	
	
	@ModelAttribute
	public void common()
	{
		
		System.out.println("Common method..");
		
		
	}
	
	@RequestMapping("/contact")
	public String showForm() {
		
		System.out.println("contact");
		return "contact";
	}

	
//	@RequestMapping(path = "/processForm",method = RequestMethod.POST)
//	public String handleFrom(@RequestParam("email") String email,
//			@RequestParam("userName") String userName,
//			@RequestParam("password") String password,Model model)
//	{
//		
//		System.out.println(email);
//		System.out.println(userName);
//		System.out.println(password);
//		
//		model.addAttribute("email", email);
//		model.addAttribute("userName", userName);
//		model.addAttribute("password", password);
//		
//		
//		return "success";
//	}
	
	@RequestMapping(path = "/processForm",method = RequestMethod.POST)
	public String handleFrom(@ModelAttribute User user)
	{
		
		System.out.println(user);
		
		this.userService.insert(user);
		
		System.out.println("inserted...");
		return "success";
	}
	
	
}
