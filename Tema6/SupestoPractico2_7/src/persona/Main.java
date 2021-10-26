package persona;

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
 * Created on 26 oct. 2021 At 10:30:39
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/


/**
 *

 * @author  Rogelio Rodriguez
 * @date    26 oct. 2021
 * @version 1.0
 * 
 */
public class Main {
        
    public static void main(String[] args) {
        Viajero viajero007 = new Viajero("D002932","James", "Bond","Gran Bretaña","Birmingham Road-24, London");
        Viajero v00 = new Viajero();
        
        v00.getInfo("normal");
        System.out.println("*****************************");
        viajero007.getInfo("normal");
        System.out.println("*****************************");
        
        v00.setNombre("nadie");
        v00.setApellidos("sin apellidos");
        v00.setNacionalidad("a saber...");
        v00.getInfo("normal");
        
        System.out.println("El numero de viajeros es: "+Viajero.getNumViajeros());
    }
}
