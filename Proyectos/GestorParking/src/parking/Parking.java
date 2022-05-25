package parking;

import exceptions.ArrayFullException;
import exceptions.NoCarException;

/**
 * Clase que guarda una colección de coches, con los métodos todos necesarios para su manipulación.
 */
public class Parking {
    //***ATRIBUTOS***
    static final long serialVersionUID = 2L;
    protected Coche[] plazas;

    //***Constructor***
    /**
     * Constructor que crea un parking de un número de plazas
     * @param numPlazas número de plazas
     */
    public Parking(int numPlazas) {
        plazas = new Coche[numPlazas];
    }

    //***MÉTODOS***
    /**
     * Método para añadir un coche automáticamente a la plaza libre más cercana.
     * @param c coche a añadir
     * @throws ArrayFullException cuando el parking está lleno
     */
    public void anyadirCoche(Coche c) throws ArrayFullException {
        if (isFull())
            throw new ArrayFullException();

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                plazas[i] = c;
                return;
            }
        }
    }

    /**
     * Método para quitar un coche determinado por su posición en el parking.
     * @param pos posición del coche a eliminar
     * @throws NoCarException cuando no hay coches en el parking
     * @throws IndexOutOfBoundsException cuando se elige una posición inválida.
     */
    public void quitarCoche(int pos) throws NoCarException, IndexOutOfBoundsException {
        if (plazas[pos] == null)
            throw new NoCarException();

        plazas[pos] = null;
    }

    /**
     * Método que devuelve verdadero si el parking está lleno y falso si hay mínimo una plaza libre.
     * @return falso si hay un valor nulo en "plazas"
     */
    public boolean isFull() {
        for (Coche c : plazas) {
            if (c == null)
                return false;
        }

        return true;
    }

    /**
     * Método que devuelve verdadero si el parking está vacío y falso si hay mínimo una plaza llena.
     * @return falso sí hay algún coche
     */
    public boolean isEmpty(){
        for (Coche c : plazas) {
            if (c != null)
                return false;
        }

        return true;
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
            if (i % 10 == 0 && i != 0)
                s += "|\n| ";

            if (plazas[i] == null) {
                x = " ";
                libres++;
            } else {
                x = "X";
                ocupadas++;
            }

            s += (i + 1) + "(" + x + ")\t";
        }

        s += "|\n";
        s += "Plazas libres: " + libres + "\n";
        s += "Plazas ocupadas: " + ocupadas + "\n";

        return s;
    }

    /**
     * Método que busca un coche dentro del parking que coincida con la matrícula introducida. Devuelve la posición del
     * coche en el parking, o -1 cuando no se ha encontrado ningún coche.
     * @param mat matrícula del coche a buscar
     * @return la posición del coche en el parking
     */
    public int buscarMatricula(String mat){
        for(int i=0; i<plazas.length; i++){
            if(mat.equalsIgnoreCase(plazas[i].getMatricula())){
                return i;
            }
        }
        return -1;
    }
}
