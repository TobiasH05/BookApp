package bookapp;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ISBN: ");
		String isbn = scanner.nextLine();
		scanner.close();

		String book = ServerCommunication.getBookByISBN(isbn);
		System.out.println(book);
	}
}
