package aplicacion;

import java.io.*;
import java.util.InputMismatchException;

public class Principal {
    //Variable global
    private static Almacen almacen;
    //Constante
    private static final String RUTA = "almacenes.db";

    public static void main(String[] args) {

        //INICIO del tratamiento de ficheros
        File fich = new File(RUTA);

        if (!fich.exists() || fich.length() < 1) {
            System.out.print("\nNo existe fichero o esta vacío. Creando almacén nuevo...");
            crearAlmacen();
        } else {
            System.out.print("\nArchivo encontrado.");
            boolean opc = Utilidades.pedirSiONo("\nDesea cargar el archivo?(Sí o no) ");
            if (opc) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA));
                    almacen = (Almacen) ois.readObject();
                    ois.close();
                } catch (ClassNotFoundException e) {
                    System.out.print("Clase no coincide: " + e.getMessage() + "\nCreando un almacén nuevo...");
                    crearAlmacen();
                } catch (IOException e) {
                    System.out.print("Error inesperado: " + e.getMessage() + "\nCreando un almacén nuevo...");
                    crearAlmacen();
                }
            } else {
                System.out.print("\nCreando un almacén nuevo...");
                crearAlmacen();
            }
        }
        //FIN del tratamiento de ficheros

        //INICIO del trabajo con el almacén
        if(almacen.getAlmacen()==null){
            crearAlmacen();
        }
        int op;
        do {
            op = mostrarMenu();
            switch (op) {
                case 1 -> agregarBebida();
                case 2 -> eliminarBebida();
                case 3 -> precioTotal();
                case 4 -> precioPorMarca();
                case 5 -> precioPorEstante();
                case 6 -> numBebidasAlmacen();
                case 7 -> numBebidasTotales();
                case 8 -> infoBebidas();
                case 9 -> ampliarAlmacen();
                case 0 -> salir();
            }
        } while (op != 0);

    }


    private static void crearAlmacen() {
        int filas, columnas;
        do {
            filas = Utilidades.pedirIntPositivo("\nIndique el número de estantes (mayor o igual a 1): ");
        } while (filas <= 0);
        do {
            columnas = Utilidades.pedirIntPositivo("\nIndique la capacidad de los estantes (mayor o igual a 1): ");
        } while (columnas <= 0);

        almacen = new Almacen(filas, columnas);
    }

    //Métodos que utiliza main
    public static int mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nALMACÉN DE BEBIDAS");
            System.out.println("******************");
            System.out.println("1. Agregar bebida");
            System.out.println("2. Eliminar una bebida");
            System.out.println("3. Calcular precio total");
            System.out.println("4. Calcular precio marca");
            System.out.println("5. Calcular precio estante");
            System.out.println("6. Bebidas del almacén");
            System.out.println("7. Número de bebidas dadas de alta");
            System.out.println("8. Mostrar todo");
            System.out.println("9. Ampliar almacén");
            System.out.println("0. SALIR");
            System.out.print("Introduzca la acción a realizar: ");
            try {
                opcion = Utilidades.sc.nextInt();
                Utilidades.sc.nextLine();
                if (opcion < 0 || opcion > 9)
                    System.out.println("\nOpción incorrecta. Vuelva a intentarlo");
            } catch (InputMismatchException e) {
                System.out.print("\nTiene que ser un número.");
                opcion = -1;
            }
        } while (opcion < 0 || opcion > 9);

        return opcion;
    }

    private static void agregarBebida() {
        //Agregar bebida: solicitar ID, comprobar que no existe, comprobar que queda sitio
        //--> crear bebida y agregarla al almacén
        System.out.print("\n**AÑADIENDO BEBIDA**");
        if (estaLLeno()) {
            System.out.print("\nEl almacén esta lleno...");
            Utilidades.continuar();
            return;
        }
        int opc;
        do {
            opc = Utilidades.pedirInt("\nIndique si quiere añadir Agua Mineral(1) o Bebida Azucarada(2): ");
        } while (opc != 1 && opc != 2);
        String id = Utilidades.pedirStringNoVacio("\nIndique el identificador: ");
        if (existeBebida(id)) {
            System.out.print("\nEsa bebida ya existe...");
            Utilidades.continuar();
            return;
        }
        double litros = Utilidades.pedirDoublePositivo("\nIndique la capacidad en litros (L): ");
        double precio = Utilidades.pedirDoublePositivo("\nIndique el precio en euros (€): ");
        String marca = Utilidades.pedirStringNoVacio("\nIndique la marca: ");

        if (opc == 1) {
            String origen = Utilidades.pedirStringNoVacio("\nIndique el manantial del agua: ");
            almacen.agregarBebida(new Agua(id, litros, precio, marca, origen));
            System.out.print("\n*Agua mineral agregada.");
        } else {
            double azucar = Utilidades.pedirDoublePositivo("\nIndique el porcentaje de azúcar (%): ");
            double descuento = Utilidades.pedirDoublePositivo("\nIndique el descuento (%): ");
            almacen.agregarBebida(new Refresco(id, litros, precio, marca, azucar, descuento));
            System.out.print("\n*Bebida azucarada agregada.");
        }
        Utilidades.continuar();
    }

    private static void eliminarBebida() {
        //Eliminar bebida: solicitar ID, borrarlo e informar
        System.out.print("\n**ELIMINANDO BEBIDA**");
        String id = Utilidades.pedirStringNoVacio("\nIndique el identificador: ");
        if (!almacen.eliminarBebida(id)) {
            System.out.print("\n*No existe una bebida con ese identificador.");
        } else {
            System.out.print("\n*Bebida eliminada");
        }
        Utilidades.continuar();
    }

    private static void precioTotal() {
        //Calcular precio total y mostrarlo
        System.out.print("\n**PRECIO TOTAL DEL ALMACÉN**");
        System.out.print("\nTotal: " + Utilidades.formatDecimal(almacen.precioTotal()) + "€");
        Utilidades.continuar();
    }

    private static void precioPorMarca() {
        //Calcular precio marca: solicitar marca y mostrar precio
        System.out.print("\n**PRECIO TOTAL POR MARCA**");
        String marca = Utilidades.pedirStringNoVacio("\nIndique la marca: ");
        System.out.print("\nTotal: " + Utilidades.formatDecimal(almacen.precioTotalPorMarca(marca)) + "€");
        Utilidades.continuar();
    }

    private static void precioPorEstante() {
        //Calcular precio estante: solicitar estante y mostrar precio
        System.out.print("\n**PRECIO TOTAL POR ESTANTE**");
        int estante, max = almacen.getAlmacen().length;
        do {
            estante = Utilidades.pedirIntPositivo("\nIndique el número del estante (1 a " + max + "): ");
        } while (estante <= 0 || estante > max);
        System.out.print("\nTotal: " + Utilidades.formatDecimal(almacen.precioTotalEstante(estante - 1)) + "€");
        Utilidades.continuar();
    }

    private static void numBebidasAlmacen() {
        //Consultar número de bebidas del almacén
        System.out.print("\n**TOTAL DE BEBIDAS EN EL ALMACÉN**");
        System.out.print("\nTotal: " + almacen.numeroTotalBebidas() + " bebidas");
        Utilidades.continuar();
    }

    private static void numBebidasTotales() {
        //Consultar número de bebidas creadas
        System.out.print("\n**TOTAL DE BEBIDAS CREADAS**");
        System.out.print("\nTotal: " + Bebida.getNum() + " bebidas");
        Utilidades.continuar();
    }

    private static void infoBebidas() {
        //Mostar toda la información de las bebidas
        System.out.print("\n**INFORMACIÓN DE LAS BEBIDAS EN EL ALMACÉN**");
        almacen.mostrarTodaInformacion();
        System.out.println();
        Utilidades.continuar();
    }

    private static void ampliarAlmacen() {
        //Ampliar almacén:
        //mostrar dimensiones actuales del almacén,
        //crear almacén nuevo,
        //comprobar dimensiones del almacén nuevo,
        //copiar bebidas del almacén pequeño al nuevo
        System.out.print("\n**AMPLIAR EL ALMACÉN**");
        System.out.print("\nDimensiones actuales:" +
                "\n\tEstantes: " + almacen.getAlmacen().length +
                "\n\tFilas: " + almacen.getAlmacen()[0].length);
        int filas, columnas;
        do {
            filas = Utilidades.pedirIntPositivo("\nIndique el número de estantes (mayor a " + almacen.getAlmacen().length + "): ");
        } while (filas <= almacen.getAlmacen().length);

        do {
            columnas = Utilidades.pedirIntPositivo("\nIndique el número de filas (mayor o igual a " + almacen.getAlmacen()[0].length + "): ");
        } while (columnas < almacen.getAlmacen()[0].length);


        Bebida[][] viejo = almacen.getAlmacen();
        Bebida[][] nuevo = new Bebida[filas][columnas];

        for (int i = 0; i < viejo.length; i++) {
            for (int j = 0; j < viejo[i].length; j++) {
                nuevo[i][j] = viejo[i][j];
            }
        }
        almacen = new Almacen(filas, columnas);
        System.out.print("\n*Almacén ampliado.");
        almacen.setAlmacen(nuevo);
        Utilidades.continuar();
    }

    private static void salir() {
        //Salir: tratamiento de fichero y mensaje de despedida
        System.out.print("\n*Guardando en fichero...");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA));
            oos.writeObject(almacen);
            oos.close();
            System.out.print("\n*Fichero guardado correctamente.");
        } catch (IOException e) {
            System.out.print("\nError inesperado: " + e.getMessage());
        }
        System.out.print("\nCerrando aplicación. Hasta la próxima \\(^^*)");
    }


    /*
     * MÉTODOS DE APOYO
     */

    private static boolean existeBebida(String id) {
        for (int i = 0; i < almacen.getAlmacen().length; i++) {
            for (int j = 0; j < almacen.getAlmacen()[i].length; j++) {
                if (almacen.getAlmacen()[i][j] == null)
                    continue;
                if (almacen.getAlmacen()[i][j].getIdentificador().equalsIgnoreCase(id))
                    return true;
            }
        }
        return false;
    }

    private static boolean estaLLeno() {
        for (int i = 0; i < almacen.getAlmacen().length; i++) {
            for (int j = 0; j < almacen.getAlmacen()[i].length; j++) {
                if (almacen.getAlmacen()[i][j] == null)
                    return false;
            }
        }
        return true;
    }

    private static void mostrarBebida(String id) {
        for (int i = 0; i < almacen.getAlmacen().length; i++) {
            for (int j = 0; j < almacen.getAlmacen()[i].length; j++) {
                if (almacen.getAlmacen()[i][j] == null)
                    return;
                if (almacen.getAlmacen()[i][j].getIdentificador().equalsIgnoreCase(id)) {
                    System.out.print(almacen.getAlmacen()[i][j].toString());
                    return;
                }
            }
        }
    }

}
