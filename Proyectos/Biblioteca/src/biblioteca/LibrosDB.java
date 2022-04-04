package biblioteca;

import org.jetbrains.annotations.NotNull;

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

    public void prestar(Empleado empleado, Usuario usuario, Libro l){
        l.setPrestado(true);
        l.setEmpleado(empleado);
        l.setUsuario(usuario);
    }

    public void devolver(Libro l){
        l.setPrestado(false);
        l.setEmpleado(null);
        l.setUsuario(null);
    }

}
