package sistema;

import excepciones.EmptyFileException;
import excepciones.EmptyNameException;
import excepciones.NameAlreadyUsedException;
import objetos.Empleado;
import objetos.Libro;
import objetos.Usuario;

import java.io.File;
import java.util.ArrayList;

import static sistema.Utilidades.*;

public class Aplicacion {
    private static GestionDatos gd;

    public void init() {
        System.out.print("\n [SISTEMA: Inicializando aplicación...]");
        System.out.print("\n [SISTEMA: Inicializando gestor de datos...]");
        gd = new GestionDatos();

        System.out.print("\n [SISTEMA: Indique la ruta (en blanco para predeterminado)]" +
                "\n [SISTEMA: Esperando acción del usuario...] >> ");
        String s = sc.nextLine();
        if (!s.trim().isEmpty()) {
            File f = new File(s);
            if (f.isDirectory() || !f.canRead() || !f.canWrite() || !f.canExecute()) {
                System.out.print("\n [ERROR: Ruta del archivo inválida]");
                System.out.print("\n [SISTEMA: Ejecutando con ruta predeterminada]");
            } else {
                gd.setFilePath(s);
            }
        }

        try {
            System.out.print("\n [SISTEMA: Cargando datos del fichero]");
            gd.cargarFichero();
            System.out.print("\n [SISTEMA: Datos cargados correctamente]");
        } catch (EmptyFileException e) {
            int opc = pedirInt("\n [SISTEMA: ¿Cargar valores predeterminados? (1)Sí (2)No]" +
                    "\n [SISTEMA: Esperando acción del usuario...] >> ");
            if (opc == 1) {
                System.out.print("\n [SISTEMA: Cargando valores predeterminados]");
                gd.cargarDatosPredeterminados();
                System.out.print("\n [SISTEMA: Proceso terminado]");
            } else if (opc == 2) {
                System.out.print("\n [SISTEMA: Ignorando valores predeterminados]");
            } else {
                System.out.print("\n [ERROR: Opción no válida]");
                gd.cargarDatosPredeterminados();
            }
        }
        System.out.print("\n [SISTEMA: Inicialización terminada]");
    }

    public void start() {
        menuPrincipal();
    }

    public void close() {
        System.out.print("\n [SISTEMA: Cerrando aplicación]");
        boolean listasVacias = gd.listaLibros().isEmpty() || gd.listaEmpleados().isEmpty() || gd.listaUsuarios().isEmpty();
        if (!listasVacias) {
            int opc = pedirInt("\n [SISTEMA: ¿Guardar datos en el fichero? (1)Sí (2)No]" +
                    "\n [SISTEMA: Esperando acción del usuario...] >> ");
            if (opc == 1) {
                System.out.print("\n [SISTEMA:Guardando datos en fichero]");
                gd.guardarFichero();
            } else if (opc == 2) {
                System.out.print("\n [SISTEMA: Fichero ignorado]");
            } else {
                System.out.print("\n [ERROR: Opción no válida]" +
                        "\n [SISTEMA: Guardando datos en fichero sin su consentimiento]");
                gd.guardarFichero();
            }
        }
        System.out.print("\n [SISTEMA: Cerrando sistema]");
    }

