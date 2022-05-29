package parking;

import java.io.Serializable;

/**
 * Clase del objeto Cliente que contiene más información. Necesario para vecinos.
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
        return " - " + nombre + " " + apellido +
                "\n -DNI: " + super.getDni() +
                "\n -Dirección: " + direccion +
                "\n -Teléfono: " + telefono +
                "\n -IBAN: " + iban;
    }
}
