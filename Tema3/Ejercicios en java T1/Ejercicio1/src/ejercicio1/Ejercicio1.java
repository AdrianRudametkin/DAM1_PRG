package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        int num1 ,num2;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Introduzca un entero: ");
        num1 = s.nextInt();   
        System.out.print("Introduzca otro entero: ");
        num2 = s.nextInt();
        
        if(num1 == num2) System.out.println("Los dos numeros son iguales.");
        else if(num1 > num2) System.out.println("El primer numero es mayor.");
        else System.out.println("El segundo numero es mayor.");
        
        s.close();   
    }
}
