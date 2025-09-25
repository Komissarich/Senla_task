package CurrencyExchange;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, this is simple currency exchanger. If you want to create currency, type 0. If you want to exchange currencies, type 1. If you want to exit the program, type 2.");
        System.out.println("The default value is US dollar with rate 1.0.");
        while (true) {
            System.out.println("Type command");
            if (scanner.hasNextInt()) {
                int command = scanner.nextInt();

                switch (command) {
                    case 0: {
                        System.out.println("Type the name of currency.");
                        String name = scanner.next();
                        System.out.println("Type its rate, in US dollar. For example, 0.5 or 100");
                        if (scanner.hasNextDouble()) {
                            double rate = scanner.nextDouble();
                            if (rate != 0.0) {
                                exchanger.AddRate(name, rate);
                            } else
                                System.out.println("Rate cannot be 0.0");

                        } else {
                            System.out.println("Type a number!");
                            scanner.next();
                        }
                        break;
                    }
                    case 1: {

                        System.out.println("Type the name of first currency");
                        String first_currency = scanner.next();
                        double first_amount = 0;
                        System.out.println("Type the amount of it.");
                        if (scanner.hasNextDouble()) {
                            first_amount = scanner.nextDouble();
                        }
                         else {
                            System.out.println("Type a number!");
                            scanner.next();
                            break;
                        }

                        System.out.println("Type the name of second currency");
                        String second_currency = scanner.next();


                        exchanger.Exchange(first_currency, first_amount, second_currency);
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
