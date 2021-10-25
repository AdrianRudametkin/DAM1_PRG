/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Main.java
 *
 * Created on 25 oct. 2021 At 9:29:41
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/


/**
 *
 * @author  Rogelio Rodriguez
 * @date    25 oct. 2021
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        // Creando 2 productos
        Producto p1 = new Producto(10);
        Producto p2 = new Producto(30);
        Producto.infoRebajaActual();
        System.out.println("Precio p1: " + p1.getPrecioFinal());
        System.out.println("Precio p2: " + p2.getPrecioFinal() + "\n");
        
        // Comienzan las primeras rebajas de un 25%
        p2.rebaja = 25;
        p1.infoRebajaActual();
        System.out.println("Precio p1 primeras rebajas: " + p1.getPrecioFinal());
        System.out.println("Precio p2 primeras rebajas: " + p2.getPrecioFinal()+ "\n");
        
        // Comienzan las segundas rebajas al 50%
        Producto.rebaja = 50;
        p2.infoRebajaActual();
        System.out.println("Precio p1 segundas rebajas: " + p1.getPrecioFinal());
        System.out.println("Precio p2 segundas rebajas: " + p2.getPrecioFinal());
    }

}
