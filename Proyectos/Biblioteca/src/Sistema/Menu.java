package Sistema;

public class Menu {
    public static String menuPrincipal(){
        return  "\n---MENU PRINCIPAL---" +
                "\n (1) Gestión de Datos" +
                "\n (2) Búsqueda de Libros" +
                "\n (3) Alquilar un Libro" +
                "\n (4) Devolver un libro" +
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
                "\nIndique la opción deseada:";
    }
    public static String menuGesLibros(){
        return  "\n---GESTIÓN DE DATOS: LIBROS---" +
                "\n (1) Dar alta un libro" +
                "\n (2) Dar baja un libro" +
                "\nIndique la opción deseada:";
    }
    public static String menuGesEmpleados(){
        return  "\n---GESTIÓN DE DATOS: EMPLEADOS---" +
                "\n (1) Dar alta un empleado" +
                "\n (2) Dar baja un empleado" +
                "\n (3) Listar empleados" +
                "\n (4) Mostrar empleados" +
                "\nIndique la opción deseada:";
    }
    public static String menuGesUsuarios(){
        return  "\n---GESTIÓN DE DATOS: USUARIOS---" +
                "\n (1) Dar alta un usuario" +
                "\n (2) Dar baja un usuario" +
                "\n (3) Listar usuario" +
                "\n (4) Mostrar usuario" +
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
                "\nIndique la opción deseada:";
    }
}
