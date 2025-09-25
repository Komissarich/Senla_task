package PasswordGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PwdGenerator generator = new PwdGenerator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, this is simple password generator. If you want to generate a password, type 1, if you want to exit the program, type 2.");
        while (true) {
            System.out.println("Type command");
            if (scanner.hasNextInt()) {
                int command = scanner.nextInt();

                switch (command) {
                    case 1: {
                        System.out.println("Type a length of password. It must be value between 8 and 12.");
                        if (scanner.hasNextInt()) {
                            int length = scanner.nextInt();
                            if (length < 8 || length > 12)
                                System.out.println("Invalid length!");
                            else {
                                System.out.println("Generating new password....");
                                generator.Generate(length);
                            }
                        }
                        else {
                            System.out.println("Type number!");
                            scanner.next();
                        }
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
                System.out.println("Type a number!");
                scanner.next();
            }
        }
    }
}
