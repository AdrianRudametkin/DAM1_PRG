/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Main.java
 *
 * Created on Dec 13, 2021 At 9:48:30 AM
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
public class Main {

    public static void main(String[] args) {
        double sueldo = 1000;
        Empleado e1 = new Empleado(sueldo);
        Encargado e2 = new Encargado(sueldo);
        
        System.out.println("Sueldo empleado: "+e1.getSueldo());
        System.out.println("Sueldo empleado: "+e2.getSueldo());
    }

}
