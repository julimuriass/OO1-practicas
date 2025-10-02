package com.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class Farola {
    //Falso -> apagado, verdadero -> encendido
    private boolean estado;
    private ArrayList<Farola> farolasVecinas;

    public Farola() {
        farolasVecinas = new ArrayList<> (); 
        estado = false;
    }



/* Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
*/
    public void pairWithNeighbor(Farola otraFarola) {
        this.farolasVecinas.add(otraFarola);
        otraFarola.farolasVecinas.add(this);
    }

/*
* Retorna sus farolas vecinas
*/
    public List<Farola> getNeighbors(){
        return this.farolasVecinas;
    }


/*
* Si la farola no está encendida, la enciende y propaga la acción.
*/
    public void turnOn() {
        if (!this.isOn()) {
            this.estado = true;
            this.farolasVecinas.stream().forEach(farola -> farola.turnOn());
        }

    }

/*
* Si la farola no está apagada, la apaga y propaga la acción.
*/
    public void turnOff() {
        if (!this.isOff()) {
            this.estado = false;
            this.farolasVecinas.stream().forEach(farola -> farola.turnOff());
        }
    }

/*
* Retorna true si la farola está encendida.
*/
    public boolean isOn() {
        return this.estado;
    }
/*
* Retorna true si la farola está apagada.
*/
    public boolean isOff() {
        return !this.estado;
    }


}
