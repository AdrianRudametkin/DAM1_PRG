package tiempo;

import java.io.Serializable;

/**
 * Clase que almacena la fecha.
 */
public class Date implements Serializable {
    // ***ATRIBUTOS***
    static final long serialVersionUID = 31L;
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

    @Override
    public String toString(){
        return day+"/"+month+"/"+year;
    }

}
