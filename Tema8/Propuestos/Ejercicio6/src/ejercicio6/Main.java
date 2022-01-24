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
 * Created on Jan 24, 2022 At 8:45:47 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio6;

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
        String s = pedirCadena();
        
        if(palindromo(s)){
            System.out.println("La frase '"+s+"' SI es un palindromo.");
        }else{
            System.out.println("La frase '"+s+"' NO es un palindromo.");
        }
    }
    
     // pedir al usuario una cadena
    public static String pedirCadena(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca el texto: ");
        return sc.nextLine();
    }
    
    // compobar si la cadena formateada es un palindromo
    public static boolean palindromo(String cadena){
        String s = formatear(cadena);
        String div1, div2;
        // dividir string en 2
        if(s.length()%2==0){    // si es par
            div1=s.substring(0,s.length()/2);
            div2=s.substring(s.length()/2);
        }else{
            div1=s.substring(0,s.length()/2);
            div2=s.substring(s.length()/2+1);
        }
        
        return div1.equals(invertir(div2));
    }
    
    // formatear cadena
    public static String formatear(String s){
        return s.toLowerCase().replace(" ", "");
    }
    
    // invertir cadena
    public static String invertir(String s){
        String inv = "";
        for(int i=s.length()-1; i>=0; i--){
            inv += s.charAt(i);
        }
        return inv;
    }

}
