import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        Libro l1=new Libro();
        l1.setTitulo("100 años de soledad");
        l1.setAutor("-gabriel Garcia Marquez");
        l1.setGenero("Novela");
        l1.setCodigoBarras("00001");

        Libro l2=new Libro("Rowlling", "Harry Potter y la pierda filosofal", "Ciencia ficción", "00002");

        Libro l3= new Libro("Baldor", "Operaciones aritmeticas", "Educación", "00003");

        List<Libro> libros=new ArrayList<>();
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);

        System.out.println("\n -- MENU --");
        System.out.println("Opción 1 : Guardar Libro");
        System.out.println("Opción 2: Buscar por Código");
        System.out.println("Opción 3: Mostrar todos los libros ");
        System.out.println("Opción 4: Buscar por genero");
        System.out.println("\n Ingrese una opción");

        Scanner scanner= new Scanner(System.in);
        int opcion= scanner.nextInt();

        //System.out.println("El valor ingresado fue: "+ opcion);
        
        if(opcion==1){

        }else if(opcion==2){
            Libro resultado=l1.buscarPorCodigo(libros, "000002");
            if(resultado!=null){
                System.out.println(resultado.getTitulo());
            }else{
                System.err.println("No se encontró el código de barras :( ");
            }

        }else if(opcion==3){

        }else{

        }
        

    }
}