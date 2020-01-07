package com.deloitte.itcinema.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.itcinema.model.*;
import com.deloitte.itcinema.services.MovieServices;

@Controller
@ResponseBody
public class MovieController {
	
	@Autowired
	MovieServices service;
	@GetMapping("/")
	public ModelAndView getAllMovies(){
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("index");
//		modelAndView.addObject("allMovies","Welcome");
//		return modelAndView;
		//service.getAllMovies()
		
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@PostMapping(value="/addmovie")
	public String postMovie(Movie movie) {
		HttpHeaders headers= new HttpHeaders();
		headers.set("Content-Type", "application/x-www-form-urlencoded");
		boolean status = service.postMovie(movie);
		
		if(status)return "Movie Added.";
		else return "Movie Not Added";
	}
	
	@GetMapping("/seats")
	public ArrayList<String> getSeats(int movieId){
		return service.getSeats(movieId);
	}
	
	@GetMapping("/invoice")
	public ArrayList<User> getInvoice() {
		return service.getInvoice();
	}
	
	@PostMapping("/userinfo")
	public void postUserData(@RequestBody User booking) {
		service.postUserData(booking);
	}
	
	@PostMapping("/adminsignup")
	public void postAdminData(@RequestBody Admin admin) {
		service.postAdminData(admin);
	}
	@GetMapping("/adminlogin")
	public ModelAndView getAdminData(){
		return null;
	}
	
//	@GetMapping("/form")
//	public ModelAndView loginForm() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("login");
//		return modelAndView;
//	}
//	@GetMapping("/adminauth")
//	public ModelAndView adminAuth(@RequestParam("username") String username, 
//			@RequestParam("password") String password) {
//		ModelAndView modelAndView = new ModelAndView();
//		if(service.getAuth(username,password)) {
//			modelAndView.setViewName("index");
//			modelAndView.addObject("auth","Hello "+username);
//		}else {
//			modelAndView.setViewName("login");
//			modelAndView.addObject("auth","Invalid User");
//		}
//		
//		return modelAndView;
//	}
	
	
}
