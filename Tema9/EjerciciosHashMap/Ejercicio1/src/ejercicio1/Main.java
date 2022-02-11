/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal are problems
 encoutered, please contact
 the author.
 Thank you \(^o^)/ 
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
                    modificar();
                    break;
                case 5:
                    consultarNom();
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
        System.out.print("\n\n\n *** Contactos ***"
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
                + "\n[11] Salir"
                + "\n>>Introduzca una opcion: ");
    }
    
    /**
     * 
     * Metodo que pide al usuario por pantalla el nombre y telefono del contacto
     * que se quiere agragar a la angeda.
     * 
     * @see java.lang.String
     */
    public static void agendar() {
        // Pedir el nombre al usuario del nuevo contacto
        String tel, nom;
        sc.nextLine();
        System.out.print("\nIntroduce el nombre de tu amig@: ");
        nom = sc.nextLine();
        
        // Comprobar que no existe el contacto
        if(agenda.containsValue(nom.toUpperCase())){
            System.out.print(nom + " ya existe en tus contactos. Crea otro contacto[1] con un nombre difrenciador."); 
            return;
        }
        
        // Solicitar el numero de telefono
        System.out.print("Introduzca su numero de telefono: ");
        tel = sc.nextLine();
        // Comprobar que no exista el numero de telefono
        if(agenda.containsKey(tel)){
            System.out.println("Este numero le pertenece a "+agenda.get(tel));
            System.out.println("Puede modificar su numero[4] o eliminarlo[6] en el menu principal");
            return;
        }
        
        // Añadir el telefono y nombre a la agenda
        agenda.put(tel, nom.toUpperCase());
    }

    private static void numContactos() {
        // Mirar el tamaño de la agenda
        int i = agenda.size();
        // Mensaje presonalizado dependiendo del numero de entradas
        switch (i) {
            case 0:
                System.out.println("\nNo tienes amig@s :(");
                break;
            case 1:
                System.out.println("\nTienes 1 amig@.");
                break;
            default:
                System.out.println("\nTienes "+i+" amig@s.");
                break;
        }
    }

    private static void consultarTel() {
        // Solicitar el nombre del que se quiera saber el numero
        sc.nextLine();
        System.out.print("\nIntroduzca el nombre de su amig@: ");
        String nom = sc.nextLine();
        // Comprobar que el nombre existe
        if(agenda.containsValue(nom.toUpperCase())){
            // Si existe, mostar que numero tiene el contacto
            for(Entry<String, String> e : agenda.entrySet()){
                if(e.getValue().equals(nom.toUpperCase())){
                    System.out.println(e.getValue()+" tiene el numero "+e.getKey());
                }
            }
        }else{
            System.out.println("'"+nom+"' NO es tu amig@...");
        }
    }
    
    private static void modificar() {
        // Solicitar el nombre a modificar
        sc.nextLine();
        System.out.print("\nQue contacto quiere modificar? (escriba su nombre): ");
        String nom = sc.nextLine();

        // Buscar cual es el telefono (key) de esta persona
        String key = null;
        if(agenda.containsValue(nom.toUpperCase())){
            for(Entry<String, String> e : agenda.entrySet()){
                key = e.getKey();
            }
        }else{
            System.out.println("'"+nom+"' NO es tu amig@...");
            return;
        }
        
        // Solicitar el numero nuevo (tel) a modificar
        System.out.println("Modificando contacto: "+agenda.get(key)+" - "+key);
        System.out.print("Introducir numero nuevo: ");
        String tel = sc.nextLine();
        if(tel.equals(key)){
            System.out.println("No has cambiado el numero... contacto no modificado.");
            return;
        }
        // Añadir el nuevo telefono (tel) con el nombre viejo
        agenda.put(tel, agenda.get(key).toUpperCase());
        // Quitar el contacto antiguo
        agenda.remove(key);
    }

    private static void consultarNom() {
        // Solicitar el numero de telefono del que se quiera saber el nombre
        sc.nextLine();
        System.out.print("\nIntroduzca el numero de telefono: ");
        String tel = sc.nextLine();
        // Comprobar que el numero existe
        if(agenda.containsKey(tel)){
            // Si existe, mostrar a quien le pertenece el numero
            System.out.println("El numero de telefono '"+tel+"' es de "+agenda.get(tel)+".");
        }else{
            System.out.println("Ese numero de telefono no esta agendado...");
        }
    }

    

    private static void borrar() {
        sc.nextLine();
        System.out.print("\nQue contacto quiere eliminar? (escriba su nombre): ");
        String nom = sc.nextLine();
        
        // Comprobar que exista el contacto
        if(agenda.containsValue(nom.toUpperCase())){
            // Si existe, buscar su telefono(key) para poder eliminarlo
            for(Entry<String, String> e : agenda.entrySet()){
                agenda.remove(e.getKey());
                System.out.println("Contacto eliminado...");
            }
        }else{
            System.out.println("'"+nom+"' NO es tu amig@...");
        }

    }

    private static void mostarTodo() {
        System.out.print("\nLista de contactos:"
                + "\nNombre\tTelefono"
                + "\n______\t________");
        
        agenda.entrySet().forEach(e -> {
            System.out.print("\n"+e.getValue()+"\t"+e.getKey());
        });
    }

    private static void mostrarNom() {
        System.out.print("\nLista de contactos:"
                + "\nNombre"
                + "\n_____");
        
        agenda.entrySet().forEach(e -> {
            System.out.print("\n"+e.getValue());
        });
    }

    private static void ordenarNom() {
        // Crear el comparador que compara los valores (nombres) de un Entry
        Comparator porNom = (
            (Comparator<Map.Entry<String, String>>) 
                (Map.Entry<String, String> m1, Map.Entry<String, String> m2) -> 
                    m1.getValue().compareTo(m2.getValue())
            );
        // Copiar la agenda a una Lista
        List<Map.Entry<String, String>> ordered = new ArrayList<>(agenda.entrySet());
        // Ordenar la lista con el comparador
        Collections.sort(ordered, porNom);
        // Borrar la agenda
        agenda.clear();
        // Agregar los objetos de la lista a la agenda por orden
        ordered.forEach(e ->{
                agenda.put(e.getKey(), e.getValue());
            }
        );
        System.out.println("\nLista ordenado por nombre.");
    }

    private static void ordenarTel() {
        // Crear el comparador que compara los keys (telefono) de un Entry
        Comparator porNom = (
            (Comparator<Map.Entry<String, String>>) 
                (Map.Entry<String, String> m1, Map.Entry<String, String> m2) -> 
                    m1.getKey().compareTo(m2.getKey())
            );
        // Copiar la agenda a una Lista
        List<Map.Entry<String, String>> ordered = new ArrayList<>(agenda.entrySet());
        // Ordenar la lista con el comparador
        Collections.sort(ordered, porNom);
        // Borrar la agenda
        agenda.clear();
        // Agregar los objetos de la lista a la agenda por orden
        ordered.forEach(e ->{
                agenda.put(e.getKey(), e.getValue());
            }
        );
        System.out.println("\nLista ordenado por telefono.");
    }

}
