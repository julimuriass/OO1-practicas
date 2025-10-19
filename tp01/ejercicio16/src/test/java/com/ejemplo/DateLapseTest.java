package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DateLapse;
import com.DateLapseI;


public class DateLapseTest {
    private DateLapseI date;
    private DateLapseI dateSize;


    @BeforeEach
    void setUp() {
        LocalDate from = LocalDate.of(2024, 1, 1);
        LocalDate to = LocalDate.of(2025, 1, 1);
        this.date = new DateLapse(from, to);

        this.dateSize = new DateLapseSize(from,10);
    }

    @Test
    void testConstructor() {
        LocalDate from = LocalDate.of(2024, 1, 1);
        LocalDate to = LocalDate.of(2025, 1, 1);
        assertTrue(this.date.getFrom().equals(from));
        assertTrue(this.date.getTo().equals(to));
    }

    @Test
    void sizeInDays() {
        assertTrue(this.date.sizeInDays() == 366);
    }

    @Test 
    void testIncludesDates() {
        LocalDate other1 = LocalDate.of(2024, 3, 1);
        LocalDate other2 = LocalDate.of(2030, 3, 1);

        LocalDate lim1 = LocalDate.of(2024, 1, 1);
        LocalDate lim2 = LocalDate.of(2025, 1, 1);

        assertTrue(this.date.includesDate(other1));

        assertFalse(this.date.includesDate(other2));


        //Tests limits.
        assertFalse(this.date.includesDate(lim1));
        assertFalse(this.date.includesDate(lim2));
    }

    @Test
    void testConstructorS() {
        LocalDate from = LocalDate.of(2024, 1, 1);
        LocalDate to = LocalDate.of(2024, 1, 11);
        assertTrue(this.dateSize.getFrom().equals(from));
        assertTrue(this.dateSize.getTo().equals(to));
    }

    @Test
    void sizeInDaysS() {
        assertTrue(this.dateSize.sizeInDays() == 10);
    }

    @Test 
    void testIncludesDatesS() {
        LocalDate other1 = LocalDate.of(2024, 1, 5);
        LocalDate other2 = LocalDate.of(2030, 3, 1);

        LocalDate lim1 = LocalDate.of(2024, 1, 1);
        LocalDate lim2 = LocalDate.of(2024, 1, 11);

        assertTrue(this.dateSize.includesDate(other1));

        assertFalse(this.dateSize.includesDate(other2));


        //Tests limits.
        assertFalse(this.dateSize.includesDate(lim1));
        assertFalse(this.dateSize.includesDate(lim2));
    }
    
}
