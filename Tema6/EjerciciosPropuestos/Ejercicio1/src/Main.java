/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Main.java
 *
 * Created on Oct 26, 2021 At 9:36:04 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Oct 26, 2021
 * @version 1.0
 * 
 */

// Comprueba la clase Finanzas
public class Main {

    public static void main(String[] args) {
        Finanzas f1 = new Finanzas();
        System.out.printf("1€ = %.2f$\n",f1.dolarsToEuros(1.0));
        System.out.printf("10$ = %.2f€\n",f1.eurosToDolars(10.0));
        
        System.out.println("");
        System.out.println("Viene la inflacion...");
        Finanzas f2 = new Finanzas(3.23);
        System.out.printf("1€ = %.2f$\n",f2.eurosToDolars(1.0));
        System.out.printf("10$ = %.2f€\n",f2.dolarsToEuros(10.0));
    }

}
