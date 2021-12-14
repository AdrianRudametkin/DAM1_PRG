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
 * Created on Dec 14, 2021 At 1:12:26 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio3;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 14, 2021
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Libro l = new Libro(1234, "El Libro", 1999);
        Revista r = new Revista(4322, "La Revista", 2001, 23);
        
        System.out.println(l.toString());
        System.out.println(r.toString());
    }

}
