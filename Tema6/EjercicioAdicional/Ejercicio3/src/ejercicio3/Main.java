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

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Nov 14, 2021
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Longitud de la contraseña 1: [default]");
        Password p1 = new Password();
        System.out.println("Introduce la longitud de la contraseña 2: ");
        Password p2 = new Password(sc.nextInt());
        
        System.out.println("Contraseña 1: " + p1.getContrasenya());
        System.out.println("Contraseña 2: " + p2.getContrasenya());
    }

}
