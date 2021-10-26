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
 * Created on Oct 26, 2021 At 10:00:43 PM
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
        Numero n1 = new Numero();
        Numero n2 = new Numero(10);
        
        n1.anyade(10);
        n2.anyade(10);
        
        n1.resta(5);
        n2.setNumero();
        
        System.out.println(n1.getDoble());
        System.out.println(n1.getTriple());
        System.out.println(n2.getValor());
    }

}
