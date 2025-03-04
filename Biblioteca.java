import java.io.*;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private static final String ARCHIVO = "libros.txt"; // El archivo donde se guardarán los libros

    public Biblioteca() {
        this.libros = new ArrayList<>();
        cargarLibros(); // Cargar los libros cuando se inicializa la biblioteca
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        guardarLibros(); // Guardar los libros cada vez que se agrega uno
    }

    public String getLibros() {
        if (libros.isEmpty()) {
            return "No hay libros en la biblioteca.";
        }
        StringBuilder info = new StringBuilder();
        for (Libro libro : libros) {
            info.append(libro.getInformacion()).append("\n\n");
        }
        return info.toString();
    }

    public String buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return "Libro encontrado: \n" + libro.getInformacion();
            }
        }
        return "No se encontró el libro con el título: " + titulo;
    }

    // Guardar los libros en un archivo de texto
    private void guardarLibros() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Libro libro : libros) {
                writer.write(libro.getTitulo() + "\n");
                writer.write(libro.getAutor() + "\n");
                writer.write(libro.getAñoPublicacion() + "\n");
                writer.write(libro.getIsbn() + "\n\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los libros: " + e.getMessage());
        }
    }

    // Cargar los libros desde un archivo de texto
    private void cargarLibros() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String titulo = linea;
                String autor = reader.readLine();
                int añoPublicacion = Integer.parseInt(reader.readLine());
                String isbn = reader.readLine();
                libros.add(new Libro(titulo, autor, añoPublicacion, isbn));
                reader.readLine(); // Leer la línea vacía entre los libros
            }
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, significa que es la primera vez que se ejecuta el programa
        } catch (IOException e) {
            System.err.println("Error al cargar los libros: " + e.getMessage());
        }
    }
}
