public class Main {
    public static void main(String[] args) {
        imprimirCuadrado(5);
    }

    public static void imprimirCuadrado(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(cuadrado(i, j) + "\t");
            }
            System.out.println();
        }
    }

    public static int cuadrado(int i, int j) {
        if (i == 0 || j == 0)
            return 1;

        return cuadrado(i - 1, j) + cuadrado(i, j - 1);
    }
}
