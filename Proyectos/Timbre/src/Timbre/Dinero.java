package Timbre;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class Dinero implements Serializable {
    // ***ATRIBUTOS***
    private double valor;
    private int anyo;
    static final long serialVersionUID = 1L;

    protected DecimalFormat df = new DecimalFormat("#.##");

    // ***CONSTRUCTOR***

    /**
     * Constructor de Dinero
     *
     * @param valor valor del timbre en €
     * @param anyo año de emisión
     */
    public Dinero(double valor, int anyo) {
        this.valor = valor;
        this.anyo = anyo;
    }

    /**
     * Constructor copia de dinero
     *
     * @param o objeto de tipo Dinero
     */
    public Dinero(Dinero o){
        this.valor = o.getValor();
        this.anyo = o.getAnyo();
    }

    // ***METODOS***
    //  gettes y setters

    /**
     * Devuelve el valor del timbhre.
     *
     * @return valor en €
     */
    public double getValor() {
        return valor;
    }

    /**
     * Cambiar el valor del timbre.
     *
     * @param valor valor en €
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Devuleve el año de emisión del timbre.
     *
     * @return
     */
    public int getAnyo() {
        return anyo;
    }

    /**
     * Cambiar el año de emisión del timbre.
     *
     * @param anyo
     */
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    /**
     * Metodo que compara dos objetos de Timbre.Dinero. Devuleve true si son de la misma clase y ademas
     * tengan el mismo valor y año de emision.
     *
     * @param o objeto que herede de la clase Timbre.Dinero
     * @return si los objetos son iguales
     */
    public boolean equals(Dinero o){
        return o.getClass().equals(getClass()) && (o.getAnyo() == getAnyo()) && (o.getValor() == getValor());
    }

    /**
     * Metodo que compara dos objetos de Dinero.
     *
     * @param o objeto que herede de la clase Timbre.Dinero
     * @return >0 cuando 'o' sea mayor, <0 cuando sea menor y 0 cuando sean iguales.
     */
    public int compareTo(Dinero o){
        if(o.getAnyo()>getAnyo()){
            return 1;
        }else if(o.getAnyo()<getAnyo()){
            return -1;
        }else{
            if(o.getValor()>getValor()){
                return 1;
            }else if(o.getValor()<getValor()){
                return -1;
            }else{
                return 0;
            }
        }
    }

    /**
     * Metodo que devuelve una cadena don el valor y año de emisión.
     *
     * @return cadena formateda
     */
    @Override
    public String toString() {
        return  ("\n Valor: " + df.format(valor) + " €" +
                "\n Año de emisión: " + anyo);
    }
}
