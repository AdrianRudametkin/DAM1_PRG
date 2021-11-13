package ejercicio11;


public class Ejercicio11 {

    public static void main(String[] args) {
        insertarCantidad(438.29);
    }
    
    public static void insertarCantidad(double c){
        double dineroRestante = c;
        int temp = 0;
        
        double[] euros = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
        for(int i = 0; i<euros.length; i++){
            while(dineroRestante - euros[i] >= 0){
               dineroRestante -= euros[i];
               temp++;
            }
            
            if(temp != 0){
                if(euros[i]>2) System.out.println(temp + " billete(s) de " + euros[i]);
                else System.out.println(temp + " moneda(s) de " + euros[i]);
                temp = 0;
            } 
        }
    }
    
}
