package etiquetasJLabel3;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        setVentana();
        initComponents();
    }

    public void setVentana() {
        setSize(400,400);
        setTitle("Window JLabels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200,200));
        setMaximumSize(new Dimension(800,800));
        /* si colocamos un panel, este color no se verá, a no ser que el panel no ocupe toda la ventana */
        getContentPane().setBackground(Color.YELLOW);
        setLayout(null);
    }

    public void initComponents() {
        setPanels();
    }

    public void setPanels() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        // como no tenemos un layout definido, vamos a darle tamaño y posicion al panel
        // ponemos el mismo tamaño que el maximo de tamaño de la ventana
        panel.setBounds(0,0,800,800);
        /*
        PARA PODER COLOCAR LA JLABEL DONDE QUERAMOS, HAY QUE HACER LO MISMO QUE CON EL JFRAME
        HAY QUE ELIMINAR EL LAYOUT QUE VIENE POR DEFECTO
         */
        panel.setLayout(null);
        // añadimos el panel al marco
        this.getContentPane().add(panel);

        // creamos la etiqueta, pasamos en el constructor el texto y la posición del texto en la misma
        JLabel jLabel = new JLabel("Esto es una etiqueta", SwingConstants.CENTER);
        // colocamos etiqueta
        jLabel.setBounds(10,10,200,30);
        // cambiamos color de la fuente
        jLabel.setForeground(Color.WHITE);
        // cambiamos fondo, PARA ESTO HAY QUE INDICAR QUE LA ETIQUETA NO TENGA FONDO TRANSPARENTE
        jLabel.setOpaque(true);
        jLabel.setBackground(Color.black);
        // cambiamos la fuente
        jLabel.setFont(new Font("open sans", Font.PLAIN, 20));
        // la añadimos al panel
        panel.add(jLabel);

        /*
        AHORA CREAMOS UNA NUEVA ETIQUETA DONDE ADJUNTAREMOS UNA IMAGEN
         */
        ImageIcon imageIcon = new ImageIcon("src/emoticono.jpg");
        JLabel jLabelImage = new JLabel();
        // damos tamaño y posicion a la etiqueta
        jLabelImage.setBounds(100,110,250,250);
        // colocamos la imagen en la etiqueta, podría bastar con jLabelImage.setIcon(imageIcon)
        // pero de esa forma, la imagen no se adapta al tamaño de la etiqueta
        // para ello creamos una instancia de ImageIcon y en el constructor pasamos como 1º parametro la imagen
        // y luego el método getScaledInstance al que pasamos las dimensiones de la etiqueta y el tipo de escalado
        jLabelImage.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(jLabelImage);
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}
