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
 * Created on 5 nov. 2021 At 11:31:27
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/


/**
 *
 * @author  Rogelio Rodriguez
 * @date    5 nov. 2021
 * @version 1.0
 * 
 */
public class Persona {
    // *** ATRIBUTOS ***
    private final char SEXO_DEFAULT = 'H';
    // De clase:
    private static int numPersonas;    // Contador de objetos Persona
    // De objeto:
    private String  nombre;
    private int     edad;
    private char    sexo;          // Solo un caracter: 'H' o 'M'
    private double  peso;
    private double  altura;
    
    // *** CONSTRUCTORES ***
    public Persona(){
        this.nombre = "";
        this.edad   = 0;
        this.sexo   = SEXO_DEFAULT;
        this.peso   = 0.0;
        this.altura = 0.0;
        
        numPersonas++;
    }
    
    public Persona(String nombre, int edad, char sexo){
        this.nombre = nombre;
        this.edad   = edad;
        comprobarSexo(sexo);
        this.peso   = 0.0;
        this.altura = 0.0;
        
        numPersonas++;
    }
    
    public Persona(String nombre, int edad, char sexo, double peso, double altura){
        this.nombre = nombre;
        this.edad   = edad;
        comprobarSexo(sexo);
        this.peso   = peso;
        this.altura = altura;
        
        numPersonas++;
    }
    
    // *** METODOS ***
    // getters and settes (de objeto)
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getEdad(){
        return this.edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public char getSexo(){
        return this.sexo;
    }
    public void setSexo(char sexo){
        comprobarSexo(sexo);
    }
    
    public double getPeso(){
        return this.peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    
    public double getAltura(){
        return this.altura;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    // getter de clase
    public int getNumPersonas(){
        return this.numPersonas;
    }
    
    // Calcular si es mayor de edad
    public boolean esMayorDeEdad(){
        return edad>18;
    }
    
    // Compobar que el sexo sea el correcto (metodo interno)
    private void comprobarSexo(char sexo){
        if(sexo == 'H' || sexo == 'M'){
            this.sexo = sexo;
        }else{
            this.sexo = SEXO_DEFAULT;
        }
    }
    
    // Calcular el IMC: IMC = (peso en kilos)/(altura en m)^2
    public int calcularIMC(){
        double imc = this.peso/Math.pow(this.altura, 2.0);
        if(imc < 20)
            return -1;
        else if(imc > 25)
            return 1;
        else
            return 0;
        
    }
    
    // Devolver cadena de la informacion del paciente
    @Override
    public String toString(){
        return("\nPaciente: "+this.nombre+
                "\nEdad: "+this.edad+" años"+
                "\nSexo: "+this.sexo+
                "\nPeso: "+this.peso+" kg"+
                "\nAltura: "+this.altura+" metros");
    }
}
