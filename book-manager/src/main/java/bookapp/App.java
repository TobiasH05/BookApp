package bookapp;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		String book = ServerCommunication.getBookByISBN("9780395951057");
		System.out.println(book);
	}
}
