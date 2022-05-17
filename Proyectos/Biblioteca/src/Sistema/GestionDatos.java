package Sistema;

import Objetos.Empleado;
import Objetos.Libro;
import Objetos.Usuario;

import java.util.ArrayList;

public class GestionDatos {
    private static ArrayList<Empleado> empleados;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Libro> libros;

    //*************************************
    //      GESTIÓN DE FICHEROS
    //*************************************
    public void cargarFichero(String fp){
        //TODO
    }

    public void guardarFichero(String fp){
        //TODO
    }

    //*************************************
    //      GESTIÓN DE LIBROS
    //*************************************
    public void altaLibro(String titulo, String autor, String editorial, int ubicacion, String isbn, double precio){
        //TODO
    }

    public ArrayList<Libro> busquedaLibroTitulo(String s){
        ArrayList<Libro> resultados = new ArrayList<>();
        for(Libro l: libros){
            if(l.getTitulo().equals(s)){
                resultados.add(l);
            }
        }

        return resultados;
    }
    public ArrayList<Libro> busquedaLibroAutor(String s){
        ArrayList<Libro> resultados = new ArrayList<>();
        for(Libro l: libros){
            if(l.getAutor().equals(s)){
                resultados.add(l);
            }
        }

        return resultados;
    }
    public ArrayList<Libro> busquedaLibroEditorial(String s){
        ArrayList<Libro> resultados = new ArrayList<>();
        for(Libro l: libros){
            if(l.getEditorial().equals(s)){
                resultados.add(l);
            }
        }

        return resultados;
    }
    public ArrayList<Libro> busquedaLibroIsbn(String s){
        ArrayList<Libro> resultados = new ArrayList<>();
        for(Libro l: libros){
            if(l.getIsbn().equals(s)){
                resultados.add(l);
            }
        }

        return resultados;
    }
    public ArrayList<Libro> busquedaLibroUbicacion(int i){
        ArrayList<Libro> resultados = new ArrayList<>();
        for(Libro l: libros){
            if(l.getPasillo() == i){
                resultados.add(l);
            }
        }

        return resultados;
    }
    public ArrayList<Libro> busquedaLibroEmpleado(Empleado e){
        ArrayList<Libro> resultados = new ArrayList<>();
        for(Libro l: libros){
            if(l.getEmpleado() == e){
                resultados.add(l);
            }
        }

        return resultados;
    }

    public ArrayList<Libro> busquedaLibroUsuario(Usuario u){
        ArrayList<Libro> resultados = new ArrayList<>();
        for(Libro l: libros){
            if(l.getUsuario() == u){
                resultados.add(l);
            }
        }

        return resultados;
    }

    public ArrayList<Libro> busquedaLibroEstado(boolean b){
        ArrayList<Libro> resultados = new ArrayList<>();
        for(Libro l: libros){
            if(l.isPrestado() == b){
                resultados.add(l);
            }
        }

        return resultados;
    }


    //*************************************
    //      GESTIÓN DE USUARIOS
    //*************************************

    //*************************************
    //      GESTIÓN DE EMPLEADOS
    //*************************************
}
