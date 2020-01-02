package com.deloitte.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.deloitte.model.BookDetails;
import com.deloitte.services.BookImplement;

public class Books {

	public static void main(String[] args) {

		Scanner ob = new Scanner(System.in);
		BookImplement mainBookOb = new BookImplement();
		ArrayList<BookDetails> books = new ArrayList<BookDetails>();

		while (true) {
			System.out.println("1.Add\n2.display\n3.exit");
			int option = Integer.parseInt(ob.next());

			switch (option) {
			case 1:
				System.out.println("Enter book name");
				String name = ob.next();
				System.out.println("Enter book price");
				int price = ob.nextInt();
				System.out.println("Enter book author");
				String author = ob.next();

				BookDetails ob2 = mainBookOb.addBook(name, author, price);
				books.add(ob2);
				break;
			case 2:

				for (BookDetails alvariable : books) {
					System.out.println(alvariable);
				}
				break;

			case 3:
				ob.close();
				System.exit(0);
				break;

			}

		}

	}
}
