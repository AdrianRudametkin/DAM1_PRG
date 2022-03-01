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
 * Created on Jan 24, 2022 At 12:55:20 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio8;

import java.util.Arrays;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 24, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = crearVector(100, 10, 80);
        System.out.println(Arrays.toString(arr));
        System.out.println("El numero con mas frecuencia es el "+hayarNumero(arr));
    }

    private static int hayarNumero(int[] arr) {
        // hayar el maximo y minimo para saber que valores contaremos
        int min, max;
        min = arr[0];
        max = arr[0];
        for(int i: arr){
            if(i<min)
                min = i;
            if(i>max)
                max = i;
        }
        
        // cada elemento representa un numeroX+min; contar cuantas veces ocurre
        int[] freq = new int[max-min+1];
        for(int i: arr){
            freq[i-min] += 1;
        }
        
        // averiguar cual es el mayor
        int mayor=0;
        for(int i=0; i<freq.length; i++){
            if(freq[i]>freq[mayor]){
                mayor = i;
            }
        }
        System.out.println(Arrays.toString(freq));
        return mayor+min;
        
    }

    private static int[] crearVector(int length, int min, int max) {
        int[] array = new int[length];
        
        for(int i=0; i<length; i++){
            array[i] = (int)(Math.random()*(max-min+1)+min);
        }
        
        return array;
    }

}
