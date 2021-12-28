/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * JuegoEnAlquiler.java
 *
 * Created on Dec 21, 2021 At 1:33:08 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejerciciopropuesto;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 21, 2021
 * @version 1.0
 * 
 */
public class JuegoEnAlquiler extends Juego implements Alquilable{
    // Valores por defecto
    private final static int DIAS_ALQUILA_DEF = 0;
    //*** ATRIBUTOS ***
    private int diasAlquila;
    
    //*** CONSTRUCTORES ***
    public JuegoEnAlquiler(){
        super();
        diasAlquila = DIAS_ALQUILA_DEF;
    }

    public JuegoEnAlquiler(String titulo, String fabricante, int anyo, double precio, int numCopias, int diasAlquila) {
        super(titulo, fabricante, anyo, precio, numCopias);
        this.diasAlquila = diasAlquila;
    }

    public JuegoEnAlquiler(JuegoEnAlquiler o) {
        super(o.getTitulo(), o.getFabricante(), o.getAnyo(),
                o.getPrecio(), o.getNumCopias());
        
        diasAlquila = o.diasAlquila;
    }

    //*** METODOS ***
    public int getDiasAlquila() {
        return diasAlquila;

    }
    public void setDiasAlquila(int diasAlquila) {    
        this.diasAlquila = diasAlquila;
    }

    @Override
    public void alquilar() {
        int copias = this.getNumCopias();
        if(copias==0)
            throw new IllegalArgumentException("No hay mas copias!");
        copias--;
        this.setNumCopias((copias));
    }

    @Override
    public void devolver() {
        int copias = this.getNumCopias();
        copias++;
        this.setNumCopias(copias);
    }

    @Override
    public double precioFinal() {
        double precio = this.getPrecio();
        
        return ((double)diasAlquila * precio);
    }
    
    @Override
    public String toString(){
        return(super.toString()+
                "\nDias alquilado: "+diasAlquila+(diasAlquila==1?" dia":" dias"));
    }
}
