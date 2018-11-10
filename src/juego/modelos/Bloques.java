/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.modelos;

import juego.util.Util;

import javax.swing.JLabel;

/**
 *
 * @author Carlos Mario
 */
public class Bloques extends Objetos{
    
    public JLabel pared;
    private String ID = "PD";
     
    public Bloques(int fila,int columna,String Mundo) 
    {
        super(Util.BLOQUE);
        this.pared = new JLabel();
        this.pared.setBounds(columna*50,fila*48,50,50);
        this.objeto = pared;
        this.tamañoX = 50;
        this.tamañoY = 48;
        switch (Mundo) {
            case "Mundo1":
                this.pared.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mundo1/muroMundo13D.jpg")));
                break;
            case "Mundo2":
                this.pared.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mundo2/muro.jpeg")));
                break;
        }
    }

    public JLabel getPared() {
        return pared;
    }

  //  @Override
//    public String getID() {
    //    return ID;
    //}
}
