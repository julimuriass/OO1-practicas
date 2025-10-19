package com;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse implements DateLapseI{
    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public boolean overlaps(DateLapse dateLapse) {
        //Límite 1 y 2 son iguales.
        //inicio nuevo >= fecha from.
        //fin nuevo <= fecha to.

        if (dateLapse.getFrom().isEqual(from) || dateLapse.getTo().isEqual(to)) {
            return true;
        } else {
            if (dateLapse.getFrom().isAfter(this.from) || dateLapse.getFrom().isEqual(this.from)) {
                return true;
            } else {
                if (dateLapse.getTo().isBefore(this.to) || dateLapse.getTo().isEqual(this.to)) {
                    return true;
                }
            }
        }

        return false;
    }



    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.to;
    }

    public int sizeInDays() {
        long daysDifference = ChronoUnit.DAYS.between(this.from, this.to);
        return (int) daysDifference;
    }

    public boolean includesDate(LocalDate other) {
        return (other.isAfter(this.from) && other.isBefore(this.to));
    }
    
}
