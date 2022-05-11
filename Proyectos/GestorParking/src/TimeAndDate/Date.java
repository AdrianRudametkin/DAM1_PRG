package TimeAndDate;

/**
 * Clase que almacena la fecha.
 */
public class Date {
    // ***ATRIBUTOS***
    private int day;
    private int month;
    private int year;

    // ***CONSTRUCTORES***
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // ***MÉTODOS***

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
