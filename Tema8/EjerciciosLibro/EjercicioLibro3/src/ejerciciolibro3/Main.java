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
            System.out.println("");
            switch(mi){
                case 1:
                    printAddMenu();
                    int add = s.nextInt();
                    s.nextLine();
                    switch(add){
                        case 1:
                            System.out.print("Introduzca alumn@ a añadir:");
                            lista = addElement(lista, s.nextLine());
                            break;
                        case 2:
                            System.out.print("Introduzca la posicion:");
                            int i = s.nextInt();
                            s.nextLine();
                            System.out.print("Introduzca alumn@ a añadir:");
                            lista = addElement(lista, s.nextLine(), i);
                            break;
                        default:
                            System.out.println("Introduzca un numero valido.");
                            System.out.println("");
                    }
                    System.out.println("");
                    break;
                case 2:
                    printRemoveMenu();
                    int rem = s.nextInt();
                    s.nextLine();
                    switch(rem){
                        case 1:
                            System.out.print("Introduzca alumn@ a quitar:");
                            lista = removeElement(lista, s.nextLine());
                            break;
                        case 2:
                            System.out.print("Introduzca posicion a quitar:");
                            lista = removeElement(lista, s.nextInt());
                            break;
                        case 3:
                            System.out.print("Introduzca posicion a quitar:");
                            int j = s.nextInt();
                            s.nextLine();
                            System.out.print("Introduzca alumn@ a quitar:");
                            lista = removeElement(lista, j, s.nextLine());
                            break;
                        default:
                            System.out.println("Introduzca un numero valido.");
                            System.out.println("");
                    }
                    System.out.println("");
                    break;
                case 3:
                    lista = orderElements(lista);
                    System.out.println("");
                    break;
                case 4:
                    printElements(lista);
                    System.out.println("");
                    break;
                case 5:
                    System.out.print("De cuant@s alumn@s sera la lista:");
                    lista = new String[s.nextInt()];
                    s.nextLine();
                    for(int i=0; i<lista.length; i++){
                        System.out.print("Introduzca alumn@ "+(i+1)+": ");
                        lista[i] = s.nextLine();
                    }
                    System.out.println("");
                    break;
                default: System.out.println("Introduzca un numero valido.");
                System.out.println("");
            }
        }
    }
    
    // Añadir Elemento al final
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
    
    // Añadir Elemento en una posicion
    private static String[] addElement(String[] array, String element, int pos){
        if(array==null){
            System.out.println("La lista no existe...");
            System.out.println("");
            return array;
        }
        if(pos > array.length-1){
            System.out.println("La lista no es tan larga...");
            System.out.println("");
            return array;
        }        
        String newArray[] = new String[array.length+1];
        
        System.arraycopy(array, 0, newArray, 0, pos);
        newArray[pos]=element;
        System.arraycopy(array, pos, newArray, pos+1, array.length-pos);
        
        System.out.println("  ::Alumn@ añadid@");
        System.out.println("");
        return newArray;
    }
    
    // Quitar elemento por nombre
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
    
    // Quitar elemento por posicion
    private static String[] removeElement(String[] array, int pos){
        if(array==null || array.length==0){
            System.out.println("La lista esta vacia o no existe... nada que quitar");
            System.out.println("");
            return array;
        }
        if(pos > array.length-1){
            System.out.println("La lista no es tan larga...");
            System.out.println("");
            return array;
        }
        String newArray[] = new String[array.length-1];
        System.arraycopy(array, 0, newArray, 0, pos);
        System.arraycopy(array, pos+1, newArray, pos, newArray.length-pos);
        System.out.println("  ::Alumn@ borrad@...");
        System.out.println("");
        return newArray;
    }
    
    // Quitar elemento por posicion y por nombre
    private static String[] removeElement(String[] array, int pos, String element){
        if(array==null || array.length==0){
            System.out.println("La lista esta vacia o no existe... nada que quitar");
            System.out.println("");
            return array;
        }
        if(pos > array.length-1){
            System.out.println("La lista no es tan larga...");
            System.out.println("");
            return array;
        }
        if(array[pos].equals(element)){
            String newArray[] = new String[array.length-1];
            System.arraycopy(array, 0, newArray, 0, pos);
            System.arraycopy(array, pos+1, newArray, pos, newArray.length-pos);
            System.out.println("  ::Alumn@ borrad@...");
            System.out.println("");
            return newArray;
        }else{
            System.out.println("  ::Alumn@ no en la posicion descrita");
            System.out.println("");
            return array;
        }
    }
    
    // Ordenar alfabeticamente los elementos
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
    
    // Imprimir lista de elementos
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
    
    // Imprimir menu pricipal
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
    
    // Imprimir menu de añadir
    private static void printAddMenu(){
        System.out.println("Añadir alumn@ en:");
        System.out.println(" 1 -Al final de la lista.");
        System.out.println(" 2 -En una posicion especifica.");
        System.out.print("Selecionar una opcion: ");
    }
    
    // Imprimir menu de quitar
    
    private static void printRemoveMenu(){
        System.out.println("Quitar alumn@ en:");
        System.out.println(" 1 -Por nombre.");
        System.out.println(" 2 -Por posicion.");
        System.out.println(" 3 -Por posicion y nombre.");
        System.out.print("Selecionar una opcion: ");
    }
}
