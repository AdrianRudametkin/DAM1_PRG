package aplicacion;

import java.io.Serializable;

public class Refresco extends Bebida implements Serializable {
    //***ATRIBUTOS***
    static final long serialVersionUID = 22L;
    //  de objeto
    private double porAzucar;
    private double descuento;

    //***CONSTRUCTOR***
    public Refresco(String identificador, double litros, double precio, String marca, double porAzucar, double descuento) {
        super(identificador, litros, precio, marca);
        this.porAzucar = porAzucar;
        this.descuento = descuento;
    }

    //***MÉTODOS***
    public double getDescuento() {
        return descuento;
    }

    @Override
    public double getPrecio(){
        double total = super.getPrecio()-super.getPrecio() * descuento / 100.0;
        if(total<0)
            return 0;
        else
            return total;
    }

    @Override
    public String toString() {
        return ("Bebida Azucarada:" +
                super.toString() +
                "\n -Azúcar: " + Utilidades.formatDecimal(porAzucar) + "%" +
                "\n -Descuento: " + Utilidades.formatDecimal(descuento) + "% -> (Precio real: " + Utilidades.formatDecimal(this.getPrecio()) + "€)");
    }
}
