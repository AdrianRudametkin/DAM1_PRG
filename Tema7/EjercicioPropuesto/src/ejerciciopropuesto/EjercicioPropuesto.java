/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * EjercicioPropuesto.java
 *
 * Created on Dec 21, 2021 At 12:45:15 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejerciciopropuesto;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 21, 2021
 * @version 1.0
 * 
 */
public class EjercicioPropuesto {

    public static void main(String[] args) {
        JuegoEnAlquiler ja1 = new JuegoEnAlquiler();
        JuegoEnAlquiler ja2 = new JuegoEnAlquiler("El juego 2", "Namco", 1992, 19.2, 3, 2);
        JuegoEnAlquiler ja3 = new JuegoEnAlquiler(ja2);
        
        JuegoEnVenta jv1 = new JuegoEnVenta();
        JuegoEnVenta jv2 = new JuegoEnVenta("El juego vendido", "Toshiba", 2006, 45.99, 15);
        
        // Comprobar el metodo equals
        System.out.println("\nJA1: " + ja1.toString());
        System.out.println("\nJA2: " + ja2.toString());
        System.out.println("\nJA3: " + ja3.toString());
        System.out.println("\nJV1: " + jv1.toString());
        System.out.println("\nJV2: " + jv2.toString());
        System.out.println("\nja1.equals(ja2): "+ja1.equals(ja2));
        System.out.println("\nja2.equals(ja3): "+ja2.equals(ja3));
        
        ja2.setTitulo("El juego vendido");
        System.out.println("\nja2.equals(ja3): "+ja2.equals(ja3));
        
        ja2.setFabricante("Toshiba");
        ja2.setAnyo(2006);
        System.out.println("\nja2.equals(jv2): "+ja2.equals(jv2));
        
        // Comprobar el metodo compareTo
        System.out.println("\nja2.compareTo(jv2): "+ja2.compareTo(jv2));
        jv2.setAnyo(2011);
        System.out.println("\nja2.compareTo(jv2): "+ja2.compareTo(jv2));
        ja2.setFabricante("Zamco");
        System.out.println("\nja2.compareTo(jv2): "+ja2.compareTo(jv2));
        jv2.setTitulo("The Game");
        System.out.println("\nja2.compareTo(jv2): "+ja2.compareTo(jv2));
        
        System.out.println("\n");
        
        // Interfaz alquilable
        System.out.println("Copias JA2: "+ja2.getNumCopias());
        ja2.alquilar();
        ja2.alquilar();
        System.out.println("Copias JA2: "+ja2.getNumCopias());
        ja2.devolver();
        ja2.devolver();
        ja2.devolver();
        System.out.println("Copias JA2: "+ja2.getNumCopias());
        System.out.println("Dias alquiler: "+ja2.getDiasAlquila()+
                "\nPrecio: "+ja2.getPrecio()+"€"+
                "\nPrecio final: "+ja2.precioFinal()+"€");
        
        System.out.println("\n");
        // Vender juegos
        System.out.println("Copias JV2: "+jv2.getNumCopias());
        jv2.vender();
        jv2.vender();
        jv2.vender();
        System.out.println("Copias JV2: "+jv2.getNumCopias());
    }

}
