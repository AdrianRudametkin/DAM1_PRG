/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Principal.java
 *
 * Created on Nov 14, 2021 At 10:02:51 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio2;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Nov 14, 2021
 * @version 1.0
 * 
 */
public class Principal {

    public static void main(String[] args) {
        Raices ecuacion = new Raices(1, 4, 4);  // Creamos objeto
        ecuacion.calcular();                    // Calculamos
    }

}
