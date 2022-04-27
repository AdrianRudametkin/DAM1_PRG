import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Indique el número factorial: ");
            num = sc.nextInt();
            System.out.println("factorial recursivo: " + num + "! = " + factorial_recursivo(num));
            System.out.println("factorial iterativo: " + num + "! = " + factorial_iterativo(num));
        }catch (InputMismatchException e){
            System.out.println("No están implementadas las letras de momento.");
        }
    }

    public static int factorial_recursivo(int num) {
        if (num < 0)
            return 0;
        if (num == 0)
            return 1;

        return num * factorial_recursivo(num - 1);
    }

    public static int factorial_iterativo(int num) {
        if (num < 0)
            return 0;
        if(num==0)
            return 1;

        int fact = 1;

        for (int i = num; i > 1; i--) {
            fact *= i;
        }

        return fact;
    }
}
