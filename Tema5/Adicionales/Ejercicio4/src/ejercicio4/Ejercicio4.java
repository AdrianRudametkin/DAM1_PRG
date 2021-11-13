/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio4.java
 *
 * Created on 18 oct. 2021 At 9:35:39
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
 * @date    18 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        final String password = "password";
        String input;
        Scanner s = new Scanner(System.in);
        
        for(int i=0; i<3; i++){
            System.out.print("Introduzca la contraseña: ");
            input = s.nextLine();
            if(input.equals(password)){
                System.out.println("Felicidades ☆*:.o(≧▽≦)o.:*☆");
                break;
            }
            else System.out.println("Esa no es la contraseña (¬.¬)");
        }
        s.close();
    }

}
