package Hangman;
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse;

public class WordCreator {


    public String CreateWord() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://random-word-api.herokuapp.com/word"))
                    .build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String word  = response.body().toString();
            word = word.substring(2, word.length() - 2);
            return word;

        } catch (Exception e) {
            System.out.println("Error in sending request: " + e);
            throw new RuntimeException(e);
        }

    }
}
