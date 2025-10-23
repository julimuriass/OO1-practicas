package main.java.com.ejemplo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapseSize implements DateLapseI {
    private LocalDate from;
    private int size;

    public DateLapseSize(LocalDate from, int size){
        this.from=from;
        this.size=size;
    }

    public LocalDate getFrom(){
        return from;
    }

    public LocalDate getTo(){
        return from.plusDays((long) size);
    }

    public LocalDate getToInt(){
        return from.plusDays(size);
    }

    public int sizeInDays(){
         long daysDifference = ChronoUnit.DAYS.between(this.from, this.getTo());
        return (int) daysDifference;
    }
    
    public boolean includesDate(LocalDate other){
        return (other.isAfter(this.from) && other.isBefore(this.getTo()));
    }

}
