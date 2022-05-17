package objetos;

import java.io.Serializable;

import static sistema.Utilidades.*;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private String editorial;
    private int pasillo;
    private String isbn;
    private double precio;
    private Usuario usuario;
    private Empleado empleado;
    private boolean prestado;
    static final long serialVersionUID = 98712938741L;

    public Libro(String titulo, String autor, String editorial, int pasillo, String isbn, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.pasillo = pasillo;
        this.isbn = isbn;
        this.precio = precio;
        this.usuario = null;
        this.empleado = null;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getPasillo() {
        return pasillo;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar(Empleado e, Usuario u){
        this.empleado = e;
        this.usuario = u;
        this.prestado = true;
    }

    public void devolver(){
        this.empleado = null;
        this.usuario = null;
        this.prestado = false;
    }

    public String toString(){
        String p = "";
        if(isPrestado())
            p = "Prestado por "+empleado.getNombre()+" a "+usuario.getNombre();

        return "\n\""+titulo+"\" por "+autor+". Editorial "+editorial+""+
                ". \nISBN:[" + isbn + "] Precio: "+df.format(precio)+"€ Ubicación: pasillo nº "+pasillo+
                "\n"+p;
    }
}
