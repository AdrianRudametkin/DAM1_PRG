import java.util.InputMismatchException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        int num;
        try {
            System.out.print("Indique el número: ");
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
            imprimirCuadrado(num);
        }catch (InputMismatchException e){
            System.out.println("Muy mal :(");
        }
    }

    public static void imprimirCuadrado(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(cuadrado(i, j) + "\t");
            }
            System.out.println();
        }
    }

    public static int cuadrado(int i, int j) {
        if (i == 0 || j == 0)
            return 1;

        return cuadrado(i - 1, j) + cuadrado(i, j - 1);
    }
}
