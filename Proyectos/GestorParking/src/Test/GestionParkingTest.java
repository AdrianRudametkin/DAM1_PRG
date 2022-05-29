package Test;

import aplicacion.GestionParking;
import org.junit.jupiter.api.Test;
import parking.Cliente;
import parking.Coche;
import parking.Vecino;
import tiempo.Tiempo;

import static org.junit.jupiter.api.Assertions.*;

class GestionParkingTest {

    @Test
    void GPTest() {
        GestionParking gp = new GestionParking();
        gp.agregarCoche(new Coche(new Cliente("a"),"1","p","p","p","p",new Tiempo()));
        gp.agregarCoche(new Coche(new Vecino("a","o","o","o","o","o"),"2","p","p","p","p",new Tiempo()));
    }

}