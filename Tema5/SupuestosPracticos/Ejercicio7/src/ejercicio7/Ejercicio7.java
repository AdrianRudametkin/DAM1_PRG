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
 * Created on Oct 12, 2021 At 12:32:11 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio7;

import java.io.IOException;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Oct 12, 2021
 * @version 1.0
 * 
 */
public class Ejercicio7 {

    public static void main(String[] args) throws IOException {
        // Primero impreme por pantalla para indicar al usuario
        System.out.println("Introduzca un texto: ");
        // Entramos en un bucle infinito hasta que read() lance una excepcion.
        while(true){
            // Se lee la letra como entero de la consola
            int letra = System.in.read();
            // Imprimir el entero como caracter haciendo un casting
            System.out.println((char)letra);
        }
    }

}
