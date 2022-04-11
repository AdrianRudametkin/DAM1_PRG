import java.io.*;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String fp = "datosCoches.rrr";
    private static DecimalFormat df = new DecimalFormat(".##");

    public static void main(String[] args) {

        int option;
        do {
            printMenu();
            option = leerInt("\nElegir una opción: ");
            sc.nextLine();
            switch (option) {
                case 1 -> escribirCoche();
                case 2 -> mostrarCoches();
                case 3 -> System.out.print("\nHasta luego!!");
                default -> System.out.print("\nOpción no válida!!");
            }

        } while (option != 3);
        sc.close();
    }

    public static void printMenu() {
        System.out.print("\n\n***Datos de Coches***" +
                "\n[1] Añadir un coche." +
                "\n[2] Mostrar los coches guardados." +
                "\n[3] Salir.");
    }

    public static void escribirCoche() {
        String matricula = leerString("\nIntroduzca la matrícula: ");
        String marca = leerString("Introduzca la marca: ");
        String modelo = leerString("Introduzca el modelo: ");
        double deposito = leerDouble("Introduzca el tamaño del depósito (litros): ");

        escribirFichero(matricula, marca, modelo, deposito);
        System.out.print("\nCoche guardado.");
    }

    private static String leerString(String msj) {
        String s;
        do {
            System.out.print(msj);
            s = sc.nextLine();
            if(s.trim().equalsIgnoreCase("")){
                System.out.print("Estaría bien que pusieras algo. ");
            }
        } while (s.trim().equalsIgnoreCase(""));

        return s;
    }

    private static double leerDouble(String msj) {
        double i = -1;
        do {
            try {
                System.out.print(msj);
                i = sc.nextDouble();
                sc.nextLine();
                if (i < 0) {
                    System.out.print("Números positivos por favor...\n");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("\nEso no va así...\n");
                sc.nextLine();
                i = -1;
            }
        } while (i < 0);

        return i;
    }

    private static int leerInt(String msj) {
        int i = -1;
        do {
            try {
                System.out.print(msj);
                i = sc.nextInt();
                if (i < 0) {
                    System.out.print("Números positivos por favor...\n");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("\nEso no va así...\n");
                sc.nextLine();
                i = -1;
            }
        } while (i < 0);

        return i;
    }

    private static void escribirFichero(String matricula, String marca, String modelo, double deposito) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fp, true));
            dos.writeUTF(matricula);
            dos.flush();
            dos.writeUTF(marca);
            dos.flush();
            dos.writeUTF(modelo);
            dos.flush();
            dos.writeDouble(deposito);
            dos.flush();
            dos.writeUTF("\n");
            dos.flush();
            dos.close();
        } catch (FileNotFoundException e) {
            System.out.print("\nFichero no encontrado...");
        } catch (IOException e) {
            System.out.print("\nError al escribir...");
        }
    }


    public static void mostrarCoches() {
        String matricula, marca, modelo;
        double deposito = -1;
        boolean eof = false;
        int i = 1;

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(fp));

            while (!eof) {
                try {
                    matricula = dis.readUTF();
                    marca = dis.readUTF();
                    modelo = dis.readUTF();
                    deposito = dis.readDouble();
                    System.out.print("\nCoche numero " + i + ": ");
                    System.out.print(toString(matricula, marca, modelo, deposito) + "\n");
                    i++;
                    dis.readUTF();
                } catch (EOFException e) {
                    System.out.print("\nFinal del archivo.");
                    System.out.print("\nPulse INTRO para continuar...");
                    sc.nextLine();
                    eof = true;
                } catch (IOException e) {
                    System.out.print("\nError al leer el archivo...");
                }
            }
            dis.close();

        } catch (FileNotFoundException e) {
            System.out.print("\nNo hay datos guardados...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String toString(String matricula, String marca, String modelo, double deposito) {
        return ("\nEl vehículo tiene una matrícula " + matricula + ", su marca es " + marca + ", " +
                "su modelo es " + modelo + " y el tamaño del depósito es de " + df.format(deposito) + " litros");
    }
}
