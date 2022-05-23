package tiempo;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase que almacena la fecha y la hora utilizando la clase java.time.LocalDateTime. Implementa métodos
 * para facilitar la legibilidad y uso de esta librería.
 */
public class Tiempo implements Serializable {
    // ***ATRIBUTOS***
    static final long serialVersionUID = 3L;
    private LocalDateTime ldt;
    private Hour hour;
    private Date date;

    // ***CONSTRUCTORES***

    /**
     * Constructor para crear una fecha y hora personalizada.
     * @param day       día del mes (1-31)
     * @param month     mes del año (1-12)
     * @param year      año
     * @param hour      hora del día (0-23)
     * @param minute    minuto de la hora (0-59)
     */
    public Tiempo(int day, int month, int year, int hour, int minute) throws DateTimeException {
        ldt = LocalDateTime.of(year, month, day, hour, minute);

        this.hour = new Hour(hour, minute);
        this.date = new Date(day, month, year);
    }

    /**
     * Constructor para crear la fecha y hora actual.
     */
    public Tiempo(){
        ldt = LocalDateTime.now();

        this.hour = new Hour(ldt.getHour(), ldt.getMinute());
        this.date = new Date(ldt.getDayOfMonth(), ldt.getMonthValue(), ldt.getYear());
    }


    // ***MÉTODOS***

    /**
     * Método que calcula los minutos que hay entre 2 fechas.
     * @param tObj objeto a comparar
     * @return la diferencia en minutos
     */
    public long minutesDifference(Tiempo tObj){
        return ChronoUnit.MINUTES.between(this.ldt, tObj.ldt);
    }

    /**
     * Devuelve la hora en formato de la clase Hour.
     * @return hora
     */
    public Hour getHour(){
        return this.hour;
    }

    /**
     * Devuelve la hora en formato de la clase Date.
     * @return fecha
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * Método que formatea la fecha en [dd/MM/yyyy HH:mm].
     * @return cadena de la fecha y hora
     */
    @Override
    public String toString(){
        return date.toString()+" "+hour.toString();
    }
}
