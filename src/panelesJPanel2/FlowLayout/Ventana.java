package panelesJPanel2.FlowLayout;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        setWindow();
        initComponents();
    }

    private void setWindow() {
        setSize(400,400);
        setTitle("Window FlowLayout");
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
        /*
        ESTE TIPO DE LAYOUT ESTÁ PENSADO PARA PONER BOTONES Y OTROS COMPONENTES DENTRO
        DE LOS PANELES, POR LO TANTO, COMO NO HEMOS METIDO NINGÙN COMPONENTE LOS PANELES
        APARECEN CON EL MÍNIMO TAMAÑO POSIBLE
         */
        this.setLayout(new FlowLayout());
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
