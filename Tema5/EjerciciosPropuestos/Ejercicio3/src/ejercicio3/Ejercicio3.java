/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio3.java
 *
 * Created on 7 oct. 2021 At 11:54:12
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
 * @date    7 oct. 2021
 * @version 1.0
 * 
 */

// Programa que hace un rombo
public class Ejercicio3 {

    public static void main(String[] args) {
        for(int i=0; i<7; i++){
            if(i<3){
                for(int j=3; j>0; j--){
                    if(i<j) System.out.print(" ");
                    else System.out.print("*");
                }
                System.out.print("*");
                for(int j=0; j<=2; j++){
                    if(i>j) System.out.print("*");
                    else System.out.print(" ");
                }
            }else if(i>3){
                for(int j=4; j<=6; j++){
                    if(i<j) System.out.print("*");
                    else System.out.print(" ");
                }
                System.out.print("*");
                for(int j=5; j>3; j--){
                    if(i>j) System.out.print(" ");
                    else System.out.print("*");
                }
            }else{
                for(int j=0; j<7; j++){
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }

}
