package juego.vistas;

import juego.controlador.ControladorPrincipal;
import juego.Inicio;
import juego.modelos.Personaje;
import juego.modelos.Tuberia;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Carlos Mario
 */
public class Mapa extends JFrame implements Runnable {

    private JTextArea consola;          //Consola de interaccion con el usuario.

    /**
     * Creates new form Mapa
     */
    private ControladorPrincipal controlador;
    
    public Mapa(){
        initComponents();
        this.setSize(1365, 900); //665
        //this.setLocationRelativeTo(null);

    }
    
    public void setControlador(ControladorPrincipal controlador) {
        this.controlador = controlador;
    }
    
    public void setPersonaje(Personaje personaje) { this.add(personaje.getCuerpo());}
    
    public void AgregarTuberia(Tuberia tuberia) { this.add(tuberia.getPared());}

    public void AgregaPared(JLabel pared) { this.add(pared);} //this.repaint();

    public void setTextoConsola(String texto){
        this.consola.setText(texto + "\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        this.consola = new JTextArea(600, 200);
        this.consola.setBounds(0, 626,250,150 );
        this.consola.setEditable(false);
        this.consola.setLineWrap(true);
        this.consola.setWrapStyleWord(true);
        this.add(this.consola);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        /**
         * Se llama al controlador para que haga el movimiento del Personaje
         * luego se agrega a la pantalla y se vuelve a repintar
         */
        this.controlador.mover(evt);
        if(ControladorPrincipal.FinJuego.equals(true)) {
            this.dispose();
            Inicio inicio = new Inicio();
            inicio.iniciar("Mundo2");
        }
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        this.add(this.controlador.getPersonaje().getCuerpo());
        this.controlador.pintar();
        //this.repaint();
    }

    @Override
    public void run() {
        while (true){
            this.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
