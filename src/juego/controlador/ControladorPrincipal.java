/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.controlador;

import juego.util.Util;
import juego.vistas.Mapa;
import juego.modelos.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Carlos Mario
 */
public class ControladorPrincipal {
    private Personaje personaje;
    private Mapa mapa;
    private Objetos[][] matrizLogica;
    private Clip musicaClasica;
    private String Mundo;
    private ArrayList<Thread> fantasmas;
    private Thread ventana;
    public static Boolean FinJuego;
    

    public ControladorPrincipal(String Mundo) {
        FinJuego = false;
        this.matrizLogica = new Objetos[13][27];//le quite los 17
        this.Mundo = Mundo;
        this.fantasmas = new ArrayList<Thread>();
        switch (Mundo) {
            case "Mundo1":
                this.insertarMusica("/juego/musica/SuperMarioClasico.wav");
                break;
            case "Mundo2":
                this.insertarMusica("/juego/musica/Debajo.wav");
                break;}
    }


    public void IniciarTiempo() {
        /**
         * Controla la pintada del mapa.. va agregando al mapa lo que hay en la matriz.. 
         */ 
       /* tiempo = new Timer(1, new ActionListener(){      
            public void actionPerformed(ActionEvent e) {
                pintar();
            }
        });*/
       //tiempo.start();
       pintar();
    }


    /**
     * Metodo llamado para hacerlo con el modelo MVC
     * @param mapa 
     */
    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
        this.ventana = new Thread(this.mapa);
    }


    public void musica() {
        //musicaClasica.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Agrega el personaje en el mapa y en la matriz grafica.
     * @param leucosito 
     */
    public void setPersonaje(Personaje leucosito, int fila, int columna) {
        this.personaje = leucosito;
        this.matrizLogica[fila][columna] = leucosito;
    }
    
    public void setTuberia(int fila,int columna) {
        Tuberia tuberia = new Tuberia(11,25,Mundo);
        this.matrizLogica[fila][columna] = tuberia;
        this.mapa.AgregarTuberia(tuberia);
    }

    /**
     * Retorna el personaje...
     * @return 
     */
    public Personaje getPersonaje() {
        return personaje;
    }


    public void crearMatrizPorArchivo(String rutaArchivo) throws IOException {
        String cadena;
        FileReader f = new FileReader(new File(rutaArchivo));
        BufferedReader b = new BufferedReader(f);
        int fila = 0;
        while((cadena = b.readLine())!=null) {
            for (int columna =0; columna < cadena.length(); columna++) {
                char c = cadena.charAt(columna);
                switch(c) {
                    case('0'):
                        Paredes pared = new Paredes(fila,columna,this.Mundo);
                        this.matrizLogica[fila][columna] = pared;
                        break;
                    case('1'):
                        Camino camino = new Camino(fila,columna);
                        this.matrizLogica[fila][columna] = camino;
                        break;
                    case('k'):
                        Llave llave = new Llave(fila,columna, this.Mundo);
                        this.matrizLogica[fila][columna] = llave;
                        break;
                    case('F'):
                        Fantasma fantasma = new Fantasma(fila, columna, this.matrizLogica, this);
                        this.matrizLogica[fila][columna] = fantasma;
                        Thread thread = new Thread(fantasma);
                        fantasmas.add(thread);
                        break;
                    case('P'):
                        Puerta puerta = new Puerta(fila, columna);
                        this.matrizLogica[fila][columna] = puerta;
                        break;
                     default:
                         //System.out.print(c);
                }
            }
            fila++;
        }
        b.close();
    }

    /**
     * Pinta el mapa Grafico
     */
    public void pintar() {
        for(int i = 0;i<13;i++)
            for(int j = 0;j<27;j++) {
                if(this.matrizLogica[i][j].getID().equals(Util.PARED)    ||
                   this.matrizLogica[i][j].getID().equals(Util.TUBERIA)  ||
                   this.matrizLogica[i][j].getID().equals(Util.LLAVE)    ||
                   this.matrizLogica[i][j].getID().equals(Util.FANTASMA) ||
                   this.matrizLogica[i][j].getID().equals(Util.PUERTA))
                {
                    mapa.AgregaPared(this.matrizLogica[i][j].getObjeto());
                }
            }
    }

    /**
     * Mueve el personajes, los metodos estan dentro de él...
     * @param movimiento 
     */
    public void mover(KeyEvent movimiento) {
        this.personaje.mover(movimiento, this.matrizLogica);
        //this.personaje.moverConBloque(movimiento,this.matrizLogica);
        if(FinJuego.equals(true)){this.musicaClasica.stop();}
    }

    public void insertarMusica(String ruta) {
        try {
            this.musicaClasica = AudioSystem.getClip();
            this.musicaClasica.open(AudioSystem.getAudioInputStream(getClass().getResource(ruta))); //new File()
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encenderHilos() {
        this.ventana.start();               //Se enciende el hilo de la ventana.
        for (Thread f: fantasmas) {         //Se enciende el hilo de los fantasmas.
            f.start();
        }
    }

}
