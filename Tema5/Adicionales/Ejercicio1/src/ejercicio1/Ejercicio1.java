/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Ejercicio1.java
 *
 * Created on 18 oct. 2021 At 8:07:23
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
 * @date    18 oct. 2021
 * @version 1.0
 * 
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        double notaMedia, notas[] = {10.0, 5.0};
        
        notaMedia = calcularMedia(notas);
        
        System.out.printf("La nota media es %.2f.\n", notaMedia);
    }
    
    public static double calcularMedia(double[] notas){
        double temp = 0;
        
        for(int i=0; i<notas.length; i++){
            temp += notas[i];
        }
        
        return (double)temp/notas.length;
    }

}
