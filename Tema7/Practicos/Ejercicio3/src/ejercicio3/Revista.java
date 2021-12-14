/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Revista.java
 *
 * Created on Dec 14, 2021 At 1:13:23 PM
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
public class Revista extends Publicacion{
    private int numero;
    
    public Revista(int codigo, String titulo, int anyo, int numero){
        super(codigo, titulo, anyo);
        this.numero = numero;
    }
    
    @Override
    public String toString(){
        return(super.toString()+
                "\n·Numero: "+ numero);
    }
}
