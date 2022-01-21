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
 * Created on Jan 21, 2022 At 12:09:09 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejerciciolibro4;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 21, 2022
 * @version 1.0
 * 
 */
public class Main {
    
    // Argumentos:
    // "Hola hola HOLA adios buenas ADIos" "Jorge jorge Juan roge alumno PROFE carmen" "hola" "piña" "locomotora locoMotora"
    public static void main(String[] args) {        
        // Un array con todas las palabras, pasando por todos los argumentos
        String[] palabras = new String[0];
        for(String s: args){
            palabras = addElement(palabras,s.split(" "));
        }
        
        for(String s: palabras){
            System.out.println(s);
        }
        
        System.out.println(palabras.length);
        
    }
    
    // Metodo para concatenar arrays
    private static String[] addElement(String[] array, String[] elements){
        String newArray[] = array;
        
        int i=0;
        for(String s: elements){
            newArray=addElement(newArray,s);
            i++;
        } 
        return newArray;
    }
    // Añadir un elemento que no exista (ignorando may/min) en el array de entrada
    private static String[] addElement(String[] array, String element){        
        String newArray[] = new String[array.length+1];
        
        for(String s: array){
            if(s.equalsIgnoreCase(element)){
                return array;
            }
        }
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length-1]=element;
        return newArray;
    }
}
