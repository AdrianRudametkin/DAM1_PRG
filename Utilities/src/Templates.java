import java.io.*;
import java.util.ArrayList;

public class Templates {
    String file;
    ArrayList<Object> arrayList = new ArrayList<>();

    public void cargarFichero(String fp) {
        if (!(new File(file)).exists() || (new File(file)).length() < 2) {
            System.out.println("No existe fichero.");
        } else {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                arrayList = (ArrayList<Object>) ois.readObject();
                ois.close();
            } catch (ClassNotFoundException e) {
                System.out.print("Clase no coincide: "+e.getMessage());
            } catch (IOException e) {
                System.out.print("Error inesperado: "+e.getMessage());
            }
        }
    }

    public void guardarFichero() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(arrayList);
            oos.close();
        } catch (IOException e) {
            System.out.print("Error inesperado: "+e.getMessage());
        }
    }
}
