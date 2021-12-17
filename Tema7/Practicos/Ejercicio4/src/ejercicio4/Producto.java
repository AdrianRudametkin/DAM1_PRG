/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Producto.java
 *
 * Created on Dec 17, 2021 At 12:38:03 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio4;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 17, 2021
 * @version 1.0
 * 
 */
public abstract class Producto {
    private String f_cad;
    private int lote;
    private String f_env;
    private String pais_origen;

    public String getF_cad() {
        return f_cad;
    }

    public void setF_cad(String f_cad) {
        this.f_cad = f_cad;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }
    
    
}
