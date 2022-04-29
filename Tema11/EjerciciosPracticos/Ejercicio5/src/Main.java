import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        try {
            System.out.print("Indique el número: ");
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
            imprimirPiramide(num);
        }catch (InputMismatchException e){
            System.out.println("Muy mal :(");
        }
    }

    public static void imprimirPiramide(int num) {
        for (int i = 1; i <= num; i++) {
            for (int k = num * 2; k > i * 2; k--)
                System.out.print(" ");

            for (int j = 0; j < (i * 2 - 1); j++)
                System.out.print(piramide(i-1, j) + " ");

            System.out.println();
        }
    }

    public static int piramide(int i, int j) {
        if (j < 0 | i < 0)
            return 0;
        if (j == 0)
            return 1;

        return piramide((i - 1), j) + piramide((i - 1), (j-1)) + piramide((i - 1), (j -2));
    }
}
