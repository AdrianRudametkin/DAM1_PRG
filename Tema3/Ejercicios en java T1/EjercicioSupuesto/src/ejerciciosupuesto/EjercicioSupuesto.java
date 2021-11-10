
package ejerciciosupuesto;

import java.util.Scanner;

public class EjercicioSupuesto {

    public static void main(String[] args) {
        int year;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Introducir un año: ");
        year = s.nextInt();
        
        if(algoritmo_bisiesto(year)) System.out.println("El año "+year+" es bisiesto.");
        else System.out.println("El año "+year+" no es bisiesto.");
    }
    
    private static boolean algoritmo_bisiesto(int year){
        boolean respuesta;
        
        if(year%4 != 0) respuesta = false;
        else if((year%100 == 0) && (year%400 != 0)) respuesta = false;
        else respuesta = true;
        
        return respuesta;
    }
}
