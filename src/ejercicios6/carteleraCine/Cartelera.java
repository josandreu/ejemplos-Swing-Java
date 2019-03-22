package ejercicios6.carteleraCine;

/*
Cartelera de cine
Realizada con layouts
    Imagen de la película
    Título
    Género
 */

import javax.swing.*;
import java.awt.*;

public class Cartelera extends JFrame {
    // panel principal
    private JPanel mainPanel;
    // panel contiene película
    private JPanel filmPanel;
    // panel imagen
    private JPanel imagePanel;
    // panel textos
    private JPanel textPanel;
    // peliculas
    private Pelicula[] peliculas;

    // etiquetas
    private JLabel image, title, type;

    public Cartelera()  {
        this.setTitle("Cartelera de cine");
        Toolkit window = Toolkit.getDefaultToolkit();
        Dimension sizeWindow = window.getScreenSize();
        this.setSize(480, 640);
        // lo colocamos en el centro, más o menos
        this.setLocation(sizeWindow.width/3, sizeWindow.height/4);
        initComponents();
    }

    private void initComponents() {
        // panel principal
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.red);
        // ponemos las peliculas una debajo de otra
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.add(mainPanel);

        // creamos las películas
        createFilm();

        for (Pelicula pelicula : peliculas) {
            // panel pelicula
            filmPanel = new JPanel();
            filmPanel.setBackground(Color.cyan);
            // queremos que el texto y la imagen estén siempre uno al lado de otro
            filmPanel.setLayout(new BoxLayout(filmPanel, BoxLayout.X_AXIS));
            mainPanel.add(filmPanel);

            // panel imagen
            imagePanel = new JPanel();
            imagePanel.setBackground(Color.blue);
            imagePanel.setPreferredSize(new Dimension(180,260));
            filmPanel.add(imagePanel);

            // panel textos
            textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.setBackground(Color.white);
            filmPanel.add(textPanel);

            // imagen de la pelicula, creamos objeto ImageIcon y recuperamos la imagen asignada en el constructor de la pelicula
            ImageIcon imageIcon = new ImageIcon(pelicula.getImagen());
            Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(180,260,Image.SCALE_SMOOTH));

            // etiqueta con la imagen
            image = new JLabel();
            image.setIcon(icon);
            imagePanel.add(image);

            // etiqueta del titulo
            title = new JLabel(pelicula.getTitulo());
            textPanel.add(title);

            // etiqueta del genero, necesitamos colocarla debajo del título, por ello BoxLayout
            type = new JLabel(pelicula.getGenero());
            textPanel.add(type);
        }

    }

    private void createFilm() {
        peliculas = new Pelicula[3];
        peliculas[0] = new Pelicula("Spiderman", "Acción", "./src/ejercicios6/carteleraCine/spiderman.jpg");
        peliculas[1] = new Pelicula("Iron man 1", "Acción", "./src/ejercicios6/carteleraCine/ironman.jpg");
        peliculas[2] = new Pelicula("Harry Potter y la piedra filosofal", "Ficción", "./src/ejercicios6/carteleraCine/harrypotter.jpg");
    }

    public static void main(String[] args) {
        Cartelera cartelera = new Cartelera();
        cartelera.setVisible(true);
        cartelera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
