package bookapp;

import java.util.Date;
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

			switch (action) {
				case "1":
					break;
				case "2":
					checkBooks();
				case "3":
					System.out.println(Integer.toString(bookshelf.getTotalPages()));
				case "4":
					checkPagesByYear(scanner);
				case "5":
					addBook(scanner);
				case "6":
					System.out.print("Title to remove: ");
					bookshelf.removeBook(bookshelf.getBookByTitle(scanner.nextLine()));
				case "7":
					System.out.println("ISBN: ");
					ServerCommunication.getBookByISBN(scanner.nextLine());
				default:
					System.out.println("No valid input given: try again");
			}
		}

		scanner.close();
	}

	private static void checkBooks() {
		if (bookshelf.getBooks().isEmpty()) {
			System.out.println("No books in bookshelf");
			return;
		}

		System.out.println("Books in collection:");
		for (Book book : bookshelf.getBooks()) {
			System.out.println(book.getTitle());
		}
	}

	private static void checkPagesByYear(Scanner scanner) {
		System.out.print("Year: ");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.println(Integer.toString(bookshelf.getTotalPagesByYear(year)));
	}

	@SuppressWarnings("deprecation")
	private static void addBook(Scanner scanner) {
		System.out.print("Title: ");
		String title = scanner.nextLine();
		System.out.print("Author: ");
		String author = scanner.nextLine();
		System.out.print("Pages: ");
		int pages = Integer.parseInt(scanner.nextLine());
		System.out.println("Year read: ");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.println("Month read (1-12 inclusive)");
		int month = Integer.parseInt(scanner.nextLine());
		System.out.println("Day read (1-month length inclusive)");
		int day = Integer.parseInt(scanner.nextLine());

		Date readDate = new Date(year, month, day);

		Book book = new Book(
				title,
				author,
				"",
				pages,
				readDate);

		bookshelf.addBook(book);
	}
}
