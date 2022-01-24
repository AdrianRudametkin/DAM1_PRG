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
 * Created on Jan 24, 2022 At 9:15:23 AM
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
 * @author  Rogelio Rodriguez
 * @date    Jan 24, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        int[] arr1, arr2, arr;
        System.out.println("Introduzca los numero del array 1: ");
        cadena = sc.nextLine();
        arr1 = parseArray(cadena);
        System.out.println("Introduzca los numero del array 2: ");
        cadena = sc.nextLine();
        arr2 = parseArray(cadena);
        
        System.out.println("Cadena ordenada: ");
        arr=ordenar(arr1,arr2);
        for(int i: arr)
            System.out.print(i+", ");
    }
    
    // concatenar y ordenar dos arrays de enteros
    public static int[] ordenar(int[] array1, int[] array2){
        // Utilizando algoritmo "Insertion Sort"
        //   1-iterar sobre el array
        //   2-Comparar numero con sus predecesores
        //   3-si es mayor se queda, si es menor baja y volvemos al paso 2
        //      hasta que sea mayor.
        //   4-continuar con el siguente elemento
        int[] arrayR = new int[(array1.length + array2.length)];
        System.arraycopy(array1, 0, arrayR, 0, array1.length);
        System.arraycopy(array2, 0, arrayR, array1.length-1, array2.length);
        
        int key,j;
        
        for(int i=1; i<arrayR.length; i++){
            key = arrayR[i];
            
            j = i - 1;
            
            while(j >= 0 && arrayR[j] > key){
                arrayR[j+1] = arrayR[j];
                j=j-1;
            }
            arrayR[j+1] = key;
        }
        return arrayR;
    }
    
    // converir string a array de ints
    public static int[] parseArray(String s){
        String[] arrayS = s.split(" ");
        int[] arrayI = new int[arrayS.length];
        
        for(int i=0; i<arrayI.length; i++){
            arrayI[i] = Integer.parseInt(arrayS[i]);
        }
        
        return arrayI;
    }

}
