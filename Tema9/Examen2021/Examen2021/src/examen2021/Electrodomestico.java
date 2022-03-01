/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Electrodomestico.java
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
public abstract class Electrodomestico {
    // Valores por defecto
    private final static String MODELO_DEF = "Desconocido";
    private final static double PRECIOBASE_DEF = 0.0;
    private final static Character CONSENERG_DEF = 'F';
    private final static double PESO_DEF = 5.0;
    private final static String COLOR_DEF = "blanco";
    
    private final static String[] COLORES_VALIDOS= {
        "blanco", "negro", "rojo", "azul", "gris"
    };
    
    // ***ATRIBUTOS***
    //  de objeto
    private String modelo;
    private double precioBase;      // En Euros
    private double peso;            // En kilogramos
    private String color;
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
    public Electrodomestico() {
        modelo = MODELO_DEF;
        precioBase = PRECIOBASE_DEF;
        peso = PESO_DEF;
        consEnerg = CONSENERG_DEF;
        color = COLOR_DEF;
        numElectrodomesticos ++;
    }

    /**
     * Constructor que inicializa los parametros con los valores introducidos y 
     * el resto por defecto.
     * @param precioBase precio del electrodomestico en €.
     * @param peso peso total del electrodomestico en kg.
     */
    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        modelo = MODELO_DEF;
        consEnerg = CONSENERG_DEF;
        color = COLOR_DEF;
        numElectrodomesticos ++;
    }
    
    

    /**
     * Constructor que inicializa los parametros con los valores introducidos.
     * @param modelo modelo/Marca del electrodomestico.
     * @param precioBase precio del electrodomestico en €.
     * @param peso peso total del electrodomestico en KG.
     * @param consEnerg consumo energetico del electrodomestico.
     * @param color color del electrodomestico
     */
    public Electrodomestico(String modelo, double precioBase, double peso, Character consEnerg, String color) {
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.peso = peso;
        comprobarConsumo(consEnerg);
        comprobarColor(color);
        numElectrodomesticos ++;
    }
    
    // ***METODS***
    /**
     * Metodo que rellena la tabla interna 'precioPorCons', que indica
     * el precio por cada letra del consumo energetico.
     */
    public final static void rellenarLetras(){
        precioPorCons = new HashMap<>();
        precioPorCons.put('A', 100.0);
        precioPorCons.put('B', 80.0);
        precioPorCons.put('C', 60.0);
        precioPorCons.put('D', 50.0);
        precioPorCons.put('E', 30.0);
        precioPorCons.put('F', 10.0);
    }
    
    //  getters y setters
    /**
     * Metodo que devuelve el atributo 'modelo' del objeto.
     * @return el modelo del electrodomestico
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * Metodo que devuelve el atributo 'precioBase' del objeto.
     * @return el precio base del electrodomestico en €.
     */
    public double getPrecioBase() {
        return precioBase;
    }
    /**
     * Metodo que devuelve el atributo 'peso' del objeto.
     * @return el peso del electrodomestico en kg.
     */
    public double getPeso() {
        return peso;
    }
    /**
     * Metodo que devuelve el atributo 'consEnerg' del objeto.
     * @return la letra del consumo energetico del electrodomestico.
     */
    public Character getConsEnerg() {
        return consEnerg;
    }
    /**
     * Metodo que devuelve el atributo 'color' del objeto.
     * @return el color del electrodomestico.
     */
    public String getColor() {
        return color;
    }
    /**
     * Metodo que devuelve el atributo 'numElectrodomesticos' de la clase.
     * @return el numero de objetos electrodomesticos creados.
     */
    public static int getNumElectrodomesticos() {
        return numElectrodomesticos;
    }
    
    /**
     * Metodo que modifica el atributo 'modelo' del objeto.
     * @param modelo modelo del electrodomestico
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    /**
     * Metodo que modifica el atributo 'precioBase' del objeto.
     * @param precioBase precio base del electrodomestico en €.
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    /**
     * Metodo que modifica el atributo 'peso' del objeto.
     * @param peso peso del electrodomestico en kg.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
    /**
     * Metodo que modifica el atributo 'consEnerg' del objeto.
     * Este metodo no modifica el atributo directamente. Pasa por un metodo interno
     * que comprubea si la letra es correcta.
     * @param consEnerg letra del consumo energetico del electrodomestico.
     */
    public void setConsEnerg(Character consEnerg) {
        comprobarConsumo(consEnerg);
    }
    /**
     * Metodo que modifica el atributo 'color' del objeto.
     * Este metodo no modifica el atributo directamente. Pasa por un metodo interno
     * que comprubea si el color es correcto.
     * @param color color del electrodomestico.
     */
    public void setConsEnerg(String color) {
        comprobarColor(color);
    }
    
    //  metodos privados
    /**
     * Metodo que comprueba si la letra pasado por parametro se encuentra entre
     * la 'A' y la 'F', ignorando mayus/minusculas, y actualiza el atributo 'consEnerg'.
     * En caso de que no sea correcto, mostrara un mensaje de error por pantalla
     * y asignara el valor por defecto al atributo.
     * @param letra letra que se quiera comprobar.
     */
    private void comprobarConsumo(char letra){
        // Comprobar que la letra pasada es valida y escribirla al atributo de objeto
        Character c = Character.toUpperCase(letra);
        if(c.equals('A') || c.equals('B') || c.equals('C')
        || c.equals('D') || c.equals('E') || c.equals('F')){
            consEnerg = c;
        }else{
            System.out.println(" *CONSUMO No valido: estableciendo parametro por defecto '"+CONSENERG_DEF+"'.");
            consEnerg = CONSENERG_DEF;
        }
    }
    
    /**
     * Metodo que compruba si el color esta incluido en la lista de validos, ignorando
     *  mayus/minusculas, y actualiza el atributo 'color'.
     * En caso de que no sea correcto, mostrara un mensaje de error por pantalla
     * y asignara el valor por defecto al atributo.
     * @param color 
     */
    private void comprobarColor(String color) {
        for(String c: COLORES_VALIDOS){
            if(c.equalsIgnoreCase(color)){
                this.color = color.toLowerCase();
                return;
            }
        }
        System.out.println(" *COLOR No valido: estableciendo parametro por defecto '"+COLOR_DEF+"'.");
        this.color = COLOR_DEF;
    }
    
    //  metodos publicos
    /**
     * Metodo que calcula el incremento de precio dependiendo del peso del 
     * electrodomestico.
     * @return precio que se tiene que incrementar
     */
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
     */
    @Override
    public String toString(){
        return("\n Modelo: " + modelo
                + "\n -Precio Base: " + precioBase + "€"
                + "\n -Consumo Energetico: " + consEnerg
                + "\n -Peso: " + peso + "KG");
    }
}
