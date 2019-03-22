package botonesJButton4.boton1;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private JPanel panel;
    private JLabel jLabel, jLabelImage;
    private JButton jButton;

    public Ventana() {
        setWindow();
        initComponents();
    }

    private void setWindow() {
        setSize(400,400);
        setTitle("Window Botones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200,200));
        setMaximumSize(new Dimension(800,800));
        /* si colocamos un panel, este color no se verá, a no ser que el panel no ocupe toda la ventana */
        getContentPane().setBackground(Color.darkGray);
    }

    private void initComponents() {
        setPanel();
        // setJLabels();
        setJButtons();
    }

    private void setPanel() {
        panel = new JPanel();
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
    }

    private void setJLabels() {
        // creamos la etiqueta, pasamos en el constructor el texto y la posición del texto en la misma
        jLabel = new JLabel("Esto es una etiqueta", SwingConstants.CENTER);
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
        ImageIcon imageIcon = new ImageIcon("emoticono.jpg");
        jLabelImage = new JLabel();
        // damos tamaño y posicion a la etiqueta
        jLabelImage.setBounds(100,110,250,250);
        // colocamos la imagen en la etiqueta, podría bastar con jLabelImage.setIcon(imageIcon)
        // pero de esa forma, la imagen no se adapta al tamaño de la etiqueta
        // para ello creamos una instancia de ImageIcon y en el constructor pasamos como 1º parametro la imagen
        // y luego el método getScaledInstance al que pasamos las dimensiones de la etiqueta y el tipo de escalado
        jLabelImage.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(jLabelImage);
    }

    private void setJButtons() {
        jButton = new JButton("Botón");
        // lo centramos en el panel
        jButton.setBounds(150,170,100,40);
        /*
        FUENTE DEL BOTÓN
         */
        // cambiamos el color del texto
        jButton.setForeground(Color.BLUE);
        // cambiamos la fuente
        jButton.setFont(new Font("open sans", Font.ITALIC, 16));
        /*
        IMAGEN DEL BOTÓN
        ImageIcon imageIcon = new ImageIcon("emoticono.jpg");
        jButton.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_SMOOTH)));
         */

        panel.add(jButton);

    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}
