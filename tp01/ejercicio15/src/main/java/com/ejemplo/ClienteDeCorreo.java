package com.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
    private List<Carpeta> carpetas;
    
    public ClienteDeCorreo() {
        this.carpetas = new ArrayList<Carpeta>();
    }

    public void agrgarCarpeta(Carpeta carpeta) {
        this.carpetas.add(carpeta);
    }

    public void recibir(Email email, String carpeta) {
        Carpeta carp = this.carpetas.stream().filter(c -> c.getNombre().equals(carpeta)).findFirst().orElse(null);
        if (carp != null) {
            carp.agregarEmail(email);
        }   
    }

    public Email buscar(String texto) {
        Carpeta carp = this.carpetas.stream().filter(c -> c.coincideEmail(texto) != null).findFirst().orElse(null);
        if (carp != null) {
            return carp.coincideEmail(texto);
        } else {
            return null;
        }
        
    }

    public Integer espacioOcupado() {
        return this.carpetas.stream().mapToInt(c -> c.calcularTamaño()).sum();
        
    }
    
}
