package sistema;

public class Menu {
    public static String menuPrincipal(){
        return  "\n" +
                "\n---MENU PRINCIPAL---" +
                "\n (1) Gestión de Datos" +
                "\n (2) Búsqueda de Libros" +
                "\n (3) Alquilar Libro" +
                "\n (4) Devolver Libro" +
                "\n (5) Salir" +
                "\nIndique la opción deseada:";
    }

    //*************************************
    //      GESTIÓN DE DATOS
    //*************************************
    public static String menuGestion(){
        return  "\n---GESTIÓN DE DATOS---" +
                "\n (1) Gestión de Libros" +
                "\n (2) Gestión de Usuarios" +
                "\n (3) Gestión de Empleados" +
                "\n (4) Salir" +
                "\nIndique la opción deseada:";
    }
    public static String menuGesLibros(){
        return  "\n---GESTIÓN DE DATOS: LIBROS---" +
                "\n (1) Dar alta un libro" +
                "\n (2) Dar baja un libro" +
                "\n (3) Salir" +
                "\nIndique la opción deseada:";
    }
    public static String menuGesEmpleados(){
        return  "\n---GESTIÓN DE DATOS: EMPLEADOS---" +
                "\n (1) Dar alta un empleado" +
                "\n (2) Dar baja un empleado" +
                "\n (3) Mostrar empleados" +
                "\n (4) Salir" +
                "\nIndique la opción deseada:";
    }
    public static String menuGesUsuarios(){
        return  "\n---GESTIÓN DE DATOS: USUARIOS---" +
                "\n (1) Dar alta un usuario" +
                "\n (2) Dar baja un usuario" +
                "\n (3) Mostrar usuarios" +
                "\n (4) Salir" +
                "\nIndique la opción deseada:";
    }

    //*************************************
    //      BÚSQUEDA
    //*************************************
    public static String menuBusqueda(){
        return  "\n---BÚSQUEDA DE LIBROS---" +
                "\nBuscar por:" +
                "\n (1) Título" +
                "\n (2) Autor" +
                "\n (3) Editorial" +
                "\n (4) Ubicación en biblioteca" +
                "\n (5) ISBN" +
                "\n (6) Empleado que lo alquiló" +
                "\n (7) Usuario que lo prestó" +
                "\n (8) Estado de préstamo" +
                "\n (9) Salir" +
                "\nIndique la opción deseada:";
    }

    //*************************************
    //      ALQUILAR/DEVOLVER
    //*************************************
    public static String menuAlquilar(){
        return  "\n---ALQUILAR LIBRO---" +
                "\nIntroduzca el título del libro que quiere alquilar: ";
    }

    public static String menuDevolver(){
        return  "\n---DEVOLVER LIBRO---" +
                "\nIntroduzca el título del libro que quiere devolver: ";
    }
}
