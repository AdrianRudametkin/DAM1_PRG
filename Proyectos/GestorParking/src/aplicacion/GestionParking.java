package aplicacion;

import exceptions.WrongOwnerException;
import parking.Coche;
import parking.Parking;

/**
 * Clase que maneja todos los datos del parking y el manejo de ficheros.
 */
public class GestionParking {
    //***ATRIBUTOS***
    private Parking[] plantas;
    private int reservados;
    private final String fpDefault = "datos.db";

    //***CONSTRUCTORES***
    public GestionParking(){

    }

    //***MÉTODOS***


    public boolean existeMatricula(String mat) {
        return false;
    }

    public int[] agregarCoche(Coche c) {
        return null;
    }

    public boolean hayEspacioParking() {
        return false;
    }

    public boolean hayEspacioVecinos() {
        return false;
    }

    public boolean esVecino(String mat) {
        return false;
    }

    public Coche getCoche(String mat) {
        return null;
    }

    public void revisarDNI(Coche coche, String dni) throws WrongOwnerException{
    }

    public void eliminarCoche(String mat) {
    }

    public String mostrarPlazas() {
        return null;
    }

    public String datosCoche(int pos, int planta) {
        return null;
    }

    public int numPlazas(int planta) {
        return -1;
    }

    public int numPlantas() {
    }

    public boolean existeCliente(String dni) {
    }

    public boolean datosCochePorDni(String dni) {
    }

    public boolean estadisticasColor() {
    }

    public boolean estadisticasMarca() {
    }

    public boolean estadisticasHora() {
    }

    public boolean mostrarTodo() {
    }
}
