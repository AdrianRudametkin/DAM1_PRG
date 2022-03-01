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

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        System.out.println("\n\n--Agregando Electrodomestico--");
        
        // Comprobar el tipo de electrodomestico
        System.out.print("Introduzca el tipo de electrodomestico: ");
        sc.nextLine();
        String tipo = sc.nextLine();
        boolean cond = tipo.equalsIgnoreCase("lavadora")||tipo.equalsIgnoreCase("television");
        if(!cond){
            System.out.println(" *Error: Ese tipo no existe.");
            return;
        }
        
        // Sacar los datos del electrodomestico
        String modelo, color;
        double precioBase, peso;
        Character consEnerg;
        
        // Introducir modelo
        System.out.print("Introducir el modelo: ");
        modelo = sc.nextLine();
        // Introducir precio, comprobando que sea un numero
        precioBase = -1;
        do{
            try{
                System.out.print("Introducir el precio base: ");
                precioBase = sc.nextDouble();
                if(precioBase<0){
                    System.out.print("Tiene que ser mayor a 0. ");
                }
            }catch(InputMismatchException e){
                System.out.print("Tiene que ser un numero. ");
                sc.nextLine();
            }
        }while(precioBase<0);
        // Introducir el peso
        peso = -1;
        do{
            try{
                System.out.print("Introducir el peso: ");
                peso = sc.nextDouble();
                if(peso<0){
                    System.out.print("Tiene que ser mayor a 0. ");
                }
            }catch(InputMismatchException e){
                System.out.print("Tiene que ser un numero. ");
                sc.nextLine();
            }
        }while(peso<0);
        // Introducir consumo energetico
        sc.nextLine();
        consEnerg = null;
        do{
            try{
                System.out.print("Introducir el consumo electrico (A-F): ");
                consEnerg = sc.nextLine().charAt(0);
            }catch(StringIndexOutOfBoundsException e){
                System.out.print("Tienes que poner algo. ");
            }
        }while(consEnerg==null);
        // Introducir color
        System.out.print("Introducir el color: ");
        color = sc.nextLine();
        
        
        if(tipo.equalsIgnoreCase("lavadora")){
            Lavadora lav = crearLavadora(modelo, precioBase, peso, consEnerg, color);
            electrodomesticos.forEach(e-> {
                if(lav.equals(e))
                    System.out.print("\nEsta lavadora ya existe.");
                else
                    electrodomesticos.add(lav);
            });
        }else if(tipo.equalsIgnoreCase("television")){
            Television tel = crearTelevision(modelo, precioBase, peso, consEnerg, color);
            electrodomesticos.forEach(e-> {
                if(tel.equals(e))
                    System.out.print("\nEsta lavadora ya existe.");
                else
                    electrodomesticos.add(tel);
            });
        }else{
            System.out.print("\n!!!***SUPER ERROR INTERNO****!!!");
        }
        
        System.out.print("\n--Lavadora añadida--");
    }
    
    /**
     * Metodo que crea una lavadora a partir de un electrodomestico generico.
     * @param elec electrodomestico generico.
     * @return la lavadora.
     */
    private Lavadora crearLavadora(String modelo, double precioBase, double peso, Character consEnerg, String color){
        double carga = -1;
        do{
            try{
                System.out.print("Introducir la carga de la lavadora: ");
                carga = sc.nextDouble();
                if(carga<0){
                    System.out.print("Tiene que ser mayor a 0. ");
                }
            }catch(InputMismatchException e){
                System.out.print("Tiene que ser un numero. ");
                sc.nextLine();
            }
        }while(carga<0);
        
        System.out.println("\n--Agregando Lavadora--");
        return new Lavadora(modelo, precioBase, peso, consEnerg, color, carga);
    }
    /**
     * Metodo que crea una television a partir de un electrodomestico generico.
     * @param elec electrodomestico generico.
     * @return la television.
     */
    private Television crearTelevision(String modelo, double precioBase, double peso, Character consEnerg, String color){
        double resolucion = -1;
        do{
            try{
                System.out.print("Introducir la resolucion en pulgadas: ");
                resolucion = sc.nextDouble();
                if(resolucion<0){
                    System.out.print("Tiene que ser mayor a 0. ");
                }
            }catch(InputMismatchException e){
                System.out.print("Tiene que ser un numero. ");
                sc.nextLine();
            }
        }while(resolucion<0);
        Boolean tieneTDT = null;
        sc.nextLine();
        do{
            System.out.print("Tiene sintonizador TDT? ");
            String respuesta = sc.nextLine();
            if(respuesta.equalsIgnoreCase("si")){
                tieneTDT = true;
            }else if(respuesta.equalsIgnoreCase("no")){
                tieneTDT = false;
            }else{
                System.out.print("Escribe 'si' o 'no'. ");
            }
        }while(tieneTDT == null);
        
        System.out.println("\n--Agregando Television--");
        return new Television(modelo, precioBase, peso, consEnerg, color, resolucion, tieneTDT);
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
        System.out.print("\nHay "+electrodomesticos.size()+" electrodomestico(s).\n");
        int i=1;
        for(Electrodomestico e : electrodomesticos){
            System.out.print("\nElectrodomestico "+i+":");
            System.out.print(e.toString() + "\n");
            i++;
        }
    }
    
    /**
     * Metodo que imprime el menu principal por pantalla.
     * @return devuelve el numero de la opccion que el usuario ha elegido.
     */
    private int menu(){
        System.out.print("\n\n::--TIENDA DE ELECTRODOMESTICOS--::"
                + "\n--OPCIONES--"
                + "\n[1] Agregar electrodomestico."
                + "\n[2] Buscar electrodomestico por modelo."
                + "\n[3] Modificar el precio base de un electrodomestico."
                + "\n[4] Eliminar un electrodomestico"
                + "\n[5] Mostrar todas los electrodomesticos."
                + "\n[6] Mostrar el numero de electrodomesticos solo."
                + "\n[7] Salir."
                + "\nSeleccionar una opcion: ");
        try{
            return sc.nextInt(); 
        }catch(InputMismatchException e){
            return 0;
        }
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
                    System.out.print("\nEliga una opcion valida.");
                    System.out.print("\nPulse intro para continuar...");
                    sc.nextLine();
                    sc.nextLine();
            }
        }while(option != 7);
    }    
}
