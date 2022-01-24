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
 * Created on Jan 24, 2022 At 8:34:56 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio5;

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
        vocales(pedirCadena());
    }
    
    // pedir al usuario una cadena
    public static String pedirCadena(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca el texto: ");
        return sc.nextLine();
    }
    
    // imprimir numero de vocales
    public static void vocales(String s){
        System.out.println("Numero de A's: "+letras(s, "a"));
        System.out.println("Numero de I's: "+letras(s, "i"));
        System.out.println("Numero de U's: "+letras(s, "u"));
        System.out.println("Numero de E's: "+letras(s, "e"));
        System.out.println("Numero de O's: "+letras(s, "o"));
    }
    
    // contar letras en una cadena
    public static int letras(String cadena, String filtro){
        int i=0;
        for(char c: cadena.toLowerCase().toCharArray()){
            if(filtro.toLowerCase().charAt(0)==c)
                i++;
        }
        return i;
    }

}
