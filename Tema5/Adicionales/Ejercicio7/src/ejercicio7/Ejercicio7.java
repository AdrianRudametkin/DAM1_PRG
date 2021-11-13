/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio7.java
 *
 * Created on 18 oct. 2021 At 9:55:54
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio7;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    18 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio7 {

    public static void main(String[] args) {
        int num1, num2;
        String op;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Introduzca el primer numero: ");
        num1 = s.nextInt();
        System.out.print("Introduzca el primer numero: ");
        num2 = s.nextInt();
        System.out.print("Introduzca la operacion (+ - * / ^ %): ");
        op = s.nextLine();
        op = s.nextLine();
        
        System.out.println();
        operation(op, num1, num2);
        
    }
    
    public static void operation(String op, int num1, int num2){
        switch(op){
            case "+": System.out.printf("El resultado es: %d\n",num1 + num2); break;
            case "-": System.out.printf("El resultado es: %d\n",num1 - num2); break;
            case "*": System.out.printf("El resultado es: %d\n",num1 * num2); break;
            case "/": 
                if(num2==0) System.out.printf("La operacion es invalida!!\n");
                else System.out.printf("El resultado es: %.2f\n",(double)(num1 / num2)); 
                break;
            case "^": System.out.printf("El resultado es: %.0f\n", Math.pow(num1, num2)); break;
            case "%": System.out.printf("El resultado es: %.2f\n",(double)(num1 % num2)); break;
            default: System.out.printf("La operacion es invalida!!\n");
        }        
    }

}
