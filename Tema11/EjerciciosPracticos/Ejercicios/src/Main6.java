import java.util.InputMismatchException;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base, num;
        try {
            do {
                System.out.print("\n\nIndique la base: ");
                base = sc.nextInt();
                sc.nextLine();
                if (base == 2 || base == 8 || base == 16) {
                    System.out.print("Indique el número decimal: ");
                    num = sc.nextInt();
                    System.out.print("Conversion:\n" + num + "(10) -> " + conversion(num, base) + "(" + base + ")");

                }else{
                    System.out.print("Base no válida... solo 2, 8 y 16 >:(");
                }

            }while(base!=0);
            System.out.print("\nPero has encontrado la salida... ciao \\(^^*)");
        }catch (InputMismatchException e){
            System.out.print("De momento solo aceptamos números... disculpe las molestias :(");
        }
    }

    public static String conversion(int num, int base) {
        int div = num / base;
        int mod = num % base;

        if (base == 16) {
            String s = Integer.toHexString(mod).toUpperCase();
            if (num < base)
                return s;

            return s + conversion(div, base);
        }

        if (num < base)
            return String.valueOf(mod);

        return conversion(div, base) + mod;
    }
}
