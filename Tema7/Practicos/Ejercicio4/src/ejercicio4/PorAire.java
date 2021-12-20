/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * PorAire.java
 *
 * Created on Dec 17, 2021 At 12:59:21 PM
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
 * @date    Dec 17, 2021
 * @version 1.0
 * 
 */
public class PorAire extends Congelados{
    // Atributos
    private double porc_N;
    private double porc_O;
    private double porc_CO2;
    private double porc_H2O;
    
    // Constructores
    public PorAire(double porc_N, double porc_O, double porc_CO2, double porc_H2O, Fecha f_cad, int lote, Fecha f_env, String paisOrigen) {
        super(f_cad, lote, f_env, paisOrigen);
        this.porc_N = porc_N;
        this.porc_O = porc_O;
        this.porc_CO2 = porc_CO2;
        this.porc_H2O = porc_H2O;
    }
    
    // Getters y Setters
    public double getPorc_N() {
        return porc_N;
    }

    public void setPorc_N(double porc_N) {
        this.porc_N = porc_N;
    }

    public double getPorc_O() {
        return porc_O;
    }

    public void setPorc_O(double porc_O) {
        this.porc_O = porc_O;
    }

    public double getPorc_CO2() {
        return porc_CO2;
    }

    public void setPorc_CO2(double porc_CO2) {
        this.porc_CO2 = porc_CO2;
    }

    public double getPorc_H2O() {
        return porc_H2O;
    }

    public void setPorc_H2O(double porc_H2O) {
        this.porc_H2O = porc_H2O;
    }
    
    // Metodo que devuelve informacion del producto
    @Override
    public String toString(){
        return ("\nPRODUCTO CONGELADO POR AIRE:"+
                super.toString()+
                "\n Composicion Atmosfera:"+
                "\n  -Nitrogeno: "+porc_N+"%"+
                "\n  -Oxigeno: "+porc_O+"%"+
                "\n  -Dioxido de Carbono: "+porc_CO2+"%"+
                "\n  -Vapor de Agua: "+porc_H2O+"%");
    }
}
