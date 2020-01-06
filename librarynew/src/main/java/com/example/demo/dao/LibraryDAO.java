package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;
import com.example.demo.model.User;

@Repository
public class LibraryDAO {
	
	public static Connection connectToDB(){
		Connection connection = null;
		
		try {
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create connection
			Connection
			connection1 = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe",
							"system",
							"admin");
			return connection1;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	
	public  ArrayList<Book> Display()
	{
		ArrayList<Book> arr=new ArrayList<Book>(); 
		PreparedStatement stmt;
		try {
			stmt = connectToDB().prepareStatement("select * from Book");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				Book obj = new Book();
				
			obj.setBookId(rs.getInt(1));
			obj.setBookName(rs.getString(2));
			obj.setPrice(rs.getDouble(3));
			
			arr.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
		
	}
		

}
