/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Colegio.java
 *
 * Created on Feb 8, 2022 At 1:35:11 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio2;

import java.util.HashMap;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 8, 2022
 * @version 1.0
 * 
 */
/**
 * Clase que guarda una lista de nacionalidades de un colegio junto con el
 * numero de alumnos que pertenecen a esa nacionalidad.
 * @author Rogelio Rodriguez
 */
public class Colegio {
    // ***ASTRIBUTOS***
    private HashMap<String, Integer>  nacionalidades = new HashMap();
    
    // ***METODOS***
    /**
     * Metodo que añade la nacionalidad del alumno a la lista: 
     * si su nacionalidad ya existe se incrementara el numero de esa nacionalidad.
     * @param nacionalidad Introducir la nacionalidad del alumno nuevo.
     */
    public void addAlumno(String nacionalidad){
        // Ponerlo en mayusculas
        nacionalidad = nacionalidad.toUpperCase();
        // Revisar si la nacionalidad ya existe
        if(nacionalidades.containsKey(nacionalidad)){
            // Si existe, añadir 1 al total
            int num = nacionalidades.get(nacionalidad) + 1;
            nacionalidades.replace(nacionalidad, num);
        }else{
            // Si no existe, añadir a la lista
            nacionalidades.put(nacionalidad, 1);
        }
    }
    
    /**
     * Metodo que imprime por pantalla la nacionalidades del colegio y la
     * cantidad de alumnos que pertenecen a ella.
     */
    public void showAll(){
        System.out.print("\n::NACIONALIDADES::"
                + "\nNº Alumnos\tPais"
                + "\n----------\t------");
        nacionalidades.entrySet().forEach(e->{
            System.out.print("\n    "+e.getValue()+"\t\t"+e.getKey());
        });
        System.out.println("");
    }
    
    /**
     * Metodo que imprime por pantalla el numero de alumnos de la nacionalidad 
     * introducida.
     * @param nacionalidad Nacionalidad de la que se quiere saber el numero de alumnos.
     */
    public void showNacionalidad(String nacionalidad){
        // Ponerlo en mayusculas
        nacionalidad = nacionalidad.toUpperCase();
        // Comprobar que exista la nacionalidad
        if(nacionalidades.containsKey(nacionalidad)){
            // Si existe, mostar numero de alumnos con esa nacionalidad
            System.out.println("Hay "+nacionalidades.get(nacionalidad)
                    +" nacionales de "+nacionalidad+" en el colegio.");
        }else{
            System.out.println("No hay alumnos nacionales de "+nacionalidad+" en el colegio.");
        }
    }
    
    /**
     * Metodo que muestra por pantalla el numero de nacionalidades distintas que 
     * hay en el colegio.
     */
    public void cuantos(){
        // Muestra el numero de nacionalidades distintas
        System.out.println("Hay "+nacionalidades.size()+
                (nacionalidades.size()==1?" nacionalidad": " nacionalidades")+" en el colegio.");
    }
    
    /**
     * Metodo que borra de la lista la nacionalidad introducida.
     * @param nacionalidad Nacionalidad que se quiera borrar de la lista.
     */
    public void borrarNacionalidad(String nacionalidad){
        // Ponerlo en mayusculas
        nacionalidad = nacionalidad.toUpperCase();
        // Comprobar que exista la nacionalidad
        if(nacionalidades.containsKey(nacionalidad)){
            // Si existe, borrar la nacionalidad
            nacionalidades.remove(nacionalidad);
            System.out.println("Nacionalidad de "+nacionalidad+" borrada...");
        }else{
            System.out.println("No hay alumnos de "+nacionalidad+" en el colegio.");
        }
    }
    
    /**
     * Metodo que borra todas las nacionalidades de la lista.
     */
    public void borrarAll(){
        nacionalidades.clear();
    }
}
