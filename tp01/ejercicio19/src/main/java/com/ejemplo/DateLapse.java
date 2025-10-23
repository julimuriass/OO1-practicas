package com.ejemplo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public boolean overlaps(DateLapse dateLapse) {

        //Check from desde la fecha original.
        boolean libre = this.includesDate(dateLapse.getFrom());
        if (libre) {
            return true;
        }

        //Check to desde la fecha original.
        libre = this.includesDate(dateLapse.getTo());
        if (libre) {
            return true;
        }

        //Check from desde la nueva fecha.
        libre = dateLapse.includesDate(this.getFrom());
        if (libre) {
            return true;
        }

        //Check to desde la nueva fecha.
        libre = dateLapse.includesDate(this.getTo());
        if (libre) {
            return true;
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
        return ((other.isAfter(this.from) || (other.isEqual(this.from))) && (other.isBefore(this.to) || (other.isEqual(this.to))));
    }
    
}
