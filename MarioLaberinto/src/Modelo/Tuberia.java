/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JLabel;

/**
 *
 * @author Carlos Mario
 */
public class Tuberia extends Objetos {

    public JLabel pared;
    private String ID = "T";
     
    public Tuberia(int fila,int columna,String Mundo) 
    {
        super("T");
        this.pared = new JLabel();
        this.pared.setBounds(columna*50,fila*48,50,50);
        
        this.objeto = pared;
        switch (Mundo) {
            case "Mundo1":
                this.pared.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mundo1/final3D.jpg")));
                break;
            case "Mundo2":
                this.pared.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mundo2/finalMundo.jpg")));
                break;
        }
    }

    public JLabel getPared() {
        return pared;
    }

    @Override
    public String getID() {
        return ID;
    }
    
}
