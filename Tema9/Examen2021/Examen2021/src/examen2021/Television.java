/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Television.java
 *
 * Created on Feb 15, 2022 At 12:23:51 PM
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
 * @date    Feb 15, 2022
 * @version 1.0
 * 
 */
/**
 * Clase de Electrodomestico que guarda informacion sobre televisores.
 * @author Rogelio Rodriguez
 */
public final class Television extends Electrodomestico{
    // Valores por defecto
    private final double RESOLUCION_DEF = 20.0;
    private final boolean TIENETDT_DEF = false;
    
    // ***ATRIBUTOS***
    private double resolucion;
    private boolean tieneTDT;
    
    // ***CONSTRUCTORES***
    /**
     * Constructor que inicializa el objeto con los valores predeterminados.
     */
    public Television() {
        super();
        resolucion = RESOLUCION_DEF;
        tieneTDT = TIENETDT_DEF;
    }
    
    /**
     * Contructor que inicializa los parametros con los valores introduciodes y
     * los valores por defecto. 
     * @param precioBase precio del televisor en €.
     * @param peso peso total del televisor en kg.
     */
    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        resolucion = RESOLUCION_DEF;
        tieneTDT = TIENETDT_DEF;
    }
    
    /**
     * Constructor que inicializa los parametros con los valores introducidos.
     * @param modelo modelo/Marca del electrodomestico.
     * @param precioBase precio del electrodomestico en €.
     * @param peso peso total del electrodomestico en KG.
     * @param consEnerg consumo energetico del electrodomestico.
     * @param color color del televisor.
     * @param resolucion resolucion del televisor en pulgadas.
     * @param tieneTDT si el televisor tiene (true) o no (false) sintonizador TDT.
     */
    public Television(String modelo, double precioBase, double peso, Character consEnerg, String color, double resolucion, boolean tieneTDT) {
        super(modelo, precioBase, peso, consEnerg, color);
        this.resolucion = resolucion;
        this.tieneTDT = tieneTDT;
    }
    
    /**
     * Constructor que copia un objeto 'Television' ya creado a otro neuvo.
     * @param t objeto ya inicializado del la clase Lavadora.
     */
    public Television(Television t){
        super(t.getModelo(),t.getPrecioBase(),t.getPeso(),t.consEnerg, t.getColor());
        this.resolucion = t.resolucion;
        this.tieneTDT = t.tieneTDT;
    }
    
    // ***METODOS***
    //  getters y setters
    /**
     * Metodo que devuelve el atributo 'resolucion' del objeto.
     * @return resolucion del televisor en pulgadas.
     */
    public double getResolucion() {
        return resolucion;
    }
    /**
     * Metodo que devuelve el atributo 'tieneTDT' del objeto.
     * @return si el televisor tiene (true) o no (false) sintonizador TDT.
     */
    public boolean isTieneTDT() {
        return tieneTDT;
    }

    /**
     * Metodo que modifica el atributo 'resolucion' del objeto.
     * @param resolucion resolucion del televisor en pulgadas.
     */
    public void setResolucion(double resolucion) {
        this.resolucion = resolucion;
    }
    /**
     * Metodo que modifica el atributo 'tieneTDT' del objeto.
     * @param tieneTDT si el televisor tiene (true) o no (false) sintonizador TDT.
     */
    public void setTieneTDT(boolean tieneTDT) {
        this.tieneTDT = tieneTDT;
    }
    
    //  metodos publicos
    /**
     * Metodo que calcula y devuelve el precio final de la lavadora.
     * @return Precio final de la lavadora.
     */
    public double precioFinal() {
        double precioFinal = 0;
        
        precioFinal += getPrecioBase();
        precioFinal += incrementoPrecio();
        
        if(tieneTDT){
            precioFinal += 50;
        }
        
        if(resolucion > 40){
            precioFinal += precioFinal*0.3;
        }
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
                + "\n Tipo: Television"
                + "\n -Resolucion: "+resolucion+" pulgadas"
                + "\n -Sintonizador TDT: "+(tieneTDT?"Si":"No")
                + "\n -Precio Final: " + precioFinal() + "€");
    }
    
    /**
     * Metodo que comprueba si ambos objetos son iguales.
     * Devolvera true cuando se cumpla que todos sus atributos sean identicos 
     * (ignorando mayus/minus en String). Y falso en caso contrario.
     * @param tel objeto del que se quiere comparar.
     * @return true si son iguales. False en caso contrario
     */
    public boolean equals(Television tel){
        if(tel.getClass() != this.getClass()){
            return false;
        }
        return this.getModelo().equalsIgnoreCase(tel.getModelo())
                && this.getPrecioBase() == tel.getPrecioBase()
                && this.consEnerg.equals(tel.consEnerg)
                && this.getPeso() == tel.getPeso()
                && resolucion == tel.resolucion
                && tieneTDT == tel.tieneTDT;
    }
    
}
