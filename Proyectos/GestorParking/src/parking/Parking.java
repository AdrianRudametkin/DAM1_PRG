package parking;

import exceptions.ArrayFullException;
import exceptions.NoCarException;

public class Parking {
    //***ATRIBUTOS***
    static final long serialVersionUID = 2L;
    private Coche[] plazas;

    //***Constructor***
    public Parking(int numPlazas) {
        plazas = new Coche[numPlazas];
    }

    //***MÉTODOS***
    public void anyadirCoche(Coche c) throws ArrayFullException {
        if (estaLLeno())
            throw new ArrayFullException();

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                plazas[i] = c;
                return;
            }
        }
    }

    public void quitarCoche(int pos) throws NoCarException, IndexOutOfBoundsException {
        if (plazas[pos] == null)
            throw new NoCarException();

        plazas[pos] = null;
    }

    private boolean estaLLeno() {
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
}
