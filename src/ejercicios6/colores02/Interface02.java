package ejercicios6.colores02;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;

/*
SE TRATA DE UNA PEQUEÑA APP QUE MUESTRA TRES BOTONES Y UNA ETIQUETA
Cada botón representa un color dentro del sistema RGB
Dependiendo del botón pulsado, podremos cambiar el color del panel con la rueda del ratón
 */

public class Interface02 extends JFrame {

    private JLabel etiqueta;
    private JButton botonR, botonG, botonB;
    private JPanel panel;
    private int contadorR, contadorG, contadorB;
    // se utiliza para saber cual ha sido el último botón pulsado
    private enum Pulsado {PULSADOR, PULSADOG, PULSADOB, NADA}
    // variable de tipo Pulsado donde guardamos el enum
    private Pulsado pulsado;

    public Interface02() {
        setSize(600, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        // inicio de los contadores de color
        contadorR = 0;
        contadorG = 0;
        contadorB = 0;
        // inicio del enum
        pulsado = Pulsado.NADA;

        // configurar panel
        panel = new JPanel();
        panel.setBounds(0, 0, 600, 400);
        panel.setLayout(null);
        this.add(panel);

        // etiqueta
        etiqueta = new JLabel("Color (R, G, B)");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(100, 50, 400, 50);
        panel.add(etiqueta);

        setButtons();

        // ahora vamos a meter un listener en todo el frame para la rueda del ratón
        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                mouseWheelMoveListener(e);
            }
        });

    }

    private void setButtons() {
        // botones, se indican tal y como deben aparecer, añadimos el listener de cada uno
        botonR = new JButton("R");
        botonR.setBounds(100, 200, 100,100);
        panel.add(botonR);

        botonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = Pulsado.PULSADOR;
            }
        });

        botonG = new JButton("G");
        botonG.setBounds(250,200,100,100);
        panel.add(botonG);

        botonG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = Pulsado.PULSADOG;
            }
        });

        botonB = new JButton("B");
        botonB.setBounds(400,200,100,100);
        panel.add(botonB);

        botonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = Pulsado.PULSADOB;
            }
        });
    }

    private void mouseWheelMoveListener(MouseWheelEvent e) {
        if (pulsado != Pulsado.NADA) {
            if (pulsado == Pulsado.PULSADOR) {
                // aumentar o disminuir valor de R
                contadorR += e.getWheelRotation();
                // controlamos que no pase de 255 y que no baje del 0
                if (contadorR < 0 || contadorR > 255) {
                    // como no sabemos si estamos sumando o restando, de esta forma si suma lo resta y si lo resta lo suma
                    contadorR -= e.getWheelRotation();
                }
            } else if (pulsado == Pulsado.PULSADOG) {
                // aumentar o disminuir valor de G
                contadorG += e.getWheelRotation();
                if (contadorG < 0 || contadorG> 255) {
                    contadorG -= e.getWheelRotation();
                }
            } else {
                // aumentar o disminuir valor de B
                contadorB += e.getWheelRotation();
                if (contadorB < 0 || contadorB > 255) {
                    contadorB -= e.getWheelRotation();
                }
            }
        }
        // aplicamos dinámicamente los valores al texto de la etiqueta
        etiqueta.setText("Color (R: " + contadorR + ", G: " + contadorG + " , B: " + contadorB + ")");
        panel.setBackground(new Color(contadorR, contadorG, contadorB));
    }

    public static void main(String[] args) {
        Interface02 interface02 = new Interface02();
        interface02.setVisible(true);
    }
}
