package ejercicios6.contadorClicks01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface01 extends JFrame {
    private JLabel label;
    private JButton buttonMore, buttonMinus;
    private int contador;

    public Interface01() {
        setInterface();
        initComponents();
    }

    private void setInterface() {
        setSize(400,400);
        setLayout(null);
        setTitle("Contador de clicks");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        setLabel();
        setButtonMore();
        setButtonMinus();
    }

    private void setLabel() {
        // pasamos el texto y su posición como argumento en el constructor, esto es = label.setHorizontalAlignment(SwingConstants.CENTER);
        label = new JLabel("Pulsa el botón", SwingConstants.CENTER);
        label.setBounds(50,50,300,50);
        this.add(label);
    }

    private void setButtonMore() {
        buttonMore = new JButton("+");
        buttonMore.setBounds(100,200,100,50);
        this.add(buttonMore);
        contador = 0;
        // creamos el listener que ejecuta el método buttonClicks cada vez que hacemos click en el botón
        buttonMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonMoreClicks();
            }
        });
    }

    private void setButtonMinus() {
        buttonMinus = new JButton("-");
        buttonMinus.setBounds(200,200,100,50);
        this.add(buttonMinus);

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonMinusClicks();
            }
        });
    }

    // cada vez que hagamos click, aumentamos la variable contador y cambiamos el texto de la etiqueta
    private void setButtonMoreClicks() {
        contador++;
        label.setText("El botón se ha pulsado " + contador + " veces");
    }

    private void setButtonMinusClicks() {
        contador--;
        label.setText("El botón se ha pulsado " + contador + " veces");
    }

    public static void main(String[] args) {
        Interface01 interface01 = new Interface01();
        interface01.setVisible(true);
    }
}
