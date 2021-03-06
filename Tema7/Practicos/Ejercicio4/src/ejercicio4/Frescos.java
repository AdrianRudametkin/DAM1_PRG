/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Frescos.java
 *
 * Created on Dec 17, 2021 At 12:41:31 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio4;

import tools.Fecha;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 17, 2021
 * @version 1.0
 * 
 */
public class Frescos extends Producto{
    // Constructores
    public Frescos(Fecha f_cad, int lote, Fecha f_env, String paisOrigen) {
        super(f_cad, lote, f_env, paisOrigen);
    }
    
    // Metodo que devuelve informacion del producto
    @Override
    public String toString(){
        return ("\nPRODUCTO FRESCO"+
               super.toString());
    }
}
