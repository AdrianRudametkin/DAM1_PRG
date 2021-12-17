/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Disco.java
 *
 * Created on Dec 17, 2021 At 12:07:03 PM
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
 * @date    Dec 17, 2021
 * @version 1.0
 * 
 */
public class Disco extends Multimedia{
    private Genero genero;

    public Disco(String titulo, String autor, Formato formato, double duracion, Genero genero) {
        super(titulo, autor, formato, duracion);
        this.genero = genero;
    }

    @Override
    public String toString(){
        return (super.toString()+
                "\nGenero: "+genero);
    }
}
