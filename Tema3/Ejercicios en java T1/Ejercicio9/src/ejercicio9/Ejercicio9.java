
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        String dia;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Introduzca el dia de la semana: ");
        dia = s.nextLine();
        
        System.out.print("Este dia hay: ");
        
        switch(dia.toLowerCase().replace(" ", "")){
            case "lunes":
                System.out.println("Psicomotricidad.");
                break;
            case "martes":
                System.out.println("Natación.");
                break;
            case "miercoles":
                System.out.println("Música.");
                break;
            case "jueves":
                System.out.println("Natación.");
                break;
            case "viernes":
                System.out.println("Descanso.");
                break;
            case "sabado":
                System.out.println("Nada.");
                break;
            case "domingo":
                System.out.println("Nada.");
                break;
            default:
                System.out.println("Dia introducido incorrectamente");
        }
    }
    
}
