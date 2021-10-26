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
public class Minumero {

    //*** Atributos ***
    private int num_doble;
    private int num_triple;
    private int num_cuadruple;

    //*** Constructor ***
    public Minumero(int numero) {
        this.num_doble = doble(numero);
        this.num_triple = triple(numero);
        this.num_cuadruple = cuadruple(numero);
    }

    //*** Metodos ***
    // Metodo para el doble
    private int doble(int numero) {
        return (numero * 2);
    }

    // Metodo para el triple
    private int triple(int numero) {
        return (numero * 3);
    }

    // Metodo para el cuadruple
    private int cuadruple(int numero) {
        return (numero * 4);
    }

    //*** Getters & Setters ***
    public int getNum_doble() {
        return num_doble;
    }

    public int getNum_triple() {
        return num_triple;
    }

    public int getNum_cuadruple() {
        return num_cuadruple;
    }

    //*** Metodo principal ***
    public static void main(String[] args) {
        Minumero x = new Minumero(20);
        
        System.out.println("Doble: "+x.getNum_doble());
        System.out.println("Triple: "+x.getNum_triple());
        System.out.println("Cuadruple: "+x.getNum_cuadruple());
    }

}
