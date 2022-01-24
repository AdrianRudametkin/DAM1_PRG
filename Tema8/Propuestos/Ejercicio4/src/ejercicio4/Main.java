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
 * Created on Jan 24, 2022 At 8:27:09 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio4;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 24, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        String s = crearUsuario(pedirCadena("nombre"),
                pedirCadena("primer apellido"),
                pedirCadena("segundo apellido"));
        System.out.println("Su usuario es: " + s);
    }
    
    // pedir al usuario una cadena
    public static String pedirCadena(String tipo){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca su "+tipo+": ");
        return sc.nextLine();
    }
    
    // creacion del codigo de usuario
    public static String crearUsuario(String nombre, String apellido1, String apellido2){
        return (nombre.substring(0,3) + 
                apellido1.substring(0,3) + 
                apellido2.substring(0,3)
                ).toUpperCase();
    }
}
