/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Libro.java
 *
 * Created on 23 nov. 2021 At 8:07:23
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package Examen;

import java.util.Random;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    23 nov. 2021
 * @version 1.0
 * 
 */
public class Libro {
    //*** Atributos ***
    //  constantes
    private final static int ISBN_DEF = 204;
    //  de clase
    private static int numLibros;
    //  de objeto
    private int isbn;
    private String titulo;
    private String autor;
    private int numPaginas;
    
    //*** Constructores ***
    public Libro(){
        this.isbn = ISBN_DEF;
        this.titulo = "";
        this.autor = "";
        this.numPaginas = 0;
        
        numLibros++;
    }
    
    public Libro(int isbn, String titulo, String autor, int numPaginas){
        
        if(comprobarISBN(isbn))
            this.isbn=isbn;
        else
            this.isbn=ISBN_DEF;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        
        numLibros++;
    }
    
    // Constructor extra para ISBN aleatorio
    public Libro(String titulo, String autor, int numPaginas){
        randomISBN();
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        
        numLibros++;
    }
    

    //*** Metodos ***
    //  getters y settes    
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        if(comprobarISBN(isbn))
            this.isbn = isbn;
        else
            this.isbn = ISBN_DEF;
    }   

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

    public int getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas) {    
        this.numPaginas = numPaginas;
    }

    //  privados
    //      Obtener el numero de files (F): centenas de isbn
    private int obtenerFilas() {
        if(this.isbn==0)
            return 0;
        return (this.isbn / 100);
    }
    
    //      Obtener el numero de files (C): unidad de isbn
    private int obtenerColumnas(){
        return (this.isbn % 10);
    }
    
    //      Comprobar que el ISBN es correcto: 3 cifras, centenas >=2, unidades >0
    private boolean comprobarISBN(int isbn){
        if(isbn == 0)                           // Comprobar que no es cero, para no dividir por cero
            return false;
        else if(isbn/100 < 2 || isbn/100>9)     // Comprobar que las centenas esten entre 2 y 9 (incluidos)
            return false;
        else if(isbn%10 == 0)                   // Comprobar que las unidades no sean 0
            return false;
        else                                    // Si todo esta bien, retornar true
            return true;
    }
    
    //      Metodo que genera un ISBN correcto:  3 cifras, centenas >=2, unidades >0
    private void randomISBN(){
        Random r = new Random();
        int isbn = r.nextInt(999-201)+201;      // Generar un numero aleatorio entre 201 y 999
        
        while(!comprobarISBN(isbn))             // Seguir en el bucle hasta que comprobarISBN() sea true
            isbn = r.nextInt(999-201)+201;
        
        this.isbn = isbn;
    }
    
    //      Metodo que muestra el codigo QR por pantalla
    private void mostrarQR(){
        Random r = new Random();
        int f=obtenerFilas();
        int c=obtenerColumnas();
        
        for(int i=0; i<f; i++){             // Bucle para filas
            System.out.print("|");            // Imprimir inicio de fila         
            for(int j=0; j<c; j++){             // Bucle para columnas
                if(r.nextInt(2)==0)                 // Comprobar si aleatorio es 1 o 0
                    System.out.print(" ");            //Si 0 -> " "
                else
                    System.out.print("*");            // Si 1 -> "*"
            }
            System.out.print("|");            // Imprimir fin de fila
            System.out.println("");
        }
    }
    
    //      Metodo que muestra romboide de numeros aleatorios, las suma de estos numeros y su promedio
    private void mostrarRomboide(){
        Random r = new Random();
        int f=obtenerFilas();
        int c=obtenerColumnas();
        int suma = 0;
        
        for(int i=0; i<f; i++){
            for(int a=f-i; a>1; a--)              // Imprimir espacios antes de las filas
                System.out.print(" ");
            
            for(int j=0; j<c; j++){                // Imprimir las columnas de numeros aleatorios y añadir a suma
                int rand = r.nextInt(10);
                System.out.print(rand);
                System.out.print(" ");
                suma += rand;
            }
            System.out.println("");
        }        
        float promedio = (float)suma/(f*c);
        System.out.printf("Suma total: "+suma+"      Promedio: %.2f",promedio);
    }
   
    //  publicos
    //      Mostrar objeto como string
    @Override
    public String toString(){
        return ("El libro "+this.titulo
                +" con ISBN "+this.isbn
                +" creado por el autor "+this.autor
                +" tiene "+this.numPaginas+" paginas.");
    }
    
    //      Metodo que muestra "numLibros" por pantalla
    public static void muestraLibros(){
        System.out.println("Numero de libro(s): " + numLibros);
    }
    
    //      Mostrar todo por pantalla
    public void mostrarTodo(){
        System.out.println(this.toString());
        System.out.println("Su codigo QR es:");
        mostrarQR();
        System.out.println("y ha generado el romboide ("+obtenerFilas()+"x"+obtenerColumnas()+"):");
        mostrarRomboide();
        System.out.println("");
    }
}
