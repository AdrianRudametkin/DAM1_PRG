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
 * Created on Oct 7, 2021 At 11:51:59 PM
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
 * @author  Rogelio Rodriguez
 * @date    Oct 7, 2021
 * @version 1.0
 * 
 */

// Programa que detecta si un numero es OMIRP
public class Ejercicio8 {

    public static void main(String[] args) {
        int num,rev;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Introduce un numero: ");
        num = s.nextInt();
        
        if(!isPrime(num)) System.out.println(num+" no es primo.");
        else if(!isPrime(reverseInt(num))) System.out.println(num+" es primo, pero " +reverseInt(num)+ " no lo es. No es OMIRP");
        else System.out.println(num+" es primo y " +reverseInt(num)+ " tambien. Es OMIRP!!");
    }
    
    public static boolean isPrime(int num){
        for(int i=2; i<num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static int reverseInt(int num){
        String s = Integer.toString(num), newS = "";
        
        for(int i=s.length()-1; i>=0; i--){
            newS += s.charAt(i);
        }
        
        return Integer.parseInt(newS);
    }
}
