package panelesJPanel2.BorderLayout;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        setWindow();
        initComponents();
    }

    private void setWindow() {
        setSize(400,400);
        setTitle("Window 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200,200));
        setMaximumSize(new Dimension(800,800));
        /* si colocamos un panel, este color no se verá, a no ser que el panel no ocupe toda la ventana */
        getContentPane().setBackground(Color.darkGray);
    }

    /*
    AHORA VAMOS CON LOS PANELES
     */
    private void setPanels() {
        // creamos panel central
        JPanel panelCenter = new JPanel();
        // color del panel
        panelCenter.setBackground(Color.blue);
        // colocamos el panel (this es la ventana)
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);

        // ahora panel norte
        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(Color.cyan);
        this.getContentPane().add(panelNorth, BorderLayout.NORTH);

        JPanel panelSouth = new JPanel();
        panelSouth.setBackground(Color.PINK);
        this.getContentPane().add(panelSouth, BorderLayout.SOUTH);

        JPanel panelEast = new JPanel();
        panelEast.setBackground(Color.green);
        this.getContentPane().add(panelEast, BorderLayout.EAST);

        JPanel panelWest = new JPanel();
        panelWest.setBackground(Color.ORANGE);
        this.getContentPane().add(panelWest, BorderLayout.WEST);

    }
    /*
    ESTE MÉTODO IRÁ LLAMANDO A TOD0 LO QUE HAY QUE PONER EN MARCHA DE LA GUI
     */
    private void initComponents() {
        setPanels();
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}
