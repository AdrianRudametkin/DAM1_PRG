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
 * Created on Dec 13, 2021 At 9:12:05 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio1;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 13, 2021
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Examen e1 = new Examen("Mates",13, new Fecha(15,9,2022), new Hora(12,5));
        Examen e2 = new Examen("Castellano",79, new Fecha(16,9,2022), new Hora(9,30));
        
        System.out.println(e1.toString());
        System.out.println(e2.toString());
    }

}
