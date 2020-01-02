package com.deloitte.services;

import com.deloitte.dao.BooksDAO;
import com.deloitte.model.BookDetails;

public class BookImplement implements BookInterface {

	@Override
	public BookDetails addBook(String bookName, String author, int price) {
		// TODO Auto-generated method stub

		BookDetails ob1 = new BookDetails();
		ob1.setBookName(bookName);
		ob1.setAuthor(author);
		ob1.setPrice(price);
		ob1.setBookId(BookDetails.getBookcounter());
		BooksDAO.addBook(ob1);
		return ob1;
	}

}
