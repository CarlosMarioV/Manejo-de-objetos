package Modelo;

import javax.swing.*;

public class Llave extends Objetos {

    public JLabel Llave;
    private String ID = "k";

    public Llave(int fila,int columna,String Mundo) {
        super("k");

        this.Llave = new JLabel();
        this.Llave.setBounds(columna*50,fila*48,50,50);

        this.objeto = Llave;

        this.Llave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Llave.jpg")));

    }

    public JLabel getPared() {
        return Llave;
    }

    @Override
    public String getID() {
        return ID;
    }
}
