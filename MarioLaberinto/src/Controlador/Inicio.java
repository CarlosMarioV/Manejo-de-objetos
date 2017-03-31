package Controlador;


import Modelo.Mario;
import Modelo.Tuberia;
import Vista.Mapa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Mario
 */
public class Inicio {
    
    private Mapa mapa; 
    private Mario leucosito;
    private ControladorPrincipal controlador;

    public Inicio() {
    }
    
    public void iniciar(String Mundo)
    {
        this.leucosito = new Mario(1,11);
        this.mapa = new Mapa();
        this.controlador = new ControladorPrincipal(Mundo);
        
        
        /**
         * Se agrega el personaje y el mapa al controlador
         */
        this.controlador.setLeucosito(leucosito,11,1);
        this.controlador.setMapa(mapa);
        
        /**
         * Se agrega al mapa el controlador
         */
        this.mapa.setControlador(controlador);
        this.mapa.AgregaLeucosito(leucosito);
        
        /**
         * Se agrega la figura del nimbus a la ventana y el controlador crea la matriz
         * luego pinta lo que en la matriz logica en la grafica...
         */
        AgregaElNimbus();
        this.controlador.crearTodaMatriz();
        this.controlador.setTuberia(11,25);
        this.controlador.pintar();
        
        this.controlador.musica();
        this.mapa.setVisible(true);
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
