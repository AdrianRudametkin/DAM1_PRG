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
 * Created on Oct 7, 2021 At 11:27:10 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
 */
package ejercicio7;

import java.util.Scanner;

/**
 *
 * @author Rogelio Rodriguez
 * @date Oct 7, 2021
 * @version 1.0
 *
 */
public class Ejercicio7 {

    public static void main(String[] args) {
        int numD;
        String numR = "";
        Scanner s = new Scanner(System.in);
        
        System.out.print("Type a number: ");
        numD = s.nextInt();
        
        if(numD>4000) System.out.println("Number too big for Romans.");
        else{
            switch(numD/1000%10){
                case 0: numR=""; break;
                case 1: numR="M"; break;
                case 2: numR="MM"; break;
                case 3: numR="MMM"; break;
                default: numR=" ";
            }
            switch(numD/100%10){
                case 0: numR+=""; break;
                case 1: numR+="C"; break;
                case 2: numR+="CC"; break;
                case 3: numR+="CCC"; break;
                case 4: numR+="CD"; break;
                case 5: numR+="D"; break;
                case 6: numR+="DC"; break;
                case 7: numR+="DCC"; break;
                case 8: numR+="DCCC"; break;
                case 9: numR+="CM"; break;
                default: numR+=" ";
            }
            switch(numD/10%10){
                case 0: numR+=""; break;
                case 1: numR+="X"; break;
                case 2: numR+="XX"; break;
                case 3: numR+="XXX"; break;
                case 4: numR+="XL"; break;
                case 5: numR+="L"; break;
                case 6: numR+="LX"; break;
                case 7: numR+="LXX"; break;
                case 8: numR+="LXXX"; break;
                case 9: numR+="XC"; break;
                default: numR+=" ";
            }
            switch(numD%10){
                case 0: numR+=""; break;
                case 1: numR+="I"; break;
                case 2: numR+="II"; break;
                case 3: numR+="III"; break;
                case 4: numR+="IV"; break;
                case 5: numR+="V"; break;
                case 6: numR+="VI"; break;
                case 7: numR+="VII"; break;
                case 8: numR+="VIII"; break;
                case 9: numR+="IX"; break;
                default: numR+=" ";
            }
            System.out.println(numR);
        }
        
    }

}
