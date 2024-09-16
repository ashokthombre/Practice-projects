package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home")
   public String home(Model model)
{
    model.addAttribute("name","Ashoka");
    System.out.println("home");
    return "index";
}


@RequestMapping(path = "/about",method = RequestMethod.GET)
public String about()
{
    System.out.println("this is about");
    return "about";
}

@RequestMapping("/help")
public ModelAndView help()
{
	
	ModelAndView modelAndView=new ModelAndView();
	modelAndView.addObject("name","ashoka");
	modelAndView.setViewName("help");
    
	
	return modelAndView;
	
}
}
