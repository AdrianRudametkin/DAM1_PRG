/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Password.java
 *
 * Created on Nov 14, 2021 At 10:34:01 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio3;

import java.util.Random;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Nov 14, 2021
 * @version 1.0
 * 
 */
public class Password {
    // *** Atributos ***
    //  Atributos constantes
    private final int LONGITUD_DEF = 8;
    //  Atributos de clase
    private int longitud;
    private String contrasenya;
    
    // *** Constructores ***
    public Password(){
        this.longitud = this.LONGITUD_DEF;
        this.contrasenya = generarPassword();
    }
    
    public Password(int longitud){
        this.longitud = longitud;
        this.contrasenya = generarPassword();
    }
    
    // *** Metodos ***
    //  Getters & Setters
    public int getLongitud(){
        return this.longitud;
    }
    public void setLongitud(int longitud){
        this.longitud = longitud;
        this.contrasenya = generarPassword();
    }
    
    public String getContrasenya(){
        return this.contrasenya;
    }
    
    //  Metodos publicos
    //      Metodo que genera una contraseña aleatoria de una longitud
    private String generarPassword(){
        Random r = new Random();
        String pswd = "";
        
        for(int i=0; i<this.longitud; i++){
            // Los caracteres que queremos en UNICODE van de d48 a d122 (exluyendo 58-64 y 91-96)
            int ch = (r.nextInt(75)+48);        // *75 para incluir el 74º numero
            
            while((ch>=58&&ch<=64) || (ch>=91&&ch<=96))
                ch = (r.nextInt(75)+48);
            
            pswd += (char)ch;   
        }
        
        return pswd;
    }
}
