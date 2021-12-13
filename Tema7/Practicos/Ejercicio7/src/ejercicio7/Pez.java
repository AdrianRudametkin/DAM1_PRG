/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Pez.java
 *
 * Created on Dec 13, 2021 At 8:40:01 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio7;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 13, 2021
 * @version 1.0
 * 
 */
public class Pez {
    // Atributos
    private String nombre;
    private static int numpeces;
    
    public Pez(Pez p){
        this.nombre = p.getNombre();
        numpeces++;
    }
    public Pez(String nombre){
        this.nombre = nombre;
        numpeces++;
    }
    public Pez(){
        numpeces++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static int getNumpeces(){
        return numpeces;
    }

    public boolean equals(Pez p){
        if(this.nombre.equals(p.getNombre()))
            return true;
        else 
            return false;
    }
}
