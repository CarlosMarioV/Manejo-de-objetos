package Modelo;


import Controlador.ControladorPrincipal;
import Controlador.Inicio;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Mario
 */
public class Mario extends Objetos
{
    private JLabel cuerpo = new JLabel(); 
    private int x,y,columna,fila;
    
    

    public Mario(int columna,int fila) {
        super("L");
        this.cuerpo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mario2.gif")));
        this.x = columna*50;//x1;//Posicion en la ventana eje X, Columna my 
        this.y = fila*48;//y1;//Posicion en la ventana eje Y, Fila mx
        this.columna = columna;//Columna en la matrizLogica
        this.fila = fila;//Fila en la matrizLogica
        this.cuerpo.setBounds(x, y, 48, 50);
    }
    
    public JLabel getCuerpo() {
        return cuerpo;
    }
    
    public void mover(KeyEvent movimiento,Objetos[][] matrizLogica)
    {   
        int seMovio = movimiento.getKeyCode();
        if(seMovio == KeyEvent.VK_RIGHT)
        {
            if(matrizLogica[fila][columna+1].getID().equals("C"))
            {
                matrizLogica[fila][columna] = matrizLogica[fila][columna+1];matrizLogica[fila][columna+1] = this;
                this.columna += 1;this.x +=50;this.cuerpo.setBounds(x, y, 48, 50); 
            }  
        }
        else if(seMovio == KeyEvent.VK_LEFT)
        {
            if(matrizLogica[fila][columna-1].getID().equals("C"))
            {
                matrizLogica[fila][columna] = matrizLogica[fila][columna-1];matrizLogica[fila][columna-1] = this;
                this.columna -= 1;this.x -= 50;this.cuerpo.setBounds(x, y, 48, 50);
            }
        }
        else if(seMovio == KeyEvent.VK_UP)
        {
            if(matrizLogica[fila-1][columna].getID().equals("C"))
            {
                matrizLogica[fila][columna] = matrizLogica[fila-1][columna];matrizLogica[fila-1][columna] = this;
                this.fila -= 1;this.y -= 48;this.cuerpo.setBounds(x, y, 48, 50);
            }
        }
        else if(seMovio == KeyEvent.VK_DOWN)
        {
            if(matrizLogica[fila+1][columna].getID().equals("T"))
                {
                    JOptionPane.showMessageDialog(null, "*** GANASTE.. ***!!", "Falicidades", JOptionPane.INFORMATION_MESSAGE); 
                    ControladorPrincipal.FinJuego = true;
                }
            
            if(matrizLogica[fila+1][columna].getID().equals("C"))
            {
                matrizLogica[fila][columna] = matrizLogica[fila+1][columna];matrizLogica[fila+1][columna] = this;
                this.fila += 1;this.y += 48;this.cuerpo.setBounds(x, y, 48, 50);
            }
        }
    }
    
    public void moverConBloque(KeyEvent movimiento,Objetos[][] matrizLogica)
    {   
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
}

