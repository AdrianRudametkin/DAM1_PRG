/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Encargado.java
 *
 * Created on Dec 13, 2021 At 9:49:14 AM
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
public class Encargado extends Empleado{
    
    public Encargado(double sueldo){
        super(sueldo);
    }
    
    @Override
    public double getSueldo(){
        return (super.getSueldo() * 1.1);
    }
}
