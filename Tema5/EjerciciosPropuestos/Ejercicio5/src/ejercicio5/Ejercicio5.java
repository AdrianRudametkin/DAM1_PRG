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
 * Created on Oct 7, 2021 At 11:12:03 PM
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
 * @date    Oct 7, 2021
 * @version 1.0
 * 
 */

// Programa que te saca la tabla de multiplicar que quieras
public class Ejercicio5 {

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Introduce un numero del 1 al 10: ");
        n = s.nextInt();
        
        for(int i=1; i<=10; i++){
            System.out.println(n + " x " + i + " = " + n*i);
        }
    }

}
