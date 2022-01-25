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
 * Created on Jan 24, 2022 At 1:27:31 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio9;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 24, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        int[] array = crearVector(100, 1, 100);
        
        System.out.println("Vector aleatorio: ");
        for(int i: array)
            System.out.print(i+", ");
        System.out.println("");
        
        System.out.println("Vector ordenado: ");
        array = ordenar(array);
        for(int i: array)
            System.out.print(i+", ");
        System.out.println("");
        
        numerosNoMostrados(array);
        
        
    }
    
    private static int[] crearVector(int length, int min, int max) {
        int[] array = new int[length];
        
        for(int i=0; i<length; i++){
            array[i] = (int)(Math.random()*(max-min+1)+min);
        }
        
        return array;
    }
    
     // ordenar array de enteros
    public static int[] ordenar(int[] arr){
        // Utilizando algoritmo "Insertion Sort"
        //   1-iterar sobre el array
        //   2-Comparar numero con sus predecesores
        //   3-si es mayor se queda, si es menor baja y volvemos al paso 2
        //      hasta que sea mayor.
        //   4-continuar con el siguente elemento
        int[] arrayR = arr;
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
    
    private static void numerosNoMostrados(int[] arr) {        
        // averiguar cuales no estan
        System.out.println("Los valores no existentes son: ");
        boolean tmp = false;
        for(int i=1; i<=100; i++){
            for(int j: arr){
                if(j==i){
                    tmp = false;
                    break;
                }
                tmp = true;
            }
            if(tmp){
                System.out.print(i+", ");
            }
                
        }
    }

}
