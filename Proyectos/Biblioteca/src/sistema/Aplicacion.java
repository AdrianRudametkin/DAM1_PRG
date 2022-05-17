package sistema;

import static sistema.Utilidades.*;
public class Aplicacion {
    private GestionDatos gd;

    public void init(){
        gd = new GestionDatos();
        gd.cargarFichero();
    }

    public void start(){
        menuPrincipal();
        gd.guardarFichero();
    }

    private void menuPrincipal(){
        int opc;
        do {
            opc = pedirInt(Menu.menuPrincipal());
            switch (opc){
                case 1 -> gestionDeDatos();
                case 2 -> busquedaDeLibros();
                case 3 -> alquilarLibro();
                case 4 -> devolverLibro();
                case 5 -> opc = 5;
                default -> opc = -1;
            }
            if(opc<0){
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        }while(opc != 5);
    }

    //*************************************
    //      GESTIÓN DE DATOS
    //*************************************
    private void gestionDeDatos() {
        int opc;
        do {
            opc = pedirInt(Menu.menuGestion());
            switch (opc){
                case 1 -> gestionLibros();
                case 2 -> gestionUsuarios();
                case 3 -> gestionEmpleados();
                case 4 -> opc = 4;
                default -> opc = -1;
            }
            if(opc<0){
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        }while(opc != 4);
    }

    private void gestionLibros() {
        int opc;
        do {
            opc = pedirInt(Menu.menuGesLibros());
            switch (opc){
                case 1 -> darAltaLibro();
                case 2 -> darBajaLibro();
                case 3 -> opc = 3;
                default -> opc = -1;
            }
            if(opc<0){
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        }while(opc != 3);
    }

    private void darAltaLibro() {
    }

    private void darBajaLibro() {

    }

    private void gestionUsuarios() {
        int opc;
        do {
            opc = pedirInt(Menu.menuGesUsuarios());
            switch (opc){
                case 1 -> darAltaUsuario();
                case 2 -> darBajaUsuario();
                case 3 -> mostrarUsuarios();
                case 4 -> opc = 4;
                default -> opc = -1;
            }
            if(opc<0){
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        }while(opc != 4);
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
            switch (opc){
                case 1 -> darAltaEmpleado();
                case 2 -> darBajaEmpleado();
                case 3 -> mostrarEmpleados();
                case 4 -> opc = 4;
                default -> opc = -1;
            }
            if(opc<0){
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        }while(opc != 4);
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
        int opc;
        do {
            opc = pedirInt(Menu.menuBusqueda());
            switch (opc){
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
            if(opc<0){
                System.out.print("\n [SISTEMA: Por favor, elija una opción válida]");
            }
        }while(opc != 9);
    }

    private void buscarTitulo() {
    }

    private void buscarAutor() {
    }

    private void buscarEditorial() {
    }

    private void buscarUbucacion() {
    }

    private void buscarIsbn() {
    }

    private void buscarEmpleado() {
    }

    private void buscarUsuario() {
    }

    private void buscarEstado() {
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
