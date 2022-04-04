import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String fp1, fp2, des;
        File f1, f2, fDes;
        boolean valido;

        do {
            System.out.print("\nIndique la ruta del fichero 1: ");
            fp1 = sc.nextLine();
            f1 = new File(fp1);
            if (!f1.exists()) {
                System.out.print("\nEse fichero no existe.");
                valido = false;
            }else{
                valido = true;
            }
        }while(!valido);

        do {
            System.out.print("\nIndique la ruta del fichero 2: ");
            fp2 = sc.nextLine();
            f2 = new File(fp2);
            if (!f2.exists()) {
                System.out.print("\nEse fichero no existe.");
                valido = false;
            }else{
                valido = true;
            }
        }while(!valido);

        do {
            System.out.print("Indique la ruta de destino: ");
            des = generarNombre(fp1, fp2, sc.nextLine());
            fDes = new File(des);
            if (fDes.exists()) {
                System.out.print("\nEse fichero existe, ¿desea sobreescribirlo?(s/n)");
                String respuesta = sc.nextLine();
                if(respuesta.equalsIgnoreCase("s")){
                    valido = true;
                }else if (respuesta.equalsIgnoreCase("n")){
                    valido = false;
                }else{
                    System.out.print("Opción no válida.");
                    return;
                }
                valido = false;
            }else{
                valido = true;
            }
        }while(!valido);
        System.out.print("Indique la ruta de destino: ");
        des = generarNombre(fp1, fp2, sc.nextLine());


        generarArchivo(f1, f2, fDes);
        System.out.print("\nFichero copiado con éxito.");
    }

    private static String generarNombre(String fp1, String fp2, String des) {
        String cad1="", cad2="", rutaCompleta = "";

        cad1 = fp1.substring(0, des.lastIndexOf("."));
        cad2 = fp2.substring(0, des.lastIndexOf("."));

        if(des.trim().equals("")){
            rutaCompleta += cad1 + cad2 + ".txt";
        } else if(des.charAt(des.length()-1) == '/'){
            rutaCompleta += des + cad1 + cad2 + ".txt";
        } else {
            rutaCompleta += "/" + des + cad1 + cad2 + ".txt";
        }

        return rutaCompleta;
    }

    private static void generarArchivo(File f1, File f2, File fDes) {
        try {
            FileWriter fw = new FileWriter(fDes);
            FileReader fr = new FileReader(f1);
            int c;
            while((c=fr.read()) != -1){
                fw.write(c);
                fw.flush();
            }

            fr = new FileReader(f2);
            while((c=fr.read()) != -1){
                fw.write(c);
                fw.flush();
            }

            fw.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.print("\nArchivo no encontrado.");
        } catch (IOException e) {
            System.out.print("\nError al escribir en el archivo.");
        }
    }
}
