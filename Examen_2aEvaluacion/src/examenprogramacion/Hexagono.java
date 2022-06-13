/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Hexagono.java
 *
 * Created on Feb 28, 2022 At 10:46:47 AM
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
public class Hexagono extends Figura{    
    // ***CONSTRUCTOR***
    public Hexagono(int base, int altura) {
        super(base, altura);
    }

    // ***METODOS***
    @Override
    public double area() {
        // Calculamos la apotema
        double apotema = 6 * this.getBase();
        
        return apotema*(this.getAltura()/2)/2;
    }

    @Override
    public double perimetro() {
        return this.getBase() * 6;
    }

    @Override
    public void dibujar() {
        // Elegir una figura random
        int n = (int)(Math.random() * figuras.size()+1);
        Character c = figuras.get(n);
        
        System.out.println("");
        // Parte superior
        for(int i = 0; i < this.getAltura()/2; i++){
            // Espacios del triangulo izquierdo
            for(int j = i; j<this.getAltura()/2; j++){
                System.out.print(" ");
            }
            // Triangulo izquierdo
            for(int j = 0; j<i; j++){
                System.out.print(c);
            }
            // Rectangulo entre los subtriangulos
            for(int j = 0; j<this.getAltura(); j++){
                System.out.print(c);
            }
            // Triangulo derecho
            for(int j = 0; j<i; j++){
                System.out.print(c);
            }
            // Salto de linea
            System.out.println("");
        }
        // Parte inferior
        for(int i = this.getAltura()/2; i > 0; i--){
            // Espacios del triangulo izquierdo
            for(int j = i; j<this.getAltura()/2; j++){
                System.out.print(" ");
            }
            // Triangulo izquierdo
            for(int j = 0; j<i; j++){
                System.out.print(c);
            }
            // Rectangulo entre los subtriangulos
            // Rectangulo entre los subtriangulos
            for(int j = 0; j<this.getAltura(); j++){
                System.out.print(c);
            }
            // Triangulo derecho
            for(int j = i; j>0; j--){
                System.out.print(c);
            }
            // Salto de linea
            System.out.println("");
        }
        System.out.println("");
    }
    
    @Override
    public String toString(){
        return ("\nTipo: Hexagono"
                + super.toString());
    }
}
