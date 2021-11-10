/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

 /*
 *
 * Coche.java
 *
 * Created on 27 oct. 2021 At 8:10:09
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
 */

/**
 *
 * @author  Rogelio Rodriguez
 * @date 27 oct. 2021
 * @version 1.0
 *
 */

// Clase que contiene informacion de un coche
public class Coche {

    //*** Atributos ***
    private String marca;
    private String modelo;

    //*** Constructores ***
    public Coche() {
        this.marca = "Sin marca";
        this.modelo = "N/A";
    }
    public Coche(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }
}
