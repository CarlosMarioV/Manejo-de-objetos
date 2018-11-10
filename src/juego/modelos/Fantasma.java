package juego.modelos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import juego.controlador.ControladorPrincipal;
import juego.util.Util;

import javax.swing.*;

/**
 *
 * @author Carlos Mario
 */
public class Fantasma extends Objetos implements Runnable {

    public JLabel fantasma;
    private int x, y, columna, fila;
    private String nivel = "defecto/";
    private String direccion = "derecha/";
    private Objetos[][] matrizLogica;
    private ControladorPrincipal controlador;

    public Fantasma(int fila,int columna, Objetos[][] matrizLogica, ControladorPrincipal controlador) {
        super(Util.FANTASMA);

        this.fantasma = new JLabel();
        this.fantasma.setBounds(columna*50,fila*48,50,50);
        this.fantasma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juego/img/fantasma.png")));

        this.x = columna*50;        //x1;//Posicion en la ventana eje X, Columna my
        this.y = fila*48;           //y1;//Posicion en la ventana eje Y, Fila mx
        this.columna = columna;     //Columna en la matrizLogica
        this.fila = fila;           //Fila en la matrizLogica
        this.objeto = fantasma;
        this.matrizLogica = matrizLogica;
        this.controlador = controlador;


    }

    public void setMatrizLogica(Objetos[][] matrizLogica) {
        this.matrizLogica = matrizLogica;
    }

    public JLabel getPared() {
        return fantasma;
    }

   @Override
    public void run(){
        while (true){
            mover();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Mueve el objeto por la matriz logica, si hay camino realiza el movimiento.
     * */
    public void mover() {
        int seMovio = (int) (Math.random() * 4) + 1;
        if(seMovio == Util.DERECHA) {
            //direccion = !direccion.equals("derecha/") ? "derecha/" : direccion;
            if(matrizLogica[fila][columna+1].getID().equals(Util.CAMINO)) {
                matrizLogica[fila][columna] = matrizLogica[fila][columna+1];matrizLogica[fila][columna+1] = this;
                this.columna += 1;this.x +=50;this.fantasma.setBounds(x, y, 48, 50);

            }
        }
        else if(seMovio == Util.IZQUIERDA) {
            //direccion = !direccion.equals("izquierda/") ? "izquierda/" : direccion;
            if(matrizLogica[fila][columna-1].getID().equals(Util.CAMINO)) {
                matrizLogica[fila][columna] = matrizLogica[fila][columna-1];matrizLogica[fila][columna-1] = this;
                this.columna -= 1;this.x -= 50;this.fantasma.setBounds(x, y, 48, 50);
            }
        }
        else if(seMovio == Util.ARRIBA) {
            //direccion = !direccion.equals("arriba/") ? "arriba/" : direccion;
            if(matrizLogica[fila-1][columna].getID().equals(Util.CAMINO)) {
                matrizLogica[fila][columna] = matrizLogica[fila-1][columna];matrizLogica[fila-1][columna] = this;
                this.fila -= 1;this.y -= 48;this.fantasma.setBounds(x, y, 48, 50);
            }
        }
        else if(seMovio == Util.ABAJO) {
            //direccion = !direccion.equals("abajo/") ? "abajo/" : direccion;
            if(matrizLogica[fila+1][columna].getID().equals(Util.CAMINO)) {
                matrizLogica[fila][columna] = matrizLogica[fila+1][columna];matrizLogica[fila+1][columna] = this;
                this.fila += 1;this.y += 48;this.fantasma.setBounds(x, y, 48, 50);
            }
        }
    }
    
}
