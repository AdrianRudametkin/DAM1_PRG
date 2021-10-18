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
        double array[] = {};
        boolean exit;
        
        System.out.print("Type a number: ");
        array = addX(array, s.nextInt());
        
        do{
            s.nextLine();
            System.out.println("Type another number?(y/n)");
            String answer = s.nextLine();
            
            if(answer.toLowerCase().equals("n")){
                exit = true;
            }else if(answer.toLowerCase().equals("y")){
                exit = false;
                System.out.print("Type a number: ");
                array = addX(array, s.nextInt());
            }else{
                System.out.print("Type either y (for yes) or n (for no): ");
                exit = false;
            }
        }while(!exit);
        
        System.out.printf("\n\n");
        System.out.printf("**---MAX & MIN---**\n");
        System.out.printf(" The max number is: %.2f\n", maxNum(array));
        System.out.printf(" The min number is: %.2f\n", minNum(array));
        System.out.printf("**---SUMS---**\n");
        System.out.printf(" For %d positive numbers, the sum is: %.2f\n",numPositives(array), sumPositives(array));
        System.out.printf(" For %d negative numbers, the sum is: %.2f\n", numNegatives(array), sumNegatives(array));
        System.out.printf(" For %d even numbers, the sum is: %.2f\n", numEvens(array), sumEvens(array));
        System.out.printf(" For %d odd numbers, the sum is: %.2f\n", numOdds(array), sumOdds(array));
        System.out.printf("**---AVERAGE---**\n");
        System.out.printf(" For %d numbers, the average is: %.2f\n", array.length, average(array));
    }
    
    public static double[] addX(double array[], int num){
        double newArray[] = new double[array.length + 1];
        for(int i=0; i<array.length; i++){
                newArray[i] = array[i];
            }
            newArray[array.length] = num;
        return newArray;
    }
    
    public static double maxNum(double a[]){
        double temp = a[0];
        for(int i=0; i<a.length; i++){
            if(a[i] > temp) temp = a[i];
        }
        return temp;
    }
    
    public static double minNum(double a[]){
        double temp = a[0];
        for(int i=0; i<a.length; i++){
            if(a[i] < temp) temp = a[i];
        }
        return temp;
    }
    
    public static double sumPositives(double a[]){
        double temp = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] > 0) temp+=a[i];
        }
        return temp;
    }
    public static int numPositives(double a[]){
        int temp = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] > 0) temp++;
        }
        return temp;
    }
    
    public static double sumNegatives(double a[]){
        double temp = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] < 0) temp-=a[i];
        }
        return temp;
    }
    public static int numNegatives(double a[]){
        int temp = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] < 0) temp++;
        }
        return temp;
    }
    
    public static double sumEvens(double a[]){
        double temp = 0;
        for(int i=0; i<a.length; i++){
            if(a[i]%2 == 0) temp+=a[i];
        }
        return temp;
    }
    public static int numEvens(double a[]){
        int temp = 0;
        for(int i=0; i<a.length; i++){
            if(a[i]%2 == 0) temp++;
        }
        return temp;
    }
    
    public static double sumOdds(double a[]){
        double temp = 0;
        for(int i=0; i<a.length; i++){
            if(a[i]%2 != 0) temp+=a[i];
        }
        return temp;
    }
    public static int numOdds(double a[]){
        int temp = 0;
        for(int i=0; i<a.length; i++){
            if(a[i]%2 != 0) temp++;
        }
        return temp;
    }
    
    public static double average(double a[]){
        double temp = 0;
        for(int i=0; i<a.length; i++){
            temp += a[i];
        }
        return (double)temp/a.length;
    }
}
