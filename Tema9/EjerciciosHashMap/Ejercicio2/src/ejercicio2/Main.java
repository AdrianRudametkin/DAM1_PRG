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
 * Created on Feb 8, 2022 At 1:34:40 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio2;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 8, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Colegio c = new Colegio();
        
        c.addAlumno("España");
        c.addAlumno("Portugal");
        c.addAlumno("España");
        c.addAlumno("alemania");
        c.addAlumno("españA");
        c.addAlumno("PORTUGAL");
        
        c.showAll();
        System.out.println("");
        
        c.showNacionalidad("España");
        c.showNacionalidad("francia");
        System.out.println("");
        
        c.cuantos();
        System.out.println("");
        
        c.borrarNacionalidad("portugal");
        c.borrarNacionalidad("francia");
        c.showAll();
        System.out.println("");
        
        c.borrarAll();
        c.cuantos();
        c.showAll();
        
    }

}
