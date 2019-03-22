package eventosTecladoRaton5.raton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    JPanel panel = new JPanel();
    JButton button = new JButton();
    Color green = new Color(160,192,169);
    Color blue = new Color(65,164,255);
    Color darkBlue = new Color(8,96,178);

    public Window() {
        setWindow();
        initComponents();
    }

    private void setWindow() {
        setSize(400,400);
        setTitle("Window Eventos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200,200));
        setMaximumSize(new Dimension(800,800));
        /* si colocamos un panel, este color no se verá, a no ser que el panel no ocupe toda la ventana */
        getContentPane().setBackground(Color.darkGray);
    }

    private void initComponents() {
        setPanels();
        setButtons();
    }

    private void setPanels() {
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
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

    private void setButtons() {
        button = new JButton("Botón");
        // lo centramos en el panel
        button.setBounds(100,150,200,80);
        button.setFont(new Font("open sans", Font.ITALIC, 16));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createMatteBorder(5,10,5,10, green));
        button.setOpaque(true);
        button.setBackground(Color.BLUE);
        panel.add(button);

        eventsButton();
    }

    /*
    MÉTODO QUE MANEJARÁ LAS INTERACCIONES CON EL BOTÓN
    MouseListener (clicks)
    MouseMotionListener (movimiento del ratón)
    MouseWheelListener (rueda del ratón)

    ActionListener (para acciones genéricas, el más usado)
     */

    private void eventsButton() {
        // añadimos al botón el listener, cuando hagamos click, se ejecuta buttonActionPerformed
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonActionPerformed(e);
            }
        });
        /*
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.setBackground(blue);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(green);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(darkBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.BLUE);
            }
        });

        button.addMouseMotionListener(new MouseAdapter() {
            @Override
            // pulsar y sin soltar, arrastrar
            public void mouseDragged(MouseEvent e) {
                button.setBackground(green);
            }

            @Override
            // si el ratón se ha movido por encima del botón
            public void mouseMoved(MouseEvent e) {
                button.setBackground(blue);
            }
        });
        */
    }

    // este método realizará la acción que nosotros queremos cuando pulsemos el botón
    // a su vez, es pasado en el ActionListener
    private void buttonActionPerformed(ActionEvent e) {
        panel.setBackground(green);
    }

    private void setLabels() {

    }

    public static void main(String[] args) {
        Window w = new Window();
        w.setVisible(true);
    }
}
