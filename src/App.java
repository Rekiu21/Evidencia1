import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Libro> libros = new ArrayList<>();
        // Inicializar algunos libros de ejemplo
        Libro l1 = new Libro("Gabriel García Márquez", "100 años de soledad", "Novela", "00001");
        Libro l2 = new Libro("J.K. Rowling", "Harry Potter y la piedra filosofal", "Fantasía", "00002");
        Libro l3 = new Libro("Baldor", "Operaciones aritméticas", "Educación", "00003");
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Mostrar menú
            System.out.println("\n=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
            System.out.println("1. Crear / Registrar un libro");
            System.out.println("2. Buscar por Código");
            System.out.println("3. Mostrar todos los libros registrados");
            System.out.println("4. Buscar por Género");
            System.out.println("5. Salir");
            System.out.println("\nIngrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n== REGISTRO DE NUEVO LIBRO ==");
                    System.out.println("Ingrese el título:");
                    String titulo = scanner.nextLine();
                    
                    System.out.println("Ingrese el autor:");
                    String autor = scanner.nextLine();
                    
                    System.out.println("Ingrese el código de barras:");
                    String codigo = scanner.nextLine();
                    
                    System.out.println("Ingrese el género:");
                    String genero = scanner.nextLine();
                    
                    Libro nuevoLibro = new Libro(autor, titulo, genero, codigo);
                    libros.add(nuevoLibro);
                    System.out.println("\n¡Libro registrado exitosamente!");
                    break;

                case 2:
                    System.out.println("\n== BÚSQUEDA POR CÓDIGO ==");
                    System.out.println("Ingrese el código de barras:");
                    String codigoBuscar = scanner.nextLine();
                    
                    Libro resultado = l1.buscarPorCodigo(libros, codigoBuscar);
                    if (resultado != null) {
                        System.out.println("\nLibro encontrado:");
                        System.out.println("Título: " + resultado.getTitulo());
                        System.out.println("Autor: " + resultado.getAutor());
                        System.out.println("Código de Barras: " + resultado.getCodigoBarras());
                        System.out.println("Género: " + resultado.getGenero());
                    } else {
                        System.out.println("No se encontró el código solicitado: " + codigoBuscar);
                    }
                    break;

                case 3:
                    System.out.println("\n== LISTADO DE TODOS LOS LIBROS ==");
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros registrados.");
                    } else {
                        for (Libro libro : libros) {
                            System.out.println("\nTítulo: " + libro.getTitulo());
                            System.out.println("Autor: " + libro.getAutor());
                            System.out.println("Código de Barras: " + libro.getCodigoBarras());
                            System.out.println("Género: " + libro.getGenero());
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n== BÚSQUEDA POR GÉNERO ==");
                    System.out.println("Ingrese el género a buscar:");
                    String generoBuscar = scanner.nextLine();
                    
                    List<Libro> resultadosGenero = l1.busquedaPorGenero(libros, generoBuscar);
                    if (!resultadosGenero.isEmpty()) {
                        System.out.println("\nLibros encontrados:");
                        for (Libro libro : resultadosGenero) {
                            System.out.println("\nTítulo: " + libro.getTitulo());
                            System.out.println("Autor: " + libro.getAutor());
                            System.out.println("Código de Barras: " + libro.getCodigoBarras());
                            System.out.println("Género: " + libro.getGenero());
                        }
                    } else {
                        System.out.println("No se encontró el género solicitado: " + generoBuscar);
                    }
                    break;

                case 5:
                    System.out.println("\n¡Gracias por usar el sistema! Hasta pronto.");
                    continuar = false;
                    break;

                default:
                    System.out.println("\nOpción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
        scanner.close();
    }
}