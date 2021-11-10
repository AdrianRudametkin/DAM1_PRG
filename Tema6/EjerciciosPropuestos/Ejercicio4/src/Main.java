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
 * Created on Oct 26, 2021 At 10:12:36 PM
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

// Clase que comprueba la clase satelite
public class Main {

    public static void main(String[] args) {
        Satelite s = new Satelite(10, 15, -80);
        
        s.printPosicion();
        s.setPosicion(0, 0, 0);
        s.printPosicion();
        System.out.println(s.enOrbita());
        s.variaAltura(10.192);
        s.variaPosicion(22, 54);
        s.printPosicion();
    }

}
