/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Tienda.java
 *
 * Created on Feb 11, 2022 At 8:36:45 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package examen2021;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 11, 2022
 * @version 1.0
 * 
 */
/**
 * Clase que almacena los electrodomesticos de una tienda.
 * @author Rogelio Rodriguez
 */
public class Tienda {
    // ***ATRIBUTOS***
    private static ArrayList<Electrodomestico> electrodomesticos;
    private static Scanner sc;
    
    // ***METODOS***
    //  metodos privados
    /**
     * Metodo que pide al usuario los datos de la lavadora y la agrega a la lista
     * de la tienda.
     */
    private void agregar(){
        System.out.println("\n\n--Agregando Lavadora--");
        Lavadora lav = new Lavadora();
        System.out.print("Introducir el modelo: ");
        sc.nextLine();
        lav.setModelo(sc.nextLine());
        System.out.print("Introducir el precio base: ");
        lav.setPrecioBase(sc.nextDouble());
        System.out.print("Introducir el consumo electrico (A-F): ");
        sc.nextLine();
        lav.setConsEnerg(sc.nextLine().charAt(0));
        System.out.print("Introducir el peso: ");
        lav.setPeso(sc.nextDouble());
        System.out.print("Introducir la carga maxima de la lavadora: ");
        lav.setCarga(sc.nextDouble());
        
        // Comprobar si la lavadora ya existe
        for(Electrodomestico e: electrodomesticos){
            if(e.equals(lav)){
                System.out.print("\nEsta lavadora ya existe. Quiere añadirla de todas formas(si/no)? ");
                sc.nextLine();
                if(sc.nextLine().toLowerCase().charAt(0)=='n'){
                    System.out.println("--Lavadora NO añadida--");
                    return;
                }
            }
        }
        electrodomesticos.add(lav);
        
        System.out.println("--Lavadora añadida--");
    }
    
    /**
     * Metodo que pide al usuario los datos de la lavadora y la agrega a la lista
     * de la tienda.
     */
    private void agregar(){
        System.out.println("\n\n--Agregando Electrodomestico--");
        Electrodomestico elec;
        
        // Comprobar el tipo de electrodomestico
        System.out.print("Introduzca el tipo de electrodomestico: ");
        sc.nextLine();
        String tipo = sc.nextLine();
        if(tipo.equalsIgnoreCase("lavadora")){
            elec = new Lavadora();
        }else if(tipo.equalsIgnoreCase("television")){
            elec = new Television();
        }else{
            System.out.println(" *Error: Ese tipo no existe.");
            return;
        }
        
        
        System.out.print("Introducir el modelo: ");
        sc.nextLine();
        elec.setModelo(sc.nextLine());
        System.out.print("Introducir el precio base: ");
        elec.setPrecioBase(sc.nextDouble());
        System.out.print("Introducir el consumo electrico (A-F): ");
        sc.nextLine();
        elec.setConsEnerg(sc.nextLine().charAt(0));
        System.out.print("Introducir el peso: ");
        elec.setPeso(sc.nextDouble());
        
        if(tipo.equalsIgnoreCase("lavadora")){
            System.out.print("Introducir la carga maxima de la lavadora: ");
            elec.setCarga(sc.nextDouble());
        }else if(tipo.equalsIgnoreCase("television")){
            System.out.print("Introducir la resolucion en pulgadas: ");
            elec.setResolucion(sc.nextDouble());
            System.out.print("Tiene sintonizador TDT? ");
            
            elec.setTieneTDT(sc.nextDouble());
        }
        
        
        // Comprobar si la lavadora ya existe
        for(Electrodomestico e: electrodomesticos){
            if(e.equals(elec)){
                System.out.print("\nEste electrodomestico ya existe. Quiere añadirla de todas formas(si/no)? ");
                sc.nextLine();
                if(sc.nextLine().toLowerCase().charAt(0)=='n'){
                    System.out.println("--Lavadora NO añadida--");
                    return;
                }
            }
        }
        electrodomesticos.add(el);
        
        System.out.println("--Lavadora añadida--");
    }
    
