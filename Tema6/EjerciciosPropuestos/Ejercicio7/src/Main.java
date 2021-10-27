/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Main.java
 *
 * Created on 27 oct. 2021 At 8:16:12
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/


/**
 *
 * @author  Rogelio Rodriguez
 * @date    27 oct. 2021
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Consumo c1 = new Consumo(1340,232,123.33,1.082);
        
        System.out.println(c1.consumoEuros());
        System.out.println(c1.cousumoMedio());
        System.out.println(c1.getPGas());
        System.out.println(c1.getKms());
        System.out.println(c1.getTiempo());
        System.out.println(c1.getVmed());
    }

}
