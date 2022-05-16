package objetos;

public class Libro {
    // ***ATRIBUTOS***
    private String titulo;
    private String autor;
    private String editorial;
    private boolean prestado;
    private int pasillo;
    private String isbn;
    private double precio;
    private Empleado empleado;
    private Usuario usuario;

    // ***CONSTRUCTORES***

    /**
     * Constructor que inicializa todos los parámetros.
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
        empleado = null;
        usuario = null;
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
        empleado = null;
        usuario = null;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario empleado) {
        this.usuario = usuario;
    }

    @Override
    public String toString(){
        String alquilado = "";
        if(prestado){
            alquilado = "\n -> Alquilado a \""+ usuario +"\" por \""+ empleado +"\".";
        }else{
            alquilado = "\n -> Se encuentra en el pasillo Nº"+pasillo+".";
        }
        return ("\n ·\""+titulo+"\" por "+autor+ ", Editorial: "+editorial+"" +
                "\n ·ISBN: "+isbn+"" + ", Precio: "+precio+"€"+
                 alquilado);
    }
}
