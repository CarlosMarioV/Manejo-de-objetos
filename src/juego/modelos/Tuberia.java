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
public class Tuberia extends Objetos {

    public JLabel pared;
     
    public Tuberia(int fila,int columna,String Mundo) 
    {
        super(Util.TUBERIA);
        this.pared = new JLabel();
        this.pared.setBounds(columna*50,fila*48,50,50);
        
        this.objeto = pared;
        switch (Mundo) {
            case "Mundo1":
                this.pared.setIcon(new javax.swing.ImageIcon("src/juego/img/mundo1/final3D.jpg"));
                break;
            case "Mundo2":
                this.pared.setIcon(new javax.swing.ImageIcon("src/juego/img/mundo2/finalMundo.jpg"));
                break;
        }
    }

    public JLabel getPared() {
        return pared;
    }

    //@Override
    //public String getID() {
      //  return ID;
    //}
    
}
