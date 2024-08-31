package controlador;

import mundo.Alcancia;

public class ControladorAlcancia {
    private Alcancia alcancia;

    public ControladorAlcancia() {
        alcancia = new Alcancia(0); // Inicialmente la alcancía está vacía
    }

    public void nuevaAlcancia(int n) {
        alcancia = new Alcancia(n); // Llena la alcancía con `n` monedas
    }

    public void agregarMoneda(int denominacion) {
        switch (denominacion) {
            case 50: alcancia.agregarMoneda50(); break;
            case 100: alcancia.agregarMoneda100(); break;
            case 200: alcancia.agregarMoneda200(); break;
            case 500: alcancia.agregarMoneda500(); break;
            case 1000: alcancia.agregarMoneda1000(); break;
        }
    }

    public void romperAlcancia() {
        alcancia.romperAlcancia();
    }

    // Métodos getter que faltaban
    public String getEstadoAlcancia() {
        return alcancia.darEstadoAlcancia();
    }

    public int getNumeroMonedas50() {
        return alcancia.darNumeroMonedas50();
    }

    public int getNumeroMonedas100() {
        return alcancia.darNumeroMonedas100();
    }

    public int getNumeroMonedas200() {
        return alcancia.darNumeroMonedas200();
    }

    public int getNumeroMonedas500() {
        return alcancia.darNumeroMonedas500();
    }

    public int getNumeroMonedas1000() {
        return alcancia.darNumeroMonedas1000();
    }

    public int obtenerDenominacionMasNumerosa() {
        return alcancia.obtenerDenominacionMasNumerosa();
    }

    public boolean valiosa() {
        return alcancia.valiosa();
    }
}