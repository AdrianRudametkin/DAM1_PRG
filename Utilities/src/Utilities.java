import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utilities {
    public static Scanner sc = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static Random rnd = new Random();

    /**
     * Método que devuelve un String de un número con dos decimales redondeadas. Se escriben 0 decimales cuando.
     * @param d número a convertir
     * @return número formateado
     */
    public static String formatDecimal(double d){
        return df.format(d);
    }

    /**
     * Método que devuelve un número entero aleatorio entre un mínimo y un máximo incluidos.
     * @param min límite mínimo
     * @param max límite máximo
     * @return número aleatorio
     */
    public static int randomInt(int min, int max){
        return rnd.nextInt(max-min+1)+min;
    }

    /**
     * Método que devuelve un número decimal aleatorio entre un mínimo incluido y un máximo excluido.
     * @param min límite mínimo
     * @param max límite máximo
     * @return número aleatorio
     */
    public static double randomDouble(double min, double max){
        return rnd.nextDouble(max-min+Double.MIN_VALUE)+min;
    }


    public static int pedirIntPositivo(String msj, String msjNeg, String msjError) {
        Integer res;
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

    public static int pedirInt(String msj, String msjError) {
        Integer res;
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

    public static double pedirDoublePositivo(String msj, String msjNeg, String msjError) {
        Double res;
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

    public static double pedirDouble(String msj, String msjError) {
        Double res;
        do {
            try {
                System.out.print(msj);
                res = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print(msjError);
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
        } while (s == null);

        return s;
    }

    public static String pedirStringNoVacio(String msj, String msjError) {
        String s;
        do {
            System.out.print(msj);
            s = sc.nextLine();

            if(s.trim().isEmpty()){
                System.out.print(msjError);
                s = null;
            }
        } while (s == null);

        return s;
    }

    public static boolean pedirSiONo(String msg, String msjError) {
        String s;
        boolean res = false;
        do {
            System.out.print(msg);
            s = sc.nextLine();

            if (s.equalsIgnoreCase("sí") | s.equalsIgnoreCase("si") | s.equalsIgnoreCase("s"))
                res = true;
            else if (s.equalsIgnoreCase("no") | s.equalsIgnoreCase("n"))
                res = false;
            else {
                System.out.print(msjError);
                s = null;
            }
        } while (s == null);

        return res;
    }

    public static void continuar(String msj) {
        System.out.print(msj);
        sc.nextLine();
    }
}


