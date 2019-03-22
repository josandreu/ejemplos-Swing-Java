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
    // panel para el scroll
    private JScrollPane scrollPanel;
    // peliculas
    private Pelicula[] peliculas;
    // etiquetas
    private JLabel image, title, type;
    // tamaño ventana
    private int size_x = 480, size_y = 640;
    // panel film
    private int film_x = 460, film_y = 260;
    // imagen
    private int image_x = 180, image_y = 260;

    public Cartelera()  {
        this.setTitle("Cartelera de cine");
        Toolkit window = Toolkit.getDefaultToolkit();
        Dimension sizeWindow = window.getScreenSize();
        this.setSize(size_x, size_y);
        // lo colocamos en el centro, más o menos
        this.setLocation(sizeWindow.width/3, sizeWindow.height/4);
        initComponents();
    }

    private void initComponents() {
        // panel principal
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        // ponemos las peliculas una debajo de otra
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.add(mainPanel);

        // creamos panel para el scroll, en el constructor el panel al que afecta
        scrollPanel = new JScrollPane(mainPanel);
        mainPanel.setAutoscrolls(true);
        // añadimos el scrollPanel al frame
        this.add(scrollPanel);

        // creamos las películas
        createFilm();

        for (Pelicula pelicula : peliculas) {
            createPanels();
            createContent(pelicula);
        }

    }

    private void createFilm() {
        peliculas = new Pelicula[3];
        peliculas[0] = new Pelicula("Spiderman", "Acción", "./src/ejercicios6/carteleraCine/spiderman.jpg");
        peliculas[1] = new Pelicula("Iron man 1", "Acción", "./src/ejercicios6/carteleraCine/ironman.jpg");
        peliculas[2] = new Pelicula("Harry Potter y la piedra filosofal", "Ficción", "./src/ejercicios6/carteleraCine/harrypotter.jpg");
    }

    private void createPanels() {
        // panel pelicula
        filmPanel = new JPanel();
        filmPanel.setBackground(Color.white);
        // queremos que el texto y la imagen estén siempre uno al lado de otro
        filmPanel.setLayout(new BorderLayout());
        mainPanel.add(filmPanel);

        // panel imagen
        imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        filmPanel.add(imagePanel, BorderLayout.WEST);

        // panel textos
        textPanel = new JPanel();
        textPanel.setBackground(Color.WHITE);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        // se restan 20 pixels para que el texto se separe un poco de la imagen
        textPanel.setPreferredSize(new Dimension(film_x - image_x - 20, film_y));
        filmPanel.add(textPanel, BorderLayout.EAST);
    }

    // método encargado de crear el contenido interior de las peliculas
    private void createContent(Pelicula pelicula) {
        // imagen de la pelicula, creamos objeto ImageIcon y recuperamos la imagen asignada en el constructor de la pelicula
        ImageIcon imageIcon = new ImageIcon(pelicula.getImagen());
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(image_x,image_y,Image.SCALE_SMOOTH));

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

    public static void main(String[] args) {
        Cartelera cartelera = new Cartelera();
        cartelera.setVisible(true);
        cartelera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
