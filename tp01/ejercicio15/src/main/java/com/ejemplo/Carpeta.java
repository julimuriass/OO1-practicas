package com.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
    private String nombre;
    private List<Email> emails;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.emails = new ArrayList<>();
    }

    public List<Email> obtenerEmails() {
        return this.emails;
    }


    public void agregarEmail(Email email) {
        this.emails.add(email);
    }

    public String getNombre() {
        return this.nombre;
    }


    public void mover(Email email, Carpeta carpetaDest) {
        Email mail = this.emails.stream().filter(e -> e.getTitulo().equals(email.getTitulo())).findFirst().orElse(null);
        if (mail != null) {
            this.emails.remove(mail);
            carpetaDest.agregarEmail(email);
        }

    }

    public Email coincideEmail(String texto){
        return this.emails.stream().filter( e -> e.getTitulo().equals(texto) || e.getCuerpo().equals(texto) ).findFirst().orElse(null);
    }

    public Integer calcularTamaño(){
        return this.emails.stream().mapToInt(e -> e.calcularTamaño()).sum();
    }
    
}
