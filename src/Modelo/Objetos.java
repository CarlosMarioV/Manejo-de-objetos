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
public class Objetos 
{
    private int x,y;
    private String ID;
    public JLabel objeto;
    public int tamañoX,tamañoY;
    
    public Objetos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Objetos(String ID) {
        this.ID = ID;
    }

    public JLabel getObjeto() {
        return objeto;
    }

    public String getID() {
        return ID;
    }
    
    public void nuevaPosicion(int fila,int columna)
    {
        objeto.setLocation(columna*tamañoX, fila*tamañoY);
    }
}
