/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio10.java
 *
 * Created on Oct 8, 2021 At 12:20:00 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio10;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Oct 8, 2021
 * @version 1.0
 * 
 */

// Programa que muestra los numeros del 1-100 menos los multiplos de 5
public class Ejercicio10 {

    public static void main(String[] args) {
        for(int i=1; i<=100; i++){
            if(i%5!=0) System.out.println(i);
        }
    }

}
