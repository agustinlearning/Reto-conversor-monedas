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

        // Usando la libreria Gson
        Gson gson = new Gson();
        ConversorRate rates = gson.fromJson(response.body(), ConversorRate.class);
        System.out.println("Monedas disponibles: " + rates.conversion_rates().keySet());

        // Consulta usuario
        System.out.print("Moneda origen (ej: USD): ");
        String monedaOrigen = scanner.nextLine().toUpperCase();

        System.out.print("Moneda destino (ej: DOP): ");
        String monedaDestino = scanner.nextLine().toUpperCase();

        // Cambiando moneda
        double tasa = rates.conversion_rates().get(monedaDestino) / rates.conversion_rates().get(monedaOrigen);
        Conversor conversor = new Conversor(monedaOrigen, monedaDestino, tasa);

        // escribiendo la respuesta de la api para consultarla

        String json = response.body();
        System.out.println("Respuesta de la API:\n" + json);

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
