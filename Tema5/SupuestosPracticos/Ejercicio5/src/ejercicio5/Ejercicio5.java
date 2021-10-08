/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio5.java
 *
 * Created on 8 oct. 2021 At 13:00:41
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
 * @date    8 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter the size of your pyramid: ");
        n = s.nextInt();
        
        for(int i=0; i<n; i++){
            if(i<n){
                for(int j=n; j>0; j--){
                    if(i<j) System.out.print(" ");
                    else System.out.print("*");
                }
                System.out.print("*");
                for(int j=0; j<=n; j++){
                    if(i>j) System.out.print("*");
                    else System.out.print(" ");
                }
            }else{
                for(int j=0; j<n; j++){
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }

}
