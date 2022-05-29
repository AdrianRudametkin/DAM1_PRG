package aplicacion;

import exceptions.NoCarException;
import exceptions.WrongOwnerException;
import parking.Cliente;
import parking.Coche;
import parking.Parking;
import parking.Vecino;
import tiempo.Tiempo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que maneja todos los datos del parking y el manejo de ficheros.
 */
public class GestionParking {
    //***ATRIBUTOS***
    private Parking[] plantas;
    private int reservados;
    private final String FP_DEFAULT = "datos.db";
    private String file;
    private double tarifa = 0.01666;

    //***CONSTRUCTORES***

    /**
     * Constructor por defecto del gestor del parking.
     */
    public GestionParking() {

    }

    //***MÉTODOS***

    /**
     * Método que carga unos datos predeterminados a la aplicación.
     */
    public void datosPredeterminados() {
        plantas = new Parking[]{new Parking(30), new Parking(20)};
        reservados = 10;

        agregarCoche(new Coche(new Cliente("Y1121331F"), "123-QWE", "Ford", "Fiesta", "azul", "", new Tiempo()));
        agregarCoche(new Coche(new Cliente("P1121331F"), "234-QWE", "Ferrari", "Forza", "rojo", "", new Tiempo()));
        agregarCoche(new Coche(new Cliente("R1121331F"), "345-QWE", "Nissan", "Cortés", "magenta", "", new Tiempo()));
        agregarCoche(new Coche(new Cliente("Q1121331F"), "456-QWE", "Citroen", "Cactus", "amarillo", "", new Tiempo()));
        agregarCoche(new Coche(new Cliente("S1121331F"), "567-QWE", "Citroen", "Alpha", "Marrón", "Sin rueda izquierda", new Tiempo()));
        agregarCoche(new Coche(new Cliente("Y1121331F"), "678-QWE", "Ford", "Fiesta", "rojo", "", new Tiempo()));
        agregarCoche(new Coche(new Cliente("F1121331F"), "789-QWE", "Ford", "Cacla", "rojo", "", new Tiempo()));
        agregarCoche(new Coche(new Cliente("G1121331F"), "890-QWE", "Nissan", "Plago", "negro", "Algún rasguño", new Tiempo()));
        agregarCoche(new Coche(new Cliente("L1121331F"), "901-QWE", "Porsche", "R5", "azul", "", new Tiempo()));
        agregarCoche(new Coche(new Cliente("M1121331F"), "012-QWE", "Ford", "Fiesta", "azul", "", new Tiempo()));

        agregarVecino(new Coche(new Vecino("M1987123G", "Raul", "Cofrentes Torno", "C/ Toledo 1", "982984281", "ES12-1212-4321-13412"),
                "012-QWE", "Ford", "Fiesta", "azul", "", new Tiempo()));
        agregarVecino(new Coche(new Vecino("Ñ1987123G", "Carmen", "Cordial Aprenua", "C/ Toledo 2", "982984282", "ES12-1212-4321-13412"),
                "012-QWE", "Ford", "Fiesta", "azul", "", new Tiempo()));
        agregarVecino(new Coche(new Vecino("P1987123G", "Sara", "Ponta Gil", "C/ Toledo 3", "982984283", "ES12-1212-4321-13412"),
                "012-QWE", "Ford", "Fiesta", "azul", "", new Tiempo()));
        agregarVecino(new Coche(new Vecino("E1987123G", "Jordi", "Lotre Lagarto", "C/ Toledo 4", "982984284", "ES12-1212-4321-13412"),
                "012-QWE", "Ford", "Fiesta", "azul", "", new Tiempo()));
        agregarVecino(new Coche(new Vecino("B1987123G", "Danima", "Lasombra", "C/ Toledo 5", "982984285", "ES12-1212-4321-13412"),
                "012-QWE", "Ford", "Fiesta", "azul", "", new Tiempo()));

    }

    //----------------------------
    //    GESTIÓN DE FICHEROS
    //----------------------------

