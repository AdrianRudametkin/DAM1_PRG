package biblioteca;

import java.util.ArrayList;

public class LibrosDB {
    // ***ATRIBUTOS***
    private static ArrayList<Libro> lista;
    private static LibrosDB librosDB = null;

    // ***CONSTRUCTOR***
    private LibrosDB(){
        lista = new ArrayList<>();
    }

    // ***MÉTODOS***
    public static LibrosDB get(){
        if(librosDB == null){
            librosDB = new LibrosDB();
        }
        return librosDB;
    }

    public int darAlta(Libro l){
        lista.add(l);
        return lista.indexOf(l);
    }

    public void darBaja(int pos){
        lista.remove(pos);
    }

    public ArrayList<Libro> lista(){
        return lista;
    }


}
