package ejercicios6.colores02;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;

public class Interface02 extends JFrame {

    public JLabel etiqueta;
    public JButton botonR, botonG, botonB;
    public JPanel panel;
    public int contadorR, contadorG, contadorB;

    public enum Pulsado {PULSADOR, PULSADOG, PULSADOB, NADA}

    Pulsado pulsado;

    public Interface02() {
        setSize(600, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        // inicializar
        contadorR = 0;
        contadorG = 0;
        contadorB = 0;
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

    }

    public static void main(String[] args) {
        Interface02 interface02 = new Interface02();
        interface02.setVisible(true);
    }
}
