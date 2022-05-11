package Test;

import TimeAndDate.Time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class TimeTest {
    @Test
    void differenceTest(){
        Time t1 = new Time();
        Time t2 = new Time();
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

        String expected = "Se esperaba DateTimeException";

        DateTimeException thrown = Assertions.assertThrows(DateTimeException.class, ()->{
            Time t = new Time(bisiesto[0], bisiesto[1], bisiesto[2], bisiesto[3], bisiesto[4]);
        });
        assertTrue(thrown.getMessage().contains("Invalid"));
    }

}