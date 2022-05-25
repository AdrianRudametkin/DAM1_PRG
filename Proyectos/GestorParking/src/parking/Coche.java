package parking;

import tiempo.Tiempo;

import java.io.Serializable;

/**
 * Clase del objeto coche, con todos los atributos y métodos necesarios para su manipulación y uso.
 */
public class Coche implements Serializable {
    //***ATRIBUTOS***
    static final long serialVersionUID = 1L;
    private String dni;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private String defectos;
    private Tiempo entrada;

    //***CONSTRUCTORES***

    public Coche(String dni, String matricula, String marca, String modelo, String color, String defectos, Tiempo entrada) {
        this.dni = dni;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.defectos = defectos;
        this.entrada = entrada;
    }

    //***MÉTODOS***
    //  getters
    public String getDni() {
        return dni;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getDefectos() {
        return defectos;
    }

    public Tiempo getEntrada() {
        return entrada;
    }

    @Override
    public String toString(){
        String obs = "";
        if(!defectos.isEmpty())
            obs = "\nObservaciones: "+defectos;

        return "Matricula: "+matricula+
                "\n"+marca+" "+modelo+", "+color+
                obs+
                "\nEntrada: "+entrada.toString()+
                "\nDueño(DNI): " + dni;
    }

    public boolean equals(Coche c){
        if(c.getMatricula().equals(this.matricula) );
    }

}
