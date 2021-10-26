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
public class Main {

    public static void main(String[] args) {
        Finanzas f1 = new Finanzas();
        System.out.println("1$ = "+f1.dolarsToEuros(1.0)+"€");
        
        Finanzas f2 = new Finanzas(1.99);
        System.out.println("1$ = "+f2.dolarsToEuros(1.0)+"€");
    }

}
