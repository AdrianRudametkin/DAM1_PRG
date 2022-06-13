/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Rectangulo.java
 *
 * Created on Feb 28, 2022 At 10:50:55 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package examenprogramacion;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 28, 2022
 * @version 1.0
 * 
 */
public class Rectangulo extends Figura {    
    // ***CONSTRUCTOR***    
    public Rectangulo(int base, int altura) {
        super(base, altura);
    }
    
    // ***METODOS***
    @Override
    public double area() {
        return this.getBase() * this.getAltura();
    }

    @Override
    public double perimetro() {
        return this.getBase()*2 + this.getAltura()*2;
    }

    @Override
    public void dibujar() {
        // Elegir una figura random
        int n = (int)(Math.random() * figuras.size()+1);
        Character c = figuras.get(n);
        
        // Iterar filas
        for(int i = 0; i < this.getAltura(); i++){
            // Para la primera mitad del triangulo
            for (int j = getBase(); j > 0; j--) {
                System.out.print(c);
            }
            // Salto de linea
            System.out.println("");
        }
    }
    
    @Override
    public String toString(){
        return ("\nTipo: Rectangulo"
                + super.toString());   
    }
}
