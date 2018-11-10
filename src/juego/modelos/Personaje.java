package juego.modelos;


import juego.controlador.ControladorPrincipal;
import juego.util.Util;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;


/**
 * This class contain the method for the character, the moves and other.
 * @author Carlos Mario
 */
public class Personaje extends Objetos
{
    private JLabel cuerpo = new JLabel();
    private int x,y,columna,fila;
    private String nivel = "defecto/";
    private String direccion = "derecha/";

    public Personaje(int columna, int fila) {
        super(Util.PERSONAJE);
        this.x = columna*50;        //x1;//Posicion en la ventana eje X, Columna my
        this.y = fila*48;           //y1;//Posicion en la ventana eje Y, Fila mx
        this.columna = columna;     //Columna en la matrizLogica
        this.fila = fila;           //Fila en la matrizLogica

        this.cuerpo.setIcon(new javax.swing.ImageIcon(Util.rutaImagenes + "personaje/" +this.nivel +
                this.direccion + "1.gif"));
        this.cuerpo.setBounds(x, y, 48, 50);

    }
    
    public JLabel getCuerpo() {
        return cuerpo;
    }

    public void mover(KeyEvent movimiento, Objetos[][] matrizLogica) {
        int seMovio = movimiento.getKeyCode();
        if(seMovio == KeyEvent.VK_RIGHT) {
            direccion = !direccion.equals("derecha/") ? "derecha/" : direccion;
            if(matrizLogica[fila][columna+1].getID().equals(Util.CAMINO)) {
                    matrizLogica[fila][columna] = matrizLogica[fila][columna+1];matrizLogica[fila][columna+1] = this;
                    this.columna += 1;this.x +=50;this.cuerpo.setBounds(x, y, 48, 50);

                }
        }
        else if(seMovio == KeyEvent.VK_LEFT) {
            direccion = !direccion.equals("izquierda/") ? "izquierda/" : direccion;
            if(matrizLogica[fila][columna-1].getID().equals(Util.CAMINO)) {
                matrizLogica[fila][columna] = matrizLogica[fila][columna-1];matrizLogica[fila][columna-1] = this;
                this.columna -= 1;this.x -= 50;this.cuerpo.setBounds(x, y, 48, 50);
            }
        }
        else if(seMovio == KeyEvent.VK_UP) {
            direccion = !direccion.equals("arriba/") ? "arriba/" : direccion;
            if(matrizLogica[fila-1][columna].getID().equals(Util.CAMINO)) {
                matrizLogica[fila][columna] = matrizLogica[fila-1][columna];matrizLogica[fila-1][columna] = this;
                this.fila -= 1;this.y -= 48;this.cuerpo.setBounds(x, y, 48, 50);
            }
        }
        else if(seMovio == KeyEvent.VK_DOWN) {
            direccion = !direccion.equals("abajo/") ? "abajo/" : direccion;
            if(matrizLogica[fila+1][columna].getID().equals(Util.TUBERIA)) {
                    JOptionPane.showMessageDialog(null, "*** GANASTE.. ***!!", "Falicidades",
                            JOptionPane.INFORMATION_MESSAGE);
                    ControladorPrincipal.FinJuego = true;
                }
            
            if(matrizLogica[fila+1][columna].getID().equals(Util.CAMINO)) {
                matrizLogica[fila][columna] = matrizLogica[fila+1][columna];matrizLogica[fila+1][columna] = this;
                this.fila += 1;this.y += 48;this.cuerpo.setBounds(x, y, 48, 50);
            }
        }cambiarImagen();
    }
    
    public void moverConBloque(KeyEvent movimiento, Objetos[][] matrizLogica) {

        System.out.println("Me movi2");
        int seMovio = movimiento.getKeyCode();
        Camino camino;
        if((matrizLogica[fila][columna+1].getID().equals("PD"))&&(matrizLogica[fila][columna+2].getID().equals("C"))&&
                (seMovio == KeyEvent.VK_RIGHT))
        {
            matrizLogica[fila][columna] = (camino = new Camino(fila,columna));
            matrizLogica[fila][columna+1].nuevaPosicion(fila, columna+2);
            matrizLogica[fila][columna+2] = matrizLogica[fila][columna+1];
            matrizLogica[fila][columna+1] = this;
            this.columna += 1;this.x +=50;this.cuerpo.setBounds(x, y, 48, 50);  
        }
        else if((matrizLogica[fila][columna-1].getID().equals("PD")) && (matrizLogica[fila][columna-2].getID().equals("C"))
                &&(seMovio == KeyEvent.VK_LEFT))
        {
            matrizLogica[fila][columna] = (camino = new Camino(fila,columna));
            matrizLogica[fila][columna-1].nuevaPosicion(fila, columna-2);
            matrizLogica[fila][columna-2] = matrizLogica[fila][columna-1];
            matrizLogica[fila][columna-1] = this;
            this.columna -= 1;this.x -= 50;this.cuerpo.setBounds(x, y, 48, 50);
        }
        else if((matrizLogica[fila-1][columna].getID().equals("PD")) && (matrizLogica[fila-2][columna].getID().equals("C"))&&
                (seMovio == KeyEvent.VK_UP))
        {
            matrizLogica[fila][columna] = (camino = new Camino(fila,columna));
            matrizLogica[fila-1][columna].nuevaPosicion(fila-2, columna);
            matrizLogica[fila-2][columna] = matrizLogica[fila-1][columna];
            matrizLogica[fila-1][columna] = this;
                this.fila -= 1;this.y -= 48;this.cuerpo.setBounds(x, y, 48, 50);
        }
        else if((matrizLogica[fila+1][columna].getID().equals("PD")) && (matrizLogica[fila+2][columna].getID().equals("C"))&&
                (seMovio == KeyEvent.VK_DOWN))
        {
            matrizLogica[fila][columna] = (camino = new Camino(fila,columna));
            matrizLogica[fila+1][columna].nuevaPosicion(fila+2, columna);
            matrizLogica[fila+2][columna] = matrizLogica[fila+1][columna];
            matrizLogica[fila+1][columna] = this;
            this.fila += 1;this.y += 48;this.cuerpo.setBounds(x, y, 48, 50);
        }
        else
        {
            this.mover(movimiento, matrizLogica);
        }
    }

    private void cambiarImagen(){
        this.cuerpo.setIcon(new javax.swing.ImageIcon(Util.rutaImagenes + "personaje/" +this.nivel +
                this.direccion + "1.gif"));
    }

}

