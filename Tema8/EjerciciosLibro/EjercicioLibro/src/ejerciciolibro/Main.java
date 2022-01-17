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
 * Created on Jan 12, 2022 At 8:30:18 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejerciciolibro;

/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 12, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        printArray(miArray());
    }
    
    private static int[] miArray(){
        int[] array = new int[100];
        
        for(int i=0; i<array.length; i++){
            array[i] = (int)(Math.random()*100+1);
        }
        
        return array;
    }

    private static void printArray(int array[]){
        int suma = 0;
        for(int i: array){
            suma = suma+i;
        }
        System.out.println(suma);
    }
}
