package Timbre;

public class Billete extends Dinero{
    // ***ATRIBUTOS***
    private double altura;
    private double anchura;

    // ***CONSTRUCTORES***

    /**
     * Contructor que instancia todos los atributos del objeto.
     * Ampliación del constructor {@link Dinero#Dinero(double valor, int anyo) Dinero()}
     *
     * @param valor valor en euros
     * @param anyo año de emision
     * @param altura alto del billete en centímetros
     * @param anchura ancho del billete en centímetros
     */
    public Billete(double valor, int anyo, double altura, double anchura) {
        super(valor, anyo);
        this.altura = altura;
        this.anchura = anchura;
    }

    /**
     * Constructor que copia un objeto {@link Billete Billete} a este.
     * Ampliación del constructor copia {@link Dinero#Dinero(Dinero o) Dinero()}
     *
     * @param o objeto de clase {@link Billete Billete}
     */
    public Billete(Billete o) {
        super(o);
        this.altura = o.getAltura();
        this.anchura = o.getAnchura();
    }

    // ***METODOS***
    //  getters y setters

    /**
     * Devuleve la altura del billete.
     *
     * @return altura en cm
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Cambia la altura del billete.
     *
     * @param altura altura en cm
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Devuelve el ancho del billete.
     *
     * @return anchura en cm
     */
    public double getAnchura() {
        return anchura;
    }

    /**
     * Cambia el ancho del billete.
     *
     * @param anchura anchura en cm
     */
    public void setAnchura(double anchura){
        this.anchura = anchura;
    }

    /**
     * Devuelve una cadena con la información del billete.
     * Ampliación de {@link Dinero#toString() Dinero.toString()}
     *
     * @return cadena formateada
     */
    @Override
    public String toString() {
        return "\nBILLETE: " +
                super.toString() +
                "\n Altura: " + df.format(altura) + " cm" +
                "\n Anchura: " + df.format(anchura) + " cm";
    }
}
