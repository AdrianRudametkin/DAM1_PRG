package Test;

import exceptions.ArrayFullException;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking.Coche;
import parking.Parking;
import tiempo.Tiempo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {
    final int numPlazas = 10;
    ArrayList<Coche> coches;


    @BeforeEach
    void before(){
        coches = new ArrayList<>();
        coches.add(new Coche("1", "m1", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche("2", "m2", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche("3", "m3", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche("4", "m3", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche("5", "m4", "ford", "fiesta", "rojo", "  ", new Tiempo()));
        coches.add(new Coche("6", "m5", "ford", "fiesta", "rojo", "  ", new Tiempo()));
    }

    @Test
    void anyadirCoche() throws ArrayFullException {
        Parking instance = new Parking(numPlazas);
        instance.anyadirCoche(coches.get(0));
        instance.anyadirCoche(coches.get(1));
        instance.anyadirCoche(coches.get(1));
        instance.anyadirCoche(coches.get(2));
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