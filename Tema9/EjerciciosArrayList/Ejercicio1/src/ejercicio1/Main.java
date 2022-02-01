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
 * Created on Jan 31, 2022 At 9:10:43 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 31, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> al;
        al = leerValores();
        mostrarResultados(al, calcularSuma(al), calcularMedia(al));
    }
    
    static ArrayList<Integer> leerValores(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int valor;
        do{
            System.out.print("Introduzca un numero: ");
            valor = sc.nextInt();
            if(valor != -99)
                al.add(valor);
        }while(valor!=-99);
        return al;
    }
    
    static int calcularSuma(ArrayList<Integer> al){
        Iterator<Integer> i = al.iterator();
        int suma = 0;
        while(i.hasNext()){
            suma += i.next();
        }
        return suma;
    }
    
    static double calcularMedia(ArrayList<Integer> al){
        return ((double)calcularSuma(al)/al.size());
    }
    
    static void mostrarResultados(ArrayList<Integer> al, int suma, double media){
        System.out.println("Contenido del ArrayList: ");
        System.out.print("[ ");
        int mayoresMedia = 0;
        for(int element: al) {
            System.out.print(element + " ");
            if(element>media)
                mayoresMedia++;
        }
        
        System.out.println("]");
        
        System.out.println("La suma de todos los valores es: " + suma);
        System.out.printf("%d numeros superan la media de %.2f\n", mayoresMedia, media);
    }

}
