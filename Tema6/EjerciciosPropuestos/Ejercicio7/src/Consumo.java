/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Consumo.java
 *
 * Created on 27 oct. 2021 At 8:16:54
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
public class Consumo {
    //*** Atributos ***
    private int kms;
    private int litros;
    private double vmed;
    private double pGas;
    
    //*** Constructores ***
    public Consumo(int kms, int litros, double vmed, double pGas){
        this.kms = kms;
        this.litros = litros;
        this.vmed = vmed;
        this.pGas = pGas;
    }
    
    //*** Metodos ***
    public double getTiempo(){
        return ((double)kms/vmed);
    }
    public double cousumoMedio(){
        return ((double)litros/kms * 100);
    }
    public double consumoEuros(){
        return ((double)litros/kms * pGas);
    }
    public int getKms(){
        return kms;
    }
    public double getVmed(){
        return vmed;
    }
    public double getPGas(){
        return pGas;
    }
}
