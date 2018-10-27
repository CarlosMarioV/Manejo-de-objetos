/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Carlos Mario
 */
public class Camino extends Objetos 

{
    private String ID = "C";
    private int x,y;
    
    public Camino(int x,int y) 
    {
        super("C");
        this.x = x;
        this.y = y;
    }

    public String getID() {
        return ID;
    }
    
    
}
