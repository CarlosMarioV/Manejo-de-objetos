/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.modelos;

import javax.swing.JLabel;
import java.awt.*;

/**
 *
 * @author Carlos Mario
 */
public abstract class Objetos {
    private int x,y;
    private Character ID;
    public JLabel objeto;
    public int tamañoX,tamañoY;

    public Image img;
    
    public Objetos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Objetos(Character ID) {
        this.ID = ID;
    }

    public JLabel getObjeto() {
        return objeto;
    }

    public Character getID() {
        return ID;
    }
    
    public void nuevaPosicion(int fila,int columna)
    {
        objeto.setLocation(columna*tamañoX, fila*tamañoY);
    }

}
