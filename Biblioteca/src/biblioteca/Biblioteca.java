package biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Biblioteca {
    // ***ATRIBUTOS***
    private EmpleadosDB empleadosDB;
    private UsuariosDB usuariosDB;
    private LibrosDB librosDB;
    private Scanner sc;

    /**
     * Método principal.
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
    public void init(){
        empleadosDB = EmpleadosDB.get();
        usuariosDB = UsuariosDB.get();
        librosDB = LibrosDB.get();
        sc = new Scanner(System.in);
    }

    /**
     * Método bucle del programa para el programa principal.
     */
    public void loop(){
        int option;
        do {
            try {
                printMenu();
                option = pedirInt("\n Elegir una opción: ");
                switch (option) {
                    case 1 -> altaLibro();
                    case 2 -> busqueda();
                    case 3 -> bajaLibro();
                    case 4 -> alquilarLibro();
                    case 5 -> devolucionLibro();
                    case 6 -> gestionEmpleados();
                    case 7 -> gestionUsuarios();
                    case 10 -> System.out.print("\n\nHasta la próxima!!");
                    default -> System.out.print("\nPor favor, elija una opción válida.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.print("\nNo existe ese numero en la lista.");
                continuar();
                option = -1;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("\nPor favor, elija un numero válido.");
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
                    System.out.print("\nPor favor, introduzca un número positivo.");
                }
            }catch(InputMismatchException e){
                System.out.print("\nPor favor, introduzca un número válido.");
                sc.nextLine();
                i = -1;
            }
        }while(i<0);

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
                    System.out.print("\nPor favor, introduzca un número positivo.");
                }
            }catch(InputMismatchException e){
                System.out.print("\nPor favor, introduzca un número válido.");
                sc.nextLine();
                d = -1;
            }
        }while(d<0);

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
            if(s.trim().equalsIgnoreCase("")){
                System.out.print("\nCadena vacía, por favor introduzca algo.");
            }
        }while(s.trim().equalsIgnoreCase(""));

        return s;
    }

    /**
     * Pulse intro para continuar;
     */
    private void continuar(){
        System.out.print("\nPulse INTRO para continuar...");
        sc.nextLine();
    }

    //***************************************************
    //                 Mostar por Pantalla
    //***************************************************
    /**
     * Imprimir el menu principal en pantalla.
     */
    private static void printMenu() {
        System.out.print("\n*** MENU PRINCIPAL ***" +
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
    private void menuBusqueda(){
        System.out.print("\n*** MENU BÚSQUEDA ***" +
                "\n [1] - Buscar por Título" +
                "\n [2] - Buscar por Autor" +
                "\n [3] - Buscar por Editorial" +
                "\n [4] - Buscar por Ubicación" +
                "\n [5] - Buscar por Empleado que lo prestó" +
                "\n [6] - Buscar por Estado de préstamo" +
                "\n [7] - Buscar por Usuario que lo tiene prestado" +
                "\n [8] - Salir");
    }

    /**
     * Mostrar una lista de tipo {@link java.util.ArrayList ArrayList} por pantalla.
     *
     * @param l un {@link java.util.ArrayList ArrayList}
     */
    private static void mostrarLista(ArrayList<Object> l) {

        for (Object o : l) {
            String s = "";
            if(o instanceof Libro) s = "Libro";
            else if(o instanceof Empleado) s = "Empleado";
            else if(o instanceof Usuario) s = "Usuario";
            System.out.print("\n\n--"+s+" nº"+l.indexOf(o)+"--");
            mostrarObjeto(o);
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
    public void altaLibro(){
        System.out.print("\n\n*** ALTA DE LIBRO ***");
        Libro l = new Libro();
        // Pedir info del libro
        l.setTitulo(pedirString("\nIntroduzca el título: "));
        l.setAutor(pedirString("\nIntroduzca el autor: "));
        l.setEditorial(pedirString("\nIntroduzca la editorial: "));
        l.setPasillo(pedirInt("\nIntroduzca su ubicación (número del pasillo): "));
        l.setIsbn(pedirString("\nIntroduzca el ISBN: "));
        l.setPrecio(pedirDouble("\nIntroduzca su precio: "));

        // Añadir a la base de datos
        System.out.print("\n >>Añadiendo a base de datos...");
        int pos = librosDB.darAlta(l);
        System.out.print("\nLibro añadido con éxito.");
        System.out.print("\n--Libro nº"+pos+"--");
        System.out.println(l.toString());
        continuar();
    }

    //***************************************************
    //                 Búsqueda Libro
    //***************************************************
    /**
     * Buscar un libro en la base de datos por varios atributos a elegir.
     */
    public void busqueda(){
        int option;
        do {
            try {
                menuBusqueda();
                option = pedirInt("\n Elegir una opción: ");
                switch (option) {
                    case 1 -> buscarTitulo();
                    case 2 -> buscarAutor();
                    case 3 -> buscarEditorial();
                    case 4 -> buscarUbicacion();
                    case 5 -> buscarPrestadoPor();
                    case 6 -> buscarEstado();
                    case 7 -> buscarPrestadoA();
                    case 8 -> System.out.print("\n\nVolviendo al menú principal.");
                    default -> System.out.print("\nPor favor, elija una opción válida.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.print("\nNo existe ese numero en la lista.");
                continuar();
                option = -1;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("\nPor favor, elija un numero válido.");
                continuar();
                option = -1;
            }
        } while (option != 10);
        continuar();
    }

    private void buscarTitulo(){
        //TODO busqueda por titulo
    }

    private void buscarAutor(){
        //TODO busqueda por autor
    }

    private void buscarEditorial(){
        //TODO busqueda por editorial
    }

    private void buscarUbicacion(){
        //TODO busqueda por ubicacion
    }

    private void buscarEstado(){
        //TODO busqueda por estado
    }

    private void buscarPrestadoPor(){
        //TODO busqueda por empleddo
    }

    private void buscarPrestadoA(){
        //TODO busqueda por usuario
    }


    //***************************************************
    //                 Baja Libro
    //***************************************************
    public void bajaLibro(){
        //TODo baja libro
    }

    //***************************************************
    //                 Alquilar Libro
    //***************************************************
    public void alquilarLibro(){
        //TODO alquiler libro
    }

    //***************************************************
    //                 Devolver Libro
    //***************************************************
    public void  devolucionLibro(){
        //TODO devolucion libro
    }

    //***************************************************
    //                 Gestión de Empleados
    //***************************************************
    public void gestionEmpleados(){
        //TODO gestion empleados
    }

    //***************************************************
    //                Gestión de Usuarios
    //***************************************************
    public void gestionUsuarios(){
        //TODO gestion usuarios
    }






}
