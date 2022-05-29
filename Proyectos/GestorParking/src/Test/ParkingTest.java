package Test;

import exceptions.ArrayFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking.Cliente;
import parking.Coche;
import parking.Parking;
import tiempo.Tiempo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {
    final int numPlazas = 10;
    ArrayList<Coche> coches;


    @BeforeEach
    void before() {
        coches = new ArrayList<>();
        coches.add(new Coche(new Cliente("1"), "m1", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche(new Cliente("2"), "m2", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche(new Cliente("3"), "m3", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche(new Cliente("4"), "m3", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche(new Cliente("5"), "m4", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche(new Cliente("6"), "m5", "ford", "fiesta", "rojo", "  ", new Tiempo()));
    }

    @Test
    void anyadirCoche() throws ArrayFullException {
        Parking instance = new Parking(numPlazas + 10);
        instance.anyadirCoche(coches.get(0));
        instance.anyadirCoche(coches.get(1));
        instance.anyadirCoche(coches.get(1));
        instance.anyadirCoche(coches.get(2));
        instance.anyadirCoche(coches.get(2));
        System.out.println(instance.toString());
        System.out.print(coches.get(0));
    }

    @Test
    void quitarCoche() {
    }

    @Test
    void isFull() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void testToString() {
    }

    @Test
    void buscarMatricula() {
    }
}