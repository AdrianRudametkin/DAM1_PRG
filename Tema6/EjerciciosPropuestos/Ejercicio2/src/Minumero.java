/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

 /*
 *
 * Minumero.java
 *
 * Created on Oct 26, 2021 At 9:47:56 PM
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

// Clase que muestra varias formas de un numero
public class Minumero {

    //*** Atributos ***
    private int numero;

    //*** Constructor ***
    public Minumero(int numero) {
    	this.numero =  numero;
    }

    //*** Metodos ***
    // Metodo para el doble
    private int doble() {
        return (this.numero * 2);
    }

    // Metodo para el triple
    private int triple() {
        return (this.numero * 3);
    }

    // Metodo para el cuadruple
    private int cuadruple() {
        return (this.numero * 4);
    }

    

    //*** Metodo principal ***
    public static void main(String[] args) {
        Minumero x = new Minumero(20);
        
        System.out.println("Doble: "+x.doble());
        System.out.println("Triple: "+x.triple());
        System.out.println("Cuadruple: "+x.cuadruple());
    }

}
