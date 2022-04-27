import biblioteca.Empleado;
import biblioteca.Libro;
import database.LibrosDB;
import biblioteca.Usuario;
import database.EmpleadosDB;
import database.UsuariosDB;

import java.util.*;

public class Biblioteca {
    // ***ATRIBUTOS***
    private EmpleadosDB empleadosDB;
    private UsuariosDB usuariosDB;
    private LibrosDB librosDB;
    private Scanner sc;

    /**
     * Método principal.
     *
     * @param args argumentos de JVM
     */
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        b.init();
        b.loop();
    }

    //***************************************************
    //                 Init y Loop
    //***************************************************

    /**
     * Inicialización del programa.
     */
    public void init() {
        empleadosDB = EmpleadosDB.get();
        usuariosDB = UsuariosDB.get();
        librosDB = LibrosDB.get();
        sc = new Scanner(System.in);
    }

    /**
     * Método bucle del programa para el programa principal.
     */
    public void loop() {
        int option;
        do {
            try {
                printMenu();
                option = pedirInt("\nElegir una opción: ");
                switch (option) {
                    case 1 -> altaLibro();
                    case 2 -> busquedaPrincipal();
                    case 3 -> bajaLibro();
                    case 4 -> alquilarLibro();
                    case 5 -> devolucionLibro();
                    case 6 -> gestionEmpleados();
                    case 7 -> gestionUsuarios();
                    case 10 -> System.out.print("\n\nHasta la próxima!!");
                    default -> System.out.print("\n>Por favor, elija una opción válida.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.print("\n>No existe ese numero en la lista.");
                continuar();
                option = -1;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("\n>Por favor, elija un numero válido.");
                continuar();
                option = -1;
            }
        } while (option != 10);
    }

    //***************************************************
    //                Input de Usuario
    //***************************************************

    /**
     * Pedir al usuario un entero positivo.
     *
     * @param msg mensaje para el usuario
     * @return entero
     */
    private int pedirInt(String msg) {
        int i = -1;
        do {
            try {
                System.out.print(msg);
                i = sc.nextInt();
                sc.nextLine();
                if (i < 0) {
                    System.out.print("\n>Por favor, introduzca un número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.print("\n>Por favor, introduzca un número válido.");
                sc.nextLine();
                i = -1;
            }
        } while (i < 0);

        return i;
    }

    /**
     * Pedir al usuario un decimal positivo.
     *
     * @param msg mensaje para el usuario
     * @return decimal
     */
    private double pedirDouble(String msg) {
        double d = -1;
        do {
            try {
                System.out.print(msg);
                d = sc.nextDouble();
                sc.nextLine();
                if (d < 0) {
                    System.out.print("\n>Por favor, introduzca un número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.print("\n>Por favor, introduzca un número válido.");
                sc.nextLine();
                d = -1;
            }
        } while (d < 0);

        return d;
    }

    /**
     * Pedir una cadena no vacía.
     *
     * @param msg mensaje para el usuario
     * @return cadena.
     */
    private String pedirString(String msg) {
        String s;
        do {
            System.out.print(msg);
            s = sc.nextLine();
            if (s.trim().equalsIgnoreCase("")) {
                System.out.print("\n>Cadena vacía, por favor introduzca algo.");
            }
        } while (s.trim().equalsIgnoreCase(""));

        return s;
    }

    /**
     * Pulse intro para continuar;
     */
    private void continuar() {
        System.out.print("\n\nPulse INTRO para continuar...");
        sc.nextLine();
    }

    //***************************************************
    //                 Mostar por Pantalla
    //***************************************************

    /**
     * Imprimir el menu principal en pantalla.
     */
    private static void printMenu() {
        System.out.print("\n\n\n*** MENU PRINCIPAL ***" +
                "\n [1] - Dar de alta un Libro" +
                "\n [2] - Buscar un Libro" +
                "\n [3] - Dar de baja un Libro" +
                "\n [4] - Alquilar un Libro" +
                "\n [5] - Devolver un libro" +
                "\n [6] - Gestión de Empleados" +
                "\n [7] - Gestión de Usuarios" +
                "\n [10]- Salir");
    }

    /**
     * Imprime el menú de búsqueda en pantalla
     */
    private void menuBusqueda() {
        System.out.print("\n\n\n*** MENU BÚSQUEDA ***" +
                "\n [1] - Buscar por Título" +
                "\n [2] - Buscar por Autor" +
                "\n [3] - Buscar por Editorial" +
                "\n [4] - Buscar por Ubicación" +
                "\n [5] - Buscar por Empleado que alquiló" +
                "\n [6] - Buscar por Estado de préstamo" +
                "\n [7] - Buscar por Usuario que lo tiene prestado" +
                "\n [8] - Salir");
    }

    /**
     * Mostrar una lista por pantalla con el índice de la base de datos.
     *
     * @param hm un {@link java.util.HashMap HashMap}
     */
    private static void mostrarLista(HashMap<Integer, Object> hm) {
        for (Map.Entry e : hm.entrySet()) {
            String s = "";
            if (e.getValue() instanceof Libro) s = "Libro";
            else if (e.getValue() instanceof Empleado) s = "Empleado";
            else if (e.getValue() instanceof Usuario) s = "Usuario";

            System.out.print("\n--" + s + " nº" + e.getKey() + "--");
            mostrarObjeto(e.getValue());
        }
        System.out.println();
    }

    /**
     * Muestra solo un objeto.
     *
     * @param o objeto a mostrar
     */
    private static void mostrarObjeto(Object o) {
        System.out.print(o.toString());
    }

    //***************************************************
    //                 Alta Libro
    //***************************************************

    /**
     * Pedir datos de un libro al usuario y añadirlo a la base de datos.
     */
    public void altaLibro() {
        System.out.print("\n\n*** ALTA DE LIBRO ***\n");
        Libro l = new Libro();
        // Pedir info del libro
        l.setTitulo(pedirString("Introduzca el título: "));
        l.setAutor(pedirString("Introduzca el autor: "));
        l.setEditorial(pedirString("Introduzca la editorial: "));
        l.setPasillo(pedirInt("Introduzca su ubicación (número del pasillo): "));
        l.setIsbn(pedirString("Introduzca el ISBN: "));
        l.setPrecio(pedirDouble("Introduzca su precio: "));

        // Añadir a la base de datos
        System.out.print("\n>>Añadiendo a base de datos...");
        int pos = librosDB.darAlta(l);
        System.out.print("\n>>Libro añadido con éxito.");
        System.out.print("\n--Libro nº" + pos + "--");
        mostrarObjeto(l);
        continuar();
    }

    //***************************************************
    //                 Búsqueda Libro
    //***************************************************
    public void busquedaPrincipal() {
        HashMap<Integer, Object> hm = busqueda();
        System.out.print("\n*RESULTADOS:");
        if (hm.isEmpty()) {
            System.out.print("\n>No se ha encontrado ningún libro.");
        } else {
            mostrarLista(hm);
        }
        continuar();
    }

    /**
     * Buscar un libro en la base de datos por varios atributos a elegir.
     *
     * @return un {@link java.util.HashMap HashMap} con el libro y su posición en la BB-DD
     */
    public HashMap<Integer, Object> busqueda() {
        int option;
        HashMap<Integer, Object> hm = new HashMap<>();

        if (librosDB.lista().isEmpty()) {
            System.out.print("\n>No hay libros.");
            return hm;
        }
        do {

            menuBusqueda();
            option = pedirInt("\n Elegir una opción: ");
            switch (option) {
                case 1 -> hm = buscarTitulo();
                case 2 -> hm = buscarAutor();
                case 3 -> hm = buscarEditorial();
                case 4 -> hm = buscarUbicacion();
                case 5 -> hm = buscarAlquiladoPor();
                case 6 -> hm = buscarEstado();
                case 7 -> hm = buscarAlquiladoA();
                default -> System.out.print("\n>Por favor, elija una opción válida.");
            }
        } while (option < 1 || option > 7);
        return hm;
    }

    /**
     * Método que busca libros por su título.
     *
     * @return un {@link java.util.HashMap HashMap} con el libro y su posición en la BB-DD
     */
    private HashMap<Integer, Object> buscarTitulo() {
        System.out.print("\n-- Buscar por título --");
        String tit = pedirString("\nIntroduzca el título del libro: ");

        HashMap<Integer, Object> hm = new HashMap<>();

        for (Libro l : librosDB.lista()) {
            if (l.getTitulo().equalsIgnoreCase(tit)) {
                hm.put(librosDB.lista().indexOf(l), l);
            }
        }
        return hm;
    }

    /**
     * Método que busca libros por autor.
     *
     * @return un {@link java.util.HashMap HashMap} con el libro y su posición en la BB-DD
     */
    private HashMap<Integer, Object> buscarAutor() {
        System.out.print("\n-- Buscar por autor --");
        String aut = pedirString("\nIntroduzca el autor del libro: ");

        HashMap<Integer, Object> hm = new HashMap<>();

        for (Libro l : librosDB.lista()) {
            if (l.getAutor().equalsIgnoreCase(aut)) {
                hm.put(librosDB.lista().indexOf(l), l);
            }
        }
        return hm;
    }

    /**
     * Método que busca libros por editorial.
     *
     * @return un {@link java.util.HashMap HashMap} con el libro y su posición en la BB-DD
     */
    private HashMap<Integer, Object> buscarEditorial() {
        System.out.print("\n-- Buscar por editorial --");
        String edi = pedirString("\nIntroduzca la editorial del libro: ");

        HashMap<Integer, Object> hm = new HashMap<>();

        for (Libro l : librosDB.lista()) {
            if (l.getEditorial().equalsIgnoreCase(edi)) {
                hm.put(librosDB.lista().indexOf(l), l);
            }
        }
        return hm;
    }

    /**
     * Método que busca libros por su posición en la biblioteca.
     *
     * @return un {@link java.util.HashMap HashMap} con el libro y su posición en la BB-DD
     */
    private HashMap<Integer, Object> buscarUbicacion() {
        System.out.print("\n-- Buscar por ubicación --");
        int ubi = pedirInt("\nIntroduzca el número del pasillo: ");

        HashMap<Integer, Object> hm = new HashMap<>();

        for (Libro l : librosDB.lista()) {
            if (l.getPasillo() == ubi) {
                hm.put(librosDB.lista().indexOf(l), l);
            }
        }
        return hm;
    }

    /**
     * Método que busca libros que estén o no prestados.
     *
     * @return un {@link java.util.HashMap HashMap} con el libro y su posición en la BB-DD
     */
    private HashMap<Integer, Object> buscarEstado() {
        // Preguntar por el estado que se pretende buscar
        int option;
        do {
            try {
                option = pedirInt("\n-- Buscar por estado --" +
                        "\n[1] Libros prestados." +
                        "\n[2] Libros en la biblioteca." +
                        "\nIntroduzca una opción: ");
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("\n>Por favor, elija un numero válido.");
                continuar();
                option = -1;
            }
        } while (option != 1 && option != 2);

        HashMap<Integer, Object> hm = new HashMap<>();

        if (option == 1) {
            for (Libro l : librosDB.lista()) {
                if (l.isPrestado()) {
                    hm.put(librosDB.lista().indexOf(l), l);
                }
            }
        } else {
            for (Libro l : librosDB.lista()) {
                if (!l.isPrestado()) {
                    hm.put(librosDB.lista().indexOf(l), l);
                }
            }
        }
        return hm;
    }

    /**
     * Método que busca libros por empleado que lo ha alquilado.
     *
     * @return un {@link java.util.HashMap HashMap} con el libro y su posición en la BB-DD
     */
    private HashMap<Integer, Object> buscarAlquiladoPor() {
        System.out.print("\n-- Buscar por empleado que alquiló --");
        HashMap<Integer, Object> hm = new HashMap<>();

        // Verificar que haya libros prestados
        boolean hayLibro = false;
        for (Libro l : librosDB.lista()) {
            if (l.isPrestado()) {
                hayLibro = true;
                break;
            }
        }
        if (!hayLibro) {
            System.out.print("\n>No hay libros alquilados.");
            return hm;
        }

        // Verificar que el empleado exista
        String empleado = pedirString("\nIntroduzca el nombre del empleado: ");
        if (!empleadosDB.existe(empleado)) {
            System.out.print("\n>No se ha encontrado a ningún empleado con ese nombre.");
            return hm;
        }

        // Devolver todos los libros que tengan ese empleado
        for (Empleado e : buscarEmpleado(empleado)) {
            for (Libro l : librosDB.lista()) {
                if (l.getEmpleado() == e) {
                    hm.put(librosDB.lista().indexOf(l), l);
                }
            }
        }
        return hm;
    }

    /**
     * Método que busca los libros que un usuario haya alquilado
     *
     * @return un {@link java.util.HashMap HashMap} con el libro y su posición en la BB-DD
     */
    private HashMap<Integer, Object> buscarAlquiladoA() {
        System.out.print("\n-- Buscar por usuario que lo tiene alquilado --");
        HashMap<Integer, Object> hm = new HashMap<>();

        // Verificar que hay libros prestados
        boolean hayLibro = false;
        for (Libro l : librosDB.lista()) {
            if (l.isPrestado()) {
                hayLibro = true;
            }
        }
        if (!hayLibro) {
            System.out.print("\n>No hay libros prestados.");
            return hm;
        }

        // Verificar que exista el usuario
        String usuario = pedirString("\nIntroduzca el nombre del usuario: ");
        if (!empleadosDB.existe(usuario)) {
            System.out.print("\n>No se ha encontrado a ningún usuario con ese nombre.");
            return hm;
        }

        // Devolver todos los libros vinculados a ese usuario
        for (Usuario u : buscarUsuarios(usuario)) {
            for (Libro l : librosDB.lista()) {
                if (l.getUsuario() == u) {
                    hm.put(librosDB.lista().indexOf(l), l);
                }
            }
        }
        return hm;
    }


    //***************************************************
    //                 Baja Libro
    //***************************************************
    public void bajaLibro() {
        //TODo baja libro
    }

    //***************************************************
    //                 Alquilar Libro
    //***************************************************
    public void alquilarLibro() {
        //TODO alquiler libro
    }

    //***************************************************
    //                 Devolver Libro
    //***************************************************
    public void devolucionLibro() {
        //TODO devolucion libro
    }

    //***************************************************
    //                 Gestión de Empleados
    //***************************************************
    public void gestionEmpleados() {
        //TODO gestion empleados
    }

    /**
     * Buscar empleados que tengan el nombre indicado.
     *
     * @param nombre nombre del empleado
     * @return sublista de empleados
     */
    public ArrayList<Empleado> buscarEmpleado(String nombre) {
        ArrayList<Empleado> al = new ArrayList<>();
        for (Empleado e : empleadosDB.lista()) {
            if (e.getNombre().equals(nombre)) {
                al.add(e);
            }
        }
        return al;
    }

    //***************************************************
    //                Gestión de Usuarios
    //***************************************************
    public void gestionUsuarios() {
        //TODO gestion usuarios
    }

    /**
     * Buscar usuarios que tengan el nombre indicado.
     *
     * @param nombre nombre del usuario
     * @return sublista de usuarios
     */
    public ArrayList<Usuario> buscarUsuarios(String nombre) {
        ArrayList<Usuario> al = new ArrayList<>();
        for (Usuario u : usuariosDB.lista()) {
            if (u.getNombre().equals(nombre)) {
                al.add(u);
            }
        }
        return al;
    }


}
