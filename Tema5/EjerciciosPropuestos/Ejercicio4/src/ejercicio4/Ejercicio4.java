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
 * Created on 7 oct. 2021 At 12:45:44
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
 * @date    7 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        int temp, day, month, year;
        String numString;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Type your day of birth: ");
        day = s.nextInt();
        System.out.print("Type your month of birth: ");
        month = s.nextInt();
        System.out.print("Type your year of birth: ");
        year = s.nextInt();
        
        temp = day + month + year;
        numString = Integer.toString(temp);
        temp = 0;
        while(numString.length()>1){
            for(int i=0; i<numString.length(); i++){
                temp = Integer.parseInt(numString.substring(i, i+1)) + temp;
            }
            numString = Integer.toString(temp);
            temp = 0;
        }
        
        System.out.println("Your Lucky Number is: " + numString);
    }

}
