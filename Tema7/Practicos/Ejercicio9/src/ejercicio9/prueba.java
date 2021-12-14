/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * prueba.java
 *
 * Created on Dec 14, 2021 At 1:45:23 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio9;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 14, 2021
 * @version 1.0
 * 
 */

// El codigo no compilara porque getIdent ya esta declarada una vez con
// con los mismos parametros (es decir 0 parametros). No importa que
// devuelvan distintos valores, lo importante son los parametros de entrada.
class prueba {
    protected String nombre;
    protected int ID;
    
    public String getIdent ( ) { 
        return nombre;
    }
    
    public int getIdent2 ( ) { 
        return ID;
    }
}
