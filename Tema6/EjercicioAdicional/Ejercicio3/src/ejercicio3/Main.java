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
 * Created on Nov 14, 2021 At 10:32:59 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio3;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Nov 14, 2021
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Password p1 = new Password();
        Password p2 = new Password(20);
        
        System.out.println("Contraseña 1: " + p1.getContrasenya());
        System.out.println("Contraseña 2: " + p2.getContrasenya());
    }

}
