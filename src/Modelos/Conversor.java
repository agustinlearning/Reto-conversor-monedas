package Modelos;

public class Conversor {
    private String monedaOrigen;
    private String monedaDestino;
    private double tasaDeCambio;

    public Conversor(String monedaOrigen, String monedaDestino, double tasaDeCambio) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tasaDeCambio = tasaDeCambio;
    }

    // los getters ni siquiera se usan :)


    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }

    public void setTasaDeCambio(double tasaDeCambio) {
        this.tasaDeCambio = tasaDeCambio;
    }

    @Override
    public String toString() {
        return "1 " + monedaOrigen + " = " + tasaDeCambio + " " + monedaDestino;
    }
}

