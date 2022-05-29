package aplicacion;

import exceptions.WrongOwnerException;
import parking.Cliente;
import parking.Coche;
import parking.Vecino;
import tiempo.Tiempo;

import static utilities.Utilities.*;

/**
 * Clase que maneja la interfaz con el usuario y controla el sistema.
 */
public class App {
    //***ATRIBUTOS***
    private GestionParking gp;
    //***CONSTRUCTOR***


    //***MÉTODOS***
    public void menuPrincipal() {
        int opc;
        do {
            opc = pedirInt(Menus.menuPrincipal());
            switch (opc) {
                case 1 -> entradaCoche();
                case 2 -> salidaCoche();
                case 3 -> consultas();
                case 4 -> opc = 4;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 4);
    }

    private void entradaCoche() {
        int opc;
        do {
            opc = pedirInt(Menus.menuEntrada());
            switch (opc) {
                case 1 -> cocheNuevo();
                case 2 -> cocheVecino();
                case 3 -> opc = 3;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 3);
    }

    private void cocheNuevo() {
        if (gp.hayEspacioParking()) {
            System.out.print("\n*NO HAY MÁS PLAZAS LIBRES*");
            continuar();
            return;
        }
        System.out.print("\n**Introduciendo coche nuevo al parking: ");
        System.out.print("\n*Datos del conductor:");
        String dni = pedirString("\nIndique su DNI: ");
        System.out.print("\n*Datos del coche:");
        String mat = pedirString("\nIndique la matrícula: ");
        if (gp.existeMatricula(mat)) {
            System.out.print("\n <<<Ese coche ya está dentro del parking>>>");
            System.out.print("\n <<<Contactando con las autoridades...>>>");
            continuar();
            return;
        }
        String marca = pedirString("\nIndique la marca: ");
        String modelo = pedirString("\nIndique el modelo: ");
        String color = pedirString("\nIndique el modelo: ");
        String def = pedirString("\nIndique si el coche tiene algún desperfecto (opcional):\n");

        Tiempo t = new Tiempo();
        Coche c = new Coche(new Cliente(dni), mat, marca, modelo, color, def, t);
        int[] pos = gp.agregarCoche(c);

        System.out.print("\n Coche agregado: \n" + c.toString());
        System.out.print("\n**Que proceda a la plaza (" + pos[0] + ") en la planta " + pos[1] + ".");
        continuar();
    }

    private void cocheVecino() {
        System.out.print("\n**Entrada de un vecino:");
        String mat = pedirString("\nIndique la matrícula del coche: ");

        if (gp.esVecino(mat)) {
            System.out.print("\n*Coche registrado en el parking ");
            String dni = pedirString("\nIndique el DNI para verificar: ");
            try {
                gp.revisarDNI(gp.getCoche(mat), dni);
                System.out.print("\n<<<Datos coinciden>>>");
                System.out.print("\n<<<Dejar pasar>>>");
                continuar();
            } catch (WrongOwnerException e) {
                System.out.print("\n <<<Datos no coinciden>>>");
                System.out.print("\n <<<Contactando con las autoridades...>>>");
                continuar();
            }
        } else {
            if (!gp.existeMatricula(mat) && gp.hayEspacioVecinos()) {
                if (pedirSiONo("\nEste coche no se encuentra registrado.¿Desea registrarlo?(Sí o no)")) {
                    registrarVecino(mat);
                } else {
                    return;
                }
            } else if (!gp.existeMatricula(mat) && !gp.hayEspacioVecinos()) {
                System.out.print("\n<<<<Este coche no esta registrado y no hay mas espacio para registrar nuevos vecinos>>>");
                continuar();
            } else {
                System.out.print("\n<<<Ese coche ya está dentro del parking>>>");
                System.out.print("\n<<<Contactando con las autoridades...>>>");
                continuar();
            }
        }

    }

    private void registrarVecino(String mat) {
        System.out.print("\n**Registrando nuevo vecino en el parking: ");
        System.out.print("\n*Datos del conductor:");
        String dni = pedirString("\nIndique su DNI: ");
        String nombre = pedirString("\nIndique su nombre: ");
        String apellidos = pedirString("\nIndique sus apellidos: ");
        String dir = pedirString("\nIndique su dirección: ");
        String tel = pedirString("\nIndique su teléfono: ");
        String iban = pedirString("\nIndique su IBAN: ");
        System.out.print("\n*Datos del coche:");
        String marca = pedirString("\nIndique la marca: ");
        String modelo = pedirString("\nIndique el modelo: ");
        String color = pedirString("\nIndique el modelo: ");
        String def = pedirString("\nIndique si el coche tiene algún desperfecto (opcional):\n");

        Tiempo t = new Tiempo();
        Vecino v = new Vecino(dni, nombre, apellidos, dir, tel, iban);
        Coche c = new Coche(v, mat, marca, modelo, color, def, t);
        int[] pos = gp.agregarCoche(c);

        System.out.print("\n Coche agregado: \n" + c.toString());
        System.out.print("\n**Que proceda a la plaza (" + pos[0] + ") en la planta " + pos[1] + ".");
        continuar();
    }

    private void salidaCoche() {
        System.out.print("\n**Salida de un coche:");
        String mat = pedirString("\nIndique la matrícula del coche: ");
        if (!gp.existeMatricula(mat)) {
            System.out.print("<<<Matrícula no coincide con ninguna del parking>>>");
            System.out.print("<<<Contactando con las autoridades...>>>");
            continuar();
        } else {
            String dni = pedirString("\nIndique el DNI del conductor: ");
            try {
                gp.revisarDNI(gp.getCoche(mat), dni);
                if (!gp.esVecino(mat))
                    gp.eliminarCoche(mat);
                System.out.print("\n<<<Datos coinciden>>>");
                System.out.print("\n<<<Dejar pasar>>>");
                continuar();
            } catch (WrongOwnerException e) {
                System.out.print("\n <<<Datos no coinciden>>>");
                System.out.print("\n <<<Contactando con las autoridades...>>>");
                continuar();
            }
        }

    }

    private void consultas() {
        int opc;
        do {
            opc = pedirInt(Menus.menuConsultas());
            switch (opc) {
                case 1 -> plazasLibres();
                case 2 -> datosPlaza();
                case 3 -> datosPersona();
                case 4 -> estadisticas();
                case 5 -> mostrarTodo();
                case 6 -> opc = 6;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 6);
    }

    private void plazasLibres() {
        System.out.print("\n**Mostrando plazas libres:");
        System.out.print("\n" + gp.mostrarPlazas());
    }

    private void datosPlaza() {
        System.out.print("\n**Mostrando datos de una plaza:");
        int max = gp.numPlantas();
        int planta;
        do {
            planta = pedirInt("\nIndique el número de la planta (de 0 a " + max + "): ");
        } while (planta >= 0 && planta < max);


        max = gp.numPlazas(planta);
        int pos;
        do {
            pos = pedirInt("\nIndique el número de la plaza (de 0 a " + max + "): ");
        } while (pos >= 0 && pos < max);


        System.out.print(gp.datosCoche(pos, planta));
    }

    private void datosPersona() {
        System.out.print("\n**Mostrando datos de una persona:");
        String dni = pedirString("\nIndique el DNI: ");
        if(gp.existeCliente(dni)){
            System.out.print(gp.datosCochePorDni(dni));
        }else{
            System.out.print("\n<<<No hay nadie con ese DNI>>>");
        }
        continuar();

    }

    private void estadisticas() {
        int opc;
        do {
            opc = pedirInt(Menus.menuEstadisticas());
            switch (opc) {
                case 1 -> porColor();
                case 2 -> porMarca();
                case 3 -> porHoras();
                case 4 -> opc = 4;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 4);
    }

    private void porColor() {
        System.out.print("\n**Mostrando coches por color: ");
        System.out.print(gp.estadisticasColor());
    }

    private void porMarca() {
        System.out.print("\n**Mostrando coches por marca: ");
        System.out.print(gp.estadisticasMarca());
    }

    private void porHoras() {
        System.out.print("\n**Mostrando coches por franja horaria: ");
        System.out.print(gp.estadisticasHora());
        
    }

    private void mostrarTodo() {
        System.out.print("\n**Mostrando todos los coches:");
        System.out.print(gp.mostrarTodo());

    }
}
