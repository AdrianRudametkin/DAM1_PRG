public class Ejercicio4 {

    public static void main(String[] args) {
        //int nunero = 5;
        //num += num - 1 * 4 + 1;
        //System.out.println(num);
        //Num = 4;
        //num %= 7 * num % 3 * 7 >> 1;
        //System.out.println(num);
        
        // Este programa no mostrará nada, ya que los nombre no son consistentes
        // Si cambiamos esto, esto es lo que hará el programa:
        
        int num = 5;                    // Declaracion y asignacion
        num += num - 1 * 4 + 1;         // Primero la operacion en orden:
                                        //  (5[num]-(4*1))+1 = 2
                                        // Luego la operacion de asignacion
                                        //  num = 5[num]+2 = 7
        System.out.println(num);        // Imprimir 5
        num = 4;                        //  Asignar num a 4
        num %= 7 * num % 3 * 7 >> 1;    // Primero la operacion en orden:
                                        //  (((7*4[num]) %3)*7) >> 1
                                        //  ((     28    %3)*7) >> 1
                                        //  (      1        *7) >> 1
                                        //          0b0111      >> 1
                                        //          0b0011 = 3
                                        // Luego la operacion de asignacion
                                        //   num = 4[num] % 3 = 1
        System.out.println(num);
        
    }
    
}
