package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {
        int opcion;
        double r;
        Scanner s =  new Scanner(System.in);
        
        do{
            System.out.print("Introduzca el radio del circulo: ");
            r  = s.nextDouble();

            menuPantalla();
            opcion  = s.nextInt();

            switch(opcion){
                case 1: System.out.println("El diametro es: " + diametro(r));break;
                case 2: System.out.println("La cicumferencia es: " + circumferencia(r));break;
                case 3: System.out.println("El area es: " + area(r));break;
                default: System.out.println("Opcion no valida :(");
            }
        }while(opcion != 4);
        
        
        s.close();
    }
    
    
    private static void menuPantalla(){
        System.out.println("Funciones disponibles: ");
        System.out.println(" 1.Calcular diametro.");
        System.out.println(" 2.Calcular circumferencia.");
        System.out.println(" 3.Calcular area.");
        System.out.println(" 4.Salir.");
        System.out.println("---------------------------");
        System.out.print("Introducir el numero de la opcion deseada: ");
    }
    
    private static double pi(){
        return 3.14;
    }
    
    private static double diametro(double r){
        return 2 * r;
    }
    
    private static double circumferencia(double r){
        return 2 * pi() * r;
    }
    
    private static double area(double r){
        return pi() * r * r;
    }
    
    
}
