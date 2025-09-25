package Hangman;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;
import java.util.Scanner;

public class GameManager {

    private String current_word;
    private int lives;
    private int guesess;
    private int opened_letters;
    private boolean[] open_indexes;


    private final Drawer drawer = new Drawer();

    public void Start() {

        WordCreator wordCreator = new WordCreator();
        current_word = wordCreator.CreateWord();
        System.out.println("The game has chosen a word.");
        open_indexes = new boolean[current_word.length()];

        lives = 7;
        guesess = 0;
        opened_letters = 0;
        Game();
    }

    private void Game() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The game has started. You have 7 guesses. After spending them, you will have your last attempt. Better guess the word or you'll be hanged!");
        String game_status = CheckEnd();
        while (game_status.equals("playing")) {
            System.out.println("Type a letter to guess");
            char letter = scanner.next().charAt(0);
            MakeGuess(letter);
            PrintWord();
            game_status = CheckEnd();
        }

        if (game_status.equals("win")) {
            System.out.println("Congratulations! You have won, and you won't be hanged!");
            System.out.println("You spend " + guesess + " guesses.");
        } else if (game_status.equals("lose")) {
            System.out.println("Looks like you have lost all your lives. You have last attempt.");
            PrintWord();
            System.out.println("Type full word, or you'll be hanged!");
            String last_attempt = scanner.next();
            if (last_attempt.equals(current_word)) {
                System.out.println("You barely made it! Congratulations!");

            } else {
                System.out.println("If you'd like to know, your word is " + current_word);
                System.out.println("Hang him without remorse!");
            }
        }
        System.out.println("Actually, if you want to play another game, type 1. If you want to quit, type 2");

        int command = scanner.nextInt();
        switch (command) {
            case 1: {
                Start();
                break;
            }
            case 2: {
                System.out.println("Exiting....");
                System.exit(0);
            }
            default: {
                System.out.println("Type a valid command, please");
                break;
            }
        }
    }

    public void MakeGuess(char guess_letter) {
        guesess ++;
        boolean has_found = false;
        for (int i = 0; i < current_word.length(); i++) {
            if (current_word.charAt(i) == guess_letter && !open_indexes[i]) {
                open_indexes[i] = true;
                has_found = true;
                opened_letters ++;
            }
        }

        if (!has_found) {
            System.out.println("Oops! Bad guess, i think.");
            lives --;
            System.out.println("You have " + lives + " lives left");
            drawer.Draw(6 - lives);
        } else {
            System.out.println("Good guess!");

        }


    }

    private void PrintWord() {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < current_word.length(); i++) {
            if (open_indexes[i])
                word.append(current_word.charAt(i));
            else
                word.append(" ");
        }
        System.out.println("Your progress:");
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.charAt(i) + " ");
        }
        System.out.println();


        for (int i = 0; i < word.length(); i++) {
            System.out.print("- ");
        }

        System.out.println();

    }

    public String CheckEnd() {
        if (lives <= 0) {
            return "lose";
        }

        if (opened_letters == current_word.length()) {
            return "win";
        }

        return "playing";
    }

}
