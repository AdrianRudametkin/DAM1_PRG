/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio5.java
 *
 * Created on 18 oct. 2021 At 9:46:42
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio5;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    18 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        int num;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Introduzca un numero: ");
        num = s.nextInt();
        
        for(int i=0; i<10; i++){
            System.out.println((int)(Math.random()*num));
        }
    }

}
