package parking;

import java.io.Serializable;

/**
 * Clase del objeto vecino, con los atributos y métodos necesarios para su manipulation.
 */
public class Vecino extends Cliente implements Serializable {
    //***ATRIBUTOS***
    static final long serialVersionUID = 21L;
    String nombre;
    String apellido;
    String direccion;
    String telefono;
    String iban;

    //***CONSTRUCTOR***
    public Vecino(String dni, String nombre, String apellido, String direccion, String telefono, String iban) {
        super(dni);
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.iban = iban;
    }

    //***MÉTODOS***
    public String toString() {
        return "\n - " + nombre + " " + apellido +
                "\n -DNI: " + super.getDni() +
                "\n -Dirección: " + direccion +
                "\n -Teléfono: " + telefono +
                "\n -IBAN: " + iban;
    }
}
