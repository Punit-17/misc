package com.deloitte.dao;

import java.sql.*;

import com.deloitte.main.Books;
import com.deloitte.model.BookDetails;

public class BooksDAO {
	
	public static Connection connectToDB(){
		Connection connection = null;
		
		try {
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create connection
			Connection connection1 = DriverManager.getConnection
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
	
	public static void addBook(BookDetails ob1) {
		
		System.out.println(ob1);
		
		//create statement
		try {
			PreparedStatement stmt = connectToDB().prepareStatement("insert into books values (?,?,?,?)");
			stmt.setInt(1, ob1.getBookId());
			stmt.setString(2, ob1.getBookName());
			stmt.setString(3,ob1.getAuthor());
			stmt.setInt(4,ob1.getPrice());
			//execute sql query
			int affectedRows = stmt.executeUpdate();
			System.out.println("affected rows : "+affectedRows);
			//close the connection
			connectToDB().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
