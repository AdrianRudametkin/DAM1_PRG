/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio4.java
 *
 * Created on Dec 17, 2021 At 12:36:30 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio4;

import java.util.Date;
import tools.Fecha;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 17, 2021
 * @version 1.0
 * 
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        Fecha cad = new Fecha(25, 12, 2022);
        Fecha env = new Fecha(25, 12, 2021);
        
        Frescos f1 = new Frescos(cad, 922000, env, "España");
        Frescos f2 = new Frescos(cad, 881232, env, "Italia");
        
        Refrigerados r1 = new Refrigerados(23331, 15.2, cad, 881232, env, "Francia");
        Refrigerados r2 = new Refrigerados(53041, 10.7, cad, 123432, env, "Suiza");
        Refrigerados r3 = new Refrigerados(94832, 7.0, cad, 881132, env, "Alemania");
        
        Congelados c1 = new PorAgua(22.4, cad, 923949, env, "Noruega");
        Congelados c2 = new PorAgua(2.4, cad, 897234, env, "Finlandia");
        
        Congelados c3 = new PorAire(20.4, 10.1, 35.2, 1.3,  cad, 112312, env, "Finlandia");
        Congelados c4 = new PorAire(22.3, 8.1, 40.2, 1.01, cad, 112412, env, "Finlandia");
        
        Congelados c5 = new PorNitrogeno("Contacto directo", 120, cad, 897234, env, "Finlandia");

        System.out.println(f1.toString());
        System.out.println(f2.toString());
        
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        System.out.println(c5.toString());
    }

}
