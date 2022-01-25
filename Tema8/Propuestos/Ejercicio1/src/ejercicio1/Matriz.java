/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Matriz.java
 *
 * Created on Jan 21, 2022 At 8:07:08 PM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio1;

import java.util.Scanner;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Jan 21, 2022
 * @version 1.0
 * 
 */
public class Matriz {
    // ***ATRIBUTOS***
    public int numFilas;
    public int numColumnas;
    public int[][] matriz;
    
    // ***METODOS***
    // metodo que solicita el tamaño de la matriz y la crea
    public void solicitarTamanyo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el numero de filas: ");
        numFilas = sc.nextInt();
        System.out.print("Introduzca el numero de columnas:");
        numColumnas = sc.nextInt();
        
        matriz = new int[numFilas][numColumnas];
    }
    
    // metodo que rellena la matriz con numeros aleatoreos
    public void asignarDatos(){
        if(matriz==null){
            System.out.println("No hay matriz...");
            return;
        }
        
        for(int i=0; i<numFilas; i++){
            for(int j=0; j<numColumnas; j++){
                matriz[i][j] = (int)(Math.random()*99+1);
            }
        }
    }
    
    // metodo que haya el numero maximo de la matriz
    public int maximo(){
        if(matriz==null)
            return -1;
        
        int max = matriz[0][0];
        for(int[] filas: matriz){
            for(int elementos: filas){
                if(elementos>max)
                    max = elementos;
            }
        }
        return max;
    }

    // metodo que haya el numero minimo de la matriz
    public int minimo(){
        if(matriz==null)
            return -1;
        
        int min = matriz[0][0];
        for(int[] filas: matriz){
            for(int elementos: filas){
                if(elementos<min)
                    min = elementos;
            }
        }
        return min;
    }
    
    // Sumarle a esta matriz otra pasado como argumento
    public void sumar(Matriz matriz){
        // Tienen que tener el mismo numero de filas y columnas
        if(!((numFilas==matriz.numFilas) && (numColumnas==matriz.numColumnas))){
            System.out.println("No se pueden sumar matrices de distinto tamaño...");
            return;
        }
        // Imprimir matrices
        System.out.println(" > MATRIZ A :");
        this.mostrarMatriz();
        System.out.println(" > MATRIZ B :");
        matriz.mostrarMatriz();
        // Sumar cada elemento con su correspondiente
        for(int i=0; i<numFilas; i++){
            for(int j=0; j<numColumnas; j++){
                this.matriz[i][j] = matriz.matriz[i][j] + this.matriz[i][j];
            }
        }
        
        modificarMatriz(this.matriz);
        System.out.println(">> A + B :");
        this.mostrarMatriz();
        System.out.println("");
        
    }
    
    // Producto de una matriz por otra
    public void producto(Matriz matriz){
        // Numero de filas de uno, tiene que ser igual al numero de columnas del otro
        if(!(numFilas==matriz.numColumnas)){
            System.out.println("Las matrices son incompatibles...");
            return;
        }
        
        // Imprimir matrices
        System.out.println(" > MATRIZ A :");
        this.mostrarMatriz();
        System.out.println(" > MATRIZ B :");
        matriz.mostrarMatriz();
        // Matriz cuadrada resultate
        int[][] res = new int[numFilas][matriz.numColumnas];
        
        for(int i=0; i<numFilas; i++){
            for(int j=0; j<matriz.numColumnas; j++){
                // Producto de A*B:
                // (producto de filas A) + (producto de columnas B)
                int mat1 = 1;
                int mat2 = 1;
                // Elementos de la fila "i" de la matriz A
                for(int elem: this.matriz[i]){
                    // Producto de los elementos
                    mat1 *= elem;
                }
                // Filas de la matriz B
                for(int[] fil: matriz.matriz){
                    // Producto del elemento "j" de la fila
                    mat2 *= fil[j];
                }                
                res[i][j] = (mat1 + mat2);
            }
        }
        
        modificarMatriz(res);
        System.out.println(">> A * B :");
        this.mostrarMatriz();
        System.out.println("");
        
    }
    
    // Trasponer la matriz
    public void traspuesta(){
        // Transpuesta de una matriz:
        // Reordenacion de la matriz cambiando la filas por las columnas y viceversa
        // Imprimir matriz original
        System.out.println(" > Matriz :");
        this.mostrarMatriz();
        int[][] trp = new int[numColumnas][numFilas];
        for(int i=0; i<trp.length; i++){
            for(int j=0; j<trp[0].length; j++){
                trp[i][j] = matriz[j][i];
            }
        }
        modificarMatriz(trp);
        System.out.println(">> Matriz traspuesta :");
        this.mostrarMatriz();
        System.out.println("");
    }
    // Mostar la matriz
    public void mostrarMatriz(){
        for(int filas[]: matriz){
            for(int elemento: filas){
                System.out.printf("%3d ",elemento);
            }
            System.out.println("");
        }
    }
    
    // modificar la matriz y sus atributos
    private void modificarMatriz(int[][] matriz){
        this.matriz = matriz;
        numFilas = matriz.length;
        numColumnas = matriz[0].length;
    }
    
    public static void main(String[] args) {
        Matriz m1 = new Matriz();
        Matriz m2 = new Matriz();
        
        Scanner sc = new Scanner(System.in);
        int op;
        while(true){
            printMenu();
            op = sc.nextInt();
            if(op == 6){
                return;
            }else if(op<3){
                System.out.println("Matriz 1:");
                m1.solicitarTamanyo();
                m1.asignarDatos();
                System.out.println("Matriz 2:");
                m2.solicitarTamanyo();
                m2.asignarDatos();
            }else{
                System.out.println("Matriz:");
                m1.solicitarTamanyo();
                m1.asignarDatos();
            }
            System.out.println("");
            
            switch(op){
                case 1:
                    m1.sumar(m2);
                    break;
                case 2:
                    m1.producto(m2);
                    break;
                case 3:
                    m1.traspuesta();
                    break;
                case 4:
                    System.out.print("Maximo matriz: "+m1.maximo());
                    System.out.println("");
                    break;
                case 5:
                    System.out.print("Maximo matriz: "+m1.minimo());
                    System.out.println("");
                    break;
                default: 
                    System.out.println("Eliga una opcion valida!");
                    break;
            }
        }
    }
    
    public static void printMenu(){
        System.out.println("\nElige un opcion:"
                + "\n 1-Sumar 2 matrizes."
                + "\n 2-Multiplicar 2 matrices."
                + "\n 3-Transpuesta de una matriz."
                + "\n 4-Numero maximo de una matriz."
                + "\n 5-Numero minimo de una matriz."
                + "\n 6-Salir.");
    }
}
