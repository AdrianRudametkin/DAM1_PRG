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
 * Created on Dec 17, 2021 At 11:37:01 AM
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
public class Main {

    public static void main(String[] args) {
        Pelicula p1,p2,p3;
        Disco d1,d2,d3;
        
        p1 = new Pelicula("DEF", "Alvaro", 
                Formato.mov, 180, null, "Marta");
        p2 = new Pelicula("DEF", "Alvaro", 
                Formato.avi, 200.5, "Ramon", "Marta");
        p3 = new Pelicula("ABC", "Alvaro", 
                Formato.mpg, 90.1, "Ramon", null);
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println("----------------------");
        System.out.println("P1==P2: "+p1.equals(p2));
        System.out.println("P1==P3: "+p1.equals(p3));

        // Da error
        //p1.setActrizP(null);
        d1 = new Disco("Titulo random", "Autor random", 
                Formato.wav, 3.43, Genero.opera);
        d2 = new Disco("Titulo random", "Autor random", 
                Formato.cdAudio, 6.5, Genero.rock);
        d3 = new Disco("Titulo otro", "Autor random", 
                Formato.dvd, 10.01, Genero.pop);
        
        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(d3.toString());
        System.out.println("----------------------");
        System.out.println("D1==D2: "+d1.equals(d2));
        System.out.println("D1==D3: "+d1.equals(d3));

        
    }

}
