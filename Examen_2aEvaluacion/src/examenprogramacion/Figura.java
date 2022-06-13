/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Figura.java
 *
 * Created on Feb 28, 2022 At 8:21:19 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package examenprogramacion;

import java.text.DecimalFormat;
import java.util.HashMap;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 28, 2022
 * @version 1.0
 * 
 */
public abstract class Figura {
    // ***ATRIBUTOS***
    //  de clase
    protected static HashMap<Integer, Character> figuras;
    private static int numFiguras;
    //  de objeto
    private int base;
    private int altura;
    //  de paquete
    protected DecimalFormat dc = new DecimalFormat(".##");
    
    // ***CONSTRUCTOR***
    public Figura(int base, int altura){
        this.base = base;
        this.altura = altura;
        numFiguras++;
    }
    
    // ***METODOS***
    //  privvados
    public static void rellenarFiguras() {
        figuras = new HashMap<>();
        
        figuras.put(1, '*');
        figuras.put(2, '$');
        figuras.put(3, '@');
        figuras.put(4, '&');
        figuras.put(5, '€');
    }
    
    //  getters y setters
    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public static int getNumFiguras(){
        return numFiguras;
    }
    
    //  metodos de objeto
    @Override
    public String toString(){
        return ("\nDatos:"
                + "\n -Area: " + dc.format(area())
                + "\n -Perimetro: " + dc.format(perimetro())
                + "\n -Base: " + base
                + "\n -Altura: "+ altura);
    }
    //  abstractos
    public abstract double area();
    public abstract double perimetro();
    public abstract void dibujar();
    
    
}
