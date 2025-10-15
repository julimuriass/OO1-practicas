package com.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String titulo;
    private String cuerpo;
    private List<Archivo> archivos;

    public Email (String titulo, String cuerpo) {
        this.cuerpo = cuerpo;
        this.titulo = titulo;
        this.archivos = new ArrayList<>();
    }

    public String getCuerpo() {
        return this.cuerpo;
    }
    

    public String getTitulo() {
        return this.titulo;
    }

    public Integer calcularTamaño(){
        return this.titulo.length() + this.cuerpo.length() + archivos.stream().mapToInt(a -> a.tamaño()).sum();
    }
    public void agregarArchivo(Archivo archivo){
        archivos.add(archivo);
    }

   
}
