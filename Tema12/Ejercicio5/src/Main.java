import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indique el número de enteros: ");

    }

    public static void escribirFichero(int[] buff, String fp){
        try {
            FileOutputStream fos = new FileOutputStream(fp);
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i = 0; i < buff.length; i++){
                dos.writeInt(buff[i]);
            }
        } catch (IOException e) {
            System.out.print("\nError al escribir archivo.");
        }
    }

    public static void leerFichero(String fp){
        try {
            FileInputStream fis = new FileInputStream(fp);
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readInt());
        } catch (FileNotFoundException e) {
            System.out.print("\nNo existe el fichero.");
        }
    }

    public static int[] randoms(int min, int max, int num){
        Random r = new Random();
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = r.nextInt(min, max);
        }
        return arr;
    }
}
