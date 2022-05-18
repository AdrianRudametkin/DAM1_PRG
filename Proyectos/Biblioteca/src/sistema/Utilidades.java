package sistema;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {
    public static Scanner sc = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.##");

    public static int pedirInt(String msj) {
        Integer res;
        do {
            try {
                System.out.print(msj);
                res = sc.nextInt();
                if (res < 0 && res != -5) {
                    System.out.print("\n [SISTEMA: No entiendo números negativos]");
                    res = null;
                }
            } catch (InputMismatchException e) {
                System.out.print("\n [SISTEMA: Solo números]");
                res = null;
            } finally {
                sc.nextLine();
            }
        } while (res == null);

        return res;
    }

    public static double pedirDouble(String msj) {
        Double res;
        do {
            try {
                System.out.print(msj);
                res = sc.nextDouble();
                if (res < 0 && res != -5) {
                    System.out.print("\n [SISTEMA: No entiendo números negativos]");
                    res = null;
                }
            } catch (InputMismatchException e) {
                System.out.print("\n [SISTEMA: Solo números. Y punto para números decimales]");
                res = null;
            } finally {
                sc.nextLine();
            }
        } while (res == null);

        return res;
    }

    public static String pedirString(String msj) {
        String s;
        do {
            System.out.print(msj);
            s = sc.nextLine();

            if (s.trim().isEmpty()) {
                String res;
                do {
                    System.out.print("\n [SISTEMA: No ha escrito nada. ¿Quiere dejarlo así?(sí/no)]: ");
                    res = sc.nextLine();
                    if (res.toLowerCase().contains("s"))
                        s = "";
                    else if (res.toLowerCase().contains("n"))
                        s = null;
                    else {
                        System.out.print("\n [SISTEMA: Por favor, no me haga perder el tiempo...]");
                        res = null;
                    }
                } while (res == null);
            }
        } while (s == null);

        return s;
    }

    public void continuar(){
        System.out.print("Pulse INTRO para continuar.");
        sc.nextLine();
    }
}
