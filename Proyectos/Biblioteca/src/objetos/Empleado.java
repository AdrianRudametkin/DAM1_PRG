package objetos;

import java.io.Serializable;

public class Empleado implements Serializable {
    private String nombre;
    private static final long serialVersionUID = 198096123421L;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString(){
        return "\nEmpleado: "+nombre;
    }
}
