package ejercicio1;

// Clase "Suma"
public class Ejercicio1 {
    static int n1 = 50;
            
    public static void main(String[] args) {
        byte a = 200;
        System.out.println(a);
        int n2 = 30, suma = 0, n3;
        suma = n1 + n2;
        System.out.println("La suma es: " + suma);
        
        // No compila porque "n3" no tiene un valor, y no se puede hacer la suma
        n3 = 1;
        
        suma = suma + n3;
        System.out.println(suma);
    }
    
}
