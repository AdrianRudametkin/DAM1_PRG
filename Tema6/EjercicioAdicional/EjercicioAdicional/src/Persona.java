
import java.util.Random;

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
    //  Constantes: 
    private static final char 	SEXO_DEFAULT 	= 'H';
    public static final int	SOBREPESO	= 1;
    public static final int	BAJOPESO	= -1;
    public static final int	PESONORMAL	= 0;
    //  De clase:
    private static int numPersonas;    // Contador de objetos Persona
    //  De objeto:
    private String  nombre;
    private int     edad;
    private char    sexo;          // Solo un caracter: 'H' o 'M'
    private double  peso;
    private double  altura;
    private String  dni;
    
    // *** CONSTRUCTORES ***
    public Persona(){
        this.nombre = "";
        this.edad   = 0;
        this.sexo   = SEXO_DEFAULT;
        this.peso   = 0.0;
        this.altura = 0.0;
        this.dni    = generaDNI();
      
        numPersonas++;
    }
    
    public Persona(String nombre, int edad, char sexo){
        this.nombre = nombre;
        this.edad   = edad;
        comprobarSexo(sexo);
        this.peso   = 0.0;
        this.altura = 0.0;
        this.dni    = generaDNI();
        
        numPersonas++;
    }
    
    public Persona(String nombre, int edad, char sexo, double peso, double altura){
        this.nombre = nombre;
        this.edad   = edad;
        comprobarSexo(sexo);
        this.peso   = peso;
        this.altura = altura;
        this.dni    = generaDNI();
        
        numPersonas++;
    }
    
    // *** METODOS ***
    //  Metodos de clase
    public static int getNumPersonas(){
        return Persona.numPersonas;
    }
    
    //  Getters & Setters
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
    
    public String getDNI(){
        return this.dni;
    }
    
    //  Metodos de objeto
    //      Calcular si es mayor de edad
    public boolean esMayorDeEdad(){
        return edad>=18;
    }
    
    //      Compobar que el sexo sea el correcto (metodo interno)
    private void comprobarSexo(char sexo){
        if(sexo == 'H' || sexo == 'M'){
            this.sexo = sexo;
        }else{
            this.sexo = SEXO_DEFAULT;
        }
    }
    
    //      Calcular el IMC: IMC = (peso en kilos)/(altura en m)^2
    public int calcularIMC(){
        double imc = this.peso/Math.pow(this.altura, 2.0);
        if(imc < 20)
            return BAJOPESO;
        else if(imc > 25)
            return SOBREPESO;
        else
            return PESONORMAL;
        
    }
    
    //      Devolver cadena de la informacion del paciente
    @Override
    public String toString(){
        String sexo;
        if(this.sexo == 'M')
            sexo = "Mujer";
        else
            sexo = "Hombre";
        return("\nPaciente: "+this.nombre+
                "\nEdad: "+this.edad+" años"+
                "\nSexo: "+sexo+
                "\nPeso: "+this.peso+" kg"+
                "\nAltura: "+this.altura+" metros");
    }
    
    //      Generar un DNI aleatorio para el usuario
    private String generaDNI(){
        String dni_a = "";
        
        dni_a += generarNumero();
        dni_a += "-";
        dni_a += generarLetra(dni_a.substring(0,7));
        
        return dni_a;
    }
    
    //      Generar un numero en formato cadena de 8 caracteres
    private String generarNumero(){
        String numero = "";
        Random r = new Random();
        
        for(int i=0; i<8; i++){
            int temp = r.nextInt(10);
            numero += String.valueOf(temp);
        }
            
        return numero;
    }
    
    //      Generar una letra para el DNI
    private char generarLetra(String numero){
        final char[] tabla = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int num = Integer.valueOf(numero);
        return tabla[num%23];
        
    }
}
