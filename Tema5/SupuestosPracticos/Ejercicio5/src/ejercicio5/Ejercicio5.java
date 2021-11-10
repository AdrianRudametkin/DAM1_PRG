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
 * Created on 8 oct. 2021 At 13:00:41
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
 * @date    8 oct. 2021
 * @version 1.0
 * 
 */

// Programa que muestra una piramide de altura designada por el usuario
public class Ejercicio5 {

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        
        // Preguntar por el tamaño de la piramide
        System.out.print("Introduce la altura de la piramide: ");
        n = s.nextInt();
        
        // Entrar en un bucle del tamaño de n
        for(int i=0; i<n; i++){
            // Imprimir la parte izquierda
            for(int j=n; j>0; j--){
                if(i<j) System.out.print("-");
                else System.out.print("*");
            }
            // Imprimir el trozo del medio
            System.out.print("*");
            // Imprimir la parte derecha
            for(int j=0; j<n; j++){
                if(i>j) System.out.print("*");
                else System.out.print("-");
            }
            // Pasar a la siguente linea
            System.out.println("");
        }
    }

}
