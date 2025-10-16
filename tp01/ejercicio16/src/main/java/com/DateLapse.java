package com;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
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
