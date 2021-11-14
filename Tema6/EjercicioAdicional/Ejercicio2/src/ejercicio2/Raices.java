/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Raices.java
 *
 * Created on Nov 14, 2021 At 10:04:43 PM
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
 * @date    Nov 14, 2021
 * @version 1.0
 * 
 */
public class Raices {
    // *** Atributos ***
    //  Atributos de objeto
    private double a;
    private double b;
    private double c;
    
    // *** Constructores ***
    public Raices(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    // *** Metodos ***
    //  Metodos publicos
    //      Metodo que muestra por pantalla la solucion
    public void calcular(){
        if(tieneRaices())
            obtenerRaices();
        else if(tieneRaiz())
            obtenerRaiz();
        else
            System.out.println("Los parametros no tiene solucion real ʅ(°-°)ʃ");
    }
    
    //  Metodos privados
    //      Metodo que muestra por pantalla las dos posibles soluciones
    private void obtenerRaices(){
        double r1,r2;
        // La formula de las raices es: (-b±√((b^2)-(4*a*c)))/(2*a)
        r1 = (-b + Math.sqrt( ((b*b) - 4*a*c)) ) / (2*a);
        r2 = (-b - Math.sqrt( ((b*b) - 4*a*c)) ) / (2*a);
        
        System.out.printf("El primer resultado es: %.2f\n", r1);
        System.out.printf("El segundo es: %.2f\n", r2);
    }
    
    //      Metodo que muestra una unica raiz (cuando solo halla una solucion)
    private void obtenerRaiz(){
        double r = (-b) / (2*a);        // Se simplifica porque ±√((b^2)-(4*a*c))) = 0
        
        System.out.printf("La solucion es: %.2f\n",r);
    }
    
    //      Metodo que devuelve el valor de: (b^2) - 4*a*c
    private double getDiscriminate(){
        return ((b*b) - 4*a*c);
    }
    
    //      Metodo que devuelve TRUE si tiene dos soluciones (discriminate > 0)
    private boolean tieneRaices(){
        return getDiscriminate()>0;
    }
    
    //      Metodo que devuelve TRUE si tiene una soluciones (discriminate = 0)
    public boolean tieneRaiz(){
        return getDiscriminate()==0;
    }
    
}
