package supestopractico;


public class SupestoPractico {
    
    final static int ENTERO = 212;
    final static String CADENA = "Hola (*^-^)/";

    public static void main(String[] args) {
        final int A = 1008;
        final String B = "Saludos";
        Integer a = A;
        Integer b = a;
        
        System.out.println("Constante A: " + A);
        System.out.println("Constante B: " + B);
        System.out.println("Variable a: " + a);
        System.out.println("Variable b: " + b);
        
        // Ampliacion ejercicio 1
        System.out.println("Global ENTERO: " + ENTERO);
        System.out.println("Global CADENA: " + CADENA);
        
        // Ampliacion ejercicio 2: Autoevaluacion 2
        int b2 = 9 << 2;
            // Este codigo es una operacion de bits que añade ceros a la derecha
            // Pot lo que habrá que pasar el numero a bits y mover los bits
            // 9 = 0b0000_1001 -> 0b0010_01[00] = 36
            // Por tantod b2 será 36 en decimal.
        System.out.println("Autoevaluacion 2: " + b2);
        
        // Ampliacion ejercicio 3: Autoevaluacion 3
        int b3 = 16 & 8;
            // Una que hace una multipliacion binaria
            //  16 =   0b0001_0000
            //   8 =   0b0000_1000
            //      &  0b0000_0000
            // Por tanto b2 será 0
        System.out.println("Autoevaluacion 3: " + b3);
        
        // Ampliacion ejercio 4: Autoevaluacion 5
        int b5 = 2;
        System.out.println("Autoevaluacion 5, b (antes) = " + b5);
        int a5 = b5++ + 13;
            // El orden de instuciones es el siguiente:
            //   1. Asignar (2) a "b5" -> b5 = 2
            //   2. Asignar la operacion "b5"(2) + 13 a "a5" -> a5 = 15
            //   3. Hacer el operador '++' a "b5" -> b5 = 3
        System.out.println("Autoevaluacion 5, a = " + a5);
        System.out.println("Autoevaluacion 5, b (despues) = " + b5);
        
        // Ampliacion ejercicio 5: Autoevaluacion 6
            // short a int    -> 2 a 4 bytes (seguro)
            // int a long     -> 4 a 8 bytes (inseguro)
            // double a byte  -> 8 a 1 bytes (seguro)
            // float a double -> 4 a 8 bytes (seguro)
    }
    
}
