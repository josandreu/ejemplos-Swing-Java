package panelesJPanel2.BoxLayout;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        setWindow();
        initComponents();
    }

    public void setWindow() {
        setSize(400,400);
        setTitle("Window Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200,200));
        setMaximumSize(new Dimension(800,800));
        /* si colocamos un panel, este color no se verá, a no ser que el panel no ocupe toda la ventana */
        getContentPane().setBackground(Color.darkGray);
    }

    public void initComponents() {
        setPanels();
    }

    public void setPanels() {
        /*
        BoxLayout: hay que pasarle dos parámetros, el 1º el contenido de la ventana, el container
        y el 2º es la forma que queremos ordenar el BoxLayout.
        BoxLayout.Y_AXIS = se ordenan verticalmente, uno debajo de otro =
        BoxLayout.X_AXIS = se ordenan horizontalmente, uno al lado del otro ||||
         */
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        // creamos panel central
        JPanel panelCenter = new JPanel();
        // color del panel
        panelCenter.setBackground(Color.blue);
        // colocamos el panel (this es la ventana)
        this.getContentPane().add(panelCenter);

        // ahora panel norte
        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(Color.cyan);
        this.getContentPane().add(panelNorth);

        JPanel panelSouth = new JPanel();
        panelSouth.setBackground(Color.PINK);
        this.getContentPane().add(panelSouth);

        JPanel panelEast = new JPanel();
        panelEast.setBackground(Color.green);
        this.getContentPane().add(panelEast);

        JPanel panelWest = new JPanel();
        panelWest.setBackground(Color.ORANGE);
        this.getContentPane().add(panelWest);
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}
