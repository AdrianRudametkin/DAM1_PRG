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

    /**
     * Método que inicializa la aplicación con datos guardados en un fichero.
     */
    public void init() {
        System.out.print("\n [SISTEMA: Iniciando aplicación...]");
        gp = new GestionParking();
        System.out.print("\n [SISTEMA: Introduzca ruta del fichero (vacío para predeterminado)]");
        System.out.print("\n>>> ");
        String fp = sc.nextLine();
        gp.cargarFichero(fp);

    }

    /**
     * Método que inicia el bucle principal de la aplicación.
     */
    public void start(){
        menuPrincipal();
    }

    /**
     * Método que cierra la aplicación guardando los cambios en un fichero.
     */
    public void close(){
        System.out.print("\n [SISTEMA: Cerrando aplicación]");
        System.out.print("\n [SISTEMA: ¿Desea guardar el fichero?(Sí o no)]");
        if(pedirSiONo("\n>>>")){
            System.out.print("\n [SISTEMA: Guardando fichero...]");
            gp.guardarFichero();
            System.out.print("\n [SISTEMA: Fichero guardado]");
        }else{
            System.out.print("\n [SISTEMA: Fichero ignorado]");
        }
        System.out.print("\n [SISTEMA: Hasta la próxima :D]");

    }

    /**
     * Control de opciones para el menu principal.
     */
    private void menuPrincipal() {
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

    /**
     * Control de opciones para la entrada de un coche.
     */
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

    /**
     * Método que añade un coche nuevo al parking.
     */
    private void cocheNuevo() {
        if (!gp.hayEspacioParking()) {
            System.out.print("\n*NO HAY MÁS PLAZAS LIBRES*");
            continuar();
            return;
        }
        System.out.print("\n**Introduciendo coche nuevo al parking: ");
        System.out.print("\n*Datos del conductor:");
        String dni = pedirString("\nIndique su DNI: ");
        System.out.print("*Datos del coche:");
        String mat = pedirString("\nIndique la matrícula: ");
        if (gp.existeMatricula(mat)) {
            System.out.print("\n <<<Ese coche ya está dentro del parking>>>");
            System.out.print("\n <<<Contactando con las autoridades...>>>");
            continuar();
            return;
        }
        String marca = pedirString("Indique la marca: ");
        String modelo = pedirString("Indique el modelo: ");
        String color = pedirString("Indique el color: ");
        String def = pedirString("Indique si el coche tiene algún desperfecto (opcional):\n");

        Tiempo t = new Tiempo();
        Coche c = new Coche(new Cliente(dni), mat, marca, modelo, color, def, t);
        int[] pos = gp.agregarCoche(c);

        if(pos == null){
            System.out.print("\n [ERROR: No hay más plazas libres en el parking]");
            return;
        }
        System.out.print("\n<<<Coche agregado>>>\n" + c.toString()+"\n");
        System.out.print("\n<<<Que proceda a la plaza (" + (pos[0]+1) + ") en la planta " + pos[1] + ">>>");
        continuar();
    }

    /**
     * Método que añade o deja pasar un coche de un vecino.
     */
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

    /**
     * Sub-método de cocheVecino() para registrar a un nuevo vecino.
     *
     * @param mat la matrícula del vecino
     */
    private void registrarVecino(String mat) {
        System.out.print("\n**Registrando nuevo vecino en el parking: ");
        System.out.print("\n*Datos del conductor:");
        String dni = pedirString("\nIndique su DNI: ");
        String nombre = pedirString("Indique su nombre: ");
        String apellidos = pedirString("Indique sus apellidos: ");
        String dir = pedirString("Indique su dirección: ");
        String tel = pedirString("Indique su teléfono: ");
        String iban = pedirString("Indique su IBAN: ");
        System.out.print("*Datos del coche:");
        String marca = pedirString("\nIndique la marca: ");
        String modelo = pedirString("Indique el modelo: ");
        String color = pedirString("Indique el color: ");
        String def = pedirString("Indique si el coche tiene algún desperfecto (opcional):\n");

        Tiempo t = new Tiempo();
        Vecino v = new Vecino(dni, nombre, apellidos, dir, tel, iban);
        Coche c = new Coche(v, mat, marca, modelo, color, def, t);
        int[] pos = gp.agregarVecino(c);

        System.out.print("<<<Coche agregado>>>\n" + c.toString()+"\n");
        System.out.print("\n<<<Que proceda a la plaza (" + (pos[0]+1) + ") en la planta " + pos[1] + ">>>");
        continuar();
    }

    /**
     * Método que controla la salida de los coches.
     */
    private void salidaCoche() {
        System.out.print("\n**Salida de un coche:");
        String mat = pedirString("\nIndique la matrícula del coche: ");
        if (!gp.existeMatricula(mat)) {
            System.out.print("<<<Matrícula no coincide con ninguna del parking>>>");
            System.out.print("<<<Contactando con las autoridades...>>>");
            continuar();
        } else {
            String dni = pedirString("Indique el DNI del conductor: ");
            try {
                gp.revisarDNI(gp.getCoche(mat), dni);
                System.out.print("\n<<<Datos coinciden>>>");
                if (!gp.esVecino(mat)) {
                    System.out.print("\n<<<Total a pagar "+df.format(gp.eliminarCoche(mat))+"€>>>");
                }else {
                    System.out.print("\n<<<Dejar pasar>>>");
                }
                continuar();
            } catch (WrongOwnerException e) {
                System.out.print("\n <<<Datos no coinciden>>>");
                System.out.print("\n <<<Contactando con las autoridades...>>>");
                continuar();
            }
        }

    }

    /**
     * Control de opciones para las consultas del parking.
     */
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

    /**
     * Método que muestra las plazas gráficamente del parking.
     */
    private void plazasLibres() {
        System.out.print("\n**Mostrando plazas libres:");
        System.out.print("\n" + gp.mostrarPlazas());
        continuar();
    }

    /**
     * Método que muestra los datos del coche de una plaza determinada.
     */
    private void datosPlaza() {
        System.out.print("\n**Mostrando datos de una plaza:");
        int max = gp.numPlantas();
        int planta;
        do {
            planta = pedirInt("\nIndique el número de la planta (de 0 a " + max + "): ");
        } while (planta < 0 || planta > max);


        max = gp.numPlazas(planta);
        int pos;
        do {
            pos = pedirInt("\nIndique el número de la plaza (de 1 a " + max + "): ");
        } while (pos < 1 || pos > max);


        System.out.print(gp.datosCochePorPlaza(pos-1, planta));
        continuar();
    }

    /**
     * Método que muestra los coches que puede tener un cliente (DNI) en el parking.
     */
    private void datosPersona() {
        System.out.print("\n**Mostrando datos de una persona:");
        String dni = pedirString("\nIndique el DNI: ");
        if (gp.existeCliente(dni)) {
            System.out.print(gp.datosCochePorDni(dni));
        } else {
            System.out.print("\n<<<No hay nadie con ese DNI>>>");
        }
        continuar();

    }

    /**
     * Control de opciones para las estadísticas.
     */
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

    /**
     * Método que muestra el número de coches que hay por color.
     */
    private void porColor() {
        System.out.print("\n**Mostrando coches por color: ");
        System.out.print(gp.estadisticasColor());
        continuar();
    }

    /**
     * Método que muestra el número de coches que hay por marca.
     */
    private void porMarca() {
        System.out.print("\n**Mostrando coches por marca: ");
        System.out.print(gp.estadisticasMarca());
        continuar();
    }

    /**
     * Método que muestra el número de coches que hay por la franja horaria en la que entraron.
     */
    private void porHoras() {
        System.out.print("\n**Mostrando coches por franja horaria: ");
        int min, max;
        min = pedirInt("\nIndique la hora inicio: ");
        while (min < 0 || min > 23) {
            min = pedirInt("Elija un numero entre 0 y 23: ");
        }

        max = pedirInt("Indique la hora fin: ");
        while (max < min || max > 24) {
            max = pedirInt("Elija un numero entre " + min + " y 24: ");
        }

        System.out.print(gp.estadisticasHora(min, max));
        continuar();
    }

    private void mostrarTodo() {
        System.out.print("\n**Mostrando todos los coches:");
        System.out.print(gp.mostrarTodo());
        continuar();
    }
}
