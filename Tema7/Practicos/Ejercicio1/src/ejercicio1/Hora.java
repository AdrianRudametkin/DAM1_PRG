/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Hora.java
 *
 * Created on Dec 13, 2021 At 9:14:01 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio1;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 13, 2021
 * @version 1.0
 * 
 */
public class Hora {
    final private int hora;
    final private int minuto;
    
    public Hora(int hora, int minuto){
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }
    
    @Override
    public String toString(){
        return ((this.hora<10 ? "0"+this.hora : this.hora) 
                + ":" +
                (this.minuto<10 ? "0"+this.minuto : this.minuto));
    }
}
