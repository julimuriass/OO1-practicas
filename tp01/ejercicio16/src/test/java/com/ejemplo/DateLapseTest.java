package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DateLapse;


public class DateLapseTest {
    private DateLapse date;


    @BeforeEach
    void setUp() {
        LocalDate from = LocalDate.of(2024, 1, 1);
        LocalDate to = LocalDate.of(2025, 1, 1);
        this.date = new DateLapse(from, to);
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
    
}
