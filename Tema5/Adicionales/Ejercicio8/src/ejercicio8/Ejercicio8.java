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
        System.out.print("Introducir el dia: ");
        d = s.nextInt();
        while (d > 31 && d < 1) {
            System.out.println("Introduzca un dia valido (1-30): ");
        }

        System.out.print("Introducir el mes: ");
        m = s.nextInt();
        while (m > 12 && m < 1) {
            System.out.println("Introduzca un mes valido (1-12): ");
        }
        System.out.print("Introducir el año: ");
        m = s.nextInt();
        while (m < 0) {
            System.out.println("Introduzca un año(0-inf): ");
        }
    }

}
