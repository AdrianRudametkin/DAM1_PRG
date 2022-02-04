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
 * Created on Feb 4, 2022 At 12:30:02 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 4, 2022
 * @version 1.0
 * 
 */
public class Main {
    private static ArrayList<Alumno> notas1DAM;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        notas1DAM = new ArrayList<>();
        
        do{
            System.out.println("\n[0] para salir"
                    + "\n[1] para añadir mas"
                    + "\n[2] para mostar lista por orden alfabetico"
                    + "\n[3] para mostar lista por orden de nota");
            option = sc.nextInt();
            switch(option){
                case 2:
                    ordenarAlfa();
                    mostrar();
                    break;
                case 3:
                    ordenarNota();
                    mostrar();
                    break;
                case 0: break;
                case 1: 
                    addStudent();
                    break;
                default: System.out.println("opcion no valida");
            }
        }while(option!=0);
        
    }

    private static void ordenarAlfa() {
        Comparator<Alumno> compareByName = (Alumno a1, Alumno a2) -> 
                    a1.getNombre().compareTo(a2.getNombre());
        Collections.sort(notas1DAM, compareByName);
    }

    
    private static void ordenarNota() {
        Comparator<Alumno> compareByGrade = (Alumno a1, Alumno a2) ->{
            if(a1.getNota()<a2.getNota())
                return -1;
            else if(a1.getNota()>a2.getNota())
                return 1;
            else
                return 0;
        };
        Collections.sort(notas1DAM, compareByGrade);
    }
    
    private static void mostrar() {
        System.out.println("NOMBRE \tNOTA");
        notas1DAM.forEach(a1 -> {
            System.out.println(a1.getNombre() + "\t" + a1.getNota());
        });
        System.out.println("");
    }

    private static void addStudent() {
        Scanner sc = new Scanner(System.in);
        double nota;
        String nombre;
        sc.nextLine();
        System.out.print("introduzca el nombre: ");
        nombre = sc.nextLine();
        System.out.print("introduzca su nota: ");
        nota = sc.nextDouble();
        notas1DAM.add(new Alumno(nombre, nota));
    }


}
