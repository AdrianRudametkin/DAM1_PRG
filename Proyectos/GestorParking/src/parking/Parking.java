package parking;

import exceptions.ArrayFullException;
import exceptions.NoCarException;
import tiempo.Tiempo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que guarda una colección de coches, con los métodos todos necesarios para su manipulación.
 */
public class Parking implements Serializable {
    //***ATRIBUTOS***
    static final long serialVersionUID = 3L;
    protected Coche[] plazas;

    //***Constructor***

    /**
     * Constructor que crea un parking de un número de plazas
     *
     * @param numPlazas número de plazas
     */
    public Parking(int numPlazas) {
        plazas = new Coche[numPlazas];
    }

    //***MÉTODOS***

    //----------------------------
    //    GESTIÓN COCHES
    //----------------------------
    /**
     * Método para añadir un coche automáticamente a la plaza libre más cercana.
     *
     * @param c coche a añadir
     */
    public void anyadirCoche(Coche c, int pos) {
        try {
            plazas[pos] = c;
        }catch(ArrayIndexOutOfBoundsException e ){
            System.out.print("\n [ERROR FATAL: No se pudo introducir el coche en la posición deseada]");
        }
    }

    /**
     * Método para quitar un coche determinado por su posición en el parking.
     *
     * @param c posición del coche a eliminar
     * @throws NoCarException            cuando no hay coches en el parking
     * @throws IndexOutOfBoundsException cuando se elige una posición inválida.
     */
    public void quitarCoche(Coche c) throws NoCarException {
        int pos = posCoche(c);
        if (pos < 0) throw new NoCarException();

        plazas[pos] = null;
    }

    /**
     * Método que cambia el tiempo de entrada de un coche. Debe ser utilizado solo para los vecinos.
     *
     * @param c coche a cambiar el tiempo
     * @param t tiempo nuevo
     */
    public void cambiarTiempo(Coche c, Tiempo t){
        plazas[posCoche(c)].setEntrada(t);
    }

    //----------------------------
    //    BÚSQUEDA COCHES
    //----------------------------

    /**
     * Método que indica la posición en el parking de un coche.
     * @param c coche
     * @return posición en el parking
     */
    public int posCoche(Coche c) {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == c) return i;
        }

        return -1;
    }

    /**
     * Método que busca un coche dentro del parking que coincida con la matrícula introducida. Devuelve el coche
     * , o NULL cuando no se ha encontrado ningún coche.
     *
     * @param mat matrícula del coche a buscar
     * @return la posición del coche en el parking
     */
    public Coche buscarMatricula(String mat) {
        for (int i = 0; i < plazas.length; i++) {
            if(plazas[i]==null)
                continue;
            if (mat.equalsIgnoreCase(plazas[i].getMatricula())) {
                return plazas[i];
            }
        }
        return null;
    }

    /**
     * Método que devuelve el Coche de una determinada posición.
     *
     * @param pos posición
     * @return coche
     */
    public Coche getCoche(int pos) {
        if (pos < 0 || pos >= plazas.length) return null;

        return plazas[pos];
    }


    /**
     * Método que devuelve la lista de coches del parking.
     *
     * @return lista de coches
     */
    public Coche[] getCoches(){
        return plazas;
    }

    /**
     * Método que devuelve el número de plazas en este parking.
     *
     * @return número plazas
     */
    public int getPlazas(){
        return plazas.length;
    }

    /**
     * Devuelve una cadena que muestra todas las plazas en una tabla e indica con una "x" las que están ocupadas.
     * También indica las plazas libres y las ocupadas.
     *
     * @return representación gráfica de las plazas
     */
    @Override
    public String toString() {
        String x, s = "| ";
        int libres = 0, ocupadas = 0;

        for (int i = 0; i < plazas.length; i++) {
            if (i % 10 == 0 && i != 0) s += "|\n| ";

            if (plazas[i] == null) {
                x = " ";
                libres++;
            } else {
                x = "X";
                ocupadas++;
            }

            s += (i+1) + "(" + x + ")\t";
        }

        s += "|\n";
        s += "Plazas libres: " + libres + "\n";
        s += "Plazas ocupadas: " + ocupadas + "\n";

        return s;
    }


}
