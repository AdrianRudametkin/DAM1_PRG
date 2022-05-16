package objetos;

import java.io.Serializable;

public class Usuario extends Persona implements Serializable {
    private static final long serialVersionUID = 40L;
    public Usuario(String nombre) {
        super(nombre);
    }
}
