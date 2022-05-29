package parking;

import java.io.Serializable;

public class Cliente implements Serializable {
    //***ATRIBUTOS***
    private String dni;
    static final long serialVersionUID = 2L;

    //***CONSTRUCTOR***
    public Cliente(String dni) {
        this.dni = dni;
    }

    //***MÉTODOS***

    public String getDni() {
        return dni;
    }

    public boolean equals(Cliente cliente) {
        return this.dni.equalsIgnoreCase(cliente.dni);
    }

    @Override
    public String toString() {
        return " -DNI: " + dni;
    }
}
