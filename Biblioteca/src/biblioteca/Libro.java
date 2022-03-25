package biblioteca;

public class Libro {
    // ***ATRIBUTOS***
    private String titulo;
    private String autor;
    private String editorial;
    private boolean prestado;
    private int pasillo;
    private String isbn;
    private double precio;
    private String nombrePrestador;
    private String nombreAcogedor;

    // ***CONSTRUCTORES***

    /**
     * Contructor que inicializa todos los parámetros.
     * @param titulo            título del libro
     * @param autor             autor del libro
     * @param editorial         editorial del libro
     * @param pasillo           ubicación del libro (pasillo en la biblioteca)
     * @param isbn              ISBN del libro
     * @param precio            precio del libro en €
     */
    public Libro(String titulo, String autor, String editorial, int pasillo, String isbn, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.pasillo = pasillo;
        this.isbn = isbn;
        this.precio = precio;
        prestado = false;
        nombrePrestador = null;
        nombreAcogedor = null;
    }

    /**
     * Constructor con valores nulos
     */
    public Libro() {
        titulo = null;
        autor = null;
        editorial = null;
        prestado = false;
        pasillo = 0;
        isbn = null;
        precio = 0;
        nombrePrestador = null;
        nombreAcogedor = null;
    }

    // ***MÉTODOS***
    //  getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombrePrestador() {
        return nombrePrestador;
    }

    public void setNombrePrestador(String nombrePrestador) {
        this.nombrePrestador = nombrePrestador;
    }

    public String getNombreAcogedor() {
        return nombreAcogedor;
    }

    public void setNombreAcogedor(String nombreAcogedor) {
        this.nombreAcogedor = nombreAcogedor;
    }

    @Override
    public String toString(){
        String alquilado = "";
        if(prestado){
            alquilado = "\n Alquilado a '"+nombreAcogedor+"' por '"+nombrePrestador+"'";
        }else{
            alquilado = "\n Se encuentra en el pasillo Nº"+pasillo+".";
        }
        return ("\n-\""+titulo+"\" por "+autor+
                "\n-Editorial "+editorial+"" +
                "\n-ISBN "+isbn+"" +
                "\n-Precio "+precio+"€"+
                alquilado);
    }
}
