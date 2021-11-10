/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio6.java
 *
 * Created on Oct 7, 2021 At 11:16:44 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio6;

import java.util.*;

/**
 *
 * @author  Rogelio Rodriguez
 * @date    Oct 7, 2021
 * @version 1.0
 * 
 */

// Programa que saque un numero aleatorio entre 100 y 200 e indicar si es par
public class Ejercicio6 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int valor = rnd.nextInt(101) + 100;
        System.out.println(valor);
        if(valor%2==0) System.out.println("Es par.");
        else System.out.println("Es impar.");
    }

}