    private void menuPrincipal() {
        int opc;
        do {
            opc = pedirInt(Menu.menuPrincipal());
            switch (opc) {
                case 1 -> gestionDeDatos();
                case 2 -> busquedaDeLibros();
                case 3 -> alquilarLibro();
                case 4 -> devolverLibro();
                case 5 -> opc = 5;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 5);
    }

    //*************************************
    //      GESTIÓN DE DATOS
    //*************************************
    private void gestionDeDatos() {
        int opc;
        do {
            opc = pedirInt(Menu.menuGestion());
            switch (opc) {
                case 1 -> gestionLibros();
                case 2 -> gestionUsuarios();
                case 3 -> gestionEmpleados();
                case 4 -> opc = 4;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 4);
    }

    private void gestionLibros() {
        int opc;
        do {
            opc = pedirInt(Menu.menuGesLibros());
            switch (opc) {
                case 1 -> darAltaLibro();
                case 2 -> darBajaLibro();
                case 3 -> opc = 3;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 3);
    }

    private void darAltaLibro() {
        System.out.print("\n---DAR ALTA LIBRO---");
        String titulo, autor, editorial, isbn;
        int ubicacion;
        double precio;

        titulo = pedirString("\nIndique el título del libro: ");
        autor = pedirString("\nIndique el autor del libro: ");
        editorial = pedirString("\nIndique la editorial del libro: ");
        isbn = pedirString("\nIndique el ISBN del libro: ");
        ubicacion = pedirInt("\nIndique el pasillo donde se encuentra el libro: ");
        precio = pedirDouble("\nIndique el precio del libro: ");

        gd.altaLibro(titulo, autor, editorial, ubicacion, isbn, precio);
        System.out.print("\nOperación completada [libro añadido]");
        continuar();
    }

    private void darBajaLibro() {
        System.out.print("\n---DAR BAJA LIBRO---");
        System.out.print("\nRedirigiendo a la búsqueda...");
        ArrayList<Libro> al = new ArrayList<>();
        int opc;
        do {
            opc = pedirInt(Menu.menuBusqueda());
            switch (opc) {
                case 1 -> al = buscarTitulo();
                case 2 -> al = buscarAutor();
                case 3 -> al = buscarEditorial();
                case 4 -> al = buscarUbucacion();
                case 5 -> al = buscarIsbn();
                case 6 -> al = buscarEmpleado();
                case 7 -> al = buscarUsuario();
                case 8 -> al = buscarEstado();
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc < 0);

        if (al == null || al.isEmpty()) {
            System.out.print("\nVolviendo a la gestión de libros");
            continuar();
        } else if (al.size() == 1) {
            do {
                opc = pedirInt("\n¿Desea eliminarlo?(1)Sí (2)No: ");
                if (opc == 1) {
                    gd.bajaLibro(al.get(0));
                    System.out.print("\nOperación completada [libro eliminado]: " + "\n" + al.get(0).toString() + "\n");
                    continuar();
                } else if (opc == 2) {
                    return;
                } else {
                    opc = -1;
                    System.out.print("\nOpción no válida.");
                }
            } while (opc < 0);

        } else {
            String msj = "\nElija el número del libro que quiere dar de baja: ";
            int num = pedirInt(msj);
            do {
                try {
                    do {
                        opc = pedirInt("\n¿Desea eliminarlo?(1)Sí (2)No: ");
                        if (opc == 1) {
                            gd.bajaLibro(al.get(num));
                            System.out.print("\nOperación completada [libro eliminado]: " + "\n" + al.get(opc).toString() + "\n");
                            continuar();
                            return;
                        } else if (opc == 2) {
                            return;
                        } else {
                            opc = -1;
                            System.out.print("\nOpción no válida.");
                        }
                    } while (opc < 0);

                } catch (IndexOutOfBoundsException exc) {
                    msj = "\nEse numero número no está. Elija un numero válido: ";
                    num = -1;
                }
            } while (num < 0);
        }
    }

    private void gestionUsuarios() {
        int opc;
        do {
            opc = pedirInt(Menu.menuGesUsuarios());
            switch (opc) {
                case 1 -> darAltaUsuario();
                case 2 -> darBajaUsuario();
                case 3 -> mostrarUsuarios();
                case 4 -> opc = 4;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 4);
    }

    private void darAltaUsuario() {
        System.out.print("\n---ALTA USUARIO---");
        String s = pedirString("\nIndique el nombre del usuario: ");
        try {
            gd.altaUsuario(s);
            System.out.print("\nUsuario creado.");
            continuar();
        } catch (NameAlreadyUsedException e) {
            System.out.print("\nEse usuario ya existe.");
        } catch (EmptyNameException e) {
            System.out.print("\nEl nombre de un usuario no puede estar en blanco.");
        }
    }

    private void darBajaUsuario() {
        System.out.print("\n---BAJA USUARIO---");
        String s = pedirString("\nIndique el nombre del usuario: ");
        Usuario u = gd.buscarUsuario(s);
        if (u == null) {
            System.out.print("\nEse usuario no existe.");
            return;
        }

        gd.bajaUsuario(u);
        System.out.print("\nUsuario \"" + u.getNombre() + "\" eliminado.");
        continuar();
    }

    private void mostrarUsuarios() {
        System.out.print("\n---LISTA DE USUARIOS---");
        for(Usuario u: gd.listaUsuarios()){
            System.out.print("\n* "+u.getNombre());
        }
        continuar();
    }

    private void gestionEmpleados() {
        int opc;
        do {
            opc = pedirInt(Menu.menuGesEmpleados());
            switch (opc) {
                case 1 -> darAltaEmpleado();
                case 2 -> darBajaEmpleado();
                case 3 -> mostrarEmpleados();
                case 4 -> opc = 4;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 4);
    }

    private void darAltaEmpleado() {
        System.out.print("\n---ALTA EMPLEADO---");
        String s = pedirString("\nIndique el nombre del empleado: ");
        try {
            gd.altaEmpleado(s);
            System.out.print("\nEmpleado creado.");
            continuar();
        } catch (NameAlreadyUsedException e) {
            System.out.print("\nEse empleado ya existe.");
        } catch (EmptyNameException e) {
            System.out.print("\nEl nombre de un empleado no puede estar en blanco.");
        }
    }

    private void darBajaEmpleado() {
        System.out.print("\n---BAJA EMPLEADO---");
        String s = pedirString("\nIndique el nombre del empleado: ");
        Empleado e = gd.buscarEmpleado(s);
        if (e == null) {
            System.out.print("\nEse empleado no existe.");
            return;
        }

        gd.bajaEmpleado(e);
        System.out.print("\nEmpleado \"" + e.getNombre() + "\" eliminado.");
        continuar();
    }

    private void mostrarEmpleados() {
        System.out.print("\n---LISTA DE EMPLEADOS---");
        for(Empleado e: gd.listaEmpleados()){
            System.out.print("\n* "+e.getNombre());
        }
        continuar();
    }

    //*************************************
    //      BÚSQUEDA
    //*************************************
    private ArrayList<Libro> busquedaDeLibros() {
        if (gd.listaLibros().isEmpty()) {
            System.out.print("\n [SISTEMA: No hay libros en el sistema]" +
                    "\n [SISTEMA: Volviendo al menú principal]");
            return null;
        }
        ArrayList<Libro> al = new ArrayList<>();
        int opc;
        do {
            opc = pedirInt(Menu.menuBusqueda());
            switch (opc) {
                case 1 -> al = buscarTitulo();
                case 2 -> al = buscarAutor();
                case 3 -> al = buscarEditorial();
                case 4 -> al = buscarUbucacion();
                case 5 -> al = buscarIsbn();
                case 6 -> al = buscarEmpleado();
                case 7 -> al = buscarUsuario();
                case 8 -> al = buscarEstado();
                case 9 -> opc = 9;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            } else if (opc != 9) {
                continuar();
            }
        } while (opc != 9);
        return al;
    }

    private ArrayList<Libro> buscarTitulo() {
        String s = pedirString("\nIndique el título del libro: ");
        ArrayList<Libro> al = gd.busquedaLibroTitulo(s);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro que coincida con ese título." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.print("\nResultados de la búsqueda \"" + s + "\":");
            int i = 0;
            for (Libro l : al) {
                System.out.print("\n*(" + i + ")" + l.toString());
                i++;
            }
        }
        return al;
    }

    private ArrayList<Libro> buscarAutor() {
        String s = pedirString("\nIndique el autor del libro: ");
        ArrayList<Libro> al = gd.busquedaLibroAutor(s);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro que coincida con ese autor." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.print("\nResultado(s) de la búsqueda \"" + s + "\":");
            int i = 0;
            for (Libro l : al) {
                System.out.print("\n*(" + i + ")" + l.toString());
                i++;
            }
        }
        return al;
    }

    private ArrayList<Libro> buscarEditorial() {
        String s = pedirString("\nIndique la editorial del libro: ");
        ArrayList<Libro> al = gd.busquedaLibroEditorial(s);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro que coincida con esa editorial." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.print("\nResultados de la búsqueda \"" + s + "\":");
            int i = 0;
            for (Libro l : al) {
                System.out.print("\n*(" + i + ")" + l.toString());
            }
        }
        return al;
    }

