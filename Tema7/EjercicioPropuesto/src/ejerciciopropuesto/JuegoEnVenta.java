/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * JuegoEnVenta.java
 *
 * Created on Dec 28, 2021 At 11:49:47 AM
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
 * @date    Dec 28, 2021
 * @version 1.0
 * 
 */
public class JuegoEnVenta extends Juego{
    
    //*** CONSTRUCTORES ***
    public JuegoEnVenta() {
        super();
    }

    public JuegoEnVenta(String titulo, String fabricante, int anyo, double precio, int numCopias) {
        super(titulo, fabricante, anyo, precio, numCopias);
    }
    
    //*** METODOS ***
    public void vender(){
        int copias = this.getNumCopias();
        if(copias==0)
            throw new IllegalArgumentException("No hay mas copias!");
        copias--;
        this.setNumCopias(copias);
    }    
}
