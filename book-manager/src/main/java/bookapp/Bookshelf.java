package bookapp;

import java.util.HashSet;
import java.util.Set;

public class Bookshelf {
	private Set<Book> books = new HashSet<>();

	public Set<Book> getBooks() {
		return books;
	}

	public int getTotalPages() {
		int total = 0;

		for (Book book : books) {
			total += book.getPageNumber();
		}

		return total;
	}

	public Book getBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}

		return null;
	}

	public void addBook(Book bookToAdd) {
		for (Book book : books) {
			if (book.getTitle() == bookToAdd.getTitle()) {
				throw new IllegalArgumentException(
						"Book with same title already in bookshelf: " + book.getTitle());

			}
		}

		books.add(bookToAdd);
	}

	public Book removeBook(Book book) {
		if (books.contains(book)) {
			books.remove(book);
			return book;
		}

		throw new IllegalArgumentException("Unable to remove book: book not in bookshelf: " + book.getTitle());
	}
}
