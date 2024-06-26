import java.io.IOException;

public class CurrencyConverterHelper {

    public static double convertCurrency(String baseCurrency, String targetCurrency, double amount) throws IOException {
        double rate = ExchangeRateAPI.getRate(baseCurrency, targetCurrency);
        return amount * rate;
    }
}
