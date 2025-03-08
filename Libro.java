public class Libro {

    private String titulo;
    private Autor autor;
    private int anioPublicacion;
    private String isbn;
    private boolean prestado;

    public Libro(String titulo, Autor autor, int anioPublicacion, String isbn, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
        this.prestado = prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}

