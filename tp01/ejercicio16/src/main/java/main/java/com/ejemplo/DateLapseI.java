package main.java.com.ejemplo;

import java.time.LocalDate;

public interface DateLapseI {

    public LocalDate getFrom();

    public LocalDate getTo();

    public int sizeInDays();
    
    public boolean includesDate(LocalDate other);
}
