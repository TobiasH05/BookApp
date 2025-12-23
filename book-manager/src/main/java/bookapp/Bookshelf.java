package bookapp;

import java.util.HashSet;
import java.util.Set;

public class Bookshelf {
	private String owner;
	private Set<Book> books = new HashSet<>();

	public Bookshelf(String owner) {
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public Book getBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}

		// Does not throw error because user is able to search for books and may make
		// mistakes/typos
		System.out.println("Couldn't find book in bookshelft with name: " + title);
		return null;
	}

	public void addBook(Book bookToAdd) {
		for (Book book : books) {
			if (book.getTitle() == bookToAdd.getTitle()) {
				throw new IllegalArgumentException(
						"Unable to add book: book with same title already in bookshelf: "
								+ book.getTitle());

			}
		}

		books.add(bookToAdd);
		System.out.println("Successfully added book: " + bookToAdd.getTitle());
	}

	// To remove a book when only title is known, use getBookByTitle() -> Book
	// method inside this method
	public Book removeBook(Book book) {
		if (book == null) {
			System.out.println("Didn't remove book: input null.");
			return null;
		}

		if (books.contains(book)) {
			books.remove(book);
			System.out.println("Successfully removed book: " + book.getTitle());
			return book;
		}

		throw new IllegalArgumentException("Unable to remove book: book not in bookshelf: " + book.getTitle());
	}

	private int calculateTotalPages(Set<Book> booksToSum) {
		int total = 0;

		for (Book book : booksToSum) {
			total += book.getPageNumber();
		}

		return total;
	}

	public int getTotalPages() {
		return calculateTotalPages(books);
	}

	@SuppressWarnings("deprecation")
	public Set<Book> getBooksByYear(int year) {
		Set<Book> matchingBooks = new HashSet<>();

		for (Book book : books) {
			if (book.getReadDate().getYear() == year) {
				matchingBooks.add(book);
			}
		}

		return matchingBooks;
	}

	public int getTotalPagesByYear(int year) {
		return calculateTotalPages(getBooksByYear(year));
	}
}
