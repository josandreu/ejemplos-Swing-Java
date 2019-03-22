package ejercicios6.carteleraCine;

class Pelicula {

    private String titulo;
    private String genero;
    private String imagen; // String ya que guardaremos el nombre de la misma

    public Pelicula(String titulo, String genero, String imagen) {
        this.titulo = titulo;
        this.genero = genero;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getImagen() {
        return imagen;
    }
}
