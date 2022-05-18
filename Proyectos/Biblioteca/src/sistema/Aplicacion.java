package sistema;

import excepciones.EmptyFileException;
import objetos.Empleado;
import objetos.Libro;
import objetos.Usuario;

import java.util.ArrayList;

import static sistema.Utilidades.*;

public class Aplicacion {
    private static GestionDatos gd;

    public void init() {
        System.out.print("\n [SISTEMA: Inicializando aplicación...]");
        System.out.print("\n [SISTEMA: Inicializando gestor de datos...]");
        gd = new GestionDatos();
        String s = pedirString("\n [SISTEMA] Indique la ruta (en blanco para predeterminado): ");
        if(!s.trim().isEmpty())
            gd.setFilePath(s);


        gd = new GestionDatos();
        try {
            gd.cargarFichero();
        } catch (EmptyFileException e) {
            int opc = pedirInt("\n [SISTEMA: Archivo no existe o está vacío]" +
                    "\n [SISTEMA]¿Cargar valores predeterminados? Sí(1) No(2): ");
            if(opc==1)
                gd.cargarDatosPredeterminados();
            else if(opc==2)
                System.out.print("\n [SISTEMA: Ignorando valores predeterminados]");
            else{
                System.out.print("\n [ERROR: Opción no válida]");
                gd.cargarDatosPredeterminados();
            }
        }
    }

    public void start() {
        menuPrincipal();
        System.out.print("\n [SISTEMA: Cerrando aplicación]");
        boolean listasVacias = gd.listaLibros().isEmpty() || gd.listaEmpleados().isEmpty() || gd.listaUsuarios().isEmpty();
        if(!listasVacias){
            int opc = pedirInt("\n [SISTEMA]¿Guardar datos en el fichero? Sí(1) No(2): ");
            if(opc==1)
                gd.guardarFichero();
            else if(opc==2)
                System.out.print("\n [SISTEMA: Ok. Tu trabajo no se conservará]");
            else{
                System.out.print("\n [ERROR: Opción no válida. Te guardaré los datos]");
                gd.guardarFichero();
            }
        }
        System.out.print("\n [SISTEMA: Cerrando]");

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
    }

    private void darBajaLibro() {

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
    }

    private void darBajaUsuario() {
    }

    private void mostrarUsuarios() {
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
    }

    private void darBajaEmpleado() {
    }

    private void mostrarEmpleados() {
    }

