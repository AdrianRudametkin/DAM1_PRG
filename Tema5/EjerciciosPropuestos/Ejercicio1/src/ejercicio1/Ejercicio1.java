/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio1.java
 *
 * Created on 7 oct. 2021 At 11:45:39
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio1;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    7 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        int a, b, c;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Type first number: ");
        a = s.nextInt();
        System.out.print("Type second number: ");
        b = s.nextInt();
        System.out.print("Type third number: ");
        c = s.nextInt();
        
        if(a>b && a>c) System.out.println("The greater number is: " + a);
        else if(b>c) System.out.println("The greater number is: " + b);
        else System.out.println("The greater number is: " + c);
        
        if(a<b && a<c) System.out.println("The smallest number is: " + a);
        else if(b<c) System.out.println("The smallest number is: " + b);
        else System.out.println("The smallest number is: " + c);
    }

}
