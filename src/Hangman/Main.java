package Hangman;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        GameManager manager = new GameManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("This is hangman game. If you want to start a game, type 1. If you want to exit, type 2.");
        if (scanner.hasNextInt()) {
            int command = scanner.nextInt();

            switch (command) {
                case 1: {
                    manager.Start();
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
        } else {
            System.out.println("Type a valid command!");
            scanner.next();
        }
    }
}