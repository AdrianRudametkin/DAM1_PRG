package tiempo;

import java.io.Serializable;

/**
 * Clase que almacena la hora.
 */
public class Hour implements Serializable {
    // ***ATRIBUTOS***
    static final long serialVersionUID = 32L;
    private int hour;
    private int minute;

    // ***CONSTRUCTORES***
    public Hour(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    // ***MÉTODOS***

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        String h = "", m = "";
        if (hour < 10)
            h = "0";
        if (minute < 10)
            m = "0";

        return h + hour + ":" + m + minute;
    }
}