    /**
     * Metodo que busca en 'lavadores' las lavadoras que coindicad con el modelo
     * introducido.
     * @return devuelve un lista con la posicion de la lavadora
     */
    private ArrayList<Integer> buscar(){
        System.out.println("\n\n--Buscando Lavadora--");
        System.out.print("Introduzca el modelo de la lavadora: ");
        sc.nextLine();
        String modelo = sc.nextLine();
        
        ArrayList<Integer> lista = new ArrayList<>();
        int i = 0;
        for(Electrodomestico e: electrodomesticos){
            if(e.getModelo().equalsIgnoreCase(modelo)){
                lista.add(i);
            }
            i++;
        }
        return lista;
    }
    /**
     * Metodo que muestra por pantalla las lavadoras encontradas.
     * @param lista lista de enteros que indican la posicion de la lavadora en 'lavadoras'
     * @see Tienda.buscar();
     */
    private boolean encontradas(ArrayList<Integer> lista){
        if(lista.isEmpty()){
            System.out.print("\nNo se ha encontrado ningun electrodomestico de ese modelo.");
            return false;
        }
        System.out.print("\nSe ha(n) encontado "+lista.size()+" electrodomestico(s).\n");
        int i=1;
        for(int e : lista){
            System.out.print("\nElectrodomestico "+i+":");
            System.out.print(electrodomesticos.get(e).toString() + "\n");
            i++;
        }
        return true;
    }
    
    /**
     * Metodo que modifica el precio base de una lavadora determinada por el modelo.
     * @param lista lista de enteros que indican la posicion de la lavadora en 'lavadoras'
     * @see Tienda.buscar()
     */
    private void modificar(ArrayList<Integer> lista){
        if(!encontradas(lista)){
            return;
        }
        System.out.print("\n\nCual desea modificar (1-"+lista.size()+"): ");
        int num = sc.nextInt();
        if(num<0 || num>lista.size()){
            System.out.print("\nSolo hay "+lista.size()+" electrodomestico(s)...");
        }else{
            System.out.print("\nIntroduca el nuevo precio base: ");
            electrodomesticos.get(num).setPrecioBase(sc.nextDouble());
        }
    }
    
    /**
     * Metodo que elimina una lavadora de la lista 'lavadoras'.
     * @param lista lista de enteros que indican la posicion de la lavadora en 'lavadoras'
     * @see Tienda.buscar()
     */
    private void eliminar(ArrayList<Integer> lista){
        if(!encontradas(lista)){
            return;
        }
        System.out.print("\n\nCual desea modificar (1-"+lista.size()+"): ");
        int num = sc.nextInt();
        if(num<0 || num>lista.size()){
            System.out.print("\nSolo hay "+lista.size()+" electrodomestico(s)...");
        }else{
            System.out.print("\nIntroduca el nuevo precio base: ");
            electrodomesticos.remove(electrodomesticos.get(num));
        }
    }
    
    /**
     * Metodo que muestra todas las lavadoras en 'lavadoras'.
     */
    private void mostrarTodo(){
        System.out.print("\nHay "+electrodomesticos.size()+" lavadora(s).\n");
        int i=1;
        for(Electrodomestico e : electrodomesticos){
            System.out.print("\nLavadora "+i+":");
            System.out.print(e.toString() + "\n");
            i++;
        }
    }
    
    /**
     * Metodo que imprime el menu principal por pantalla.
     * @return devuelve el numero de la opccion que el usuario ha elegido.
     */
    private int menu(){
        System.out.print("\n\n\n\n\n::--TIENDA DE ELECTRODOMESTICOS--::"
                + "\n--OPCIONES--"
                + "\n[1] Agregar electrodomestico."
                + "\n[2] Buscar electrodomestico por modelo."
                + "\n[3] Modificar el precio base de un electrodomestico."
                + "\n[4] Eliminar un electrodomestico"
                + "\n[5] Mostrar todas los electrodomesticos."
                + "\n[6] Mostrar el numero de electrodomesticos solo."
                + "\n[7] Salir."
                + "\nSeleccionar una opcion: ");
        return sc.nextInt(); 
    }
    
    /**
     * Metodo que muestra el numero de electrodomesticos en la tienda.
     */
    private void mostarNum() {
        System.out.println("Hay "+Electrodomestico.numElectrodomesticos+
                (Electrodomestico.numElectrodomesticos==1?" electrodomestico":" electrodomesticos")+
                " en la tienda.");
    }
    
    //  metodos publicos
    /**
     * Metodo para inicializar la tienda y sus variables.
     */
    public void init(){
        electrodomesticos = new ArrayList<>();
        sc = new Scanner(System.in);
        Electrodomestico.rellenarLetras();
        // codigo para descargar la base de datos en las variables
    }
    
    
    /**
     * Metodo de bucle para que ejecuta el programa de la tienda.
     */
    public void loop(){
        int option;
        do{
            option = menu();
            switch(option){
                case 1: 
                    agregar();
                    break;
                case 2:
                    encontradas(buscar());
                    break;
                case 3:
                    modificar(buscar());
                    break;
                case 4:
                    eliminar(buscar());
                    break;
                case 5:
                    mostrarTodo();
                    break;
                case 6:
                    mostarNum();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Eliga una opcion valida...");
            }
        }while(option != 7);
    }    
}
