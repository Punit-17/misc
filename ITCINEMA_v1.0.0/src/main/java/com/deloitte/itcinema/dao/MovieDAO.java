package com.deloitte.itcinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.deloitte.itcinema.model.Admin;
import com.deloitte.itcinema.model.Movie;
import com.deloitte.itcinema.model.User;

@Repository
public class MovieDAO {
	public Connection connectionToDB() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<Movie> getAllMovies() {
		Connection con = connectionToDB();
		String sql = "select * from movie";
		Statement st;
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Movie movie  = new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieRating(rs.getString(3));
				movie.setTotalSeats(rs.getInt(4));
				movie.setAvailableSeats(rs.getInt(5));
				movie.setPosterURL(rs.getString(6));
				
				movies.add(movie);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movies;
	}

	public ArrayList<String> getSeats(int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> getInvoice() {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin getAdminData() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean postMovie(Movie movie) {
		// TODO Auto-generated method stub
		Connection con = connectionToDB();
		try {
//		String sql = "insert into movie(movieid,moviename,movierating,totalseats,availableseats,posterurl) values"
//				+ "(?,'?','?',?,?,'?')";
//		
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setInt(1, movie.getMovieId());
//		st.setString(2, movie.getMovieName());
//		st.setString(3,movie.getMovieRating());
//		st.setInt(4, movie.getTotalSeats());
//		st.setInt(5, movie.getAvailableSeats());
//		st.setString(6, movie.getPosterURL());
			
		String sql = "insert into movie values"
				+ "("+movie.getMovieId()+",'"+movie.getMovieName()+"','"
						+ movie.getMovieRating()+"',"+movie.getTotalSeats()+","
								+movie.getAvailableSeats() +",'"+movie.getPosterURL()+"')"; 
		Statement st = con.createStatement();
		st.executeUpdate(sql);
		con.commit();
		con.close();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
		
	}

	public void postAdminData(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	public void postUserData(User booking) {
		// TODO Auto-generated method stub
		
	}

	public boolean getAuth(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Connection con = connectionToDB();
			PreparedStatement st = con.prepareStatement("select * from movieadmin where username = ? and password = ?");
			st.setString(1, username);
			st.setString(2, password);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				return true;
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
