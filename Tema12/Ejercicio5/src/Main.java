import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIndique el número de enteros: ");
        try {
            int i = sc.nextInt();
            sc.nextLine();
            System.out.print("Indique la ruta del archivo: ");
            String p = sc.nextLine();
            escribirFichero(randoms(0, 100, i), p);
            System.out.print("\nFichero modificado correctamente...");
            System.out.print("\nNúmeros escritos: \n");
            leerFichero(p);
        } catch (InputMismatchException e) {
            System.out.print("\nEso no es un número...");
        } catch (FileNotFoundException e) {
            System.out.print("\nNo existe el fichero.");
        } catch (IOException e) {
            System.out.print("\nError al escribir archivo.");
        }

    }

    public static void escribirFichero(int[] buff, String fp) throws IOException {
        FileOutputStream fos = new FileOutputStream(fp);
        DataOutputStream dos = new DataOutputStream(fos);
        for (int i = 0; i < buff.length; i++) {
            dos.writeInt(buff[i]);
            dos.flush();
        }
        dos.close();
        fos.close();

    }

    public static void leerFichero(String fp) throws IOException {
        FileInputStream fis = new FileInputStream(fp);
        DataInputStream dis = new DataInputStream(fis);

        int fs_int = fis.available()/Integer.BYTES;
        for(int i = 0; i < fs_int; i++) {
            System.out.println(i+1+": " + dis.readInt());
        }
        dis.close();
        fis.close();
    }

    public static int[] randoms(int min, int max, int num) {
        Random r = new Random();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = r.nextInt(min, max);
        }
        return arr;
    }
}
