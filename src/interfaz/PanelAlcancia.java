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

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Panel donde se muestra el estado actual de la alcanc�a.
 */
@SuppressWarnings("serial")
public class PanelAlcancia extends JPanel {

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta donde se dibuja la alcanc�a.
     */
    private JLabel lblAlcancia;

    /**
     * Area donde se muestran los mensajes sobre la alcanc�a.
     */
    private JTextArea txtMensaje;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo panel. <br>
     * <b>post: </b> Se construy� el panel y se inicializaron sus componentes.
     */
    public PanelAlcancia() {
        setLayout(new BorderLayout());

        lblAlcancia = new JLabel(new ImageIcon("./data/alcancia.png"));
        add(lblAlcancia, BorderLayout.CENTER);

        txtMensaje = new JTextArea(3, 40);
        Font fuente = new Font("Tahoma", Font.PLAIN, 12);
        txtMensaje.setFont(fuente);
        txtMensaje.setText("Alcancia vacia");
        txtMensaje.setWrapStyleWord(true);
        txtMensaje.setLineWrap(true);
        txtMensaje.setBackground(getBackground());
        txtMensaje.setEditable(false);
        add(txtMensaje, BorderLayout.SOUTH);

        setBorder(new TitledBorder("Alcancia"));
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Cambia el mensaje mostrado. <br>
     * <b>post: </b> Se cambi� el mensaje.
     *
     * @param pMensaje Mensaje que se quiere mostrar. pMensaje != null.
     */
    public void cambiarMensaje(String pMensaje) {
        txtMensaje.setText(pMensaje);
        validate();
    }

    /**
     * Cambia el dibujo de la alcanc�a seg�n el estado actual. <br>
     * <b>post: </b> Se actualiz� el dibujo de la alcanc�a.
     *
     * @param pRota Indica si actualmente la alcanc�a est� rota o no.
     */
    public void cambiarImagenAlcancia(boolean pRota) {
        if (pRota) {
            lblAlcancia.setIcon(new ImageIcon("./data/alcanciaRota.png"));
        } else {
            lblAlcancia.setIcon(new ImageIcon("./data/alcancia.png"));
        }
        validate();
    }

}