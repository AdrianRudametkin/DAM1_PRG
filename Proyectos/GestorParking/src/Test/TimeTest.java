package Test;

import tiempo.Date;
import tiempo.Hour;
import tiempo.Tiempo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class TimeTest {
    @Test
    void differenceTest(){
        Tiempo t1 = new Tiempo();
        Tiempo t2 = new Tiempo();
        int expected = 0;

        assertEquals(expected,t1.minutesDifference(t2),"Error");
    }

    @Test
    void constructorExceptionTest(){
        int[] bisiesto = {29, 2, 2019, 11, 30};

        int[] malDiaMin = {0, 5, 2019, 11, 30};
        int[] malDiaMax = {32, 5, 2019, 11, 30};

        int[] malMesMin = {17, 0, 2019, 11, 30};
        int[] malMesMax = {17, 13, 2019, 11, 30};

        int[] malaHoraMax = {17, 5, 2019, -1, 30};
        int[] malaHoraMin = {17, 5, 2019, 24, 30};

        int[] malMinutoMin = {17, 5, 2019, 11, -1};
        int[] malMinutoMax = {17, 5, 2019, 11, 60};

        int[] test = bisiesto;
        String expected = "Se esperaba DateTimeException";

        DateTimeException thrown = Assertions.assertThrows(DateTimeException.class, ()->{
            Tiempo t = new Tiempo(test[0], test[1], test[2], test[3], test[4]);
        });
        assertTrue(thrown.getMessage().contains("Invalid"));
    }

    @Test
    void getHourDateTest(){
        Tiempo t = new Tiempo(12,1, 2019, 12, 30);
        Hour h = t.getHour();
        Date d = t.getDate();
        String s = t.toString();

        assertTrue(d!=null && h!=null && !s.isEmpty());
        assertEquals("12:30",h.toString());
        assertEquals("12/1/2019",d.toString());
    }

}