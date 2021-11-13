package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {
    
    public static void main(String[] args) {
        final double GRAVEDAD = 9.8;
        double velocidad, tiempo;
        Scanner s =  new Scanner(System.in);
        
        System.out.print("Introducir el tiempo de caida en segundos: ");
        tiempo  = s.nextDouble();
        
        if(tiempo == 0) System.out.println("Eso es imposible XD");
        else{
            velocidad = GRAVEDAD * tiempo;
            System.out.println("La velocidad del objeto es " + velocidad + " m/s");
        }
    }
    
}
