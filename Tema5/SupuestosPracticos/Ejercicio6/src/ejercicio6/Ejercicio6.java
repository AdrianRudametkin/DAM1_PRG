/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio6.java
 *
 * Created on Oct 12, 2021 At 12:25:50 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio6;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Oct 12, 2021
 * @version 1.0
 * 
 */

// Indicar mes a partir de un numero tecleado
public class Ejercicio6 {

    public static void main(String[] args) {
        int num;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Introduzca un numero: ");
        num = s.nextInt();
        
        System.out.print("El mes es: ");
        switch(num){
            case 1: System.out.println("Enero"); break;
            case 2: System.out.println("Febrero"); break;
            case 3: System.out.println("Marzo"); break;
            case 4: System.out.println("Abril"); break;
            case 5: System.out.println("Mayo"); break;
            case 6: System.out.println("Junio"); break;
            case 7: System.out.println("Julio"); break;
            case 8: System.out.println("Agosto"); break;
            case 9: System.out.println("Septiembre"); break;
            case 10: System.out.println("Octubre"); break;
            case 11: System.out.println("Noviembre"); break;
            case 12: System.out.println("Diciembre"); break;
            default: System.out.println("No existe... :/");
        }
    }

}
