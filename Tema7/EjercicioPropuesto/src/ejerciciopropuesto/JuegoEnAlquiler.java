/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * JuegoEnAlquiler.java
 *
 * Created on Dec 21, 2021 At 1:33:08 PM
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
public class JuegoEnAlquiler extends Juego{
    //*** ATRIBUTOS ***
    private int diasAlquila;
    
    //*** CONSTRUCTORES ***
    public JuegoEnAlquiler(){
        super();
    }

    public JuegoEnAlquiler(String titulo, String fabricante, int anyo, double precio, int numCopias, int diasAlquila) {
        super(titulo, fabricante, anyo, precio, numCopias);
        this.diasAlquila = diasAlquila;
    }

    public JuegoEnAlquiler(JuegoEnAlquiler o) {
        super(o.getTitulo(), o.getFabricante(), o.getAnyo(),
                o.getPrecio(), o.getNumCopias());
        
        diasAlquila = o.diasAlquila;
    }
    
    
    
    
}
