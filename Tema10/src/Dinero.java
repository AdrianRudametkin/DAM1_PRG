import java.text.DecimalFormat;

public abstract class Dinero {
    // ***ATRIBUTOS***
    private double valor;
    private int anyo;

    protected DecimalFormat df = new DecimalFormat(".##");

    // ***CONSTRUCTOR***
    public Dinero(double valor, int anyo) {
        this.valor = valor;
        this.anyo = anyo;
    }

    public Dinero(Dinero o){
        this.valor = o.getValor();
        this.anyo = o.getAnyo();
    }

    // ***METODOS***
    //  gettes y setters
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    /**
     * Metodo que compara dos objetos de Dinero. Devuleve true si son de la misma clase y ademas
     * tengan el mismo valor y año de emision.
     * @param o objeto que herede de la clase Dinero
     * @return si los objetos son iguales
     */
    public boolean equals(Dinero o){
        if(o.getClass().equals(getClass()) && o.getAnyo()==getAnyo() && o.getValor()==getValor()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que compara dos objetos de Dinero.
     * @param o objeto que herede de la clase Dinero
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
     * @return cadena formateda
     */
    @Override
    public String toString() {
        return  ("\n Valor: " + df.format(valor) + "€" +
                "\n Año de emisión: " + anyo);
    }
}
