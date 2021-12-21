/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Juego.java
 *
 * Created on Dec 21, 2021 At 12:46:44 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejerciciopropuesto;

import java.util.Calendar;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 21, 2021
 * @version 1.0
 * 
 */
public abstract class Juego {
    // VALORES POR DEFECTO
    private static final String DEF_TITULO = "Sin Titulo";
    private static final String DEF_FABRICANTE = "Desconocido";
    private static final int DEF_ANYO = 1970;
    private static final double DEF_PRECIO = 0;
    private static final int DEF_NUMCOPIAS = 0;
    
    //*** ATRIBUTOS ***
    //  De clase:
    private static int numJuegos;
    //  De objeto:
    private String titulo;
    private String fabricante;
    private int anyo;
    private double precio;
    private int numCopias;
    
    //*** CONSTRUCTORES ***
    public Juego(){
        titulo = DEF_TITULO;
        fabricante = DEF_FABRICANTE;
        anyo = DEF_ANYO;
        precio = DEF_PRECIO;
        numCopias = DEF_NUMCOPIAS;
        
        numJuegos++;
    }

    public Juego(String titulo, String fabricante, int anyo, double precio, int numCopias) {
        this.titulo = titulo;
        this.fabricante = fabricante;
        comprobarAnyo(anyo);
        this.precio = precio;
        this.numCopias = numCopias;
        
        numJuegos++;
    }
    
    //*** METODOS ***
    //  Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }
    
    

    public static int getNumJuegos() {
        return numJuegos;
    }
    
    // Metodo que comprueba si el año introducido es correto
        // Solo utilizable en esta clase y no se puede sobreescribir
    private void comprobarAnyo(int anyo){
        if(anyo<1970 || anyo>Calendar.getInstance().get(Calendar.YEAR))
            this.anyo = DEF_ANYO;
        else
            this.anyo = anyo;
    }
    
    // Metodo que devuelve informacion del objeto como String
    @Override
    public String toString(){
        return ("\nTitulo: "+titulo+
                "\nFabricante: "+fabricante+
                "\nAño: "+anyo);
    }
    
    // Metodo que comprueba si un objeto de la misma clase son iguales es igual
    // a este.
    public boolean equals(Juego o){
        return (titulo.equals(o.titulo) &&
                fabricante.equals(o.fabricante) &&
                anyo==o.anyo);
    }
    
    // Metodo que compruba si otro objeto de la misma clase es menor(1), 
    // mayor (-1) o igual (0) a este.
    public int compareTo(Juego o){
        
        if(titulo.compareTo(o.titulo)>0) return 1;
        else if(titulo.compareTo(o.titulo)<0) return -1;
        else{
            if(fabricante.compareTo(o.fabricante)>0) return 1;
            else if(fabricante.compareTo(o.fabricante)<0) return -1;
            else{
                if(anyo > o.anyo) return 1;
                else if(anyo < o.anyo) return -1;
                else return 0;
            }  
        }
    }
    
}
