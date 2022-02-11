/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Electrodomesticos.java
 *
 * Created on Feb 11, 2022 At 11:43:35 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package examen2021;

import java.util.HashMap;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 11, 2022
 * @version 1.0
 * 
 */
/**
 * Clase abstracta que guarda informacion general sobre los electrodomesticos.
 * @author Rogelio Rodriguez
 */
public abstract class Electrodomesticos {
    // Valores por defecto
    private final static String MODELO_DEF = "Desconocido";
    private final static double PRECIOBASE_DEF = 0.0;
    private final static Character CONSENERG_DEF = 'F';
    private final static double PESO_DEF = 5.0;
    // ***ATRIBUTOS***
    //  de objeto
    private String modelo;
    private double precioBase;      // En Euros
    private double peso;            // En kilogramos
    //  de paquete
    protected Character consEnerg;
    //  de clase
    public static int numElectrodomesticos;
    public static HashMap<Character, Double> precioPorCons;
    // Por si se quiere rellenar estaticamente...
    /*static{
        precioPorCons = new HashMap<>();
        precioPorCons.put(ConsEner.A, 100.0);
        precioPorCons.put(ConsEner.B, 80.0);
        precioPorCons.put(ConsEner.C, 60.0);
        precioPorCons.put(ConsEner.D, 50.0);
        precioPorCons.put(ConsEner.E, 30.0);
        precioPorCons.put(ConsEner.F, 10.0);
    }*/
    
    // ***CONSTRUCTOR***
    /**
     * Constructor de clase estableciendo el elctrodomestico con los valores por
     * defecto.
     */
    public Electrodomesticos() {
        modelo = MODELO_DEF;
        precioBase = PRECIOBASE_DEF;
        peso = PESO_DEF;
        consEnerg = CONSENERG_DEF;
        rellenarLetras();
    }

    /**
     * Constructor que inicializa los parametros con los valores introducidos.
     * @param modelo Modelo/Marca del electrodomestico.
     * @param precioBase Precio del electrodomestico.
     * @param peso Peso total del electrodomestico.
     * @param consEnerg Consumo energetico del electrodomestico.
     */
    public Electrodomesticos(String modelo, double precioBase, double peso, Character consEnerg) {
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.peso = peso;
        this.consEnerg = consEnerg;
        rellenarLetras();
    }
    
    // ***METODS***
    //  metodo para rellenar el atributo estatico 'precioPorCons'
    private static void rellenarLetras(){
        precioPorCons = new HashMap<>();
        precioPorCons.put('A', 100.0);
        precioPorCons.put('B', 80.0);
        precioPorCons.put('C', 60.0);
        precioPorCons.put('D', 50.0);
        precioPorCons.put('E', 30.0);
        precioPorCons.put('F', 10.0);
    }
    
    //  getters y setters
    public String getModelo() {
        return modelo;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    public double getPeso() {
        return peso;
    }
    public Character getConsEnerg() {
        return consEnerg;
    }
    public static int getNumElectrodomesticos() {
        return numElectrodomesticos;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setConsEnerg(Character consEnerg) {
        comprobarConsumo(consEnerg);
    }
    
    //  metodos privados
    private void comprobarConsumo(char letra){
        // Comprobar que la letra pasada es valida y escribirla al atributo de objeto
        Character c = Character.toUpperCase(letra);
        if(c.equals('A') || c.equals('B') || c.equals('C')
        || c.equals('D') || c.equals('E') || c.equals('F')){
            consEnerg = c;
        }
    }
    
    //  metodos publicos
    public final double incrementoPrecio(){
        // Devolver el incremento del precio dependiendo del peso y consumo energetico
        double aumento = 0;
        if(peso>=0 && peso<=19){
            aumento += 10;
        }else if(peso>=20 && peso<=49){
            aumento += 50; 
        }else if(peso>=56 && peso<=79){
            aumento += 80;
        }else{
            aumento += 100;
        }
        
        aumento += precioPorCons.get(consEnerg);
        return aumento;
    }
    
    /**
     * Metodo sobreescrito que devuelve una cadena de texto con toda la
     * informacion del objeto.
     * @return String con toda la informacion del electrodomestico.
     * @see java.lang.Object.toString()
     */
    @Override
    public String toString(){
        return("\nModelo: " + modelo
                + "\nPrecio Base: " + precioBase + "€"
                + "\nConsumo Energetico: " + consEnerg
                + "\nPeso: " + peso + "kg");
    }
}
