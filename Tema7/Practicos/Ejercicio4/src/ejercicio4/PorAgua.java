/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * PorAgua.java
 *
 * Created on Dec 20, 2021 At 8:33:35 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio4;

import java.util.Date;
import tools.Fecha;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 20, 2021
 * @version 1.0
 * 
 */
public class PorAgua extends Congelados{
    // Atributos
    private double gramosPorLitro;
    
    // Constructores
    public PorAgua(double gramosPorLitro, Fecha f_cad, int lote, Fecha f_env, String paisOrigen) {
        super(f_cad, lote, f_env, paisOrigen);
        this.gramosPorLitro = gramosPorLitro;
    }
    
    // Getters y Setters
    public double getGramosPorLitro() {
        return gramosPorLitro;
    }

    public void setGramosPorLitro(double gramosPorLitro) {
        this.gramosPorLitro = gramosPorLitro;
    }
    
    // Metodo que devuelve informacion del producto
    @Override
    public String toString(){
        return ("\nPRODUCTO CONGELADO POR AGUA:"+
                super.toString()+
                "\n Composicion Agua: "+gramosPorLitro+" g(NaCl)/l");
    }
    
    
}
