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
public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1, num2, result;
        String option;
        
        System.out.print("Type the first number: ");
        num1 = s.nextInt();
        System.out.print("Type the second number: ");
        num2 = s.nextInt();
        option = s.nextLine();
        System.out.print("What do you want to do? Add, subtract, multiply, divide, or power: ");
        option = s.nextLine();
        
        switch(option.toLowerCase().replace(" ", "")){
            case "add": System.out.println("Result: " + (num1 + num2)); break;
            case "subtract": System.out.println("Result: " + (num1 - num2)); break;
            case "multiply": System.out.println("Result: " + (num1 * num2)); break;
            case "divide": System.out.println("Result: " + (num1 / num2)); break;
            case "power": System.out.println("Result: " + ((int)Math.pow((double)num1, (double)num2))); break;
            default: System.out.println("Not a valid option.");
        }
    }

}
