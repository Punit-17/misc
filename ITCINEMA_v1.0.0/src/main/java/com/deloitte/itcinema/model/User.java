package com.deloitte.itcinema.model;

import java.util.ArrayList;

public class User {
	private String userName;
	private String userEmail;
	private String movieBooked;
	private String bookingDate;
	private ArrayList<String> seatsBooked;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getMovieBooked() {
		return movieBooked;
	}
	public void setMovieBooked(String movieBooked) {
		this.movieBooked = movieBooked;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public ArrayList<String> getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(ArrayList<String> seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
}
