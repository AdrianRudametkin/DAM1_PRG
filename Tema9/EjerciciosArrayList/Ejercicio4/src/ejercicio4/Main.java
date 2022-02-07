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
 * Created on Feb 7, 2022 At 8:22:22 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 7, 2022
 * @version 1.0
 * 
 */
public class Main {
    private static ArrayList<Persona> personas;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        personas = new ArrayList<Persona>();
        do{
            printMenu();
            option = sc.nextInt();
            switch(option){
                case 1:
                    introducirPersona();
                    break;
                case 2:
                    bucarPersona();
                    break;
                case 3:
                    eliminarPersona();
                    break;
                case 4:
                    mostrarPersonas();
                    break;
                case 0:
                    System.out.println("Hasta la proxima :D");
                    break;
                default: System.out.println("Opcion no valida.");
            }
            
        }while(option!=0);
        sc.close();
    }
    
    private static void printMenu(){
        System.out.print("\n[1] Introducir persona"
                + "\n[2] Buscar persona"
                + "\n[3] Eliminar persona"
                + "\n[4] Ordenar personas por apellidos"
                + "\n[4] Mostrar todas las personas"
                + "\n[0] Salir"
                + "\n\nIntroducir una opcion: ");
    }
    
    private static void introducirPersona(){
        Persona p = new Persona();
        System.out.print("Introducir nombres: ");
        sc.nextLine();
        p.setNombres(sc.nextLine());
        System.out.print("Introducir apellidos: ");
        p.setApellidos(sc.nextLine());
        do{
            System.out.print("Introducir sexo: ");
            p.setSexo(sc.nextLine());
        }while(p.getSexo()!=null);
        do
        System.out.print("Introducir edad: ");
        p.setEdad(sc.nextInt());
        personas.add(p);
    }
    
    private static void bucarPersona(){
        System.out.print("Introduzca el DNI: ");
        String dni = sc.nextLine();
        for(Persona p: personas){
            if(p.getDNI().equalsIgnoreCase(dni)){
                System.out.println("Persona encontrada: ");
                System.out.println(p.toString());
                return;
            }
        }
        System.out.println("Persona no encontrada.");
    }
    
    private static void eliminarPersona(){
        System.out.print("Introduzca el DNI: ");
        String dni = sc.nextLine();
        for(Persona p: personas){
            if(p.getDNI().equalsIgnoreCase(dni)){
                p.matarPersona();
                personas.remove(p);
                System.out.println("Persona eliminada");
                return;
            }
        }
        System.out.println("Persona no encontrada.");
    }

    private static void ordenarPersonas(){
        Comparator<Persona> apellidos = (Persona p1, Persona p2) -> {
            return p1.getApellidos().compareToIgnoreCase(p2.getApellidos());
        };
        Collections.sort(personas, apellidos);
    }
    
    private static void mostrarPersonas(){
        System.out.println("*** Lista De Personas ***");
        personas.forEach(p -> {
            System.out.println(p.toString());
        });
    }
}
