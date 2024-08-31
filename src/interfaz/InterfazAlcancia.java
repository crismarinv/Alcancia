/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu�a 2 - Actividad 2
 * Ejercicio: alcancia
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package interfaz;

import controlador.ControladorAlcancia;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class InterfazAlcancia extends JFrame {
    private ControladorAlcancia controlador;
    private PanelImagen panelImagen;
    private PanelAlcancia panelAlcancia;
    private PanelBotones panelBotones;
    private PanelMonedas panelMonedas;

    public InterfazAlcancia(ControladorAlcancia controlador) {
        this.controlador = controlador;
        setTitle("Alcancía");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelImagen = new PanelImagen();
        getContentPane().add(panelImagen, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());

        panelMonedas = new PanelMonedas(this);
        panelCentral.add(panelMonedas, BorderLayout.NORTH);

        panelAlcancia = new PanelAlcancia();
        panelCentral.add(panelAlcancia, BorderLayout.CENTER);

        panelBotones = new PanelBotones(this);
        panelCentral.add(panelBotones, BorderLayout.EAST);

        getContentPane().add(panelCentral, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void nuevaAlcancia() {
        String input = JOptionPane.showInputDialog(null, "Ingrese el número de monedas para llenar la alcancía:", "Inicializar Alcancía", JOptionPane.QUESTION_MESSAGE);
        if (input != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);
            controlador.nuevaAlcancia(n);

            panelAlcancia.cambiarImagenAlcancia(false);
            panelAlcancia.cambiarMensaje("La alcancía está vacía.");

            actualizarMonedas();
        }
    }

    public void actualizarMonedas() {
        panelMonedas.cambiarCantidad(50, controlador.getNumeroMonedas50());
        panelMonedas.cambiarCantidad(100, controlador.getNumeroMonedas100());
        panelMonedas.cambiarCantidad(200, controlador.getNumeroMonedas200());
        panelMonedas.cambiarCantidad(500, controlador.getNumeroMonedas500());
        panelMonedas.cambiarCantidad(1000, controlador.getNumeroMonedas1000());
    }

    public void agregarMoneda(int pDenominacion) {
        controlador.agregarMoneda(pDenominacion);
        actualizarMonedas();
    }

    public void romperAlcancia() {
        controlador.romperAlcancia();
        panelAlcancia.cambiarImagenAlcancia(true);
        panelAlcancia.cambiarMensaje("La alcancía está rota.");
        JOptionPane.showMessageDialog(this, controlador.getEstadoAlcancia(), "Romper alcancía", JOptionPane.INFORMATION_MESSAGE);
    }

    public void reqFunc1() {
        int resultado = controlador.obtenerDenominacionMasNumerosa();
        JOptionPane.showMessageDialog(this, "La moneda más numerosa en la alcancía es la de " + resultado + " pesos", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    public void reqFunc2() {
        String resultado;
        if (controlador.valiosa()) {
            resultado = "La alcancía es valiosa, solo posee monedas de 500 y de 1000";
        } else {
            resultado = "La alcancía no es valiosa, posee monedas de denominaciones diferentes a 1000 o de 500";
        }
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            ControladorAlcancia controlador = new ControladorAlcancia();
            InterfazAlcancia interfaz = new InterfazAlcancia(controlador);

            // Solicitar cuántas monedas quiere depositar inicialmente
            interfaz.nuevaAlcancia();

            interfaz.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}