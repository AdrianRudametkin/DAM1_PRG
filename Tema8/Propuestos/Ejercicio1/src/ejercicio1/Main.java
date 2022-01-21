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
 * Created on Jan 21, 2022 At 8:06:47 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio1;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 21, 2022
 * @version 1.0
 * 
 */
public class Main {

    public static void main(String[] args) {
        Matriz m1 = new Matriz();
        Matriz m2 = new Matriz();
        Matriz m3 = new Matriz();
        Matriz m4 = new Matriz();
        
        System.out.println("Matriz 1:");
        m1.solicitarTamanyo();
        System.out.println("Matriz 2:");
        m2.solicitarTamanyo();
        System.out.println("Matriz 3:");
        m3.solicitarTamanyo();
        System.out.println("Matriz 4:");
        m4.solicitarTamanyo();
        
        m1.asignarDatos();
        m2.asignarDatos();
        m3.asignarDatos();
        m4.asignarDatos();
        
        System.out.print("Maximo y minimo matriz 1: ");
        System.out.println(m1.maximo()+", "+m1.minimo());
        System.out.println("");
        
        System.out.print("Maximo y minimo matriz 2: ");
        System.out.println(m2.maximo()+", "+m2.minimo());
        System.out.println("");
        
        System.out.print("Maximo y minimo matriz 3: ");
        System.out.println(m3.maximo()+", "+m3.minimo());
        System.out.println("");
        
        System.out.print("Maximo y minimo matriz 4: ");
        System.out.println(m4.maximo()+", "+m4.minimo());
        System.out.println("");
        
        
        m1.sumar(m2);
        
        m1.producto(m2);
        
        m3.traspuesta();
        
    }

}
