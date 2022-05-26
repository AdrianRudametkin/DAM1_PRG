package parking;

import tiempo.Tiempo;

import java.io.Serializable;

public class CocheVip extends Coche implements Serializable {
    //***ATRIBUTOS***
    static final long serialVersionUID = 1L;
    private Vecino duenyo;
    //***CONSTRUCTOR***
    public CocheVip(Coche c, Vecino v) {
        super(c.getDni(), c.getMatricula(), c.getMarca(), c.getModelo(), c.getColor(), c.getDefectos(), c.getEntrada());
        duenyo = v;
    }
}
