/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Multimedia.java
 *
 * Created on Dec 17, 2021 At 11:37:22 AM
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
public abstract class Multimedia {
    private String titulo;
    private String autor;
    private Formato formato;
    private double duracion;

    public Multimedia(String titulo, String autor, Formato formato, double duracion) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    
    
    @Override
    public String toString(){
        return ("\nTitulo: "+titulo+
                "\nAutor: "+autor+
                "\nFormato: "+formato+
                "\nDuracion: "+duracion);
    }
    
    public boolean equals(Multimedia o){
        return ((o.autor.equals(this.autor)) && (o.titulo.equals(this.titulo)));
    }
}
