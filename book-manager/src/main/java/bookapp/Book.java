package bookapp;

import java.util.Date;

public class Book {
	private String title;
	private String autohorName;
	private String isbn;
	private int pageNumber;
	private Date readDate;

	public Book(
			String title,
			String authorName,
			String isbn,
			int pageNumber,
			Date readDate) {
		this.title = title;
		this.autohorName = authorName;
		this.isbn = isbn;
		this.pageNumber = pageNumber;
		this.readDate = readDate;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthorName() {
		return autohorName;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public Date getReadDate() {
		return readDate;
	}
}
