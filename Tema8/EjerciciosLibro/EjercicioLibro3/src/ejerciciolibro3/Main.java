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
 * Created on Jan 17, 2022 At 11:45:47 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejerciciolibro3;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 17, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int mi;
        String lista[] = null;
        
        while(true){
            printMenu();
            mi = s.nextInt();
            s.nextLine();
            switch(mi){
                case 1:
                    System.out.print("Introduzca alumn@ para añadir:");
                    lista = addElement(lista, s.nextLine());
                    break;
                case 2:
                    System.out.print("Introduzca alumn@ para quitar:");
                    lista = removeElement(lista, s.nextLine());
                    break;
                case 3:
                    lista = orderElements(lista);
                    break;
                case 4:
                    printElements(lista);
                    break;
                case 5:
                    System.out.print("De cuant@s alumn@s sera la lista:");
                    lista = new String[s.nextInt()];
                    s.nextLine();
                    for(int i=0; i<lista.length; i++){
                        System.out.print("Introduzca alumn@ "+(i+1)+": ");
                        lista[i] = s.nextLine();
                    }
                    break;
                default: System.out.println("Introduzca un numero valido.");
                System.out.println("");
            }
        }
    }
    
    private static String[] addElement(String[] array, String element){
        if(array==null){
            System.out.println("La lista no existe...");
            System.out.println("");
            return array;
        }
        
        String newArray[] = new String[array.length+1];
        
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length-1]=element;
        
        System.out.println("  ::Alumn@ añadid@");
        System.out.println("");
        return newArray;
    }
    
    private static String[] removeElement(String[] array, String element){
        if(array==null || array.length==0){
            System.out.println("La lista esta vacia o no existe... nada que quitar");
            System.out.println("");
            return array;
        }
        String newArray[] = new String[array.length-1];
        
        for(int i=0; i<array.length; i++){
            if(array[i].equalsIgnoreCase(element)){
                System.arraycopy(array, 0, newArray, 0, i);
                System.arraycopy(array, i+1, newArray, i, newArray.length-i);
                System.out.println("  ::Alumn@ borrad@...");
                System.out.println("");
                return newArray;
            }
        }
        System.out.println("  ::No se ha encontrado...");
        System.out.println("");
        return array;
    }
    
    private static String[] orderElements(String[] array){
        if(array==null || array.length==0){
            System.out.println("La lista esta vacia o no existe... nada que ordenar");
            System.out.println("");
            return array;
        }
        // Selection Sort Algorithm:
        //   Recursivly find the smallest value in the array
        
        // Subarray to store final result
        String ordered[] = new String[array.length];
        
        // Start from the bottom of array
        for(int i=0; i<ordered.length; i++){
            // String to store the current minimum and set to first value
            String min = array[0];
            // Find the smallest String (the alphabetically first)
            for(String s: array){
                if(s.compareTo(min)<0)
                    min = s; 
            }
            // When min found, put it in the fist postion of new array
            //  The first position will be updated with the for loop
            ordered[i] = min;
            // Now delete the this value from the array for the next iteration
            array = removeElement(array, min);
        }
        
        System.out.println("  ::Lista ordenada...");
        System.out.println("");
        return ordered;
    }
    private static void printElements(String[] array){
        if(array==null || array.length==0){
            System.out.println("La lista esta vacia o no existe... nada que mostrar");
            System.out.println("");
            return;
        }
        System.out.println("");
        System.out.println("LISTA DE ALUMN@S");
        System.out.println("****************");
        for(String s: array){
            System.out.print(s);
            System.out.print(", ");
        }
        System.out.println("");
    }
    private static void printMenu(){
        System.out.println("");
        System.out.println("***MENU PRINCIPAL***");
        System.out.println(" 1 -Añadir alumn@.");
        System.out.println(" 2 -Quitar alumn@.");
        System.out.println(" 3 -Ordenar la lista.");
        System.out.println(" 4 -Imprimir la lista.");
        System.out.println(" 5 -Hacer una lista nueva.");
        System.out.print("Selecionar una opcion: ");
    }
}
