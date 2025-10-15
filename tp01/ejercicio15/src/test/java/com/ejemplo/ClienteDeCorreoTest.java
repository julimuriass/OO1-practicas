package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ClienteDeCorreoTest {
    private Carpeta carpeta;
    private Email email;
    private Archivo archivo;
    private ClienteDeCorreo clienteCorreo;

    @BeforeEach
    void setUp() {
        this.carpeta = new Carpeta("nombre");
        this.email = new Email("pedo", "cuerpo");
        this.archivo = new Archivo("caca");
        this.clienteCorreo = new ClienteDeCorreo();

        this.clienteCorreo.agrgarCarpeta(carpeta);
    }

    @Test
    void testRecibir() {
        this.clienteCorreo.recibir(this.email, "nombre");
        assertTrue(carpeta.obtenerEmails().size() == 1);


        //this.clienteCorreo.recibir(email, "carpInexistente");

    }

    @Test
    void testBuscar() {
        this.clienteCorreo.recibir(this.email, "nombre");
        
        assertTrue(this.clienteCorreo.buscar("pedo") != null);

        assertTrue(this.clienteCorreo.buscar("cuerpo") != null);


        assertTrue(this.clienteCorreo.buscar("cacolia") == null);


    }

    @Test
    void espacioOcupado(){
        email.agregarArchivo(archivo);
        this.clienteCorreo.recibir(email, "nombre");
        assertTrue(this.clienteCorreo.espacioOcupado() == 14);
    }


    
}
