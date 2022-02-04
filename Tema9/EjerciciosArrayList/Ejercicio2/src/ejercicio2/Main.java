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
 * Created on Jan 31, 2022 At 9:47:10 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 31, 2022
 * @version 1.0
 * 
 */
public class Main {
    private static ArrayList<Double> lista;
    
    public static void main(String[] args) {
        lista = new ArrayList<>();
        int accion;
        do{
            printMenu();
            accion = (int)pedirNumero();
            switch(accion){
                case 1:
                    agregarNumero();
                    break;
                case 2:
                    buscarNumero();
                    break;
                case 3:
                    modificarNumero();
                    break;
                case 4:
                    eliminarNumero();
                    break;
                case 5:
                    insertarNumero();
                    break;
                case 6:
                    mostrarNumeros();
                    break;
                case 7:
                    ordenarNumerosA();
                    break;
                case 8:
                    ordenarNumerosD();
                    break;
                case 9:
                    System.out.println("Hasta luego!!");
                    break;
                default:
                    System.out.println("Elige una opcion valida.");
                    
            }
        }while(accion != 9);
    }

    // Imprimir el menu de acciones
    private static void printMenu() {
        System.out.print("\nACCIONES"
                + "\n [1] Agregar un numero."
                + "\n [2] Buscar un numero."
                + "\n [3] Modificar un numero."
                + "\n [4] Eliminar un numero."
                + "\n [5] Insertar un numero en una posicion."
                + "\n [6] Mostar elementos."
                + "\n [7] Ordenar ascendentemente los elementos."
                + "\n [8] Ordenar descendentemente los elementos."
                + "\n [9] Salir."
                + "\nIntroduzca accion (1-9): ");
    }
    
    // Devuelve el numero (double) que introduce el usuario
    private static double pedirNumero(){
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
    
    // Agrega un numero al final de la lista
    private static void agregarNumero(){
        System.out.print("Introzca el numero a agregar: ");
        lista.add(pedirNumero());
    }
    
    // Busca un numero y muestra su primera posicion
    private static void buscarNumero(){
        System.out.print("Introduzca el numero a buscar: ");
        double num = pedirNumero();
        if(lista.contains(num)){
            System.out.printf("El numero se encuentra en la posicion %d.\n", lista.indexOf(num));
        }else{
            System.out.println("No se ha encontrado ese valor.");
        }
    }
    
    // Modifica la primera ocurrencia del numero si existe
    private static void modificarNumero(){
        System.out.print("Introduzca el numero a modificar: ");
        double num = pedirNumero();
        if(lista.contains(num)){
            System.out.print("Introduzca su nuevo valor: ");
            double numNuevo = pedirNumero();
            lista.set(lista.indexOf(num), numNuevo);
        }else{
            System.out.println("Ese numero no existe. "
                    + "Utilize accion [2] para combprobar que existe o "
                    + "accion [6] para ver los numeros de la lista.");
        }
    }
    
    // Elimina el numero introducido si existe en la lista
    private static void eliminarNumero(){
        System.out.print("Introduzca el numero a eliminar: ");
        double num = pedirNumero();
        if(lista.contains(num)){
            lista.remove(num);
        }else{
            System.out.println("Ese numero no existe. "
                    + "Utilize accion [2] para combprobar que existe o "
                    + "accion [6] para ver los numeros de la lista.");
        }
    }
    
    // Inserta un numero en una posicion, recorriendo los numeros subsecuentes
    private static void insertarNumero(){
        System.out.print("Introduzca el numero a insertar: ");
        double num = pedirNumero();
        System.out.println("Introduzca la posicion: ");
        int pos = (int)pedirNumero();
        
        if(pos<lista.size() && pos>=0){
            lista.add(pos, num);
        }else{
            System.out.print("Introduzca una posicion valida. "
                    + "Para esta lista de 0 a "+lista.size()+".");
        }
    }
    
    // Mostar los numeros de la lista
    private static void mostrarNumeros(){
        System.out.println("Numeros en la lista: ");
        lista.forEach( d->{
            System.out.printf("%.1f, ",d);
        });
        System.out.print("\b\b  \n");
    }
    
    // Ordenar la lista en orden acendente
    private static void ordenarNumerosA(){
        Collections.sort(lista);
    }
    
    // Ordenar la lista en orden descendentemente
    private static void ordenarNumerosD(){
        Collections.sort(lista, Collections.reverseOrder());
    }
    
    
    

}
