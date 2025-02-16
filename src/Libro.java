import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String autor;
    private String titulo;
    private String genero;
    private String codigoBarras;

    public Libro() {
        // Constructor vacío
    }

    public Libro(String autor, String titulo, String genero, String codigoBarras) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.codigoBarras = codigoBarras;
    }

    public String getAutor() {
        return autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getGenero() {
        return genero;
    }
    public String getCodigoBarras() {
        return codigoBarras;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Libro buscarPorCodigo(List<Libro> libros, String codigoBarras) {
        if (libros == null || codigoBarras == null) {
            return null;
        }
        
        for (Libro libro : libros) {
            if (libro.getCodigoBarras().equals(codigoBarras.trim())) {
                return libro;
            }
        }
        return null;
    }

    public void mostrarTodos(List<Libro> libros) {
        if (libros == null || libros.isEmpty()) {
            System.out.println("\nNo hay libros registrados en el sistema.");
            return;
        }

        System.out.println("\n== LISTADO DE TODOS LOS LIBROS ==");
        for (Libro libro : libros) {
            mostrarDetallesLibro(libro);
        }
    }   

    public List<Libro> busquedaPorGenero(List<Libro> libros, String genero) {
        List<Libro> librosEncontrados = new ArrayList<>();
        
        if (libros == null || genero == null) {
            return librosEncontrados;
        }

        for (Libro libro : libros) {
            if (libro.getGenero().equalsIgnoreCase(genero.trim())) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    // Método auxiliar para mostrar detalles de un libro
    private void mostrarDetallesLibro(Libro libro) {
        System.out.println("\nTítulo: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Código de Barras: " + libro.getCodigoBarras());
        System.out.println("Género: " + libro.getGenero());
        System.out.println("----------------------------------------");
    }

    // Método para validar si un libro ya existe por código de barras
    public boolean existeLibro(List<Libro> libros, String codigoBarras) {
        return buscarPorCodigo(libros, codigoBarras) != null;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "Código de Barras: " + codigoBarras + "\n" +
               "Género: " + genero;
    }
}