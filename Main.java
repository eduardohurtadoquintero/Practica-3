import java.util.Scanner;

public class Main {
    private Biblioteca biblioteca;
    private Scanner scanner;

    public Main() {
        this.biblioteca = new Biblioteca();
        this.scanner = new Scanner(System.in);
    }

    private void agregarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el ID del autor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();

        System.out.print("Ingrese el correo del autor: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese el año de publicación: ");
        int anio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el ISBN del libro: ");
        String isbn = scanner.nextLine();

        Autor autor = new Autor(id, nombreAutor, correo);
        Libro libro = new Libro(titulo, autor, anio, isbn, false);
        biblioteca.agregarLibro(libro);
        System.out.println("¡Libro agregado exitosamente!\n");
    }

    private void mostrarLibros() {
        System.out.println("\n===== Lista de Libros =====");
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Correo del Autor: " + libro.getAutor().getCorreo());
            System.out.println("Año de Publicación: " + libro.getAnioPublicacion());
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Prestado: " + (libro.isPrestado() ? "Sí" : "No"));
            System.out.println("------------------------------");
        }
    }

    private void buscarLibro() {
        System.out.print("Ingrese el título del libro a buscar: ");
        String tituloBuscar = scanner.nextLine();
        String resultadoBusqueda = biblioteca.buscarLibroPorTitulo(tituloBuscar);
        System.out.println(resultadoBusqueda);
    }

    public void ejecutar() {
        while (true) {
            System.out.println("\n===== Menú de la Biblioteca =====");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Buscar libros por nombre");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.ejecutar();
    }
}



     