package juego;

import juego.controlador.ControladorPrincipal;
import juego.modelos.Personaje;
import juego.util.Util;
import juego.vistas.Mapa;

import java.io.IOException;

/**
 * Esta clase es la que inicia el juego.Inserta los objetos dentro del mapa e inserta el mapa en el controlador
 * @author Carlos Mario
 */
public class Inicio {

    private Personaje personaje;                //Instancia del personaje principal.
    private ControladorPrincipal controlador;   //Instancia del controlador.
    private Mapa mapa;                          //Instancia de la ventana.
    private Thread ventana;                     //Hilo de la ventana.



    public Inicio() {}

    /**
     * Metodo, recibe el nombre del mundo que se va a pintar.
     * @param Mundo
     */
    public void iniciar(String Mundo) {

        this.personaje = new Personaje(1,11);
        this.controlador = new ControladorPrincipal(Mundo);
        this.mapa = new Mapa();



        /**
         * Se agrega el personaje y el mapa al controlador
         */
        this.controlador.setPersonaje(personaje,11,1);
        this.controlador.setMapa(mapa);
        
        /**
         * Se agrega al mapa el controlador
         */
        mapa.setControlador(controlador);
        mapa.setPersonaje(personaje);
        
        /**
         * Se agrega la figura del nimbus a la ventana y el controlador crea la matriz
         * luego pinta lo que en la matriz logica en la grafica...
         */
        AgregaElNimbus();
        try {
            this.controlador.crearMatrizPorArchivo(Util.rutaMapas + "mundo1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.controlador.encenderHilos();
        this.controlador.setTuberia(11,25);
        this.controlador.pintar();
        this.controlador.musica();
        mapa.setVisible(true);
        mapa.setTextoConsola("Bienvenido...\n Este es el mundo de vectoriano, consigue las piesas que necesites " +
                "para avanzar al siguiente mundo, deberas encontrar las pistas para conseguirlo.");
    }
    
    public void AgregaElNimbus() {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
    }
    
    public static void main(String[] args)
    {
        Inicio inicio = new Inicio();
        inicio.iniciar("Mundo1"); 
    }  
}
