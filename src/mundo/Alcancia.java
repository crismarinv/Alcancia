package mundo;

import java.util.Random;

public class Alcancia {
    private int numeroMonedas50;
    private int numeroMonedas100;
    private int numeroMonedas200;
    private int numeroMonedas500;
    private int numeroMonedas1000;
    private int estado;

    public Alcancia(int n) {
        numeroMonedas50 = 0;
        numeroMonedas100 = 0;
        numeroMonedas200 = 0;
        numeroMonedas500 = 0;
        numeroMonedas1000 = 0;
        estado = 0;

        llenarAlcancia(n);
    }

    private void llenarAlcancia(int n) {
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int denominacion = random.nextInt(5);

            if (estado == 0) {
                switch (denominacion) {
                    case 0: numeroMonedas50++; break;
                    case 1: numeroMonedas100++; break;
                    case 2: numeroMonedas200++; break;
                    case 3: numeroMonedas500++; break;
                    case 4: numeroMonedas1000++; break;
                }
            }
        }
    }

    public int darNumeroMonedas50() { return numeroMonedas50; }
    public int darNumeroMonedas100() { return numeroMonedas100; }
    public int darNumeroMonedas200() { return numeroMonedas200; }
    public int darNumeroMonedas500() { return numeroMonedas500; }
    public int darNumeroMonedas1000() { return numeroMonedas1000; }
    public String darEstado() { return estado == 0 ? "NO ROTA" : "ROTA"; }
    public int calcularTotalDinero() {
        return numeroMonedas50 * 50 +
               numeroMonedas100 * 100 +
               numeroMonedas200 * 200 +
               numeroMonedas500 * 500 +
               numeroMonedas1000 * 1000;
    }
    public String darEstadoAlcancia() {
        int totalDinero = calcularTotalDinero();
        return "La alcancía tiene: \n " +
                numeroMonedas50 + " moneda(s) de $50 \n " +
                numeroMonedas100 + " moneda(s) de $100 \n " +
                numeroMonedas200 + " moneda(s) de $200 \n " +
                numeroMonedas500 + " moneda(s) de $500 \n " +
                numeroMonedas1000 + " moneda(s) de $1000 \n " +
                "Para un total de $" + totalDinero + " pesos.";
    }

    public void agregarMoneda50() { if (estado == 0) numeroMonedas50++; }
    public void agregarMoneda100() { if (estado == 0) numeroMonedas100++; }
    public void agregarMoneda200() { if (estado == 0) numeroMonedas200++; }
    public void agregarMoneda500() { if (estado == 0) numeroMonedas500++; }
    public void agregarMoneda1000() { if (estado == 0) numeroMonedas1000++; }
    public void romperAlcancia() { estado = 1; }
    public int obtenerDenominacionMasNumerosa() {
        int maxMonedas = Math.max(Math.max(numeroMonedas50, numeroMonedas100),
                                  Math.max(numeroMonedas200, Math.max(numeroMonedas500, numeroMonedas1000)));
        if (maxMonedas == numeroMonedas50) return 50;
        if (maxMonedas == numeroMonedas100) return 100;
        if (maxMonedas == numeroMonedas200) return 200;
        if (maxMonedas == numeroMonedas500) return 500;
        return 1000;
    }
    public boolean valiosa() {
        return (numeroMonedas50 == 0 && numeroMonedas100 == 0 && numeroMonedas200 == 0);
    }
}