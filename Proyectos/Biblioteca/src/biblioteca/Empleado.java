package biblioteca;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {
    private static final long serialVersionUID = 41L;
    public Empleado(String nombre) {
        super(nombre);
    }
}
