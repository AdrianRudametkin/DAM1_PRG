package objetos;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    static final long serialVersionUID = 89719495891L;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString(){
        return "\nUsuario: "+nombre;
    }
}
