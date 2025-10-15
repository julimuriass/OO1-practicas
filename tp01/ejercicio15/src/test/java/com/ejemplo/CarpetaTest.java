package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CarpetaTest {
    private Carpeta carpeta1;
    private Carpeta carpeta2;
    private Email email;

    @BeforeEach
    void setUp() {
        this.carpeta1 = new Carpeta("nombre1");
        this.carpeta2 = new Carpeta("carpeta2");
        this.email = new Email("Titulo", "cuerpo");
    }

    @Test
    void testConstructor() {
        assertTrue(carpeta1.getNombre().equals("nombre1"));
    }

    @Test
    void testAgregarMail() {
        carpeta1.agregarEmail(email);
        assertTrue(carpeta1.obtenerEmails().size() == 1);
    }

    @Test 
    void testCoincideMail() {
        carpeta1.agregarEmail(email);
        assertTrue(carpeta1.coincideEmail("Titulo") != null);

        assertTrue(carpeta1.coincideEmail("cuerpo") != null);
    }

    @Test
    void testMover() {
        carpeta1.agregarEmail(email);
        carpeta1.mover(email, carpeta2);
        assertTrue(carpeta1.obtenerEmails().size() == 0);

        assertTrue(carpeta2.obtenerEmails().size() == 1);
    }

}
