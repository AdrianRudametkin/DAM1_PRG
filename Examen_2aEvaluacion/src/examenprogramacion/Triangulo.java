/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Triangulo.java
 *
 * Created on Feb 28, 2022 At 8:26:15 AM
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
public class Triangulo extends Figura{
    // ***CONSTRUCTOR***
    public Triangulo(int base, int altura) {
        super(base, altura);
    }
    
    // ***METODOS***
    /**
     * Metodo que calcula el area de un triangulo.
     * @return area
     */
    @Override
    public double area() {
        return (double)(this.getBase()*this.getAltura())/2;
    }

    /**
     * Metodo que calcula el perimetro de un triangulo. 
     * Solo pueden ser equilateros o isosceles; en cuyo caso se supone "base" el lado desigual del triangulo.
     * @return perimetro
     */
    @Override
    public double perimetro() {
        // Buscamos la longitud del lado no conocido del triangulo: a partir de la base y la altura.
        // Los dos lados al cuadrado del subtriangulo rectangulo
        double base2 = Math.pow((double)this.getBase()/2, 2);
        double altura2 = Math.pow(this.getAltura(), 2);
        
        // Aplicamos teorema de pitagoras
        double lado = Math.sqrt(base2 + altura2);
        
        // Calculamos el perimetro como la suma de los lados.
        return lado * 2 + this.getBase();
    }
    
    /**
     * Metodo que muestra por pantalla el triangulo. Para que se muestre
     * bien el triangulo, la base tiene que ser mas o menos el doble de la altura.
     * Esto es una limitacion de las capacidades de mostrar figuras utlizando caracteres.
     */
    @Override
    public void dibujar(){
        // Elegir una figura random
        int n = (int)(Math.random() * figuras.size()+1);
        Character c = figuras.get(n);
        
        System.out.println("");
        // Iterar filas
        for(int i = 0; i < this.getAltura(); i++){
            // Espacios de la primera mitad
            for(int j = i; j<this.getAltura(); j++){
                System.out.print(" ");
            }
            // Para la primera mitad del triangulo
            for(int j = 0; j<i; j++){
                System.out.print(c);
            }
            // Linea del centro
            System.out.print(c);
            for(int j = 0; j<i; j++){
                System.out.print(c);
            }
            // Salto de linea
            System.out.println("");
        }
        System.out.println("");
    }
    
    @Override
    public String toString(){
        return ("\nTipo: Triangulo"
                + super.toString());
    }
}
