package bookapp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServerCommunication {
	private static HttpClient client = HttpClient.newHttpClient();

	public static String getBookByISBN(String isbn) {
		String url = "https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&format=json&jscmd=data";

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.statusCode());

			return response.body();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println("Request interrupted");
		} catch (IOException e) {
			System.err.println("Network error: " + e.getMessage());
		}
		return null;
	}
}
