import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        programa();
    }

    public static void programa() {
        int option;
        do {
            try {
                System.out.print("***PROGRAMA COPIADOR***" +
                        "\n [1] Copiar archivo" +
                        "\n [0] Salir" +
                        "\nElegir opción: ");
                option = sc.nextInt();
                sc.nextLine();
                switch (option){
                    case 1 -> copiarFichero();
                    case 0 -> System.out.print("Hasta luego (*^^)/");
                }
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número válido.");
                option = -1;
            }

        } while (option != 0);
    }

    public static void copiarFichero(){
        String fpEntrada, fpSalida;
        boolean valido = true;
        byte[] buffer;
        ByteArrayInputStream bis;
        do{
            try{
                System.out.print("\nIndique la ruta de origen: ");
                fpEntrada = sc.nextLine().trim();
                FileInputStream fis = new FileInputStream(fpEntrada);
                buffer = new byte[fis.available()];
                buffer = fis.readAllBytes();
                fis.close();

                System.out.print("\nIndique la ruta de destino: ");
                fpSalida = sc.nextLine().trim();
                FileOutputStream fos = new FileOutputStream(fpSalida);
                fos.write(buffer);
                fos.close();

                System.out.println("\nFichero copiado...\n\n");
                valido = true;
            } catch (FileNotFoundException e) {
                System.out.print("\nEse fichero no existe...");
                valido = false;
            } catch (IOException e) {
                System.out.print("\nError en la lectura. Elegir otro fichero válido.");
                valido = false;
            }
        }while(!valido);
    }
}