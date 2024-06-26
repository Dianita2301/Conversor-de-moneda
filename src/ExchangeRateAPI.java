import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateAPI {

    private static final String API_KEY = "d88dbaa1ffb092b3f0c09041"; //coloca tu API aquí
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double getRate(String baseCurrency, String targetCurrency) throws IOException {
        String apiUrl = API_URL + baseCurrency;
        JsonObject rates = getRates(apiUrl);
        return rates.get(targetCurrency).getAsDouble();
    }

    private static JsonObject getRates(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Error en la conexión a la API: " + responseCode);
        }

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();
        reader.close();

        return jsonResponse.getAsJsonObject("conversion_rates");
    }
}

