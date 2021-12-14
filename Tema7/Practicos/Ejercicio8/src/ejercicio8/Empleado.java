/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Empleado.java
 *
 * Created on Dec 13, 2021 At 9:48:57 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio8;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 13, 2021
 * @version 1.0
 * 
 */
public class Empleado {
    private double sueldo;
    private String trabajo;
    
    public Empleado(double sueldo){
        this.sueldo = sueldo;
    }
    
    public double getSueldo(){
        return sueldo;
    }
}
