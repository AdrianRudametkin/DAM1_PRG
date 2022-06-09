package aplicacion;

import java.io.Serializable;

public class Agua extends Bebida implements Serializable {
    //***ATRIBUTOS***
    static final long serialVersionUID = 21L;
    //  de objeto
    private String origen;

    //***CONSTRUCTOR***
    public Agua(String identificador, double litros, double precio, String marca, String origen) {
        super(identificador, litros, precio, marca);
        this.origen = origen;
    }

    //***MÉTODOS***
    @Override
    public String toString() {
        return ("Agua Mineral:" +
                super.toString() +
                "\n -Origen: " + origen);
    }
}
