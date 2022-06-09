import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\n---CALCULADORA MCD: ALGORITMO EUCLIDES---");
        int num1 = pedirInt("\nIndique el primer número: ");
        int num2 = pedirInt("\nIndique el segundo número: ");
        System.out.print("\n*El MCD de " + num1 + " y " + num2 + " es " + mcdEuclides(num1, num2));
    }


    private static int pedirInt(String msj) {
        int res;
        do {
            try {
                System.out.print(msj);
                res = sc.nextInt();
                // De todas formas hace falta un if para controlarlo todo con excepciones
                if (res <= 0)
                    throw new NegativeNumberException();

            } catch (InputMismatchException e) {
                System.out.print("\n***Tiene que ser un número***");
                res = -1;
            } catch (NegativeNumberException e) {
                System.out.print("\n***Tiene que ser un número positivo distinto de 0***");
                res = -1;
            } finally {
                sc.nextLine();
            }

        } while (res <= 0);

        return res;
    }

    private static int mcdEuclides(int num1, int num2) {
        if (num1 == num2)
            return num1;

        if (num1 > num2)
            return mcdEuclides((num1 - num2), num2);
        else
            return mcdEuclides(num1, (num2 - num1));
    }
}
