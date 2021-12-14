/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Libro.java
 *
 * Created on Dec 14, 2021 At 1:13:16 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio3;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 14, 2021
 * @version 1.0
 * 
 */
public class Libro extends Publicacion implements Prestable {
    private boolean prestado;
    
    public Libro(int codigo, String titulo, int anyo){
        super(codigo, titulo, anyo);
        prestado = false;
    }

    @Override
    public void prestar() {
        prestado = true;
    }
    
    @Override
    public void devolover() {
        prestado = false;
    }

    @Override
    public boolean prestado() {
        return prestado;
    }
    
    @Override
    public String toString(){
        return(super.toString()+
                "\n·Prestado: "+ (prestado ? "Si" : "No"));
    }
}
