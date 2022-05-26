package aplicacion;

import exceptions.ArrayFullException;
import exceptions.NoCarException;
import exceptions.WrongOwnerException;
import parking.Coche;
import parking.Parking;

import java.util.ArrayList;

/**
 * Clase que maneja todos los datos del parking y el manejo de ficheros.
 */
public class GestionParking {
    //***ATRIBUTOS***
    private Parking[] plantas;
    private Parking vip;
    private final String fpDefault = "datos.db";

    //***CONSTRUCTORES***
    public GestionParking(){

    }

    //***MÉTODOS***
    public void entradaCoche(Coche c) throws ArrayFullException {
        for(Parking p: plantas){
            if(!p.isFull()){
                p.anyadirCoche(c);
                return;
            }
        }
        if(vip.posCoche(c)>=0) {
            System.out.print(" [SISTEMA: Vehículo autorizado para entrar]");
            return;
        }

        throw new ArrayFullException();
    }

    public void salidaCoche(Coche c, String dni) throws NoCarException, WrongOwnerException {
        for(Parking p: plantas){
            if(p.posCoche(c)>=0){
                if(p.getCoche(p.posCoche(c)).getDni().equalsIgnoreCase(dni)) {
                    p.quitarCoche(c);
                }else{
                    throw new WrongOwnerException();
                }
            }
        }

        if(vip.posCoche(c)>=0) {
            if(!vip.getCoche(vip.posCoche(c)).getDni().equalsIgnoreCase(dni))
                throw new WrongOwnerException();
            else
                System.out.print(" [SISTEMA: Vehículo autorizado para salir]");
            return;
        }

        throw new NoCarException();
    }

    public String consultarPlazas(){
        return "PLANTA 1:" +
                "\n"+plantas[0]+
                "\nPLANTA 2:"+
                "\n"+plantas[1]+
                "\nZONA VIP:"+
                "\n"+vip;
    }
}
