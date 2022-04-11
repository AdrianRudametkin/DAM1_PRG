import streams.VehiculoOutputStream;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String filepath = "coches.olv";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File f = new File(filepath);
        int option;
        do {
            printMenu();
            option = leerInt("\nElegir una opción: ");
            sc.nextLine();
            switch (option) {
                case 1 -> anyadirVehiculos(f);
                case 2 -> leerVehiculos(f);
                case 3 -> System.out.print("\nHasta luego!!");
                default -> System.out.print("\nOpción no válida!!");
            }

        } while (option != 3);
        sc.close();
    }

    private static void anyadirVehiculos(File f) {
        String matricula = leerString("\nIntroduzca la matrícula: ");
        String marca = leerString("Introduzca la marca: ");
        String modelo = leerString("Introduzca el modelo: ");
        double deposito = leerDouble("Introduzca el tamaño del depósito (litros): ");

        escribirVehiculo(f, new Vehiculo(matricula, marca, modelo, deposito));
    }

    private static void printMenu(){
        System.out.print("\n\n***Datos de Coches***" +
                "\n[1] Añadir un coche." +
                "\n[2] Mostrar los coches guardados." +
                "\n[3] Salir.");
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

    public static void escribirVehiculo(File f, Vehiculo v) {
        try {
            if (!f.exists()) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(v);
                oos.close();
            }else{
                VehiculoOutputStream vos = new VehiculoOutputStream(new FileOutputStream(f, true));
                vos.writeObject(v);
                vos.close();
            }
        }catch(IOException e){
            System.out.print("\nError al escribir en el fichero.");
        }
    }

    public static void leerVehiculos(File f) {
        boolean eof = false;
        if(!f.exists()){
            System.out.print("\nFichero no existe...");
            return;
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

            while (!eof) {
                try {
                    Vehiculo v = (Vehiculo) ois.readObject();
                    System.out.print(v.toString());
                } catch (ClassNotFoundException e) {
                    System.out.print("Error al leer archivo: clase no válida.");
                } catch (EOFException e) {
                    System.out.print("\nFin del archivo.");
                    eof = true;
                }
            }
            ois.close();
        } catch (IOException e) {
            System.out.print("Error al leer archivo.");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }
}
