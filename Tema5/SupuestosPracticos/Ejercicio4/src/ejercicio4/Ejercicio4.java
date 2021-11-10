/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio4.java
 *
 * Created on 8 oct. 2021 At 12:44:43
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio4;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    8 oct. 2021
 * @version 1.0
 * 
 */

// Programa que simula un calculadora primitiva
public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1, num2, result;
        String option;
        
        System.out.print("Introduce el primer numero: ");
        num1 = s.nextInt();
        System.out.print("Introduce el segundo numero: ");
        num2 = s.nextInt();
        option = s.nextLine();
        System.out.print("¿Que quieres hacer? Sumar, restar, multiplicar, dividir o elevar: ");
        option = s.nextLine();
        
        switch(option.toLowerCase().replace(" ", "")){
            case "sumar": System.out.println("Result: " + (num1 + num2)); break;
            case "restar": System.out.println("Result: " + (num1 - num2)); break;
            case "multiplicar": System.out.println("Result: " + (num1 * num2)); break;
            case "dividir":
            	if(num2==0) System.out.println("La division por 0 no es posible.");
            	else System.out.println("Result: " + (num1 / num2)); 
            	break;
            case "elevar": System.out.println("Result: " + ((int)Math.pow((double)num1, (double)num2))); break;
            default: System.out.println("Not a valid option.");
        }
    }

}
