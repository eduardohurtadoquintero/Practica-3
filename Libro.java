public class Libro {

    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String isbn;

    public Libro(String titulo, String autor, int añoPublicacion, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getInformacion() {
        return "Título: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "Año de publicación: " + añoPublicacion + "\n" +
               "ISBN: " + isbn;
    }

    @Override
    public String toString() {
        return getInformacion();
    }
}
