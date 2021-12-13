/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio7.java
 *
 * Created on Dec 13, 2021 At 8:39:19 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio7;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 13, 2021
 * @version 1.0
 * 
 */
public class Ejercicio7 {

    public static void main(String[] args) {
        Pez juan = new Pez("juan");
        Pez diego = new Pez("diego");
        Pez diego_copia = new Pez(diego);
        Pez juan_mismo = juan;
        
        
        
        System.out.println(Pez.getNumpeces());
        System.out.println("\nJuan y Juan_mismo: -"+juan+"- -"+juan_mismo+"-");
        System.out.println("equals " + juan_mismo.equals(juan));
        System.out.println("== " + (juan_mismo==juan));
        System.out.println("\nDiego y Diego_copia: -"+diego+"- -"+diego_copia+"-");
        System.out.println("equals " + diego.equals(diego_copia));
        System.out.println("== " + (diego==diego_copia));
    }

}
