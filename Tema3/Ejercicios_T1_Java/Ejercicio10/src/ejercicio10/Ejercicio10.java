package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {
        int num, pos = 0, neg = 0, cero = 0;
        Scanner s = new Scanner(System.in);
        
        for(int i=1; i<=10; i++){
            System.out.print("Introduzca el numero "+i+": ");
            num = s.nextInt();
            
            if(num == 0) cero += 1;
            else if(num > 0) pos += 1;
            else neg += 1;
        }
        
        System.out.println("Numeros de ceros: "+cero);
        System.out.println("Numeros positivos: "+pos);
        System.out.println("Numeros negativos: "+neg);
    }
    
}
