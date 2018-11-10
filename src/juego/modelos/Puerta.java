package juego.modelos;

import juego.util.Util;

import javax.swing.*;

public class Puerta extends Objetos {
    public JLabel puerta;

    public Puerta(int fila, int columna) {
        super(Util.PUERTA);
        this.puerta = new JLabel();
        this.puerta.setBounds(columna * 50, fila * 48, 50, 50);

        this.objeto = puerta;
        this.puerta.setIcon(new javax.swing.ImageIcon( Util.rutaImagenes + "puerta.png"));

    }
}
