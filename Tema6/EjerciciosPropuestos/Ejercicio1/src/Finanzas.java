/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

 /*
 *
 * Finanzas.java
 *
 * Created on Oct 26, 2021 At 9:36:48 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
 */
/**
 *
 * @author  Rogelio Rodriguez
 * @date Oct 26, 2021
 * @version 1.0
 *
 */

// Clase que convierte euros a dolares y viceversa
public class Finanzas {
    // Atributos
    private double dolarEuro;

    // Constructores
    public Finanzas() {
        dolarEuro = 1.36;
    }
    
    public Finanzas(double dolarEuro){
        this.dolarEuro = dolarEuro;
    }

    // Metodo que cambia de dolares a euros
    public double dolarsToEuros(double dolares) {
        double calculo = dolares*dolarEuro;
        return calculo;
    }

    // Metodo que cambia de euros a dolares
    public double eurosToDolars(double euros) {
        return (euros / dolarEuro);
    }
}
