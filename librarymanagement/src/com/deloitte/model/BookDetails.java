package com.deloitte.model;

public class BookDetails {
	private static int bookcounter = 1000;
	private int bookId;
	private String bookName;
	private String author;
	private int price;

	public BookDetails() {
		bookcounter++;
	}

	public static int getBookcounter() {
		return bookcounter;
	}

	public static void setBookcounter(int bookcounter) {
		BookDetails.bookcounter = bookcounter;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ "]";
	}

}
