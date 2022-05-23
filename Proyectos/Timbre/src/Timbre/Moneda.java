package Timbre;

import Exceptions.NegativeIntegerException;

public class Moneda extends Dinero{
    // ***Atributos***
    private double diametro;
    private double peso;

    // ***CONSTRUCTORES***
    /**
     * Contructor que instancia todos los atributos del objeto.
     * Ampliación del constructor {@link Dinero#Dinero(double valor, int anyo) Dinero()}
     *
     * @param valor valor en euros
     * @param anyo año de emisión
     * @param diametro diámetro en centímetros
     * @param peso peso en gramos
     */
    public Moneda(double valor, int anyo, double diametro, double peso) {
        super(valor, anyo);
        this.diametro = diametro;
        this.peso = peso;
    }

    /**
     * Constructor que copia el objeto de la lista a otro.
     * Ampliación del constructor copia {@link Dinero#Dinero(Dinero o) Dinero()}
     *
     * @param o objeto de clase {@link Moneda Moneda}
     */
    public Moneda(Moneda o) {
        super(o);
        this.diametro = o.getDiametro();
        this.peso = o.getPeso();
    }

    // ***METODOS***
    //  getters y setters

    /**
     * Devuelve el díametro de la moneda.
     *
     * @return díametro en cm
     */
    public double getDiametro() {
        return diametro;
    }

    /**
     * Cambia el diametro de la moneda.
     *
     * @param diametro díametro en cm.
     */
    public void setDiametro(double diametro){
        this.diametro = diametro;
    }

    /**
     * Devuelve el peso de la moneda.
     *
     * @return peso en g
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Cambia el peso de la moneda.
     *
     * @param peso peso en g
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Devuelve una cadena con la información del billete.
     * Ampliación de {@link Dinero#toString() Dinero.toString()}
     *
     * @return cadena formateada
     */
    @Override
    public String toString() {
        return "\nMONEDA: " +
                super.toString() +
                "\n Diametro: " + df.format(diametro) + " cm" +
                "\n Peso: " + df.format(peso) + " g";
    }
}
