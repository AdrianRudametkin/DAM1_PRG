/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Alquilable.java
 *
 * Created on Dec 28, 2021 At 11:32:52 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejerciciopropuesto;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 28, 2021
 * @version 1.0
 * 
 */

public interface Alquilable {
    // Decrementa el numero de copias disponibles
    public void alquilar();
    
    // Incrementa el numero de copias disponibles
    public void devolver();
    
    // Devuelve el precio de alquiler, depndiendo del numero de dias
    public double precioFinal();
}
