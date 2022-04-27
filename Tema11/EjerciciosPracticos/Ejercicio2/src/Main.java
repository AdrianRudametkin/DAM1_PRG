import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Indique el número de la secuencia: ");
            num = sc.nextInt();
            System.out.println("fibonacci recursivo de " + num + " números: " + printArray(fibonacci_recursivo(num)));
            System.out.println("fibonacci iterativo de " + num + " números: " + printArray(fibonacci_iterativo(num)));
        } catch (InputMismatchException e) {
            System.out.println("No están implementadas las letras de momento.");
        }
    }


    public static String printArray(ArrayList<Integer> arr) {
        if (arr == null) {
            return ":(";
        }

        String s = "[";
        for (int i : arr) {
            s += i + ", ";
        }
        s += "\b\b]";
        return s;
    }

    public static ArrayList<Integer> fibonacci_recursivo(int num) {
        ArrayList<Integer> fib = new ArrayList<>();
        if (num <= 0)
            return null;

        for (int i = 1; i <= num; i++) {
            fib.add(fib_rec(i));
        }

        return fib;
    }

    public static int fib_rec(int num) {
        if (num == 1)
            return 0;
        if (num == 2)
            return 1;

        return fib_rec(num - 1) + fib_rec(num - 2);
    }

    public static ArrayList<Integer> fibonacci_iterativo(int num) {
        ArrayList<Integer> fib = new ArrayList<>();
        if (num <= 0)
            return null;
        fib.add(0);
        if (num == 1)
            return fib;

        fib.add(1);
        if (num == 2)
            return fib;

        for (int i = 2; i < num; i++) {
            fib.add(fib.get(i - 1) + fib.get(i - 2));
        }

        return fib;
    }

}
