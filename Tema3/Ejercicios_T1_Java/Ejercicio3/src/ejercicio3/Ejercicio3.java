package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 { 
    public static void main(String[] args) {
        int suma = 0, num;
        Scanner s =  new Scanner(System.in);    
    
        for(int i = 1; i<=10; i++){
            System.out.print("Escriba el numero " + i + ": ");
            num = s.nextInt();
            suma += num;
        }
        System.out.println("La suma es " + suma);
    }
    
}
