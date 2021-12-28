/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Test.java
 *
 * Created on Dec 28, 2021 At 12:34:51 PM
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
 * @date    Dec 28, 2021
 * @version 1.0
 * 
 */
public class Test {
    public static void main(String[] args) {
        JuegoEnAlquiler ja1 = new JuegoEnAlquiler("Mario Bros", "Nintendo", 1986, 5, 10, 2);
        JuegoEnVenta jv1 = new JuegoEnVenta("Mario Bros", "Nintendo", 1986, 40, 10);
        JuegoEnVenta jv2 = new JuegoEnVenta("Mario Bros", "Nintendo", 1985, 35, 10);
        
        // Crea una copia de ja1 a ja2
        print("COPIANDO ja1 A ja2");
        JuegoEnAlquiler ja2 = new JuegoEnAlquiler(ja1);
        
        // Mostrar por pantall el numero total de juegos en el salor
        print("MOSTRANDO POR PANTALLA numero total de juegos");
        System.out.println(ja1.getNumJuegos());
        
        // Alquilar ja1
        print("ALQUILANDO EN ja1");
        ja1.alquilar();
        System.out.println("Numero copias: "+ja1.getNumCopias());
        
        // Comprobar si ja1 y jv1 son iguales
        print("COMPROBANDO IGUALDAD entre ja1 y jv1");
        System.out.println("Son igules: "+ja1.equals(jv1));
        
        // Comprobar si ja1 y jv2 son iguales
        print("COMPROBANDO IGUALDAD entre ja1 y jv2");
        System.out.println("Son igules: "+ja1.equals(jv2));
        
        // Comparando jv1 con jv2
        print("COMPARACION entre jv1 y jv2");
        if(jv1.compareTo(jv2)>0)
            System.out.println("jv1 es mayor");
        else if(jv1.compareTo(jv2)<0)
            System.out.println("jv2 es mayor");
        else
            System.out.println("Son iguales");
        
        // Comparando ja1 con jv1
        print("COMPARACION entre ja1 y jv1");
        if(ja1.compareTo(jv1)>0)
            System.out.println("ja1 es mayor");
        else if(ja1.compareTo(jv1)<0)
            System.out.println("jv1 es mayor");
        else
            System.out.println("Son iguales");
    }
    
    private static void print(String s){
        System.out.println("\n"+s);
        for(int i=0; i<s.length(); i++){
            System.out.print("*");
        }
        System.out.println("");
    }
}
