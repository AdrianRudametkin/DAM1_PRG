package persona;

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
 * Viajero.java
 *
 * Created on 26 oct. 2021 At 10:32:40
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
 */
/**
 *
 * @author  Rogelio Rodriguez
 * @date 26 oct. 2021
 * @version 1.0
 *
 */
public class Viajero {
    private static int numViajeros;
    
    private String dni;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String direccion;

    // Constructors
    public Viajero() {
        this.dni = null;
        this.nombre = null;
        this.apellidos = null;
        this.nacionalidad = null;
        this.direccion = null;
        this.numViajeros++;
    }

    public Viajero(String dni, String nombre, String apellidos, String nacionalidad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.numViajeros++;
    }

    // Getters y setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static int getNumViajeros() {
        return numViajeros;
    }  
    
    // Metodo que retorna informacion del viajero
    public void getInfo(String Formato){
        if(Formato.equalsIgnoreCase("normal")){
            System.out.println("El viajero se llama "+this.nombre+" "+this.apellidos);
            System.out.println("DNI: "+this.dni);
            System.out.println("Vive en "+this.direccion+".");
            System.out.println("Es de "+this.nacionalidad+".");
        }else if(Formato.equalsIgnoreCase("pausado")){
            Scanner s = new Scanner(System.in);
            
            System.out.print("El viajero se llama "+this.nombre+" "+this.apellidos);
            s.nextLine();
            System.out.print("DNI: "+this.dni);
            s.nextLine();
            System.out.print("Vive en "+this.direccion+".");
            s.nextLine();
            System.out.print("Es de "+this.nacionalidad+".");
            s.nextLine();
        }else{
            System.out.print("Ese formato NO EXISTE!!!");
        }
    }
}
