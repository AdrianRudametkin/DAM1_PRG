/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Publicacion.java
 *
 * Created on Dec 14, 2021 At 1:12:54 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio3;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 14, 2021
 * @version 1.0
 * 
 */
public class Publicacion {
    private int codigo;
    private String titulo;
    private int anyo;
    
    public Publicacion(int codigo, String titulo, int anyo){
        this.codigo = codigo;
        this.titulo = titulo;
        this.anyo = anyo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
    
    @Override
    public String toString(){
        return ("\n·Titulo: "+this.titulo+
                "\n·Codigo: "+this.codigo+
                "\n·Año: "+this.anyo);
        
    }
}
