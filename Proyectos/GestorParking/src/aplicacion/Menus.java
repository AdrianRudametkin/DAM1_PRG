package aplicacion;

/**
 * Clase que almacena las cadenas de texto de los menus de la aplicación.
 */
public class Menus {
    public static String menuPrincipal() {
        return "\n\n\n--------------------" +
                "\n--*MENU PRINCIPAL*--" +
                "\n--------------------" +
                "\n (1) Entrada Coche" +
                "\n (2) Salida Coche" +
                "\n (3) Consultas" +
                "\n (4) Salir" +
                "\nIndique la opción deseada: ";
    }

    public static String menuEntrada() {
        return "\n\n\n---MENU ENTRADA---" +
                "\n (1) Coche nuevo" +
                "\n (2) Coche vecino" +
                "\n (3) Salir" +
                "\nIndique la opción deseada: ";
    }

    public static String menuConsultas() {
        return "\n\n\n---MENU CONSULTAS---" +
                "\n (1) Consultar plazas libres" +
                "\n (2) Consultas datos de una plaza" +
                "\n (3) Consultar datos de una persona" +
                "\n (4) Estadísticas" +
                "\n (5) Mostrar todos los coches" +
                "\n (6) Salir" +
                "\nIndique la opción deseada: ";
    }

    public static String menuEstadisticas() {
        return "\n\n\n*-Menu Estadísticas-*" +
                "\n (1) Por color" +
                "\n (2) Por marca" +
                "\n (3) Por franja horaria" +
                "\n (4) Salir" +
                "\nIndique la opción deseada: ";
    }
}
