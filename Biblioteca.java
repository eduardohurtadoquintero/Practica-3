import java.util.ArrayList;
import java.io.*;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private static final String ARCHIVO = "libros.txt";

    public Biblioteca() {
        this.libros = new ArrayList<>();
        cargarLibros();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        guardarLibros();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Libro> getLibrosPrestados(boolean prestados) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isPrestado() == prestados) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public String buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return "Título: " + libro.getTitulo() + "\n" +
                        "Autor: " + libro.getAutor().getNombre() + "\n" +
                        "Correo del Autor: " + libro.getAutor().getCorreo() + "\n" +
                        "Año de Publicación: " + libro.getAnioPublicacion() + "\n" +
                        "ISBN: " + libro.getIsbn() + "\n" +
                        "Prestado: " + (libro.isPrestado() ? "Sí" : "No") + "\n";
            }
        }
        return "No se encontró un libro con ese título.";
    }

    private void guardarLibros() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Libro libro : libros) {
                writer.write(libro.getTitulo() + "\n");
                writer.write(libro.getAutor().getId() + "\n");
                writer.write(libro.getAutor().getNombre() + "\n");
                writer.write(libro.getAutor().getCorreo() + "\n");
                writer.write(libro.getAnioPublicacion() + "\n");
                writer.write(libro.getIsbn() + "\n");
                writer.write(libro.isPrestado() + "\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarLibros() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String titulo;
            while ((titulo = reader.readLine()) != null) {
                int id = Integer.parseInt(reader.readLine());
                String nombre = reader.readLine();
                String correo = reader.readLine();
                Autor autor = new Autor(id, nombre, correo);
                int anioPublicacion = Integer.parseInt(reader.readLine());
                String isbn = reader.readLine();
                boolean prestado = Boolean.parseBoolean(reader.readLine());
                libros.add(new Libro(titulo, autor, anioPublicacion, isbn, prestado));
                if (reader.readLine() == null) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            // Archivo no encontrado, iniciando sin libros.
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

