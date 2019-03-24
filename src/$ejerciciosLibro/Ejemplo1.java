package $ejerciciosLibro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo1 extends JFrame {
    private JLabel jLabel;
    private JButton jButton;
    private JPanel panelTop;
    private JPanel panelBottom;

    public Ejemplo1() {
        setWindow();
        initComponents();
    }

    private void setWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ejemplo 1");
        setLayout(new GridLayout(2,1));
        setBounds(600,600,200,200);
    }

    private void initComponents() {
        jLabel = new JLabel("Etiqueta");
        jLabel.setFont(new Font("Open Sans", Font.PLAIN,18));
        jButton = new JButton("Click aquí");
        jButton.setMnemonic('c');
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLabel(e);
            }
        });
        panelTop = new JPanel();
        // panelTop.setBackground(Color.blue);
        panelTop.add(jLabel);
        panelBottom = new JPanel();
        // panelBottom.setBackground(Color.green);
        panelBottom.add(jButton);
        this.getContentPane().add(panelTop);
        this.getContentPane().add(panelBottom);
    }

    private void changeLabel(ActionEvent event) {
        if (event.getSource() == jButton) {
            float red = (float) Math.random();
            float green = (float) Math.random();
            float blue = (float) Math.random();
            jLabel.setText("Hola mundo!");
            jLabel.setForeground(new Color(red, green, blue));
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        new Ejemplo1().setVisible(true);
    }
}
