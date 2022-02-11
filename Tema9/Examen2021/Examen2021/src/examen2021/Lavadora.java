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
 * Clase de Electrodomesticos que guarda informacion sobre Lavadoras.
 * @author Rogelio Rodriguez
 */
public class Lavadora extends Electrodomesticos{
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
     * Constructor que inicializa los parametros con los valores introducidos.
     * @param modelo Modelo/Marca del electrodomestico.
     * @param precioBase Precio del electrodomestico.
     * @param peso Peso total del electrodomestico.
     * @param consEnerg Consumo energetico del electrodomestico.
     * @param carga Carge en kg que aguanta la lavadora
     */
    public Lavadora(String modelo, double precioBase, double peso, Character consEnerg, double carga) {
        super(modelo, precioBase, peso, consEnerg);
        this.carga = carga;
    }
    
    /**
     * Constructor que copia un objeto ya creado a otro neuvo.
     * @param l Objeto ya inicializado del la clase Lavadora
     */
    public Lavadora(Lavadora l){
        super(l.getModelo(),l.getPrecioBase(),l.getPeso(),l.getConsEnerg());
        this.carga = l.carga;
    }
    
    // ***METODOS***
    /**
     * Metodo que calcula y devuelve el precio final de la lavadora.
     * @return Precio final de la lavadora.
     */
    public double precioFinal(){
        double precioFinal = 0;
        if(carga > 30){
            precioFinal += 50;
        }
        precioFinal += getPrecioBase();
        precioFinal += incrementoPrecio();
        
        return precioFinal;
    }
    
    /**
     * Metodo sobreescrito que devuelve una cadena de texto con toda la
     * informacion del objeto.
     * @return String con toda la informacion de la lavadora.
     * @see java.lang.Object.toString()
     */
    @Override
    public String toString(){
        return(super.toString()+""
                + "\nTipo: Lavadora+"
                + "\nCarga: " + carga + "kg"
                + "\nPrecio Final: " + precioFinal() + "€");
    }
    
}
