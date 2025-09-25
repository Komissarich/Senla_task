package CurrencyExchange;

import java.util.HashMap;
import java.util.Map;

public class Exchanger {
    private final Map<String, Double> exchange_rates;

    public Exchanger() {
        exchange_rates = new HashMap<>();
        exchange_rates.put("USD", 1.0);
    }

    public void AddRate(String name, Double rate) {
        exchange_rates.put(name, rate);
        System.out.println("Successfully added new currency.");
    }

    public void Exchange(String first_key, double first_amount, String second_key) {
        if (exchange_rates.containsKey(first_key) || exchange_rates.containsKey(second_key)) {
            double rate = first_amount * exchange_rates.get(second_key) / exchange_rates.get(first_key);
            System.out.println("================");
            System.out.println(first_amount + " in " + first_key);
            System.out.println("    is    ");
            System.out.println(rate + " in " + second_key);
            System.out.println("================");
        }
    }
}
