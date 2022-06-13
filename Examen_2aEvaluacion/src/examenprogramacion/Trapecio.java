/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Trapecio.java
 *
 * Created on Feb 28, 2022 At 10:39:05 AM
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
public class Trapecio extends Figura{
    // ***ATRIBUTOS***
    private int Base;
    
    // ***CONSTRUCTOR***

    public Trapecio(int base, int altura, int Base) throws IllegalArgumentException {
        super(base, altura);
        comprobarTrapecio(Base);
        this.Base = Base;
        
    }
    
    

    // ***METODOS***
    //  getters y setters
    public int getBASE() {    
        return Base;
    }
    public void setBASE(int Base) { 
        comprobarTrapecio(Base);
        this.Base = Base;
    }

    @Override
    public double area() {
        return((Base+this.getBase())*this.getAltura())/2;
    }

    @Override
    public double perimetro() {
        // Buscamos la longitud del lado no conocido del trapecio: a partir de la base y la altura.
        // Los dos lados (al cuadrado) del subtriangulo rectangulo; la base es la mitad de la resta entre las bases
        double base2 = Math.pow((this.getBase()-Base)/2, 2) / 2;
        double altura2 = Math.pow(this.getAltura(), 2);
        
        // Aplicamos teorema de pitagoras
        double lado = Math.sqrt(base2 + altura2);
        
        // Calculamos el perimetro como la suma de los lados.
        return lado * 2 + this.getBase() + Base;
    }

    @Override
    public void dibujar() {
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
            // Cuadrado del centro
            for(int j = 0; j<this.getAltura(); j++){
                System.out.print(c);
            }
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
        return ("\nTipo: Trapecio"
                + super.toString()
                + "\n -Base (grande): " + Base);
    }

    private void comprobarTrapecio(int Base) {
        if(this.getBase() > Base){
            throw new IllegalArgumentException("No es un trapecio correcto.");
        }else if(this.getBase() == Base){
            throw new IllegalArgumentException("Mejor utiliza la clase rectangulo.");
        }
    }
}
