/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.Mapa;

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
import java.util.Scanner;

/**
 *
 * @author Carlos Mario
 */
public class ControladorPrincipal 
{
    private Personaje leucosito;
    private Mapa mapa;
    private Objetos[][] matrizLogica;
    private Timer tiempo;
    private AudioSystem sonido;
    private Clip musicaClasica;
    private String Mundo;
    public static Boolean FinJuego;
    
    public ControladorPrincipal(String Mundo) 
    {
        FinJuego = false;
        this.matrizLogica = new Objetos[13][27];//le quite los 17
        this.Mundo = Mundo;
        switch (Mundo) {
            case "Mundo1":
                this.insertarMusica("/Musica/SuperMarioClasico.wav");
                break;
            case "Mundo2":
                this.insertarMusica("/Musica/Debajo.wav");
                break;}
    }
    
    public void IniciarTiempo()
    {
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
    }
    
    public void musica()
    {
        musicaClasica.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Agrega el personaje en el mapa y en la matriz grafica.
     * @param leucosito 
     */
    public void setPersonaje(Personaje leucosito, int fila, int columna)
    {
        this.leucosito = leucosito;
        this.matrizLogica[fila][columna] = leucosito;
    }
    
    public void setTuberia(int fila,int columna)
    {
        Tuberia tuberia = new Tuberia(11,25,Mundo);
        this.matrizLogica[fila][columna] = tuberia;
        this.mapa.AgregarTuberia(tuberia);
    }
    /**

     * Retorna el personaje...
     * @return 
     */
    public Personaje getPersonaje() {
        return leucosito;
    }


    public void crearMatrizPorArchivo(String rutaArchivo) throws IOException {

        String cadena;
        FileReader f = new FileReader(new File(rutaArchivo));
        BufferedReader b = new BufferedReader(f);
        int fila = 0;
        while((cadena = b.readLine())!=null) {
            //char[] tipo = cadena.toCharArray();
            for (int columna =0; columna < cadena.length(); columna++) {
                char c = cadena.charAt(columna);
                switch(c){
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
                     default:
                         System.out.print(c);
                }
            }
            System.out.println("");
            fila++;
        }
        b.close();
    }

    public void crearTodaMatriz() {
        for(int i = 0;i<13;i++)
        {
            for(int j = 0;j<27;j++)
            {
                if( i == 12 || i== 0 || j == 26 || j == 0)
                {
                    Paredes pared = new Paredes(i,j,this.Mundo);
                    this.matrizLogica[i][j] = pared;
                }
                else
                {
                    if((i == 1) &&(j==4||j==5||j==6||j==7||j==8||j==9||
                            j==10||j==11||j==12||j==19))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i == 2) &&(j==1||j==14||j==15||j==16||j==17||j==19||j==21||
                            j==22||j==24))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i == 3)&&(j==1||j==3||j==4||j==5||j==6||j==7||
                            j==8||j==10||j==11||j==12||j==13||j==14||j==19||
                            j==21||j==22||j==24))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i==4)&&(j==1||j==3||j==4||j==5||j==6||j==7||j==8||j==10
                            ||j==16||j==17||j==18||j==19||j==21||j==22||j==24))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i==5)&&(j==1||j==8||j==10||j==12||j==13||j==14||j==15
                            ||j==16||j==17||j==18||j==19||j==21||j==22||j==24))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i==6)&&(j==1||j==2||j==3||j==4||j==5||j==6||j==8||j==10||j==21||j==22
                            ||j==24))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i==7)&&(j==4||j==5||j==6||j==8||j==12||j==13||j==14||j==15||j==16
                            ||j==17||j==18||j==19||j==21||j==24))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i==8)&&(j==2||j==5||j==8||j==9||j==10||j==11||j==12
                            ||j==13||j==14||j==15||j==16||j==17||j==18||j==19||j==20||j==21||j==24))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i==9)&&(j==3||j==7||j==23||j==24||j==25))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i==10)&&(j==1||j==2||j==3||j==5||j==6||j==7||j==9||j==10||j==11||j==12||j==13||j==14
                            ||j==15||j==16||j==17||j==18||j==19||j==20||j==21||j==22||j==23))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else if((i==11)&&(j==7))
                    {
                        Paredes pared = new Paredes(i,j,this.Mundo);
                        this.matrizLogica[i][j] = pared;
                    }
                    else
                   {
                        Camino camino = new Camino(i,j);
                        this.matrizLogica[i][j] = camino;
                        //fila += camino.getID()+ ", ";
                   }
                }
            }
        }
        Bloques bloque = new Bloques(1,2,this.Mundo);
        this.matrizLogica[1][2] = bloque;
        Bloques bloque2 = new Bloques(4,12,this.Mundo);
        this.matrizLogica[4][12] = bloque2;
        Bloques bloque3 = new Bloques(11,5,this.Mundo);
        this.matrizLogica[11][5] = bloque3;
        Bloques bloque4 = new Bloques(6,25,this.Mundo);
        this.matrizLogica[6][25] = bloque4;
    }
    
    /**
     * Pinta el mapa Grafico
     */
    public void pintar()
    { 
        for(int i = 0;i<13;i++)
            for(int j = 0;j<27;j++)
            {
                if(this.matrizLogica[i][j].getID().equals("P")||this.matrizLogica[i][j].getID().equals("T")
                        || this.matrizLogica[i][j].getID().equals("PD")||this.matrizLogica[i][j].getID().equals("k"))
                {mapa.AgregaPared(this.matrizLogica[i][j].getObjeto()); }
            }  
    }
    /**
     * Mueve el personajes, los metodos estan dentro de él...
     * @param movimiento 
     */
    public void mover(KeyEvent movimiento)
    {
        //this.leucosito.mover(movimiento,this.matrizLogica);
        this.leucosito.moverConBloque(movimiento,this.matrizLogica);
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
}
