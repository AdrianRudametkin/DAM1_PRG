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
                System.out.print("\n [SISTEMA: Solo números o puntos para números decimales]");
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
                Integer res;
                do {
                    res = pedirInt("\n [SISTEMA: No ha escrito nada. ¿Quiere dejarlo así? (1)Sí (2)No]: ");
                    if (res == 1)
                        s = "";
                    else if (res == 2)
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

    public static void continuar(){
        System.out.print("\nPulse INTRO para continuar.");
        sc.nextLine();
    }

}
