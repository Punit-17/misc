package com.deloitte.services;

import com.deloitte.model.BookDetails;

public interface BookInterface {

	public BookDetails addBook(String bookName, String author, int price);
}
