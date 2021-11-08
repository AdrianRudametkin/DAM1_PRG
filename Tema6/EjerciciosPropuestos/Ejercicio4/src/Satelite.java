/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Satelite.java
 *
 * Created on Oct 26, 2021 At 10:12:48 PM
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
public class Satelite {
    //*** Atributos ***
    private double meridiano;
    private double paralelo;
    private double distancia_tierra;
    
    //*** Constructores ***
    public Satelite(double meridiano, double paralelo, double distancia_tierra){
        this.meridiano = meridiano;
        this.paralelo = paralelo;
        this.distancia_tierra = distancia_tierra;
    }
    
    public Satelite(){
        this.meridiano = 0;
        this.paralelo = 0;
        this.distancia_tierra = 0;
    }
    
    //*** Metodos ***
    public void setPosicion(double meridiano, double paralelo, double distancia_tierra){
        this.meridiano = meridiano;
        this.paralelo = paralelo;
        this.distancia_tierra = distancia_tierra;
    }
    public void printPosicion(){
        System.out.println("El satellite se encuentra en el paralelo "+paralelo
                + ", meridiano "+meridiano
                +", a una distancia de la tierra de "+distancia_tierra+ " kilómetros");
    }
    public void variaAltura(double desplazamiento){
    	this.distancia_tierra += desplazamiento;
        if(this.distancia_tierra >= 0)
            this.distancia_tierra = 0;
    }
    public boolean enOrbita(){
        return this.distancia_tierra == 0;
    }
    public void variaPosicion(double variaP, double variaM){
        this.meridiano += variaM;
        this.paralelo += variaP;
    }
}
