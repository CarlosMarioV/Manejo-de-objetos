package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author Carlos Mario
 */
public class Fantasma extends Objetos {
    //TODO: Hacerla en Hilo
    public JLabel fantasma;
    private String ID = "F";

    public Fantasma(int fila,int columna,String Mundo) {
        super("F");

        this.fantasma = new JLabel();
        this.fantasma.setBounds(columna*50,fila*48,50,50);

        this.objeto = fantasma;

        this.fantasma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fantasma.jpg")));

    }

    public JLabel getPared() {
        return fantasma;
    }

    @Override
    public String getID() {
        return ID;
    }

    public void run(){

    }
    
}
