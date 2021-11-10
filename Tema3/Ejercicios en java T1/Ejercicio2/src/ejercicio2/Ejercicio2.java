package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        int prev_num, new_num;
        Scanner s =  new Scanner(System.in);
        
        System.out.print("Escriba un numero: ");
        new_num = s.nextInt();
        
        do{
            prev_num = new_num;
            System.out.print("Escriba un numero: ");
            new_num = s.nextInt();
        }while(new_num != prev_num);
        
        System.out.println("Los numeros son iguales");
        
        s.close();
    }
    
}
