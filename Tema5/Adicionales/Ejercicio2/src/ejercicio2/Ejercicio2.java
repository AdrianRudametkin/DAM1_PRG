/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio2.java
 *
 * Created on 18 oct. 2021 At 8:18:48
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio2;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    18 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int temp;
        int numMax, numMin;
        int sumPos=0, numPos=0, sumNeg=0, numNeg=0, sumEven=0,numEven=0, sumOdd=0, numOdd=0;
        int totalNum=0, totalSum=0;
        boolean exit;
        
        System.out.print("Introduzca un numero: ");
        temp = s.nextInt();
        // Maximums and minimums
        numMax = temp;
        numMin = temp;
        // Sums of positives, negatives, evens and odds (and their occurences)
        if(temp >= 0){
            numPos++;
            sumPos+=temp;
        }else{
            numNeg++;
            sumNeg-=temp;
        }
        if(temp%2==0){
            numEven++;
            sumEven+=temp;
        }else{
            numOdd++;
            sumOdd+=temp;
        }
        // Average
        totalNum++;
        totalSum+=temp;
        do{
            s.nextLine();
            System.out.println("¿Introducir otro numero?(s/n)");
            String answer = s.nextLine();
            
            if(answer.toLowerCase().equals("n")){
                exit = true;
            }else if(answer.toLowerCase().equals("s")){
                exit = false;
                System.out.print("Introducir un numero: ");
                temp = s.nextInt();
                // Maximums and minimums
                if(temp > numMax) numMax = temp;
                if(temp < numMin) numMin = temp;
                // Sums of positives, negatives, evens and odds (and their occurences)
                if(temp >= 0){
                    numPos++;
                    sumPos+=temp;
                }else{
                    numNeg++;
                    sumNeg-=temp;
                }
                if(temp%2==0){
                    numEven++;
                    sumEven+=temp;
                }else{
                    numOdd++;
                    sumOdd+=temp;
                }
                // Average
                totalNum++;
                totalSum+=temp;
            }else{
                System.out.print("Introduzca s (para s) o n (para no): ");
                exit = false;
            }
        }while(!exit);
        
        System.out.printf("\n\n");
        System.out.printf("**---MAX & MIN---**\n");
        System.out.printf(" El maximo es: %d\n", numMax);
        System.out.printf(" El minimo es: %d\n", numMin);
        System.out.printf("**---SUMAS---**\n");
        System.out.printf(" Para %d numeros positivos, la suma es: %d\n",numPos, sumPos);
        System.out.printf(" Para %d numeros negativos, la suma es: %d\n", numNeg, sumNeg);
        System.out.printf(" Para %d numeros pares, la suma es: %d\n", numEven, sumEven);
        System.out.printf(" Para %d numeros impares, la suma es: %d\n", numOdd, sumOdd);
        System.out.printf("**---MEDIA---**\n");
        System.out.printf(" Para %d numeros, la media es: %.2f\n", totalNum, (double)totalSum/totalNum);
    }
}
