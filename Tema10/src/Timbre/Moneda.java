package Timbre;

import Exceptions.NegativeIntegerException;

public class Moneda extends Dinero{
    // ***Atributos***
    private double diametro;
    private double peso;

    // ***CONSTRUCTORES***
    /**
     * Contructor que instancia todos los atributos del objeto.
     * @param valor valor en euros
     * @param anyo año de emision
     * @param diametro diametro en milimetros
     * @param peso peso en gramos
     */
    public Moneda(double valor, int anyo, double diametro, double peso) {
        super(valor, anyo);
        this.diametro = diametro;
        this.peso = peso;
    }

    /**
     * Constructor que copia el objeto de la lista a otro.
     * @param o objeto de clase Timbre.Moneda
     */
    public Moneda(Moneda o) {
        super(o);
        this.diametro = o.getDiametro();
        this.peso = o.getPeso();
    }

    // ***METODOS***
    //  getters y setters
    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro){
        this.diametro = diametro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "\nMONEDA: " +
                super.toString() +
                "\n Diametro: " + df.format(diametro) + " cm" +
                "\n Peso: " + df.format(peso) + " g";
    }
}
