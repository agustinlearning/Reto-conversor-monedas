package Modelos;

import java.util.Map;

public record ConversorRate(
        String result,
        String base_code,
        Map<String, Double> conversion_rates
) {
    @Override
    public String toString() {
        return "Tasa de cambio base: " + base_code + "\n" +
                "Monedas disponibles: " + conversion_rates.keySet();
    }
}
