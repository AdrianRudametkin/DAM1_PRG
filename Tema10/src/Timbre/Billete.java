package Timbre;

public class Billete extends Dinero{
    // ***ATRIBUTOS***
    private double altura;
    private double anchura;

    // ***CONSTRUCTORES***

    /**
     * Contructor que instancia todos los atributos del objeto.
     * @param valor valor en euros
     * @param anyo año de emision
     * @param altura dimension X del billete en milimetros
     * @param anchura dimension Y del billete en milimetros
     */
    public Billete(double valor, int anyo, double altura, double anchura) {
        super(valor, anyo);
        this.altura = altura;
        this.anchura = anchura;
    }

    /**
     * Constructor que copia el objeto 'o' a otro.
     * @param o objeto de clase Timbre.Billete
     */
    public Billete(Billete o) {
        super(o);
        this.altura = o.getAltura();
        this.anchura = o.getAnchura();
    }

    // ***METODOS***
    //  getters y setters
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAnchura() {
        return anchura;
    }

    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }

    @Override
    public String toString() {
        return "\nBILLETE: " +
                super.toString() +
                "\n Altura: " + df.format(altura) + "mm" +
                "\n Anchura: " + df.format(anchura) + "mm";
    }
}
