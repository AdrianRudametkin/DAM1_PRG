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
        
        System.out.print("Type a number: ");
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
            System.out.println("Type another number?(y/n)");
            String answer = s.nextLine();
            
            if(answer.toLowerCase().equals("n")){
                exit = true;
            }else if(answer.toLowerCase().equals("y")){
                exit = false;
                System.out.print("Type a number: ");
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
                System.out.print("Type either y (for yes) or n (for no): ");
                exit = false;
            }
        }while(!exit);
        
        System.out.printf("\n\n");
        System.out.printf("**---MAX & MIN---**\n");
        System.out.printf(" The max number is: %d\n", numMax);
        System.out.printf(" The min number is: %d\n", numMin);
        System.out.printf("**---SUMS---**\n");
        System.out.printf(" For %d positive numbers, the sum is: %d\n",numPos, sumPos);
        System.out.printf(" For %d negative numbers, the sum is: %d\n", numNeg, sumNeg);
        System.out.printf(" For %d even numbers, the sum is: %d\n", numEven, sumEven);
        System.out.printf(" For %d odd numbers, the sum is: %d\n", numOdd, sumOdd);
        System.out.printf("**---AVERAGE---**\n");
        System.out.printf(" For %d numbers, the average is: %.2f\n", totalNum, (double)totalSum/totalNum);
    }
}
