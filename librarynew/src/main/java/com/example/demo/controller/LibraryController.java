package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.services.LibraryService;

@Controller
@ResponseBody
public class LibraryController {
	
	@Autowired
	LibraryService services;
	
	@RequestMapping("/")
	public String getMessage() {
		return services.getMessage();
	}
	
	@RequestMapping("/User")
	public String getUser() {
		return "user details";
	}

}
