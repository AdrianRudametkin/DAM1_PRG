package aplicacion;

import java.io.Serializable;

public class Almacen implements Serializable {
    //***ATRIBUTOS***
    static final long serialVersionUID = 2L;
    //  de objeto
    private Bebida[][] almacen;

    public void agregarBebida(Bebida b) {
        // Recorrer filas
        for (int i = 0; i < almacen.length; i++) {
            // Recorrer columnas
            for (int j = 0; j < almacen[i].length; j++) {
                // Si no hay nada, añadir y salir
                if (almacen[i][j] == null) {
                    almacen[i][j] = b;
                    return;
                }
            }
        }
    }

    public boolean eliminarBebida(String id) {
        // Recorrer filas
        for (int i = 0; i < almacen.length; i++) {
            // Recorrer columnas
            for (int j = 0; j < almacen[i].length; j++) {
                // Si no hay nada, continuar
                if (almacen[i][j] == null)
                    continue;
                // Si hay algo comprobar ID y eliminar si es el caso
                if (almacen[i][j].getIdentificador().equalsIgnoreCase(id)) {
                    almacen[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public double precio() {
        double total = 0;
        // Recorrer filas
        for (int i = 0; i < almacen.length; i++) {
            // Recorrer columnas
            for (int j = 0; j < almacen[i].length; j++) {
                // Si no hay nada, continuar
                if (almacen[i][j] == null)
                    continue;
                // Sumar los precios
                total += almacen[i][j].getPrecio();
            }
        }

        return total;
    }

    public double precio(String marca) {
        double total = 0;
        // Recorrer filas
        for (int i = 0; i < almacen.length; i++) {
            // Recorrer columnas
            for (int j = 0; j < almacen[i].length; j++) {
                // Si no hay nada, continuar
                if (almacen[i][j] == null)
                    continue;
                // Comprobar si es la misma marca y sumar
                if (almacen[i][j].getMarca().equalsIgnoreCase(marca))
                    total += almacen[i][j].getPrecio();
            }
        }

        return total;
    }

    public double precio(int estante) {
        double total = 0;
        // Recorrer columnas
        for (int j = 0; j < almacen[estante].length; j++) {
            // Si no hay nada continuar
            if (almacen[estante][j] == null)
                continue;
            // Sumar precios
            total += almacen[estante][j].getPrecio();
        }

        return total;
    }

    public int numeroTotalBebidas() {
        int total = 0;
        // Recorrer filas
        for (int i = 0; i < almacen.length; i++) {
            // Recorrer columnas
            for (int j = 0; j < almacen[i].length; j++) {
                // Si hay algo sumar
                if (almacen[i][j] != null)
                    total++;
            }
        }

        return total;
    }

    public void mostrarTodaInformacion() {
        // Recorrer filas
        for (int i = 0; i < almacen.length; i++) {
            // Recorrer columnas
            for (int j = 0; j < almacen[i].length; j++) {
                // Si hay algo sumar
                if (almacen[i][j] == null)
                    continue;

                // Mostrar bebida
                System.out.print("\n[ESTANTE " + (i + 1) + ",FILA " + (j + 1) + "]");
                System.out.print(" -> " + almacen[i][j].toString());
            }
        }
    }


    /*
     * MÉTODOS EXTRAS IMPRESCINDIBLES
     */
    public Almacen(int filas, int columnas) {
        almacen = new Bebida[filas][columnas];
    }

    public void setAlmacen(Bebida[][] almacen) {
        this.almacen = almacen;
        System.out.print("*Datos añadidos correctamente.");
    }

    public Bebida[][] getAlmacen() {
        return almacen;
    }
}
