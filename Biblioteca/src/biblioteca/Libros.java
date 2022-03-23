package biblioteca;

import java.util.ArrayList;

public class Libros {
    // ***ATRIBUTOS***
    private static ArrayList<Libro> lista;
    private static Libros librosObj = null;

    // ***CONSTRUCTOR***
    private Libros(){
        lista = new ArrayList<>();
    }

    // ***MÉTODOS***
    public static Libros get(){
        if(librosObj == null){
            librosObj = new Libros();
        }
        return librosObj;
    }

    public ArrayList<Libro> lista(){
        return lista;
    }
}
