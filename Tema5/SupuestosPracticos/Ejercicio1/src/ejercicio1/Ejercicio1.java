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
 * Created on 8 oct. 2021 At 11:36:12
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
 * @date    8 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String fn, ln1, ln2, allNames;
        int indexMax, indexMin = 0;
        
        System.out.print("Enter your first and second lastname, then your name: ");
        allNames = s.nextLine();
        
        indexMax = allNames.indexOf(" ");
        ln1 = allNames.substring(indexMin, indexMax);
        
        indexMin = indexMax + 1;
        indexMax = allNames.indexOf(" ", indexMin);
        ln2 = allNames.substring(indexMin, indexMax);
        
        indexMin = indexMax + 1;
        fn = allNames.substring(indexMin);
        
        System.out.println(fn+" "+ln1+" "+ln2);
        
        s.close();
    }

}
