/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * PorNitrogeno.java
 *
 * Created on Dec 20, 2021 At 8:34:19 AM
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
public class PorNitrogeno extends Congelados{
    // Atributos
    private String metodo;
    private int tiempoExposicion;
    
    // Constructores
    public PorNitrogeno(String metodo, int tiempoExposicion, Fecha f_cad, int lote, Fecha f_env, String paisOrigen) {
        super(f_cad, lote, f_env, paisOrigen);
        this.metodo = metodo;
        this.tiempoExposicion = tiempoExposicion;
    }
    

    
    // Getters y Setters
    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getTiempoExposicion() {
        return tiempoExposicion;
    }

    public void setTiempoExposicion(int tiempoExposicion) {
        this.tiempoExposicion = tiempoExposicion;
    }
    
    // Metodo que devuelve informacion del producto
    @Override
    public String toString(){
        return ("\nPRODUCTO CONGELADO POR NITROGENO:"+
                super.toString()+
                "\n Metodo Utilizado: "+metodo+
                "\n Tiempo de Exposicion: "+tiempoExposicion+" segundos");
    }
}
