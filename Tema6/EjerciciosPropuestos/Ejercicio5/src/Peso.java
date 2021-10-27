/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

 /*
 *
 * Peso.java
 *
 * Created on Oct 26, 2021 At 10:33:53 PM
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
public class Peso {

    //*** Atributos Constantes ***
    private final double LB_KG = 0.453;
    private final double LI_KG = 14.59;
    private final double OZ_KG = 0.02835;
    private final double P_KG = 0.00155;
    private final double Q_KG = 43.3;
    //*** Atributos ***
    private double peso;

    //*** Constructores ***
    public Peso(double peso, String unidad) {
        switch(unidad.toLowerCase()) {
            case "lb":
                this.peso = peso * LB_KG;
                break;
            case "li":
                this.peso = peso * LI_KG;
                break;
            case "oz":
                this.peso = peso * OZ_KG;
                break;
            case "p":
                this.peso = peso * P_KG;
                break;
            case "q":
                this.peso = peso * Q_KG;
                break;
            case "k":
                this.peso = peso;
                break;
            case "g":
                this.peso = peso * 1000.0;
                break;
            default:
                this.peso = 0.0;
        }
    }

    //*** Metodos ***
    public double getLibras() {
        return (this.peso / LB_KG);
    }

    public double getLingotes() {
        return (this.peso / LI_KG);
    }

    public double getPeso(String unidad) {
        switch(unidad.toLowerCase()) {
            case "lb": return this.peso / LB_KG;
            case "li": return this.peso / LI_KG;
            case "oz": return this.peso / OZ_KG;
            case "p": return this.peso / P_KG;
            case "q": return this.peso / Q_KG;
            case "k": return this.peso;
            case "g": return this.peso * 1000.0;
            default: return -1.0;
        }
    }
}
