/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.modelos;

import juego.util.Util;

/**
 *
 * @author Carlos Mario
 */
public class Camino extends Objetos 

{
    private Character ID = Util.CAMINO;
    private int x,y;
    
    public Camino(int x,int y) 
    {
        super(Util.CAMINO);
        this.x = x;
        this.y = y;
    }

    //public String getID() {
      //  return ID;
    //}
}
