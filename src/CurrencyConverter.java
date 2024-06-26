import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("***********************************************");
            System.out.println("Bienvenido/a al conversor de moneda");
            System.out.println("***********************************************");

            System.out.println("Seleccione la opción de conversión de moneda:");
            System.out.println("1. De USD a ARS (peso argentino)");
            System.out.println("2. De ARS a USD (dólar estadounidense)");
            System.out.println("3. De USD a BOB (boliviano boliviano)");
            System.out.println("4. De BOB a USD (dólar estadounidense)");
            System.out.println("5. De USD a BRL (real brasileño)");
            System.out.println("6. De BRL a USD (dólar estadounidense)");
            System.out.println("7. De USD a CLP (peso chileno)");
            System.out.println("8. De CLP a USD (dólar estadounidense)");
            System.out.println("9. De USD a COP (peso colombiano)");
            System.out.println("10.De COP a USD (dólar estadounidense)");
            System.out.println("11. Salir");
            int option = scanner.nextInt();

            if (option == 11) {
                System.out.println("Saliendo...");
                break;
            }

            System.out.println("Ingrese la cantidad:");
            double amount = scanner.nextDouble();

            try {
                String baseCurrency, targetCurrency;
                switch (option) {
                    case 1:
                        baseCurrency = "USD";
                        targetCurrency = "ARS";
                        break;
                    case 2:
                        baseCurrency = "ARS";
                        targetCurrency = "USD";
                        break;
                    case 3:
                        baseCurrency = "USD";
                        targetCurrency = "BOB";
                        break;
                    case 4:
                        baseCurrency = "BOB";
                        targetCurrency = "USD";
                        break;
                    case 5:
                        baseCurrency = "USD";
                        targetCurrency = "BRL";
                        break;
                    case 6:
                        baseCurrency = "BRL";
                        targetCurrency = "USD";
                        break;
                    case 7:
                        baseCurrency = "USD";
                        targetCurrency = "CLP";
                        break;
                    case 8:
                        baseCurrency = "CLP";
                        targetCurrency = "USD";
                        break;
                    case 9:
                        baseCurrency = "USD";
                        targetCurrency = "COP";
                        break;
                    case 10:
                        baseCurrency = "COP";
                        targetCurrency = "USD";
                        break;
                    default:
                        throw new IllegalArgumentException("Opción no válida");
                }

                double convertedAmount = CurrencyConverterHelper.convertCurrency(baseCurrency, targetCurrency, amount);
                System.out.printf("%.2f %s equivale a %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
            } catch (IOException e) {
                System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
