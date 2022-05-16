package database;

import objetos.DatabaseOutputStream;
import objetos.Empleado;

import java.io.*;
import java.util.ArrayList;

public class EmpleadosDB extends Database{
    // ***ATRIBUTOS***
    private static ArrayList<Empleado> list;
    private static EmpleadosDB empleadosDB = null;

    private static final String FILEPATH = "empleados.db";
    private static File file;
    protected static final long serialVersionUID = 1L;  // Para la serialización del objeto.

    // ***CONSTRUCTOR***
    /**
     * Constructor por defecto: inicializa la base de datos.
     */
    private EmpleadosDB(){
        init();
    }

    // ***MÉTODOS***

    private void init(){
        list = new ArrayList<>();
        file = new File(FILEPATH);
        readDB();
    }


    public EmpleadosDB get(){
        if(empleadosDB == null){
            empleadosDB = new EmpleadosDB();
            return empleadosDB;
        }
        return empleadosDB;
    }

    public boolean existe(String nombre){
        for(Empleado e: list){
            if(e.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void readDB() {
        if(!file.exists()){
            writeDB();
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILEPATH));
            list.clear();
            list.addAll((ArrayList) ois.readObject());
            System.out.println("--Base de datos cargada correctamente.--");
        } catch (ClassNotFoundException e) {
            System.out.println("**Error: Archivo Corrupto. Se ha procedido a borrar el archivo.");
            file.delete();
        }catch (IOException e) {
            System.out.println("**Error Funesto: Lectura de archivos invalida. Se ha procedido a borrar el archivo.");
            file.delete();
        }
    }

    @Override
    protected void writeDB() {
        if(!file.exists() || file.length()==0){
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILEPATH));
            } catch (IOException e) {
                System.out.println("**Error Funesto: Lectura de archivos invalida. Se ha procedido a borrar el archivo.");
                file.delete();
            }
        }else{
            try {
                DatabaseOutputStream oos = new DatabaseOutputStream(new FileOutputStream(FILEPATH));
                oos.write()
            } catch (IOException e) {
                System.out.println("**Error Funesto: Lectura de archivos invalida. Se ha procedido a borrar el archivo.");
                file.delete();
            }
        }
    }

    public void add(Empleado obj) {
        list.add(obj);

    }

    public void remove(Empleado obj) {

    }

    @Override
    public String toString() {
        return null;
    }
}
