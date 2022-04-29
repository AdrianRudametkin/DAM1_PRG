import java.util.InputMismatchException;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        int num;
        try {
            System.out.print("Indique el número: ");
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
            imprimirPiramide(num-1);
        }catch (InputMismatchException e){
            System.out.println("Muy mal :(");
        }

    }

    public static void imprimirPiramide(int num){
        for(int i=0; i<=num;i++){
            for(int k=num; k>i; k--)
                System.out.print(" ");

            for(int j=0; j<=i; j++)
                System.out.print(piramide(i,j)+" ");

            System.out.println();
        }
    }
    public static int piramide(int i, int j) {
        if (j < 0 | i < 0)
            return 0;
        if (j == 0)
            return 1;

        return piramide(i - 1, j) + piramide(i - 1, j - 1);
    }
}
