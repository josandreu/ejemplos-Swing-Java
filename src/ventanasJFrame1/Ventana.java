package ventanasJFrame1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends JFrame {

    public Ventana(String title) {
        setSize(400,400);
        setTitle(title);
        // iniciamos el método que añade el listener de cerrar ventana
        iniciarComponentes();
        /* es lo mismo que: */
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        /* para que no se puede cambiar el tamaño de la ventana */
        // setResizable(false);
        /* establecemos un tamaño minimo y maximo de ventana, por si el usuario decide cambiarlo */
        setMinimumSize(new Dimension(200,200));
        setMaximumSize(new Dimension(600,600));
        /* cambiamos el color, hay que hacerlo con getContentPane porque lo que estamos modificando es el contenido, no lo que es el frame en sí */
        this.getContentPane().setBackground(Color.darkGray);
    }
    // método privado iniciarComponentes, iniciará todos los componentes básicos del sistema que estén a la escucha
    private void iniciarComponentes() {
        // creamos un listener de Windows (ventanas) pasamos como parámetro un objeto WindowsAdapter
        // este objeto está preparado para recibir eventos de ventana de cualquier tipo (WindowListener, WindowStateListener y WindowFocusListener)
        // este addWindowListener es la escucha, si no metemos ningún método dentro, no hace nada
        addWindowListener(new WindowAdapter() {
            @Override
            // añadimos el método windowClosing, que es el encargado de ejecutar lo que nosotros le digamos al cerrar la ventana
            // pasamos como parámetro un evento de tipo WindowEvent, que es el que se ha 'escuchado'
            public void windowClosing(WindowEvent evento) {
                // indicamos que cuando le demos a cerrar a la ventana, salga un mensaje
                JOptionPane.showMessageDialog(null, "Me cierro");
                // y que termine la ejecución del programa
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Ventana v = new Ventana("Window 1");
        v.setVisible(true);
    }
}
