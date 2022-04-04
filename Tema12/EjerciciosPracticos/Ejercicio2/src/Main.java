import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.print("\nIndique la ruta del fichero: ");
        String fp = sc.nextLine();
        System.out.print("Escriba la cadena de texto a introducir: ");
        String cad = sc.nextLine();

        escribirAFichero(fp, cad);

        System.out.println("\nMostrando archivo: ");
        String cad2 = leerFichero(fp);
        if(cad2 == null){
            System.out.print("No se puede convertir el fichero.");
        }else{
            mayusculas(cad2);
        }
    }

    private static void escribirAFichero(String fp, String cad) {
        try {
            FileWriter fw = new FileWriter(fp);
            fw.write(cad);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.print("\nError al escribir en archivo.");
        }
    }


    private static String leerFichero(String fp) {
        try {
            FileReader fr = new FileReader(fp);
            int c;
            String s = "";

            while((c=fr.read()) != -1){
                s += (char)c;
            }

            return s;
        } catch (FileNotFoundException e) {
            System.out.print("\nNo existe el fichero.");
        } catch (IOException e) {
            System.out.print("\nError al leer el archivo.");
        }

        return null;
    }

    private static void mayusculas(String s) {
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 97){
                System.out.print(Character.toUpperCase(c));
            }else{
                System.out.print(Character.toLowerCase(c));
            }
        }
    }
}
