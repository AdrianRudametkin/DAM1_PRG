import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ruta del archivo: ");
        String fp = sc.nextLine();
        try {
            leerSinEspacios(fp);
            String s;
            System.out.print("\n\nIntroduzca la clave (se guardarán los intentos fallidos): \n");
            do {
                s = sc.nextLine();
                escribirAFichero(fp, s);
            } while (!s.equals("99"));
            System.out.print("\nMuy bien!!");
        } catch (FileNotFoundException e) {
            System.out.print("\nFichero no encontrado...");
        } catch (IOException e) {
            System.out.print("\nError al leer el archivo...");
        }

    }

    public static void leerSinEspacios(String fp) throws IOException {
        FileReader fr = new FileReader(fp);
        int b;
        while ((b = fr.read()) != -1) {
            if ((char) b != ' ') {
                System.out.print((char) b);
            }
        }
        fr.close();
    }

    public static void escribirAFichero(String fp, String s) throws IOException {
        FileWriter fw = new FileWriter(fp, true);
        for (int i = 0; i < s.length(); i++) {
            fw.write((byte) s.charAt(i));
        }
        fw.write((byte)'\n');
        fw.flush();
        fw.close();
    }
}