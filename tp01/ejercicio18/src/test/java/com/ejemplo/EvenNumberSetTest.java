package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.EvenNumberSet;

public class EvenNumberSetTest {
    private EvenNumberSet numbers;

    @BeforeEach
    void setUp() {
        numbers = new EvenNumberSet();
    }

    @Test
    void testAddCorrecto() {
        assertTrue(numbers.add(10));
    }

    @Test
    void testAddIncorrecto() {
        assertFalse(numbers.add(1));
    }

    @Test
    void testAddAllIncorrecto() {
        List<Integer> digits = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertFalse(numbers.addAll(digits));
    }

    @Test
    void testAddAllCorrecto() {
        List<Integer> digits = new ArrayList<>(Arrays.asList(2,4,6,8));
        assertTrue(numbers.addAll(digits));
    }

    @Test
    void testAddAllVacio() {
        List<Integer> digits = new ArrayList<>(Arrays.asList());
        assertFalse(numbers.addAll(digits));
        
    }

    


}
