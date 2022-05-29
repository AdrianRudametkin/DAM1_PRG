package Test;

import org.junit.jupiter.api.Test;
import parking.Cliente;
import parking.Coche;
import parking.Vecino;
import tiempo.Tiempo;

import static org.junit.jupiter.api.Assertions.*;

class CocheTest {

    @Test
    void testToString() {
        Cliente c = new Cliente("A1");
        Vecino v = new Vecino("B1", "","","","","");
        Coche c1 = new Coche(c,"a1","","","","",new Tiempo());
        Coche c2 = new Coche(v,"a2","","","","",new Tiempo());
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}