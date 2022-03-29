package biblioteca;

import java.util.ArrayList;

public class UsuariosDB {
    // ***ATRIBUTOS***
    private static ArrayList<Usuario> lista;
    private static UsuariosDB usuariosDB = null;

    // ***CONSTRUCTOR***
    private UsuariosDB(){
        lista = new ArrayList<>();
        lista.add(new Usuario("usu1"));
        lista.add(new Usuario("usu2"));
        lista.add(new Usuario("usu3"));
        lista.add(new Usuario("usu4"));
        lista.add(new Usuario("usu5"));
    }

    // ***MÉTODOS***
    public static UsuariosDB get(){
        if(usuariosDB == null){
            usuariosDB = new UsuariosDB();
        }
        return usuariosDB;
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

    public boolean existe(String nombre){
        for(Usuario u: lista){
            if(u.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
}
