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
 * Created on 5 nov. 2021 At 11:31:14
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
public class Main {

    public static void main(String[] args) {
//        String nombre;
//        int edad;
//        char sexo;
//        double peso, altura;
//        
//        // Pedir informacion al usuario
//        Scanner sc = new Scanner(System.in);
//        System.out.println("***PACIENTE NUEVO***");
//        System.out.println("Introduzca nombre: ");
//        nombre = sc.nextLine();
//        System.out.println("Introduzca la edad: ");
//        edad = sc.nextInt();
//        System.out.println("Introduzca el sexo");
//        sexo = sc.next().charAt(0);
//        System.out.println("Introduza el peso: ");
//        peso = sc.nextDouble();
//        System.out.println("Introduzca la altura: ");
//        altura = sc.nextFloat();
//        
//        System.out.println("");
//		  Persona p1 = new Persona(nombre, edad, sexo, peso, altura);
//	      Persona p2 = new Persona(nombre,edad,sexo);
        // Construir los objetos
    	Persona p1 = new Persona("Sobrepeso_M", 18, 'M', 82.2, 1.23);
        Persona p2 = new Persona("Bajopeso_H",12,'H');
        Persona p3 = new Persona();
        
        p2.setPeso(25.00);
        p2.setAltura(1.63);
        
        p3.setNombre("Normal_X");
        p3.setEdad(20);
        p3.setSexo('X');
        p3.setPeso(66.0);
        p3.setAltura(1.73);
        
        
        // Ver las condiciones de IMC de todos los pacientes
        switch (p1.calcularIMC()) {
            case -1: System.out.println(p1.getNombre()+" (P1) tiene bajo peso."); break;
            case 0: System.out.println(p1.getNombre()+" (P1) tiene el peso adecuado."); break;
            case 1: System.out.println(p1.getNombre()+" (P1) tiene sobrepeso."); break;
            default: break;
        }
        
        switch (p2.calcularIMC()) {
            case -1: System.out.println(p2.getNombre()+" (P2) tiene bajo peso."); break;
            case 0: System.out.println(p2.getNombre()+" (P2) tiene el peso adecuado."); break;
            case 1: System.out.println(p3.getNombre()+" (P2) tiene sobrepeso."); break;
            default: break;
        }
        
        switch (p3.calcularIMC()) {
            case -1: System.out.println(p3.getNombre()+" (P3) tiene bajo peso."); break;
            case 0: System.out.println(p3.getNombre()+" (P3) tiene el peso adecuado."); break;
            case 1: System.out.println(p3.getNombre()+" (P3) tiene sobrepeso."); break;
            default: break;
        }
        
        System.out.println("");
        
        // Ver que pacientes son mayores de edad
        if(p1.esMayorDeEdad())
            System.out.println(p1.getNombre()+" es mayor de edad.");
        else
            System.out.println(p1.getNombre()+" NO es mayor de edad.");
        
        if(p2.esMayorDeEdad())
            System.out.println(p2.getNombre()+" es mayor de edad.");
        else
            System.out.println(p2.getNombre()+" NO es mayor de edad.");
        
        if(p3.esMayorDeEdad())
            System.out.println(p3.getNombre()+" es mayor de edad.");
        else
            System.out.println(p3.getNombre()+" NO es mayor de edad.");
        
        System.out.println("");
        
        // Ver la caracteristicas de los objetos
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        
        System.out.println("");
        
        // Ver el numero de objetos
        System.out.println("Se han adscrito "+ p1.getNumPersonas()+"pacientes");
        
        System.out.println("");
        
        // Ver los DNI de la gente
        System.out.println("DNI paciente 1: " + p1.getDNI());
        System.out.println("DNI paciente 2: " + p2.getDNI());
        System.out.println("DNI paciente 3: " + p3.getDNI());
    }
}
