/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Producto.java
 *
 * Created on 25 oct. 2021 At 9:30:21
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/


/**
 *
 * @author  Rogelio Rodriguez
 * @date    25 oct. 2021
 * @version 1.0
 * 
 */
public class Producto {
    // Atributos de la clase
    double precio;
    static double rebaja;
    
    // Constructor del producto con precio incluido
    public Producto(double precio){
        this.precio = precio;
    }
    
    // Metodo que calcula y devuelve el precio rebajado
    public double getPrecioFinal(){
        return (this.precio*(1-rebaja/100));
    }
    
    // Metodo que da informacion sobre la rebaja actual
    public static void infoRebajaActual(){
        System.out.println("Rebaja actual: " + rebaja + "%");
    }
}