    /**
     * Método que carga los datos de un fichero externo a la aplicación. Si el fichero pasado es inválido se utilizara
     * la ruta predeterminada del fichero.
     *
     * @param fp ruta del fichero
     */
    public void cargarFichero(String fp) {
        if (fp.trim().isEmpty())
            file = FP_DEFAULT;
        else
            file = fp;

        if (!(new File(file)).exists() || (new File(file)).length() <= 0) {
            System.out.print("\n [ERROR: Fichero no existe o está vacío]");
            System.out.print("\n [ERROR: Cargando datos...]");
            datosPredeterminados();
            System.out.print("\n [ERROR: Datos cargados]");
        } else {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                plantas = (Parking[]) ois.readObject();
                reservados = (Integer) ois.readObject();
                if (plantas == null) {
                    System.out.print("\n [ERROR: Fichero Corrupto. Cargando datos predeterminados]");
                    datosPredeterminados();
                    System.out.print("\n [ERROR: Datos cargados]");
                }
                ois.close();
                System.out.print("\n [SISTEMA: Fichero cargado]");
            } catch (ClassNotFoundException e) {
                System.out.print("\n [ERROR: Fichero Corrupto. Cargando datos predeterminados]");
                datosPredeterminados();
                System.out.print("\n [ERROR: Datos cargados]");
            } catch (IOException e) {
                System.out.print("\n [ERROR: Fichero inaccesible. Utilizando ruta predeterminada]");
                this.file = FP_DEFAULT;
            }
        }
    }

    /**
     * Método que guarda todos los datos de la sesión en un fichero. Si el fichero es inaccesible, se utilizara la ruta
     * por defecto.
     */
    public void guardarFichero() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(plantas);
            oos.writeObject(reservados);
            oos.close();
        } catch (IOException e) {
            System.out.print("\n [ERROR: Fichero inaccesible. Utilizando ruta predeterminada]");
            this.file = FP_DEFAULT;
            guardarFichero();
        }
    }

    //----------------------------
    //    GESTIÓN PARKING
    //----------------------------

    /**
     * Método que añade un coche a la primera plaza libre del parking que no esté reservada. Devuelve la posición y la
     * planta del hueco libre, o null si no hay sitio.
     *
     * @param c Coche a aparcar
     * @return posición del parking libre
     */
    public int[] agregarCoche(Coche c) {
        for (int i = 0; i < plantas.length; i++) {
            int max;
            if (i == 0)
                max = plantas[i].getPlazas() - reservados;
            else
                max = plantas[i].getPlazas();

            for (int j = 0; j < max; j++) {
                if (plantas[i].getCoche(j) == null) {
                    plantas[i].anyadirCoche(c, j);
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }

    /**
     * Método que añade un coche a la primera plaza libre de las plazas reservadas. Devuelve la posición y la
     * planta del hueco libre, o null si no hay sitio.
     *
     * @param c Coche a aparcar
     * @return posición del parking reservado libre
     */
    public int[] agregarVecino(Coche c) {
        int min = plantas[0].getPlazas() - reservados;
        for (int j = min; j < plantas[0].getPlazas(); j++) {
            if (plantas[0].getCoche(j) == null) {
                plantas[0].anyadirCoche(c, j);
                return new int[]{j, 0};
            }
        }
        return null;
    }

    /**
     * Método que indica el precio a pagar cuando un coche sale del parking. También elimina el coche del parking
     * y deja la plaza libre.
     *
     * @param mat matrícula del coche que sale
     * @return importe a pagar
     */
    public double eliminarCoche(String mat) {
        long minutos = 0;
        for (Parking p : plantas) {
            if (p.buscarMatricula(mat) != null) {
                try {
                    minutos = p.buscarMatricula(mat).getEntrada().minutesDifference(new Tiempo());
                    p.quitarCoche(p.buscarMatricula(mat));
                } catch (NoCarException e) {
                    System.out.print(" [ERROR: No existe el coche]");
                    minutos = 0;
                }
            }
        }

        return minutos * tarifa;
    }


    //----------------------------
    //    CONSEGUIR DATOS
    //----------------------------

    /**
     * Método que devuelve el coche que tiene la matrícula pasada.
     *
     * @param mat matrícula del coche
     * @return el Coche
     */
    public Coche getCoche(String mat) {
        for (Parking p : plantas) {
            if (p.buscarMatricula(mat) != null) {
                return p.buscarMatricula(mat);
            }
        }
        return null;
    }

    /**
     * Método que devuelve el número de plazas totales que tiene un planta,
     *
     * @param planta planta
     * @return número de plazas
     */
    public int numPlazas(int planta) {
        return plantas[planta].getPlazas();
    }

    /**
     * Método que devuelve el número de plantas que maneja este gestor de parking.
     *
     * @return número de plantas
     */
    public int numPlantas() {
        return plantas.length - 1;
    }

    //----------------------------
    //    VERIFICACIONES
    //----------------------------

    /**
     * Método que indica si existe un cliente o vecino por su DNI.
     *
     * @param dni DNI del cliente
     * @return verdadero si existe
     */
    public boolean existeCliente(String dni) {
        for (Parking p : plantas) {
            for (Coche c : p.getCoches()) {
                if (c == null)
                    continue;
                if (c.getCliente().getDni().equalsIgnoreCase(dni))
                    return true;
            }
        }
        return false;
    }

    /**
     * Método que indica si la matrícula de un coche pertenece al de las plazas reservadas. Devuelve falso también en el
     * caso de que no se encuentre esa matrícula.
     *
     * @param mat matrícula del coche
     * @return verdadero si existe
     */
    public boolean esVecino(String mat) {
        int min = plantas[0].getPlazas() - reservados;
        for (int j = min; j < plantas[0].getPlazas(); j++) {
            if (plantas[0].getCoche(j) == null)
                continue;
            if (plantas[0].getCoche(j).getMatricula().equalsIgnoreCase(mat)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que indica si la matrícula de un coche se encuentra en el parking (reservado y normal). Devuelve falso también en el
     * caso de que no se encuentre esa matrícula.
     *
     * @param mat matrícula del coche
     * @return verdadero si existe
     */
    public boolean existeMatricula(String mat) {
        for (Parking p : plantas) {
            if (p.buscarMatricula(mat) != null)
                return true;
        }
        return false;
    }


    /**
     * Método que indica si quedan plazas libres en el parking normal.
     *
     * @return verdadero si hay espacio
     */
    public boolean hayEspacioParking() {
        for (int i = 0; i < plantas.length; i++) {
            int max;
            if (i == 0)
                max = plantas[i].getPlazas() - reservados;
            else
                max = plantas[i].getPlazas();

            for (int j = 0; j < max; j++) {
                if (plantas[i].getCoche(j) == null)
                    return true;
            }
        }
        return false;
    }

    /**
     * Método que indica si quedan plazas libres en el parking reservado.
     *
     * @return verdadero si hay espacio
     */
    public boolean hayEspacioVecinos() {
        for (int i = plantas[0].getPlazas() - reservados; i < plantas[0].getPlazas(); i++) {
            if (plantas[0].getCoche(i) == null)
                return true;
        }
        return false;
    }

    /**
     * Método que comprueba si el DNI del cliente coincide con los datos que se tiene del coche.
     *
     * @param coche coche del parking
     * @param dni   DNI del cliente
     * @throws WrongOwnerException en caso de que la información no coincida
     */
    public void revisarDNI(Coche coche, String dni) throws WrongOwnerException {
        for (Parking p : plantas) {
            int pos = p.posCoche(coche);
            if (!(pos < 0)) {
                if (!p.getCoche(pos).getCliente().getDni().equalsIgnoreCase(dni)) {
                    throw new WrongOwnerException();
                }
            }
        }
    }


    //----------------------------
    //    MOSTRAR DATOS
    //----------------------------

    /**
     * Método que devuelve los datos de un coche por su plaza en el parking.
     *
     * @param pos    plaza en el parking
     * @param planta planta
     * @return cadena de información
     */
    public String datosCochePorPlaza(int pos, int planta) {
        if (plantas[planta].getCoche(pos) == null)
            return "No hay ningún coche en esta plaza.";
        return plantas[planta].getCoche(pos).toString();
    }

    /**
     * Método que devuelve los datos de los coches que coincidan con el DNI de un cliente.
     *
     * @param dni DNI del cliente
     * @return cadena de información
     */
    public String datosCochePorDni(String dni) {
        String out = "";
        for (int i = 0; i < plantas.length; i++) {
            int max = plantas[i].getPlazas();
            for (int j = 0; j < max; j++) {
                if (plantas[i].getCoche(j) == null)
                    continue;
                if (plantas[i].getCoche(j).getCliente().getDni().equalsIgnoreCase(dni)) {
                    out += "\n--Planta " + (i + 1) + ", plaza " + j + "--" +
                            "\n" + plantas[i].getCoche(j).toString() + "\n";
                }
            }
        }
        if (out.trim().isEmpty())
            out = "No se ha encontrado ningún coches asociado a ese DNI.";

        return out + "\n";
    }

    /**
     * Método que devuelve el número de coches por color.
     *
     * @return cadena de información
     */
    public String estadisticasColor() {
        HashMap<String, Integer> hm = new HashMap<>();

        for (Parking p : plantas) {
            for (Coche c : p.getCoches()) {
                if (c == null)
                    continue;
                String color = c.getColor().toLowerCase();
                if (hm.containsKey(color))
                    hm.replace(color, hm.get(color) + 1);
                else
                    hm.put(color, 1);
            }
        }

        String out = "";

        out += "\nCOLOR";
        for (int i = 0; i <= (13 - "COLOR".length()); i++)
            out += " ";
        out += "NÚMERO";
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            out += "\n·" + e.getKey();
            for (int i = 0; i <= (13 - e.getKey().length()); i++)
                out += " ";
            out += e.getValue();
        }

        return out + "\n";
    }

    /**
     * Método que devuelve el número de coches por marca.
     *
     * @return cadena de información
     */
    public String estadisticasMarca() {
        HashMap<String, Integer> hm = new HashMap<>();

        for (Parking p : plantas) {
            for (Coche c : p.getCoches()) {
                if (c == null)
                    continue;
                String marca = c.getMarca().toLowerCase();
                if (hm.containsKey(marca))
                    hm.replace(marca, hm.get(marca) + 1);
                else
                    hm.put(marca, 1);
            }
        }

        String out = "";

        out += "\nMARCA";
        for (int i = 0; i <= (13 - "MARCA".length()); i++)
            out += " ";
        out += "NÚMERO";
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            out += "\n·" + e.getKey();
            for (int i = 0; i <= (13 - e.getKey().length()); i++)
                out += " ";
            out += e.getValue();
        }

        return out + "\n";
    }

    /**
     * Método que devuelve el número de coches por franja horaria.
     *
     * @param min límite horario mínimo
     * @param max límite horario máximo
     * @return cadena de información
     */
    public String estadisticasHora(int min, int max) {
        if ((min < 0 || min > 24) || (max < 0 || max > 24) || (min >= max)) {
            System.out.print(" [ERROR: Franja horaria no válida]");
            return null;
        }
        int numCoches = 0;

        for (Parking p : plantas) {
            for (Coche c : p.getCoches()) {
                if (c == null)
                    continue;
                int hora = c.getEntrada().getHour().getHour();
                if (hora >= min && hora <= max)
                    numCoches++;
            }
        }

        return "\nNúmero de coches que entraron entre las " + min + "h y las " + max + "h: " + numCoches + "\n";
    }

    /**
     * Método que devuelve de manera gráfica las plazas libres y ocupadas.
     *
     * @return cadena de información
     */
    public String mostrarPlazas() {
        String out = "";
        out += "\n [X = plaza ocupada]";
        out += "\n Plazas Reservadas (planta 0): " + (plantas[0].getPlazas() - reservados + 1) + " a " + plantas[0].getPlazas();
        for (Parking p : plantas) {
            out += "\n" + p.toString();
        }

        return out + "\n";
    }

    /**
     * Método que devuelve todos los coches y toda su información. Ordenado por planta y plaza que ocupa cada coche.
     *
     * @return cadena de información
     */
    public String mostrarTodo() {
        String out = "";
        out += "\n [X = plaza ocupada]";
        out += "\n Plazas Reservadas (planta 0): " + (plantas[0].getPlazas() - reservados + 1) + " a " + plantas[0].getPlazas();
        for (int i = 0; i < plantas.length; i++) {
            out += "\n" + plantas[i].toString();
            for (int j = 0; j < plantas[i].getPlazas(); j++) {
                if (plantas[i].getCoche(j) == null)
                    continue;
                out += "\n*Plaza " + (j + 1) + ":";
                out += "\n" + plantas[i].getCoche(j).toString();
                out += "\n";
            }
            out += "\n\n";
        }

        return out;
    }


}