    //*************************************
    //      BÚSQUEDA
    //*************************************
    private void busquedaDeLibros() {
        if(gd.listaLibros().isEmpty()){
            System.out.print(" [SISTEMA: No hay libros en el sistema]" +
                    "\t [-Volviendo al menú principal]");
            return;
        }
        int opc;
        do {
            opc = pedirInt(Menu.menuBusqueda());
            switch (opc) {
                case 1 -> buscarTitulo();
                case 2 -> buscarAutor();
                case 3 -> buscarEditorial();
                case 4 -> buscarUbucacion();
                case 5 -> buscarIsbn();
                case 6 -> buscarEmpleado();
                case 7 -> buscarUsuario();
                case 8 -> buscarEstado();
                case 9 -> opc = 9;
                default -> opc = -1;
            }
            if (opc < 0) {
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        } while (opc != 9);
    }

    private void buscarTitulo() {
        String s = pedirString("\nIndique el título del libro: ");
        ArrayList<Libro> al = gd.busquedaLibroTitulo(s);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro que coincida con ese título." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.println("\nResultados de la búsqueda \"" + s + "\":");
            for (Libro l : al) {
                System.out.print("*" + l.toString());
                System.out.println("");
            }
        }
    }

    private void buscarAutor() {
        String s = pedirString("\nIndique el autor del libro: ");
        ArrayList<Libro> al = gd.busquedaLibroAutor(s);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro que coincida con ese autor." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.println("\nResultado(s) de la búsqueda \"" + s + "\":");
            for (Libro l : al) {
                System.out.print("*" + l.toString());
                System.out.println("");
            }
        }
    }

    private void buscarEditorial() {
        String s = pedirString("\nIndique la editorial del libro: ");
        ArrayList<Libro> al = gd.busquedaLibroEditorial(s);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro que coincida con esa editorial." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.println("\nResultados de la búsqueda \"" + s + "\":");
            for (Libro l : al) {
                System.out.print("*" + l.toString());
                System.out.println("");
            }
        }
    }

    private void buscarUbucacion() {
        int i = pedirInt("\nIndique el número pasillo donde se encuentra el libro: ");
        ArrayList<Libro> al = gd.busquedaLibroUbicacion(i);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro en esa ubicación." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.println("\nResultados de la búsqueda \"Pasillo nº " + i + "\":");
            for (Libro l : al) {
                System.out.print("*" + l.toString());
                System.out.println("");
            }
        }
    }

    private void buscarIsbn() {
        String s = pedirString("\nIndique el ISBN del libro: ");
        ArrayList<Libro> al = gd.busquedaLibroIsbn(s);
        if (al.isEmpty()) {
            System.out.print("\nNo hay ningún libro que coincida con ese ISBN." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.println("\nResultados de la búsqueda \"" + s + "\":");
            for (Libro l : al) {
                System.out.print("*" + l.toString());
                System.out.println("");
            }
        }
    }

    private void buscarEmpleado() {
        String s = pedirString("\nIndique el nombre del empleado que lo prestó: ");
        Empleado e = gd.buscarEmpleado("s");
        if (e == null) {
            System.out.print("\nEse empleado no existe. Para ver/añadir empleados: " +
                    "\nMenu Principal -> Gestión de Datos -> Gestión de Empleados");
        }
        ArrayList<Libro> al = gd.busquedaLibroEmpleado(e);
        if (al.isEmpty()) {
            System.out.print("\nEse empleado no ha prestado ningún libro." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.println("\nResultados de la búsqueda \"Prestado por " + s + "\":");
            for (Libro l : al) {
                System.out.print("*" + l.toString());
                System.out.println("");
            }
        }
    }

    private void buscarUsuario() {
        String s = pedirString("\nIndique el nombre del usuario que lo alquiló: ");
        Usuario u = gd.buscarUsuario("s");
        if (u == null) {
            System.out.print("\nEse usuario no existe. Para ver/añadir usuarios: " +
                    "\nMenu Principal -> Gestión de Datos -> Gestión de Usuarios");
        }
        ArrayList<Libro> al = gd.busquedaLibroUsuario(u);
        if (al.isEmpty()) {
            System.out.print("\nEse usuario no ha alquilado ningún libro." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.println("\nResultados de la búsqueda \"Alquilado por " + s + "\":");
            for (Libro l : al) {
                System.out.print("*" + l.toString());
                System.out.println("");
            }
        }
    }

    private void buscarEstado() {
        int opc;
        String msj = "\n¿Quiere ver los libros disponibles(1) o alquilados(2)?";
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
            s = "Disponibles";
        else if (opc == 2)
            s = "Prestados";

        if (al.isEmpty()) {
            System.out.print("\nEse empleado no ha prestado ningún libro." +
                    "\nVolviendo al menú de búsqueda.");
        } else {
            System.out.println("\nResultados de la búsqueda \""+s+"\":");
            for (Libro l : al) {
                System.out.print("*" + l.toString());
                System.out.println("");
            }
        }
    }

    //*************************************
    //      ALQUILAR/DEVOLVER
    //*************************************
    private void alquilarLibro() {
        //mostrar los libros libres
        String t = pedirString(Menu.menuAlquilar());
    }

    private void devolverLibro() {
        //mostrar los libros alquilados
        String t = pedirString(Menu.menuDevolver());
    }
}
