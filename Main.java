import javax.swing.*;

public class Main {

    private Biblioteca biblioteca;

    public Main() {
        this.biblioteca = new Biblioteca(); // Inicializa la biblioteca
    }

    private void agregarLibro() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
        String añoStr = JOptionPane.showInputDialog("Ingrese el año de publicación:");
        int año = Integer.parseInt(añoStr);
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");

        Libro libro = new Libro(titulo, autor, año, isbn);
        biblioteca.agregarLibro(libro);
        JOptionPane.showMessageDialog(null, "¡Libro agregado exitosamente!\n", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void verLibros() {
        String todosLosLibros = biblioteca.getLibros();
        JOptionPane.showMessageDialog(null, todosLosLibros, "Lista de Libros", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buscarLibro() {
        String tituloBuscar = JOptionPane.showInputDialog("Ingrese el título del libro a buscar:");
        String resultadoBusqueda = biblioteca.buscarLibroPorTitulo(tituloBuscar);
        JOptionPane.showMessageDialog(null, resultadoBusqueda, "Resultado de la Búsqueda", JOptionPane.INFORMATION_MESSAGE);
    }

    public void ejecutar() {
        while (true) {
            String menu = "===== Menú de la Biblioteca =====\n" +
                          "1. Agregar un libro\n" +
                          "2. Ver todos los libros\n" +
                          "3. Buscar un libro por título\n" +
                          "4. Salir";
            String opcionStr = JOptionPane.showInputDialog(null, menu, "Menú de la Biblioteca", JOptionPane.PLAIN_MESSAGE);

            if (opcionStr == null) {
                break;
            }

            int opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    verLibros();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.ejecutar();
    }
}


     