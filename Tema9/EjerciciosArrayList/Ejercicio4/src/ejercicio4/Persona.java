/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Persona.java
 *
 * Created on Feb 7, 2022 At 8:22:55 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio4;

import java.util.ArrayList;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Feb 7, 2022
 * @version 1.0
 * 
 */
public class Persona {
    // ***ATRIBUTOS***
    //  de clase
    private static ArrayList<String> dni_asignados = new ArrayList<String>();
    //  de objeto
    private final String DNI;   // No se podra modificar el DNI una vez asignado
    private String nombres;
    private String apellidos;
    private String sexo;          // mujer (M), hombre (H), otro (X)
    private int edad;           // mayor que 0
    
    // ***CONSTRUCTORES***

    public Persona(String nombres, String apellidos, String sexo, int edad) {
        this.DNI = asignarDNI();
        this.nombres = nombres;
        this.apellidos = apellidos;
        comprobarSexo(sexo);
        comprobarEdad(edad);
    }
    
    public Persona(){
        this.DNI = asignarDNI();
        this.nombres = null;
        this.apellidos = null;
        this.sexo = null;
        this.edad = 0;
    }
    
    // ***METODOS***
    //  setters y getters
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        comprobarSexo(sexo);
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) { 
        comprobarEdad(edad);
    }

    public String getDNI() {
        return DNI;
    }
    
    //  metodos privados
    private String asignarDNI() {
        boolean hayDni;
        String new_dni;
        if(dni_asignados == null){
            
        }
        
        do{
            new_dni = generarDNI();     // Generar nuevo dni
            hayDni = true;              // hay dni
            for(String dni: dni_asignados){
                if(dni.equalsIgnoreCase(new_dni)){
                    hayDni = false;     // Si hay uno igual en la lista, ya no hay dni
                    break;              // Volver al bucle while
                }
            }
            
            // Si dni no existe en la lista:
            if(hayDni){
                dni_asignados.add(new_dni); // Introduirlo en la lista
                return new_dni;             // Devolver el dni nuevo
            }
        }while(!hayDni);
        
        return null;    // Devolver null si hubo un error
    }
    
    private String generarDNI(){
        int numero = (int)(Math.random()*(99999999-10000000)+10000000);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numero%23;
        
        return (String.valueOf(numero)+letras.charAt(resto));
    }
    
    private void comprobarSexo(String sexo){
        if(sexo.equalsIgnoreCase("H")||
                sexo.equalsIgnoreCase("M")||
                sexo.equalsIgnoreCase("X")){
            this.sexo = sexo;
        }else{
            System.out.println("Los sexos validos son 'M'(Mujer), 'H'(Hombre) y 'X'(Otro)");
            this.sexo = null;
        }
    }
    
    private void comprobarEdad(int edad) {
        if(edad>=0){
            this.edad = edad;
        }else{
            System.out.println("No puedes tener menos de 0 años...");
            this.edad = -1;
        }    
    }
    
    //  metodos publicos
    @Override
    public String toString(){
        return ("\n"+DNI+"   ["+sexo.toUpperCase()+"] - "
                +apellidos.toUpperCase()+", "+nombres.toUpperCase()+" - "
                +edad+" años");
    }
    
    public void matarPersona(){
        dni_asignados.remove(DNI);
    }
}
