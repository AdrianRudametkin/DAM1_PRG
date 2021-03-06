/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Lavadora.java
 *
 * Created on Feb 11, 2022 At 12:46:33 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package examen2021;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 11, 2022
 * @version 1.0
 * 
 */
/**
 * Clase de Electrodomestico que guarda informacion sobre Lavadoras.
 * @author Rogelio Rodriguez
 */
public final class Lavadora extends Electrodomestico{
    // Valores por defecto
    private static final double CARGA_DEF = 5.0;
    
    // ***ATRIBUTOS***
    private double carga;
    
    // ***CONSTRUCTORES***
    /**
     * Constructor que inicializa el objeto con los valores predeterminados.
     */
    public Lavadora() {
        super();
        carga = CARGA_DEF;
    }

    /**
     * Contructor que inicializa los parametros con los valores introduciodes y
     * los valores por defecto.
     * @param precioBase precio del lavadora en €.
     * @param peso peso total de la lavadore en kg.
     */
    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        carga = CARGA_DEF;
    }
    
    /**
     * Constructor que inicializa los parametros con los valores introducidos.
     * @param modelo modelo/Marca del electrodomestico.
     * @param precioBase precio del electrodomestico en €.
     * @param peso peso total del electrodomestico en KG.
     * @param consEnerg consumo energetico del electrodomestico.
     * @param color color de la lavadora.
     * @param carga carga en kg que aguanta la lavadora.
     */
    public Lavadora(String modelo, double precioBase, double peso, Character consEnerg,  String color, double carga) {
        super(modelo, precioBase, peso, consEnerg, color);
        this.carga = carga;
    }
    
    /**
     * Constructor que copia un objeto 'lavadora' ya creado a otro neuvo.
     * @param l objeto ya inicializado del la clase Lavadora
     */
    public Lavadora(Lavadora l){
        super(l.getModelo(),l.getPrecioBase(),l.getPeso(),l.consEnerg, l.getColor());
        this.carga = l.carga;
    }
    
    
    /**
     * Constructor que copia un objeto 'electrodomestic' ya creado a uno de lavadora.
     * @param e objeto de electrodomestico.
     * @param carga carga maxima de la lavadora en kg.
     */
    /*public Lavadora(Electrodomestico e, double carga){
        super(e.getModelo(),e.getPrecioBase(),e.getPeso(),e.consEnerg, e.getColor());
        this.carga = carga;
    }
    */
    
  

    // ***METODOS***
    //  setters y getters
    /**
     * Metodo que modifica el atributo 'carga' del objeto.
     * @param carga carga maxima de la lavadora
     */
    public void setCarga(double carga) {    
        this.carga = carga;
    }
    /**
     * Metodo que devuelve el atributo 'carga' del objeto.
     * @return la carga maxima de la lavadora.
     */
    public double getCarga(){
        return carga;
    }
    
    //  metodos publicos
    /**
     * Metodo que calcula y devuelve el precio final de la lavadora.
     * @return Precio final de la lavadora.
     */
    public double precioFinal() {
        double precioFinal = 0;
        if(carga > 30){
            precioFinal += 50;
        }
        precioFinal += this.getPrecioBase();
        precioFinal += this.incrementoPrecio();
        
        return precioFinal;
    }
    
    /**
     * Metodo sobreescrito que devuelve una cadena de texto con toda la
     * informacion del objeto.
     * @return String con toda la informacion de la lavadora.
     */
    @Override
    public String toString(){
        return(super.toString()+""
                + "\n Tipo: Lavadora"
                + "\n -Carga: " + carga + "KG"
                + "\n -Precio Final: " + precioFinal() + "€");
    }
    
    /**
     * Metodo que comprueba si ambos objetos son iguales.
     * Devolvera true cuando se cumpla que todos sus atributos sean identicos 
     * (ignorando mayus/minus en String). Y falso en caso contrario.
     * @param lav objeto del que se quiere comparar.
     * @return true si son iguales. False en caso contrario
     */
    public boolean equals(Lavadora lav){
        if(lav.getClass() != this.getClass()){
            return false;
        }
        return this.getModelo().equalsIgnoreCase(lav.getModelo())
                && this.getPrecioBase() == lav.getPrecioBase()
                && this.consEnerg.equals(lav.consEnerg)
                && this.getPeso() == lav.getPeso()
                && carga == lav.getCarga();
    }
}
