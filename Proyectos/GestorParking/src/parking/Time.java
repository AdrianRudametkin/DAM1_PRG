package parking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Time {
    private LocalDateTime ldt;

    public Time(int year, int month, int day, int hour, int minute){
        ldt = LocalDateTime.of(year, month, day, hour, minute);

    }

    public Time(){
        ldt = LocalDateTime.now();
    }

    public long minutesDifference(LocalDateTime ldt){
        return ChronoUnit.MINUTES.between(this.ldt, ldt);
    }

    public int getTime(){

    }

    public int g
    @Override
    public String toString(){
        return ldt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
