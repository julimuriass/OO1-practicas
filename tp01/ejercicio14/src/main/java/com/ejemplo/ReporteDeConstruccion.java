package ejercicio14.src.main.java.com.ejemplo;

import java.util.List;

public class ReporteDeConstruccion {
    private List<Pieza> piezas;



    //"Recibe como parámetro un nombre de material (un string, por ejemplo 'Hierro'). Retorna la suma de los volúmenes de todas las piezas hechas en ese material"
    public double volumenDeMaterial(String nombreDeMaterial) {
        return this.piezas.stream().filter(p -> p.getMaterial().equals(nombreDeMaterial)).mapToDouble(p -> p.getVolumen()).sum();
    }


//"Recibe como parámetro un color (un string, por ejemplo 'Rojo'). Retorna la suma de las superficies externas de todas las piezas pintadas con ese color".
    public double superficieDeColor(String color) {
        return this.piezas.stream().filter(p -> p.getColor().equals(color)).mapToDouble(p -> p.getSuperficie()).sum();

    }


}
