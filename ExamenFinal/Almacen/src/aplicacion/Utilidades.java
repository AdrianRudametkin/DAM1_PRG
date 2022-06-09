package aplicacion;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {
    public static Scanner sc = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static String formatDecimal(double d) {
        return df.format(d);
    }

    public static int pedirIntPositivo(String msj) {
        Integer res;
        String msjError = "\nTiene que ser un número.";
        String msjNeg = "\nEl número tiene que ser positivo.";
        do {
            try {
                System.out.print(msj);
                res = sc.nextInt();
                if (res < 0 && res != -5) {
                    System.out.print(msjNeg);
                    res = null;
                }
            } catch (InputMismatchException e) {
                System.out.print(msjError);
                res = null;
            } finally {
                sc.nextLine();
            }
        } while (res == null);

        return res;
    }

    public static int pedirInt(String msj) {
        Integer res;
        String msjError = "\nTiene que ser un número.";
        do {
            try {
                System.out.print(msj);
                res = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print(msjError);
                res = null;
            } finally {
                sc.nextLine();
            }
        } while (res == null);

        return res;
    }

    public static double pedirDoublePositivo(String msj) {
        Double res;
        String msjError = "\nTiene que ser un número.";
        String msjNeg = "\nEl número tiene que ser positivo.";
        do {
            try {
                System.out.print(msj);
                res = sc.nextDouble();
                if (res < 0) {
                    System.out.print(msjNeg);
                    res = null;
                }
            } catch (InputMismatchException e) {
                System.out.print(msjError);
                res = null;
            } finally {
                sc.nextLine();
            }
        } while (res == null);

        return res;
    }


    public static String pedirStringNoVacio(String msj) {
        String s;
        String msjError = "\nNo puede estar vacío.";
        do {
            System.out.print(msj);
            s = sc.nextLine();

            if (s.trim().isEmpty()) {
                System.out.print(msjError);
                s = null;
            }
        } while (s == null);

        return s;
    }

    public static boolean pedirSiONo(String msg) {
        String s;
        String msjError = "Por favor, introduzca Si o No";
        boolean res = false;
        do {
            System.out.print(msg);
            s = sc.nextLine();

            if (s.equalsIgnoreCase("sí") | s.equalsIgnoreCase("si") | s.equalsIgnoreCase("s")) res = true;
            else if (s.equalsIgnoreCase("no") | s.equalsIgnoreCase("n")) res = false;
            else {
                System.out.print(msjError);
                s = null;
            }
        } while (s == null);

        return res;
    }

    public static void continuar() {
        System.out.print("\nPulse INTRO para continuar...");
        sc.nextLine();
    }
}


