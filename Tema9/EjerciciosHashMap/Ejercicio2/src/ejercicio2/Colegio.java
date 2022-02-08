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
public class Colegio {
    // ***ASTRIBUTOS***
    private HashMap<String, Integer>  nacionalidades = new HashMap();
    
    // ***METODOS***
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
    
    public void showAll(){
        System.out.println("::NACIONALIDADES::"
                + "Pais\tNº Alumnos");
        nacionalidades.entrySet().forEach(e->{
            System.out.println(e.getKey()+"\t"+e.getValue());
        });
    }
    
    public void showNacionalidad(String nacionalidad){
        // Ponerlo en mayusculas
        nacionalidad = nacionalidad.toUpperCase();
        // Comprobar que exista la nacionalidad
        if(nacionalidades.containsKey(nacionalidad)){
            // Si existe, añadir 1 al total
            System.out.println(": ");
        }else{
            // Si no existe, añadir a la lista
            nacionalidades.put(nacionalidad, 1);
        }
    }
    
    public void cuantos(){
        
    }
    
    public void borrarNacionalidad(){
        
    }
    
    public void borrarAll(){
        nacionalidades.clear();
    }
}
