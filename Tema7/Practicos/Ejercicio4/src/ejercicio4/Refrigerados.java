/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Refrigerados.java
 *
 * Created on Dec 17, 2021 At 12:42:39 PM
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
public class Refrigerados extends Temperados{
    // Atributos
    private int codUE;
    
    // Constructores
    public Refrigerados(int codUE, double tempMant, Fecha f_cad, int lote, Fecha f_env, String paisOrigen) {    
        super(tempMant, f_cad, lote, f_env, paisOrigen);
        this.codUE = codUE;
    }

    // Getters y Setters
    public int getCodUE() {
        return codUE;
    }

    public void setCodUE(int codUE) {
        this.codUE = codUE;
    }

    
    // Metodo que devuelve informacion del producto
    @Override
    public String toString(){
        return ("\nPRODUCTO REFRIGERADO"+
                super.toString()+
                "\n Codigo del Organismo de Supervision Alimentaria: "+codUE);
    }    
}
