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
 * Created on 27 oct. 2021 At 8:51:53
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/


/**
 *
 * @author  Rogelio Rodriguez
 * @date    27 oct. 2021
 * @version 1.0
 * 
 */

// Clase que calcula la cantidad de platillos que puede hacer un restaurante
public class Main {
    //*** Atributos ***
    private static double kPapas;
    private static double kChocos;
    
    //*** Metodos ***
    public static int calcularComensales(double chocos, double papas){
        int comensales = 0;
        
        while(chocos>0.0 && papas>0.0){
            chocos-=0.5;
            papas-=1.0;
            comensales++;
        }
        return comensales;
    }
    public static void addChocos(int x){
        kChocos += x;
    }
    public static void addPapas(int x){
        kPapas += x;
    }
    public static int getComensales(){
        return calcularComensales(kChocos, kPapas);
    }
    public static void showChocos(){
        System.out.println("Kilos de chocos: "+kChocos);
    }
    public static void showPapas(){
        System.out.println("Kilos de papas: "+kPapas);
    }

    public static void main(String[] args) {
    	System.out.println("Empezamos con nada...");
    	showChocos();
        showPapas();
        System.out.println("El numero de comensales es: "+getComensales());
        
        System.out.println("");
        System.out.println("Se añaden 1kg de chocos y 1kg de papas...");
        addChocos(1);
        addPapas(1);
        showChocos();
        showPapas();
        System.out.println("El numero de comensales es: "+getComensales());
        
        System.out.println("");
        System.out.println("Se añaden 3kg de chocos y 9kg de papas...");
        addChocos(3);
        addPapas(9);
        showChocos();
        showPapas();
        System.out.println("El numero de comensales es: "+getComensales());
    }

}
