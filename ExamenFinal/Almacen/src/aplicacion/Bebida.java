package aplicacion;

import java.io.Serializable;

public abstract class Bebida implements Serializable {
    //***ATRIBUTOS***
    static final long serialVersionUID = 1L;
    //  de objeto
    private String identificador;
    private double litros;
    private double precio;
    private String marca;

    //  de clase
    private static int num;

    //***CONSTRUCTOR***
    public Bebida(String identificador, double litros, double precio, String marca) {
        this.identificador = identificador;
        this.litros = litros;
        this.precio = precio;
        this.marca = marca;

        num++;
    }

    //***MÉTODOS***
    public double getPrecio() {
        return precio;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getMarca() {
        return marca;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num){
        Bebida.num = num;
    }

    @Override
    public String toString() {
        return ("\n -ID:" + identificador +
                "\n -Litros: " + Utilidades.formatDecimal(litros) + "L" +
                "\n -Precio: " + Utilidades.formatDecimal(precio) + "€" +
                "\n -Marca: " + marca);
    }

}
