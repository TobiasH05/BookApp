package bookapp;

import java.util.Scanner;

public class App {
	private static Bookshelf bookshelf;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Whos bookshelf is this: ");
		String owner = scanner.next();
		bookshelf = new Bookshelf(owner);

		while (true) {
			System.out.println("Choose action:");
			System.out.println("1: Exit"); // Closes session
			System.out.println("2: Check books in shelf"); // Returns all read books
			System.out.println("3: Check total pages read"); // Sums total pages for all books
			System.out.println("4: Check total pages read in given year"); // Sums total pages for books
											// read in given year
			System.out.println("5: Add custom book"); // Adds a book with given parameters
			System.out.println("6: Remove book"); // Removes book by inputing name (from list)
			System.out.println("7: Search book by isbn (returns json)"); // Uses google books API to search
											// for book by ISBN

			String action = scanner.nextLine();

			if (action.equals("1")) {
				break;
			}
		}

		scanner.close();
	}
}
