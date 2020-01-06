package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LibraryDAO;

@Service
public class LibraryService {
	
	
	@Autowired
	LibraryDAO dao;
	public String getMessage() {
		return dao.getMessage();
		
	}
	

}
