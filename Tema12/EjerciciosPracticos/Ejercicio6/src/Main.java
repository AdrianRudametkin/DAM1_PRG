import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String fp = "datosCoches.rrr";

    public static void main(String[] args) {

        int option;
        do {
            try {
                printMenu();
                option = sc.nextInt();
                sc.nextLine();
                switch (option) {
                    case 1 -> escribirCoche();
                    case 2 -> mostrarCoches();
                    case 3 -> System.out.print("\nHasta luego!!");
                    default -> System.out.print("\nOpción no válida!!");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nOpción no válida!!");
                option = -1;
            }
        }while(option!=3);
        sc.close();
    }

    public static void printMenu(){
        System.out.print("\n\n***Datos de Coches***" +
                "\n[1] Añadir un coche." +
                "\n[2] Mostrar los coches guardados." +
                "\n[3] Salir." +
                "\nElegir una opción: ");
    }

    public static void escribirCoche() {
        String matricula, marca, modelo;
        double deposito = -1;

        System.out.print("\nIntroduzca el matrícula: ");
        matricula = sc.nextLine();
        System.out.print("Introduzca el marca: ");
        marca = sc.nextLine();
        System.out.print("Introduzca el modelo: ");
        modelo = sc.nextLine();
        do {
            try {
                System.out.print("Introduzca el tamaño del depósito (litros): ");
                matricula = sc.nextLine();
                sc.nextLine();
                break;
            } catch (InputMismatchException e){
                System.out.print("\nEso no va así...");
            }
            if(deposito < 0){
                System.out.print("Números positivos por favor...");
            }
        }while (deposito < 0);

        escribirFichero(matricula, marca, modelo, deposito);
        System.out.print("\nCoche guardado.");
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

            while(!eof){
                try{
                    System.out.print("\nCoche numero "+i+": ");
                    matricula = dis.readUTF();
                    marca = dis.readUTF();
                    modelo = dis.readUTF();
                    deposito = dis.readDouble();
                    System.out.print(toString(matricula, marca, modelo, deposito));
                    i++;
                    dis.readUTF();
                }catch (EOFException e){
                    System.out.print("\nFinal del archivo.");
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
                "su modelo es " + modelo + " y el tamaño del depósito es de " + deposito + " litros");
    }
}
