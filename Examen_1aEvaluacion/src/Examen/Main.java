package Examen;

import java.util.Scanner;

/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Main.java
 *
 * Created on 23 nov. 2021 At 8:06:46
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/


/**
 *
 * @author  Rogelio Rodriguez
 * @date    23 nov. 2021
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Libro l1 = new Libro();
        l1.setIsbn(4587);
        l1.setTitulo("Diferente");
        l1.setAutor("Eloy Moreno");
        l1.setNumPaginas(392);
        
        Libro l2 = new Libro();
        System.out.println("Introduzca el ISBN: ");
        l2.setIsbn(sc.nextInt());
        System.out.println("Introduzca el Titulo: ");
        sc.nextLine();
        l2.setTitulo(sc.nextLine());
        System.out.println("Introduzca el/la Autor(a): ");
        l2.setAutor(sc.nextLine());
        System.out.println("Introduzca el numero de paginas: ");
        l2.setNumPaginas(sc.nextInt());
        
        Libro l3 = new Libro(456, "La bestia", "Carmen Mola", 544);
        
        System.out.println("");
        l1.mostrarTodo();
        System.out.println("");
        l2.mostrarTodo();
        System.out.println("");
        l3.mostrarTodo();
        
        System.out.println("");
        Libro.muestraLibros();
        
        System.out.println("");
        if(l1.getNumPaginas()>l2.getNumPaginas() && l1.getNumPaginas()>l3.getNumPaginas())
            System.out.println("El libro con mas paginas es: "+l1.toString());
        else if(l2.getNumPaginas()>l3.getNumPaginas())
            System.out.println("El libro con mas paginas es: "+l2.toString());
        else
            System.out.println("El libro con mas paginas es: "+l3.toString());        
    }

}
