package TimeAndDate;

/**
 * Clase que almacena la hora.
 */
public class Hour {
    // ***ATRIBUTOS***
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
}
