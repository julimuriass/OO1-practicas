package com.ejemplo;

public class Mamifero {
    private String especie;
    private String identificador;
    private String fechaNacimiento;
    private Mamifero mama;
    private Mamifero papa;

    public Mamifero () {
    }

    public Mamifero(String especie) {
        this.especie = especie;
    }

    //Setters.
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setIdentificador(String id) {
        this.identificador = id;
    }

    public void setFechaNacimiento(String fecNac) {
        this.fechaNacimiento = fecNac;
    }

    public void setMadre(Mamifero mama) {
        this.mama = mama;
    }

    public void setPadre(Mamifero papa) {
        this.papa = papa;
    }
    //Getters.

    public Mamifero getPadre(){
        if (papa != null) 
            return papa;
        
        return null;
    }

    public Mamifero getMadre(){
        if (mama != null)
            return mama;
        return null;
    }

    public String getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    public String getEspecie(){
        return especie;
    }

    public String getIdentificador(){
        return identificador;
    }

    public Mamifero getAbueloMaterno(){
        if (mama != null)
            return mama.getPadre();
        return null;
    }

    public Mamifero getAbueloPaterno(){
        if (papa != null)
            return papa.getPadre();
        return null;
    }

    public Mamifero getAbuelaMaterna(){
        if (mama != null)
            return mama.getMadre();
        return null;
    }

    public Mamifero getAbuelaPaterna(){
        if (papa != null)
            return papa.getMadre();
        return null;
    }

    public Boolean tieneComoAncestroA(Mamifero mami){
        if ((mama == mami) || (papa == mami))
            return true;

        Boolean resultado=false;
        if (papa != null)
            resultado=papa.tieneComoAncestroA(mami);

        if (resultado == false && mama!=null)
            resultado=mama.tieneComoAncestroA(mami);
        return resultado;
    }   

}
