package panelesJPanel2.panelesTamañosFijos;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    /*
    SI QUEREMOS DARLE UN TAMAÑO A LOS PANELES NO PUEDE HABER UN LAYOUT DEFINIDO
    POR DEFECTO, YA VIENE UN LAYOUT, POR LO QUE HAY QUE QUITARLO
    setLayout(null)

    DESVENTAJA:
    que no es fluido, los paneles no se ajustan cuando cambiamos el tamaño de la ventana
    "No son RESPONSIVE"
     */

    public Ventana() {
        setWindow();
        initComponents();
    }

    public void setWindow() {
        setSize(400,400);
        setTitle("Window con paneles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200,200));
        setMaximumSize(new Dimension(800,800));
        /* si colocamos un panel, este color no se verá, a no ser que el panel no ocupe toda la ventana */
        getContentPane().setBackground(Color.darkGray);
        // LAYOUT FUERA
        this.setLayout(null);
    }

    public void initComponents() {
        setPanels();
    }

    public void setPanels() {
        // creamos panel central
        JPanel panelEsquinaIzquierda = new JPanel();
        // color del panel
        panelEsquinaIzquierda.setBackground(Color.blue);
        // colocamos y damos tamaño al panel
        panelEsquinaIzquierda.setBounds(0,0,100,100);
        // añadimos el panel (this es la ventana)
        this.getContentPane().add(panelEsquinaIzquierda);

        // ahora panel norte
        JPanel panelInferiorDerecho = new JPanel();
        panelInferiorDerecho.setBackground(Color.cyan);
        panelInferiorDerecho.setBounds(100,100,100,100);
        this.getContentPane().add(panelInferiorDerecho);

        JPanel panelInferiorIzquierdo = new JPanel();
        panelInferiorIzquierdo.setBackground(Color.PINK);
        panelInferiorIzquierdo.setBounds(0,100, 100,100);
        this.getContentPane().add(panelInferiorIzquierdo);

        JPanel panelCentroSuperior = new JPanel();
        panelCentroSuperior.setBackground(Color.green);
        panelCentroSuperior.setBounds(100,0,100,100);
        this.getContentPane().add(panelCentroSuperior);

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.ORANGE);
        panelInferior.setBounds(200,200,200,100);
        this.getContentPane().add(panelInferior);
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}
