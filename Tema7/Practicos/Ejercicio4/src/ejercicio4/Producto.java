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

import java.util.Date;
import tools.Fecha;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 17, 2021
 * @version 1.0
 * 
 */
public abstract class Producto {
    // Atributos
    private Fecha f_cad;
    private int lote;
    private Fecha f_env;
    private String paisOrigen;
    
    // Constructores

    public Producto(Fecha f_cad, int lote, Fecha f_env, String paisOrigen) {
        this.f_cad = f_cad;
        this.lote = lote;
        this.f_env = f_env;
        this.paisOrigen = paisOrigen;
    }

    // Getters y Setters
    public Fecha getF_cad() {
        return f_cad;
    }

    public void setF_cad(Fecha f_cad) {
        this.f_cad = f_cad;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public Fecha getF_env() {
        return f_env;
    }

    public void setF_env(Fecha f_env) {
        this.f_env = f_env;
    }

    public String getPais_origen() {
        return paisOrigen;
    }

    public void setPais_origen(String pais_origen) {
        this.paisOrigen = pais_origen;
    }
    
    // Metodo que devuelve informacion del producto
    @Override
    public String toString(){
        return ("\n Numero de Lote: "+lote+
                "\n Fecha de Envasado: "+f_env.toString()+
                "\n Fecha de Caducidad: "+f_cad.toString()+
                "\n Pais de Origen: "+paisOrigen);
    }
}
