/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Numero.java
 *
 * Created on Oct 26, 2021 At 10:01:08 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Oct 26, 2021
 * @version 1.0
 * 
 */

// Clase que modifica y devuelve operaciones de un numero
public class Numero {
    //*** Atributos ***
    private int valor;
    
    //*** Constructores ***
    public Numero(){
        this.valor = 0;
    }
    public Numero(int valor){
        this.valor = valor;
    }
    
    //*** Metodos ***
    // Metodo que suma un numero a this.valor
    public void anyade(int numero){
        this.valor += numero;
    }
    // Metodo que resta un numero a this.valor
    public void resta(int numero){
        this.valor -= numero;
    }
    // Metodo que devuelve this.valor
    public int getValor(){
        return this.valor;
    }
    // Metodo que devuelve el doble de this.valor
    public int getDoble(){
        return (this.valor*2);
    }
    // Metodo que devuelve el triple de this.valor
    public int getTriple(){
        return (this.valor*3);
    }
    // Metodo que inicializa this.valor a 0
    public void setNumero(){
        this.valor = 0;
    }
}
