package biblioteca;

import java.util.ArrayList;

public class Usuarios {
    // ***ATRIBUTOS***
    private static ArrayList<Usuario> lista;
    private static Usuarios usuariosObj = null;

    // ***CONSTRUCTOR***
    private Usuarios(){
        lista = new ArrayList<>();
        lista.add(new Usuario("usu1"));
        lista.add(new Usuario("usu2"));
        lista.add(new Usuario("usu3"));
        lista.add(new Usuario("usu4"));
        lista.add(new Usuario("usu5"));
    }

    // ***MÉTODOS***
    public static Usuarios get(){
        if(usuariosObj == null){
            usuariosObj = new Usuarios();
        }
        return usuariosObj;
    }

    public ArrayList<Usuario> lista(){
        return lista;
    }

    public void darBaja(String nombre){
        // TODO comprobar que exista y retirar de la lista
    }
    public void darAlta(String nombre){
        // TODO apuntar en la lista, comprobar que no exista
    }
}
