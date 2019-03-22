package eventosTecladoRaton5.teclado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window extends JFrame {
    JPanel panel = new JPanel();
    JButton button = new JButton();
    Color green = new Color(160,192,169);
    Color blue = new Color(65,164,255);
    Color darkBlue = new Color(8,96,178);
    Color red = new Color(223,89,59);

    public Window() {
        setWindow();
        initComponents();
    }

    private void setWindow() {
        setSize(400,400);
        setTitle("Window Eventos Teclado");
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
        panel.setBounds(0,0,850,800);
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
        button.setBorder(BorderFactory.createMatteBorder(10,10,10,10, green));
        button.setOpaque(true);
        button.setBackground(blue);
        panel.add(button);

        // este es el método que tiene todos los listener
        eventsButton();
    }

    /*
    MÉTODO QUE MANEJARÁ LAS INTERACCIONES CON EL BOTÓN
    MouseListener (clicks)
    MouseMotionListener (movimiento del ratón)
    MouseWheelListener (rueda del ratón)

    ActionListener (para acciones genéricas, el más usado)
     */

    /*
    AHORA VAMOS A MANEJAR LOS EVENTOS DE TECLADO
    KeyListener
     */

    private void eventsButton() {
        // añadimos al botón el listener, cuando hagamos click, se ejecuta buttonActionPerformed
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonActionPerformed(e);
            }
        });

        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                buttonKeyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                buttonKeyReleased(e);
            }
        });
    }

    // este método realizará la acción que nosotros queremos cuando pulsemos el botón
    // a su vez, es pasado en el ActionListener
    private void buttonActionPerformed(ActionEvent e) {
        panel.setBackground(green);
    }

    // este hará la acción que indiquemos cuando tecleemos encima del botón
    private void buttonKeyTyped(KeyEvent e) {
        // solo se ejecutará si pulsamos la tecla intro (\n)
        if (e.getKeyChar() == '\n') {
            button.setBackground(darkBlue);
        }
    }

    // si pulsamos y mantenemos la tecla k, el panel se pone rojo
    private void buttonKeyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'k') {
            panel.setBackground(red);
        }
    }

    // cuando soltamos la tecla k, el panel se pone azul
    private void buttonKeyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'k') {
            panel.setBackground(blue);
        }
    }

    private void setLabels() {

    }

    public static void main(String[] args) {
        Window w = new Window();
        w.setVisible(true);
    }
}
