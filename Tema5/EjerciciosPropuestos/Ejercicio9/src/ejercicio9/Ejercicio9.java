/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio9.java
 *
 * Created on Oct 8, 2021 At 12:15:46 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio9;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Oct 8, 2021
 * @version 1.0
 * 
 */

// Programa que muestra los primeros 50 numeros pares
public class Ejercicio9 {

    public static void main(String[] args) {
        int i = 1, j = 0;
        do{
            if(i%2 == 0){
                System.out.println(i);
                j++;
            }
            i++;
        }while(j<50);
    }

}
