package biblioteca;

import java.util.ArrayList;

public class EmpleadosDB {
    // ***ATRIBUTOS***
    private static ArrayList<Empleado> lista;
    private static EmpleadosDB empleadosDB = null;

    // ***CONSTRUCTOR***
    private EmpleadosDB(){
        lista = new ArrayList<>();
        lista.add(new Empleado("Alberto"));
        lista.add(new Empleado("Encarna"));
        lista.add(new Empleado("Estela"));
        lista.add(new Empleado("Manolo"));
        lista.add(new Empleado("Agustín"));
    }

    // ***MÉTODOS***
    public static EmpleadosDB get(){
        if(empleadosDB == null){
            empleadosDB = new EmpleadosDB();
        }
        return empleadosDB;
    }

    public ArrayList<Empleado> lista(){
        return lista;
    }

    public void darBaja(String nombre){
        // TODO comprobar que exista y retirar de la lista
    }
    public void darAlta(String nombre){
        // TODO apuntar en la lista, comprobar que no exista
    }

    public boolean existe(String nombre){
        for(Empleado e: lista){
            if(e.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }

}
