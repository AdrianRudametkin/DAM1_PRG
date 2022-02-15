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
    private static ArrayList<Lavadora> lavadoras;
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
        for(Lavadora e: lavadoras){
            if(e.equals(lav)){
                System.out.print("\nEsta lavadora ya existe. Quiere añadirla de todas formas(si/no)? ");
                sc.nextLine();
                if(sc.nextLine().toLowerCase().charAt(0)=='n'){
                    System.out.println("--Lavadora NO añadida--");
                    return;
                }
            }
        }
        lavadoras.add(lav);
        
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
        for(Lavadora e: lavadoras){
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
            System.out.print("\nNo se ha encontrado ninguna lavadora de ese modelo.");
            return false;
        }
        System.out.print("\nSe han encontado "+lista.size()+" lavadora(s).\n");
        int i=1;
        for(int e : lista){
            System.out.print("\nLavadora "+i+":");
            System.out.print(lavadoras.get(e).toString() + "\n");
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
            System.out.print("\nSolo hay "+lista.size()+" lavadora(s)...");
        }else{
            System.out.print("\nIntroduca el nuevo precio base: ");
            lavadoras.get(num).setPrecioBase(sc.nextDouble());
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
            System.out.print("\nSolo hay "+lista.size()+" lavadora(s)...");
        }else{
            System.out.print("\nIntroduca el nuevo precio base: ");
            lavadoras.remove(lavadoras.get(num));
        }
    }
    
    /**
     * Metodo que muestra todas las lavadoras en 'lavadoras'.
     */
    private void mostrarTodo(){
        System.out.print("\nHay "+lavadoras.size()+" lavadora(s).\n");
        int i=1;
        for(Lavadora e : lavadoras){
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
        System.out.print("\n\n\n\n\n::--TIENDA DE LAVADORAS--::"
                + "\n--OPCIONES--"
                + "\n[1] Agregar lavadora."
                + "\n[2] Buscar lavadora por modelo."
                + "\n[3] Modificar el precio base de una lavadora."
                + "\n[4] Eliminar una lavadora"
                + "\n[5] Mostrar todas las lavadoras."
                + "\n[6] Mostrar el numero de lavadoras solo."
                + "\n[7] Salir."
                + "\nSeleccionar una opcion: ");
        return sc.nextInt(); 
    }
    
    /**
     * Metodo que muestra el numero de electrodomesticos en la tienda.
     */
    private void mostarNum() {
        System.out.println("Hay "+Electrodomesticos.numElectrodomesticos+
                (Electrodomesticos.numElectrodomesticos==1?" lavadora":" lavadoras")+
                " en la tienda.");
    }
    
    //  metodos publicos
    /**
     * Metodo para inicializar la tienda y sus variables.
     */
    public void init(){
        lavadoras = new ArrayList<>();
        sc = new Scanner(System.in);
        Electrodomesticos.rellenarLetras();
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
