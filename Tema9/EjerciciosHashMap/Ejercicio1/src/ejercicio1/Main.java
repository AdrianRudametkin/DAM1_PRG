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
 * Created on Feb 7, 2022 At 8:51:59 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 7, 2022
 * @version 1.0
 * 
 */
public class Main {
    private static LinkedHashMap<String, String> agenda;
    private static Scanner sc;

    public static void main(String[] args) {
        agenda = new LinkedHashMap<>();
        sc = new Scanner(System.in);
        int option;
        
        do{
            printMenu();
            option = sc.nextInt();
            switch(option){
                case 1:
                    agendar();
                    break;
                case 2:
                    numContactos();
                    break;
                case 3:
                    consultarTel();
                    break;
                case 4:
                    consultarNom();
                    break;
                case 5:
                    modificar();
                    break;
                case 6:
                    borrar();
                    break;
                case 7:
                    mostarTodo();
                    break;
                case 8:
                    mostrarNom();
                    break;
                case 9:
                    ordenarNom();
                    break;
                case 10:
                    ordenarTel();
                    break;
                case 11:
                    break;
                default: System.out.println("Opcion no valida...");
            }
        }while(option != 11);
    }
    
    private static void printMenu(){
        System.out.print("\n *** Contactos ***"
                + "\n[ 1] Agendar un amig@"
                + "\n[ 2] Numero de contactos"
                + "\n[ 3] Consultar numero de amig@"
                + "\n[ 4] Modificar numero de amig@"
                + "\n[ 5] Consultar amig@ por numero"
                + "\n[ 6] Borrar ex-amig@"
                + "\n[ 7] Mostrar tod@s tus amig@s y sus numeros"
                + "\n[ 8] Mostrar tod@s tus amig@s"
                + "\n[ 9] Ordenar contactos por nombre"
                + "\n[10] Ordenar contactos por telefono"
                + "\n>>Introduzca una opcion: ");
    }

    private static void agendar() {
        String tel, nom;
        System.out.print("Introduce el nombre de tu amig@: ");
        nom = sc.nextLine();
        // Comprobar que no existe el contacto
        if(agenda.containsValue(nom.toLowerCase())){
            System.out.print(nom + " ya existe en tus contactos. Crear igualmente?(s/n): "); 
            String s = sc.nextLine();
            if(s.toLowerCase().contains("n")){
                return;
            }else{
                String newNom;
                do{
                    System.out.print("Introduce un nombre diferente para tu amig@: ");
                    newNom = sc.nextLine();
                }while(nom.equalsIgnoreCase(newNom));
                nom = newNom;
            }
        }
        System.out.print("Introduzca su numero de telefono: ");
        tel = sc.nextLine();
        // Comprobar que no exista el numero de telefono
        if(agenda.containsKey(tel)){
            System.out.println("Este numero le pertenece a "+agenda.get(tel));
            System.out.println("Puede modificar su numero[4] o eliminarlo[6] en el menu principal");
            return;
        }
        agenda.put(tel, nom.toLowerCase());
    }

    private static void numContactos() {
        int i = agenda.size();
        switch (i) {
            case 0:
                System.out.println("No tienes amig@s :(");
                break;
            case 1:
                System.out.println("Tienes 1 amig@.");
                break;
            default:
                System.out.println("Tienes "+i+" amig@s.");
                break;
        }
    }

    private static void consultarTel() {
        System.out.println("Introduzca el nombre que quiere buscar: ");
        String s = sc.nextLine();
        // Comprobar que el nombre existe
        if(agenda.containsValue(s.toLowerCase())){
            agenda.entrySet().stream().filter(e -> (Objects.equals(s, e.getValue()))).forEachOrdered(e -> {
                System.out.println("El telefono de "+e.getValue()+" es "+e.getKey());
            });
        }else{
            System.out.println("No existe '"+s+"' amig@...");
        }
    }

    private static void consultarNom() {
        System.out.println("Introduzca el numero de telefono: ");
        String s = sc.nextLine();
        // Comprobar que el numero existe
        if(agenda.containsKey(s)){
            System.out.println("El numero de telefono '"+s+"' es de "+agenda.get(s)+".");
        }else{
            System.out.println("Ese numero de telefono no esta agendado...");
        }
    }

    private static void modificar() {
        System.out.println("Que contacto quiere modificar? (escriba su nombre o numero de telefono)");
        String key = sc.nextLine();
        
        if(!agenda.containsKey(key)){
            if(agenda.containsValue(key.toLowerCase())){
                for(Entry<String, String> e : agenda.entrySet()){
                    key = e.getKey();
                }
            }else{
                System.out.println("No existe un contacto con esos datos...");
                return;
            }
        }
        String nom, tel;
        System.out.println("Modificando contacto: "+agenda.get(key)+" - "+key);
        System.out.println("(dejar en blanco si no desea modificar el campo)");
        System.out.print("Introducir nombre nuevo: ");
        nom = sc.nextLine();
        System.out.print("Introducir numero nuevo: ");
        tel = sc.nextLine();
        
        if(nom == null || nom.trim().equals("")){
            nom = agenda.get(key);
        }
        if(tel == null || nom.trim().equals("")){
            tel = key;
        }
        agenda.remove(key);
        agenda.put(tel, nom);
    }

    private static void borrar() {
        System.out.println("Que contacto quiere eliminar? (escriba su nombre o numero de telefono)");
        String key = sc.nextLine();
        
        if(!agenda.containsKey(key)){
            if(agenda.containsValue(key.toLowerCase())){
                for(Entry<String, String> e : agenda.entrySet()){
                    agenda.remove(e.getKey());
                    System.out.println("Contacto eliminado...");
                }
            }else{
                System.out.println("No existe un contacto con esos datos...");
            }
        }else{
            agenda.remove(key);
        }
    }

    private static void mostarTodo() {
        System.out.print("\nLista de contactos:"
                         + "\n-------------------"
                + "\nNombre\tTelefono");
        agenda.entrySet().forEach(e -> {
            System.out.print("\n"+e.getValue()+"\t"+e.getKey());
        });
    }

    private static void mostrarNom() {
        System.out.print("\nLista de contactos:"
                         + "\n-------------------"
                + "\nNombre");
        agenda.entrySet().forEach(e -> {
            System.out.print("\n"+e.getValue());
        });
    }

    private static void ordenarNom() {
        Comparator porNom = new Comparator<Map.Entry<String, String>>(){
            @Override
            public int compare(Map.Entry<String, String> m1, Map.Entry<String, String m2>){
                return 
            }
        };
    }

    private static void ordenarTel() {
        
    }

}
