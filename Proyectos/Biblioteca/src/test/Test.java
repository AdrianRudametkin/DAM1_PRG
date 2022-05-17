package test;

import objetos.Empleado;
import sistema.GestionDatos;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        GestionDatos gd = new GestionDatos();

        gd.cargarFichero();
        System.out.print("\n" + gd.listaEmpleados().toString());
        System.out.print("\n"+gd.listaUsuarios().toString());
        gd.altaEmpleado(new Empleado("Pablo"));
        //gd.guardarFichero();
    }

}
