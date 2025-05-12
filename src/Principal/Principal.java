package Principal;

import Modelos.Conversor;
import Modelos.ConversorRate;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.*;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Consulta a la exchangerate-api
        String apiKey = "0458eaa02735b70041990c6a";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //mensaje de Bienvenida
        System.out.println("Bienvenido al conversor de monedas :)");

        // Usando la libreria Gson
        Gson gson = new Gson();
        ConversorRate rates = gson.fromJson(response.body(), ConversorRate.class);
        System.out.println("Monedas disponibles: " + rates.conversion_rates().keySet());

        // Mapa de monedas comunes: clave = código, valor = nombre descriptivo
        Map<String, String> monedasComunes = Map.of(
                "DOP", "Peso Dominicano",
                "ARS", "Peso Argentino",
                "BOB", "Boliviano Boliviano",
                "BRL", "Real Brasileño",
                "CLP", "Peso Chileno",
                "COP", "Peso Colombiano",
                "USD", "Dólar Estadounidense"
        );
        System.out.println("\n=== Monedas disponibles ===");
        monedasComunes.forEach((codigo, nombre) -> {
            System.out.println(codigo + " - " + nombre);
        });
        System.out.println("==========================");

        //consulta al usuario
        String monedaOrigen;
        do {
            System.out.print("\nIngrese moneda origen (ej: USD): ");
            monedaOrigen = scanner.nextLine().toUpperCase();
            if (!monedasComunes.containsKey(monedaOrigen)) {
                System.out.println("Código no válido. Use uno de la lista.");
            }
        } while (!monedasComunes.containsKey(monedaOrigen));

        String monedaDestino;
        do {
            System.out.print("Ingrese moneda destino (ej: DOP): ");
            monedaDestino = scanner.nextLine().toUpperCase();
            if (!monedasComunes.containsKey(monedaDestino)) {
                System.out.println("Código no válido. Use uno de la lista.");
            }
        } while (!monedasComunes.containsKey(monedaDestino));

        // Cambiando moneda
        double tasa = rates.conversion_rates().get(monedaDestino) / rates.conversion_rates().get(monedaOrigen);
        Conversor conversor = new Conversor(monedaOrigen, monedaDestino, tasa);

        // escribiendo la respuesta de la api para consultarla

        String json = response.body();
//        System.out.println("Respuesta de la API:\n" + json);

        // Guardar el JSON en un archivo
        try (FileWriter file = new FileWriter("api_response.json")) {
            file.write(json);
            System.out.println("JSON guardado en api_response.json");
        } catch (IOException e) {
            System.out.println("Error al guardar el JSON: " + e.getMessage());
        }

        System.out.println(conversor);
    }
}
