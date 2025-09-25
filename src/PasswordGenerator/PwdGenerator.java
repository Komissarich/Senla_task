package PasswordGenerator;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class PwdGenerator {
    private String[] saved_passwords;

    public void Generate(int length) {
        StringBuilder password;
        Random rnd = new Random();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890#?!@$%^&*-";

        int attempts = 0;
        int max_attempts = 1000;
        do {
            password = new StringBuilder();
            attempts ++;
            if (attempts >= max_attempts) {
                throw new IllegalStateException("Couldn't generate a password. Try restart the program");
            }
            for (int i = 0; i < length; i++) {
                int index = rnd.nextInt(letters.length());
                password.append(letters.charAt(index));
            }
        }
        while (!ValidatePassword(String.valueOf(password)));

        System.out.println("Successfully generated a password: " + password + "\nWith " + attempts + " attempts");
    }

    private boolean ValidatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,12}$");
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}

