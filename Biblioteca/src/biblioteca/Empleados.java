package biblioteca;

import java.util.ArrayList;

public class Empleados {
    // ***ATRIBUTOS***
    private static ArrayList<Empleado> lista;
    private static Empleados empleadosObj = null;

    // ***CONSTRUCTOR***
    private Empleados(){
        lista = new ArrayList<>();
        lista.add(new Empleado("Alberto"));
        lista.add(new Empleado("Encarna"));
        lista.add(new Empleado("Estela"));
        lista.add(new Empleado("Manolo"));
        lista.add(new Empleado("Agustín"));
    }

    // ***MÉTODOS***
    public static Empleados get(){
        if(empleadosObj == null){
            empleadosObj = new Empleados();
        }
        return empleadosObj;
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

}
