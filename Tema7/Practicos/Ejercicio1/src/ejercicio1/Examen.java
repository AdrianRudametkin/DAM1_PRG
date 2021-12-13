/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

/*
 *
 * Examen.java
 *
 * Created on Dec 13, 2021 At 9:12:28 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
*/

package ejercicio1;


/**
 *
 * @author  Rogelio Rodriguez
 * @date    Dec 13, 2021
 * @version 1.0
 * 
 */
public class Examen {
    private String asignatura;
    private int aula;
    private Fecha fecha;
    private Hora hora;
    
    public Examen(String asignatura, int aula, Fecha fecha, Hora hora){
        this.asignatura = asignatura;
        this.aula = aula;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }
    
    @Override
    public String toString(){
        return("\nEl examen de "+asignatura+
                " es a las "+hora.toString()+
                " el dia "+fecha.toString()+
                " en el aula "+aula);
    }
}
