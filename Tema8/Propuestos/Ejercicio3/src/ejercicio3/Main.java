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
 * Created on Jan 24, 2022 At 8:21:43 AM
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
 * @date    Jan 24, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        if(pedirCadena().equalsIgnoreCase(pedirCadena()))
            System.out.println("Son iguales.");
        else
            System.out.println("Son distintos.");
    }
    
    // pedir al usuario una cadena
    public static String pedirCadena(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca el texto: ");
        return sc.nextLine();
    }

}
