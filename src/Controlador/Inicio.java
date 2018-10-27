package Controlador;

import Modelo.Personaje;
import Vista.Mapa;

import java.io.IOException;

/**
 * Esta clase es la que inicia el juego.Inserta los objetos dentro del mapa e inserta el mapa en el controlador
 * @author Carlos Mario
 */
public class Inicio {

    private Personaje personaje;
    private ControladorPrincipal controlador;

    /*
    * Constructor vacio.
    * */
    public Inicio() {

    }

    /**
     * Metodo, recibe el nombre del mundo que se va a pintar.
     * @param Mundo
     */
    public void iniciar(String Mundo) {

        this.personaje = new Personaje(1,11);
        Mapa mapa = new Mapa();
        this.controlador = new ControladorPrincipal(Mundo);


        /**
         * Se agrega el personaje y el mapa al controlador
         */
        this.controlador.setPersonaje(personaje,11,1);
        this.controlador.setMapa(mapa);
        
        /**
         * Se agrega al mapa el controlador
         */
        mapa.setControlador(controlador);
        mapa.AgregaLeucosito(personaje);
        
        /**
         * Se agrega la figura del nimbus a la ventana y el controlador crea la matriz
         * luego pinta lo que en la matriz logica en la grafica...
         */
        AgregaElNimbus();
        //this.controlador.crearTodaMatriz();
        try {
            this.controlador.crearMatrizPorArchivo("src/Mapas/mundo1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.controlador.setTuberia(11,25);
        this.controlador.pintar();
        
        this.controlador.musica();
        mapa.setVisible(true);
    }
    
    public void AgregaElNimbus()
    {
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
