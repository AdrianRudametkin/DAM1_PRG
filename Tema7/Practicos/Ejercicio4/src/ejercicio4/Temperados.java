/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Temperados.java
 *
 * Created on Dec 20, 2021 At 8:52:18 AM
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
 * @date    Dec 20, 2021
 * @version 1.0
 * 
 */
public abstract class Temperados extends Producto{
    // Atributos
    private double tempMant;
    
    // Constructores

    public Temperados(double tempMant, Fecha f_cad, int lote, Fecha f_env, String paisOrigen) {
        super(f_cad, lote, f_env, paisOrigen);
        this.tempMant = tempMant;
    }
    
    
    // Getters y Setters
    public double getTempMant() {
        return tempMant;
    }

    public void setTempMant(double tempMant) {
        this.tempMant = tempMant;
    }
    
    // Metodo que devuelve informacion del producto
    @Override
    public String toString(){
        return (super.toString()+
                "\n Temperatura de Matenimiento "+tempMant);
    } 
}
