/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

 /*
 *
 * Ejercicio8.java
 *
 * Created on 22 oct. 2021 At 12:17:25
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
 */
package ejercicio8;

import java.util.Scanner;

/**
 *
 * @author Rogelio Rodriguez
 * @date 22 oct. 2021
 * @version 1.0
 *
 */
public class Ejercicio8 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int d, m, y;
        System.out.print("Enter the day: ");
        d = s.nextInt();
        while (d > 31 && d < 1) {
            System.out.println("Enter a valid day (1-30): ");
        }

        System.out.print("Enter the month: ");
        m = s.nextInt();
        while (m > 12 && m < 1) {
            System.out.println("Enter a valid day (1-30): ");
        }
        System.out.print("Enter the year: ");
        m = s.nextInt();
        while (m > 12 && m < 1) {
            System.out.println("Enter a valid day (1-30): ");
        }
    }

}
