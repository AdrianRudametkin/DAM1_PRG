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
 * Created on Oct 26, 2021 At 10:33:42 PM
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

// Clase que comprueba la clase Peso
public class Main {

    public static void main(String[] args) {
        Peso p =  new Peso(1,"lb");
        
        System.out.printf("%.2f\n",p.getLibras());
        System.out.printf("%.2f\n",p.getLingotes());
        System.out.printf("%.2f\n",p.getPeso("OZ"));
    }

}
