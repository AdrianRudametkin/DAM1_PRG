/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Fecha.java
 *
 * Created on Dec 13, 2021 At 9:13:54 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package tools;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 13, 2021
 * @version 1.0
 * 
 */
public class Fecha {
    final private int dia;
    final private int mes;
    final private int ano;
    
    public Fecha(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
    

    @Override
    
    public String toString(){
        return (this.dia + "/" + this.mes + "/" + this.ano);
    }
}