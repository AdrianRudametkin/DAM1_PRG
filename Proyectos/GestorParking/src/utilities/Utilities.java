package utilities;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase estática para facilitar ciertos aspectos de programar interfaces en consola.
 */
public class Utilities {
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
                    res = pedirInt("\n [SISTEMA: No ha escrito nada. ¿Quiere dejarlo vacío? (1)Sí (2)No]: ");
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

    public static boolean pedirSiONo(String msg) {
        String s;
        boolean res = false;
        do {
            System.out.print(msg);
            s = sc.nextLine();

            if (s.trim().isEmpty()) {
                System.out.print("\n [SISTEMA: No ha escrito nada...]");
                s = null;
            } else if (s.equalsIgnoreCase("sí") | s.equalsIgnoreCase("si") | s.equalsIgnoreCase("s"))
                res = true;
            else if (s.equalsIgnoreCase("no") | s.equalsIgnoreCase("n"))
                res = false;
            else {
                System.out.print("\n[SISTEMA: 'SI' o 'NO']");
                s = null;
            }
        } while (s == null);

        return res;
    }

    public static void continuar() {
        System.out.print("\n\nPulse INTRO para continuar.");
        sc.nextLine();
    }

}