    private ArrayList<Libro> buscarUbucacion() {
        int i = pedirInt("\nIndique el número pasillo donde se encuentra el libro: ");
        ArrayList<Libro> al = gd.busquedaLibroUbicacion(i);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro en esa ubicación." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.print("\nResultados de la búsqueda \"Pasillo nº " + i + "\":");
            i = 0;
            for (Libro l : al) {
                System.out.print("\n*(" + i + ")" + l.toString());
                i++;
            }
        }
        return al;
    }

    private ArrayList<Libro> buscarIsbn() {
        String s = pedirString("\nIndique el ISBN del libro: ");
        ArrayList<Libro> al = gd.busquedaLibroIsbn(s);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro que coincida con ese ISBN." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.print("\nResultados de la búsqueda \"" + s + "\":");
            int i = 0;
            for (Libro l : al) {
                System.out.print("\n*(" + i + ")" + l.toString());
                i++;
            }
        }
        return al;
    }

    private ArrayList<Libro> buscarEmpleado() {
        String s = pedirString("\nIndique el nombre del empleado que lo prestó: ");
        Empleado e = gd.buscarEmpleado(s);
        if (e == null) {
            System.out.print("\nEse empleado no existe. Para ver/añadir empleados: " +
                    "\nMenu Principal -> Gestión de Datos -> Gestión de Empleados");
            return null;
        }
        ArrayList<Libro> al = gd.busquedaLibroEmpleado(e);
        if (al.isEmpty()) {
            System.out.print("\nEse empleado no ha prestado ningún libro." +
                    "\nVolviendo al menú de búsqueda.");
            return null;
        } else {
            System.out.print("\nResultados de la búsqueda \"Prestado por " + s + "\":");
            int i = 0;
            for (Libro l : al) {
                System.out.print("\n*(" + i + ")" + l.toString());
                i++;
            }
        }
        return al;
    }

    private ArrayList<Libro> buscarUsuario() {
        String s = pedirString("\nIndique el nombre del usuario que lo alquiló: ");
        Usuario u = gd.buscarUsuario(s);
        if (u == null) {
            System.out.print("\nEse usuario no existe. Para ver/añadir usuarios: " +
                    "\nMenu Principal -> Gestión de Datos -> Gestión de Usuarios");
            return null;
        }
        ArrayList<Libro> al = gd.busquedaLibroUsuario(u);
        if (al.isEmpty()) {
            System.out.print("\nEse usuario no ha alquilado ningún libro." +
                    "\nVolviendo al menú de búsqueda.");
            return null;
        } else {
            System.out.print("\nResultados de la búsqueda \"Alquilado por " + s + "\":");
            int i = 0;
            for (Libro l : al) {
                System.out.print("\n*(" + i + ")" + l.toString());
                i++;
            }
        }
        return al;
    }

    private ArrayList<Libro> buscarEstado() {
        int opc;
        String msj = "\n¿Quiere ver los libros disponibles(1) o alquilados(2)? ";
        ArrayList<Libro> al = new ArrayList<>();
        do {
            opc = pedirInt(msj);
            switch (opc) {
                case 1 -> al = gd.busquedaLibroIsPrestado(false);
                case 2 -> al = gd.busquedaLibroIsPrestado(true);
                default -> opc = -1;
            }

            if (opc < 0) {
                msj = "\nOpciones disponibles: " +
                        "\n (1) Para ver los libros que están disponibles" +
                        "\n (2) Para ver los libros que están alquilados" +
                        "\nElija una de esas dos opciones: ";
            }
        } while (opc < 0);

        String s = "";
        if (opc == 1)
            s = "disponibles";
        else if (opc == 2)
            s = "prestados";

        if (al.isEmpty()) {
            System.out.print("\nNo hay libros " + s + "\n");
        } else {
            System.out.print("\nResultados de la búsqueda \"" + s + "\":");
            int i = 0;
            for (Libro l : al) {
                System.out.print("\n*(" + i + ")" + l.toString());
                i++;
            }
        }
        return al;
    }

    //*************************************
    //      ALQUILAR/DEVOLVER
    //*************************************
    private void alquilarLibro() {
        System.out.print("\n---ALQUILAR LIBRO---" +
                "\nLista de Empleados: ");
        for (Empleado e : gd.listaEmpleados())
            System.out.print(e.getNombre() + ", ");
        System.out.println("");

        String s = pedirString("\nIntroduzca el nombre del empleado: ");
        Empleado empleado = gd.buscarEmpleado(s);
        if (empleado == null) {
            System.out.print("\nEse empleado no existe. Para ver/añadir empleado: " +
                    "\nMenu Principal -> Gestión de Datos -> Gestión de Empleados");
            return;
        }

        System.out.print("\n Lista de usuarios: ");
        for (Usuario u : gd.listaUsuarios())
            System.out.print(u.getNombre() + ", ");
        System.out.println("");

        s = pedirString("\nIntroduzca el nombre del usuario: ");
        Usuario usuario = gd.buscarUsuario(s);
        if (usuario == null) {
            System.out.print("\nEse usuario no existe. Para ver/añadir usuario: " +
                    "\nMenu Principal -> Gestión de Datos -> Gestión de Usuarios");
            return;
        }

        Libro libro;
        ArrayList<Libro> al = gd.busquedaLibroIsPrestado(false);
        System.out.print("Libros Disponibles: ");
        int opc, i = 0;
        for (Libro l : al) {
            System.out.print("\n*(" + i + ")" + l.toString());
            i++;
        }

        String msj = "\nElija el número del libro que quiere prestar: ";
        do {
            try {
                opc = pedirInt(msj);
                libro = al.get(opc);
                gd.alquilarLibro(libro, empleado, usuario);
                System.out.print("\nOperación completada [libro prestado]: " + "\n" + libro.toString() + "\n");
                continuar();
            } catch (IndexOutOfBoundsException exc) {
                msj = "\nEse numero número no existe. Elija un numero válido: ";
                opc = -1;
            }
        } while (opc < 0);
    }

    private void devolverLibro() {
        System.out.print("\n---DEVOLVER LIBRO---");
        Libro libro;
        ArrayList<Libro> al = gd.busquedaLibroIsPrestado(true);
        System.out.print("Libros Prestados: ");
        int opc, i = 0;
        for (Libro l : al) {
            System.out.print("\n*(" + i + ")" + l.toString());
            i++;
        }

        String msj = "\nElija el número del libro que quiere devolver: ";
        do {
            try {
                opc = pedirInt(msj);
                libro = al.get(opc);
                gd.devolverLibro(libro);
                System.out.print("\nOperación completada [libro devuelto]: " + "\n" + libro.toString() + "\n");
                continuar();
            } catch (IndexOutOfBoundsException exc) {
                msj = "\nEse numero número no existe. Elija un numero válido: ";
                opc = -1;
            }
        } while (opc < 0);
    }
}