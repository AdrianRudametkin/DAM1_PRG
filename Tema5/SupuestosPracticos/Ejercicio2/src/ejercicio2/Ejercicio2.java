/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio2.java
 *
 * Created on 8 oct. 2021 At 12:03:38
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio2;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    8 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String key = "FIN", temp = "";
        
        System.out.print("Enter the key: "); 
        while(!temp.equals(key)){
            temp = s.nextLine();
        }
        s.close();
    }

}
