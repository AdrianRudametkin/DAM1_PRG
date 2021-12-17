/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Pelicula.java
 *
 * Created on Dec 17, 2021 At 11:52:07 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio2;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 17, 2021
 * @version 1.0
 * 
 */
public class Pelicula extends Multimedia{
    private String actorP;
    private String actrizP;

    public Pelicula(String titulo, String autor, Formato formato, double duracion, 
            String actorP, String actrizP) {
        super(titulo, autor, formato, duracion);
        if(actorP==null && actrizP==null || actrizP.equals("")&&actorP.equals(""))
            throw new IllegalArgumentException("Ambos atributos no puden estar vacios!");
        
        this.actorP = actorP;
        this.actrizP  = actrizP;
    }

    public String getActorP() {
        return actorP;
    }

    public void setActorP(String actorP) {
        if(actorP==null && actrizP==null)
            throw new IllegalArgumentException("Ambos atributos no puden estar vacios!");
        
        this.actorP = actorP;
    }

    public String getActrizP() {
        return actrizP;
    }

    public void setActrizP(String actrizP) {
        if(actorP==null && actrizP==null)
            throw new IllegalArgumentException("Ambos atributos no puden estar vacios!");
        
        this.actrizP = actrizP;
    }
   
    
    
    @Override
    public String toString(){
        return (super.toString()+
                "\nActor Principal: "+actorP+
                "\nActriz Principal:"+actrizP);
    }
}
