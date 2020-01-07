package com.deloitte.itcinema.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.itcinema.dao.MovieDAO;
import com.deloitte.itcinema.model.Admin;
import com.deloitte.itcinema.model.Movie;
import com.deloitte.itcinema.model.User;

@Service
public class MovieServices {
	@Autowired
	MovieDAO dao;
	
	public ArrayList<Movie> getAllMovies(){
		return dao.getAllMovies();
	}
	public boolean postMovie(Movie movie) {
		return dao.postMovie(movie);
	}
	
	public ArrayList<String> getSeats(int movieId){
		return dao.getSeats(movieId);
	}
	
	public ArrayList<User> getInvoice() {
		return dao.getInvoice();
	}
	
	public void postUserData(User booking) {
		dao.postUserData(booking);
	}
	
	public void postAdminData(Admin admin) {
		dao.postAdminData(admin);
	}
	
	public Admin getAdminData(){
		return dao.getAdminData();
	}
	public boolean getAuth(String username, String password) {
		// TODO Auto-generated method stub
		return dao.getAuth(username,password);
	}
}
