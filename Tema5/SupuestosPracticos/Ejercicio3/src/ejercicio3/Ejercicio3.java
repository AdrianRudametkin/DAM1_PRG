/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio3.java
 *
 * Created on 8 oct. 2021 At 12:16:09
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio3;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    8 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int year;
        
        System.out.print("Type a year: ");
        year = s.nextInt();
        
        String answer = algoritmo_bisiesto(year)?"es":"no es";
        System.out.println("El año " + answer + " bisiesto.");
        
        s.close();
    }
    
    private static boolean algoritmo_bisiesto(int year){
        boolean respuesta;
        
        if(year%4 != 0) respuesta = false;
        else if((year%100 == 0) && (year%400 != 0)) respuesta = false;
        else respuesta = true;
        
        return respuesta;
    }
}
