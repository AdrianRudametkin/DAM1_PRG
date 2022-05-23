package Timbre;

import java.util.*;

public class Main {
    public static Scanner sc;
    public static ArrayList<Dinero> lista;

    /**
     * Metodo main del programa.
     *
     * @param args argumentos del sistema operativo o JVM
     */
    public static void main(String[] args) {
        init();
        //TODO Metodo de pruebas, borrar antes de entregar.
        test(5, 5);

        loop();
    }

    /**
     * Metodo que crea un número determinado de monedas y billetes con atributos aleatorios (entre rangos posibles).
     * @param m número de Monedas a crear
     * @param b número de billetes a crear
     */
    public static void test(int m, int b) {
        Random r = new Random();
        for (int i = 0; i < m; i++) {
            lista.add(new Moneda(r.nextDouble(0,1000), r.nextInt(0, 2020), r.nextDouble(0,100), r.nextDouble(0,100)));
        }
        for (int i = 0; i < b; i++) {
            lista.add(new Billete(r.nextDouble(0,1000), r.nextInt(0, 2020), r.nextDouble(0,100), r.nextDouble(0,100)));
        }
    }

    /**
     * Inicializacion del programa.
     */
    public static void init() {
        lista = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    /**
     * Bucle principal del programa.
     */
    public static void loop() {
        int option;
        do {
            try {
                printMenu();
                option = pedirInt("\n Elegir una opción: ");
                switch (option) {
                    case 1 -> crearObjeto();
                    case 2 -> mostrarTodo();
                    case 3 -> comprobar();
                    case 4 -> ordenar();
                    case 5 -> copiar();
                    case 6 -> buscar();
                    case 7 -> modificar();
                    case 8 -> eliminar();
                    case 9 -> eliminarTodo();
                    case 10 -> System.out.print("\n\nHasta la próxima!!");
                    default -> System.out.print("\nPor favor, elija una option válida.");
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

    /**
     * Imprimir el menu principal en pantalla.
     */
    private static void printMenu() {
        System.out.print("\nMENU PRINCIPAL" +
                "\n**************" +
                "\n [1] - Crear objeto" +
                "\n [2] - Mostrar lista por pantalla" +
                "\n [3] - Comprobar si hay 2 objetos iguales en la lista" +
                "\n [4] - Ordenar la lista" +
                "\n [5] - Copiar un objeto" +
                "\n [6] - Buscar un objeto" +
                "\n [7] - Modificar un objeto" +
                "\n [8] - Eliminar un objeto" +
                "\n [9] - Salir");
    }

    /**
     * Pedir al usuario un entero.
     *
     * @param msg mensaje para el usuario
     * @return entero
     */
    private static int pedirInt(String msg) {
        System.out.print(msg);
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }

    /**
     * Pedir al usuario un entero.
     *
     * @param msg mensaje para el usuario
     * @return decimal
     */
    private static double pedirDouble(String msg) {
        System.out.print(msg);
        double d = sc.nextDouble();
        sc.nextLine();
        return d;
    }

    /**
     * Pedir una cadena.
     *
     * @param msg mensaje para el usuario
     * @return cadena.
     */
    private static String pedirString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    /**
     * Pulse intro para continuar;
     */
    private static void continuar(){
        pedirString("\nPulse INTRO para continuar...");
    }

    /**
     * Crear un objeto de dinero y añadirlo a la lista.
     */
    public static void crearObjeto() {
        boolean correcto;
        System.out.print(
                "\nCREACION DEL OBJETO" +
                        "\n*******************");

        String option;
        double valor;
        int anyo;
        // Pedir tipo de timbre hasta tener una opción correcta
        do {
            option = pedirString("\nQue quiere crear? Una (M)oneda o un (B)illete? ");

            if (!(option.equalsIgnoreCase("m") || option.equalsIgnoreCase("b"))) {
                System.out.print("\nSolo puede elgir entre monedas [M] y billetes [B].");
                correcto = false;
            } else {
                correcto = true;
            }
        } while (!correcto);

        // Pedir el valor hasta tener un valor válido
        do {
            valor = pedirDouble("Que valor tiene (en €)? ");
            if (valor <= 0) {
                System.out.print("\nEl valor no puede ser ni negativo ni nulo. ");
                correcto = false;
            } else {
                correcto = true;
            }
        } while (!correcto);

        // Pedir el año de emisión hasta tener un año válido (superior a -680 e inferior al año actual)
        do {
            anyo = pedirInt("En que año fue emitido? ");
            if (anyo > Calendar.getInstance().get(Calendar.YEAR) || anyo <= -680) {
                System.out.print("\nEse año de emisión no es posible. ");
                correcto = false;
            } else {
                correcto = true;
            }
        } while (!correcto);

        // En el caso de que se pida un Moneda
        if (option.equalsIgnoreCase("m")) {
            double p, d;
            // Pedir peso hasta tener un número válido
            do {
                p = pedirDouble("Cuanto pesa su moneda (en gramos)? ");
                if (p <= 0) {
                    System.out.print("\nEl peso debe ser superior a 0. ");
                    correcto = false;
                } else {
                    correcto = true;
                }
            } while (!correcto);

            // Pedir diametro hasta tener un número válido
            do {
                d = pedirDouble("Cual es su diametro (en cm)? ");
                if (d <= 0) {
                    System.out.print("\nEl diametro debe ser superior a 0. ");
                    correcto = false;
                } else {
                    correcto = true;
                }
            } while (!correcto);

            // Crear y añadir a la lista
            lista.add(new Moneda(valor, anyo, d, p));
            System.out.print("\nMoneda añadida.");

        // En el caso de que sea un Billete
        } else if (option.equalsIgnoreCase("b")) {
            double ancho, alto;
            // Pedir ancho hasta tener un número válido
            do {
                ancho = pedirDouble("Cual es la anchura del billete (en cm)? ");
                if (ancho <= 0) {
                    System.out.println("\nEl ancho debe ser superior a 0. ");
                    correcto = false;
                } else {
                    correcto = true;
                }
            } while (!correcto);

            // Pedir alto hasta tener un número válido
            do {
                alto = pedirDouble("Cual es la altura del billete (en cm)? ");
                if (alto <= 0) {
                    System.out.println("\nEl alto debe ser superior a 0. ");
                    correcto = false;
                } else {
                    correcto = true;
                }
            } while (!correcto);

            // Crear y añadir a la lista
            lista.add(new Billete(valor, anyo, alto, ancho));
            System.out.print("\nBillete añadido.");
        }
        continuar();
    }

    /**
     * Mostrar todas las monedas y billes de la lista.
     */
    public static void mostrarTodo() {
        System.out.print(
                "\nMOSTRANDO TODOS LOS OBJETOS" +
                        "\n***************************");

        // Comprobar si la lista está vacia
        if(lista.isEmpty()){
            System.out.print("\nNo hay nada que mostrar...");
        }else{
            mostrarSublista(lista);
        }
        continuar();
    }

    /**
     * Muestra por pantalla los objetos de la sublista y su posicion en la lista.
     *
     * @param l sublista
     */
    private static void mostrarSublista(ArrayList<Dinero> l) {
        for (Dinero d : l) {
            mostrarObjeto(d);
        }
        System.out.println();
    }

    /**
     * Muestra solo un objeto y su numero en la lista
     *
     * @param d objeto a mostrar
     */
    private static void mostrarObjeto(Dinero d) {
        System.out.print("\n\n--Objeto número " + lista.lastIndexOf(d) + "--");
        System.out.print(d.toString());
    }

    /**
     * Comprobar si hay dos objetos iguales en la lista.
     */
    public static void comprobar() {
        System.out.print(
                "\nCOMPROBANDO OBJETOS IGUALES" +
                        "\n***************************");

        // Comprobar si la lista esta vacia
        if(lista.isEmpty()){
            System.out.println("\nNo hay objetos que comparar...");
            continuar();
            return;
        }

        boolean hayIgual = false;
        // Recorrer la lista
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                // Si los objetos son igules
                if (lista.get(i).equals(lista.get(j))) {
                    System.out.print("\n --> El objeto " + lista.indexOf(lista.get(i)) + " y el objeto " + lista.lastIndexOf(lista.get(j)) + " son igules: ");
                    mostrarObjeto(lista.get(i));
                    mostrarObjeto(lista.get(j));
                    System.out.print("\n --> Puedes eliminar uno de ellos si quieres.\n");
                    hayIgual = true;
                }
            }
        }
        // Si no hubo objetos iguales
        if (!hayIgual) {
            System.out.print("\nNo hay objetos iguales.");
        }
        continuar();
    }

    /**
     * Ordenar la lista de monedas y billetes por valor y luego por año, ascendente o descendentemente,
     * utiliazando el método {@link Dinero#compareTo(Dinero) Dinero.compareTo()}
     */
    public static void ordenar() {
        System.out.print(
                "\nORDENANDO OBJETOS" +
                        "\n*****************");
        // Comprobar si la lista está vacia
        if(lista.isEmpty()){
            System.out.println("\nNo hay objetos que ordenar...");
            continuar();
        }else {
            int option;
            Comparator<Dinero> comp = null;
            // Pedir como ordenar la lista: ascendiente o descendientemente.
            do {
                option = pedirInt("\nComo lo quiere ordenar: " +
                        "\n[1] Ascendentemente (mas antiguo primero)" +
                        "\n[2] Descendentemente (mas moderno primero)" +
                        "\nElija una opción: ");

                if (option == 1) {
                    comp = (d1, d2) -> -d1.compareTo(d2);
                } else if (option == 2) {
                    comp = (d1, d2) -> d1.compareTo(d2);
                } else {
                    System.out.println("\nOpción no válida.");
                }
            } while (option != 2 && option != 1);

            lista.sort(comp);
            System.out.print("\nObjetos ordenados.");
            continuar();
        }
    }

    /**
     * Copia un objeto y lo añade a la lista.
     */
    public static void copiar() {
        System.out.print(
                "\nCOPIANDO OBJETOS" +
                        "\n****************");
        // Comprobar si la lista está vacia
        if(lista.isEmpty()){
            System.out.println("\nNo hay objetos que copiar...");
            continuar();
        }else {
            // Pedir la posición del objeto
            int pos = pedirInt("\nIndique la posición del objeto a copiar: ");
            if (lista.get(pos) instanceof Moneda) {
                lista.add(new Moneda((Moneda) lista.get(pos)));
                System.out.print("\nMoneda " + pos + " copiada.");
            } else if (lista.get(pos) instanceof Billete) {
                lista.add(new Billete((Billete) lista.get(pos)));
                System.out.print("\nBillete " + pos + " copiado.");
            }
            continuar();
        }
    }

    /**
     * Buscar un objeto en la lista.
     */
    public static void buscar() {
        System.out.print(
                "\nBUSCANDO OBJETOS" +
                        "\n****************");
        if(lista.isEmpty()){
            System.out.println("\nNo hay objetos que buscar...");
            continuar();
            return;
        }
        // Sublista de monedas o billetes, segun el tipo elegido
        ArrayList<Dinero> timbres = new ArrayList<>();

        boolean correcto;
        String tipo;

        // Pedir que tipo de timbre hasta tener una opción válida
        do {
            tipo = pedirString("\nEs un (B)illete o una (M)oneda? ");

            if (!(tipo.equalsIgnoreCase("m") || tipo.equalsIgnoreCase("b"))) {
                System.out.print("\nSolo puede elgir entre monedas [M] y billetes [B].");
                correcto = false;
            } else {
                correcto = true;
            }
        } while (!correcto);

        // Crear la sublista de monedas o billetes según el tipo elegido
        if (tipo.equalsIgnoreCase("m")) {
            for (Dinero d : lista) {
                if (d instanceof Moneda) {
                    timbres.add(d);
                }
            }
        } else if (tipo.equalsIgnoreCase("b")) {
            for (Dinero d : lista) {
                if (d instanceof Billete) {
                    timbres.add(d);
                }
            }
        }

        // Comprobar si se han encontrado objetos de ese tipo
        if (timbres.isEmpty()) {
            System.out.print("\nNo hay " + (tipo.equals("m") ? "monedas" : "billetes") + " en la lista.");
        // Si solo hay uno, mostrarlo directamente
        } else if (timbres.size() == 1) {
            mostrarSublista(timbres);
        } else {
        // Pedir si seguir buscando en la sublista de monedas o billetes
            int option;
            do {
                option = pedirInt("\nHay " + timbres.size() + " " + (tipo.equals("m") ? "monedas" : "billetes") + " en la lista:" +
                        "\n[1] Seguir buscando." +
                        "\n[2] Mostar los resultados." +
                        "\n[3] Salir" +
                        "\nElija una opcion: ");

                switch (option) {
                    case 1 -> buscarTimbres(timbres);
                    case 2 -> mostrarSublista(timbres);
                    case 3 -> System.out.print("\nSaliendo...");
                    default -> System.out.print("\nOpcion no valida.");
                }
            } while (option != 3 && option != 2 && option != 1);
        }
        continuar();
    }

    /**
     * Busca un timbre de una sublista por año de emisión o valor.
     *
     * @param l sublista de timbre
     */
    private static void buscarTimbres(ArrayList<Dinero> l) {
        boolean hayTimbre = false;
        int option;
        do {
            option = pedirInt("\nContinuando: " +
                    "\n[1] Buscar por año de emisión." +
                    "\n[2] Buscar por valor." +
                    "\n[3] Salir." +
                    "\nElija una opción: ");
            if (option == 1) {
                int anyo = pedirInt("\nIndique el año de emisión: ");
                System.out.print("\nMostrando "+(l.get(0) instanceof Moneda ? "monedas" : "billetes") +": ");
                for (Dinero d : l) {
                    if (d.getAnyo() == anyo) {
                        mostrarObjeto(d);
                        hayTimbre = true;
                    }
                }
                if (!hayTimbre) {
                    System.out.print("No hay "+(l.get(0) instanceof Moneda ? "monedas" : "billetes") +" con ese año.");
                }
            } else if (option == 2) {
                double valor = pedirDouble("\nIndique el valor: ");
                System.out.print("\nMostrando "+(l.get(0) instanceof Moneda ? "monedas" : "billetes") +": ");
                for (Dinero d : l) {
                    if (d.getValor() == valor) {
                        mostrarObjeto(d);
                        hayTimbre = true;
                    }
                }
                if (!hayTimbre) {
                    System.out.print("No hay "+(l.get(0) instanceof Moneda ? "monedas" : "billetes") +" con ese valor.");
                }
            } else if (option == 3) {
                System.out.print("\nSaliendo...");
            } else {
                System.out.print("\nOpcion no valida.");
            }
        } while (option != 3 && option != 2 && option != 1);
    }

    /**
     * Eliminar un objeto por posición.
     */
    public static void eliminar() {
        System.out.print(
                "\nELIMINANDO OBJETOS" +
                        "\n******************");
        if(lista.isEmpty()){
            System.out.println("\nNo hay objetos...");
            continuar();
            return;
        }

        int pos = pedirInt("\nIndique la posición del timbre que quiere eliminar: ");
        System.out.print("\nEliminando: ");
        mostrarObjeto(lista.get(pos));
        lista.remove(pos);
        String s;

        if (lista.get(pos) instanceof Moneda)
            s = "Moneda eliminada";
        else if (lista.get(pos) instanceof Billete)
            s = "Billete eliminado";
        else
            s = "...";

        System.out.print("\n\n"+s);
        continuar();
    }

    /**
     * Modificar un objeto por posición.
     */
    public static void modificar() {
        System.out.print(
                "\nMODIFICANDO OBJETOS" +
                        "\n*******************");
        if(lista.isEmpty()){
            System.out.println("\nNo hay objetos que modificar...");
            continuar();
            return;
        }
        Dinero d = lista.get(pedirInt("\nIndique la posición del timbre que quiere modificar: "));

        if (d instanceof Billete) {
            modificarBillete((Billete) d);
        } else if (d instanceof Moneda) {
            modificarMoneda((Moneda) d);
        }
        continuar();
    }

    /**
     * Submetodo para modificar las dimensiones de un billete.
     *
     * @param b el billete
     */
    private static void modificarBillete(Billete b) {
        int option;
        double var;
        boolean correcto;

        do {
            option = pedirInt("\nQue quiere modificar: " +
                    "\n[1] Ancho" +
                    "\n[2] Altura" +
                    "\n[3] Nada" +
                    "\nIntroduzca una opcion: ");
            if (option == 1) {
                do {
                    var = pedirDouble("\nIndique la nueva anchura: ");
                    if (var <= 0) {
                        System.out.print("\nLa anchura debe ser superior a 0.");
                        correcto = false;
                    } else {
                        b.setAnchura(var);
                        correcto = true;
                    }
                } while (!correcto);
                System.out.print("\nAnchura modificada.");
            } else if (option == 2) {
                do {
                    var = pedirDouble("\nIndique la nueva altura: ");
                    if (var <= 0) {
                        System.out.print("\nLa altura debe ser superior a 0.");
                        correcto = false;
                    } else {
                        b.setAltura(var);
                        correcto = true;
                    }
                } while (!correcto);
                System.out.print("\nAltura modificada.");
            } else if (option == 3) {
                System.out.print("\nSaliendo...");
            } else {
                System.out.print("\nOpción no valida.");
            }
        } while (option != 3 && option != 2 && option != 1);
    }

    /**
     * Submetodo para modificar las dimensiones de un billete.
     *
     * @param m el billete
     */
    private static void modificarMoneda(Moneda m) {
        int option;
        double var;
        boolean correcto;

        do {
            option = pedirInt("\nQue quiere modificar: " +
                    "\n[1] Peso" +
                    "\n[2] Diametro" +
                    "\n[3] Nada" +
                    "\nIntroduzca una opción: ");
            if (option == 1) {
                do {
                    var = pedirDouble("\nIndique el nuevo peso: ");
                    if (var <= 0) {
                        System.out.print("\nEl peso debe ser superior a 0.");
                        correcto = false;
                    } else {
                        m.setPeso(var);
                        correcto = true;
                    }
                } while (!correcto);
                System.out.print("\nPeso modificado.");
            } else if (option == 2) {
                do {
                    var = pedirDouble("\nIndique el nuevo diametro: ");
                    if (var <= 0) {
                        System.out.print("\nEl diametro debe ser superior a 0.");
                        correcto = false;
                    } else {
                        m.setDiametro(var);
                        correcto = true;
                    }
                } while (!correcto);
                System.out.print("\nDiametro modificado.");
            } else if (option == 3) {
                System.out.print("\nSaliendo...");
            } else {
                System.out.print("\nOpción no valida.");
            }
        } while (option != 3 && option != 2 && option != 1);
    }

    /**
     * Metodo que borra toda la lista.
     */
    public static void eliminarTodo() {
        String option;
        boolean correcto;
        do{
            option = pedirString("\nEstas seguro que quiere borrar todo (s/n)? ");
            if(option.equalsIgnoreCase("s")){
                do{
                    option = pedirString("\nSe perderá todo tu trabajo. Estas seguro? ");
                    if(option.equalsIgnoreCase("s")){
                        lista.clear();
                        System.out.print("Tu mandas... Lista borrada.");
                        correcto = true;
                    }else if(option.equalsIgnoreCase("n")){
                        System.out.print("\nPerfecto, los objetos permanecerán aquí.");
                        correcto = true;
                    }else{
                        System.out.print("Sí [S] o no [N].");
                        correcto = false;
                    }
                }while(!correcto);
            }else if(option.equalsIgnoreCase("n")){
                System.out.print("\nPerfecto, tus objetos no se borrarán.");
                correcto = true;
            }else{
                System.out.print("Opción no válida. Solo sí [S] o no [N].");
                correcto = false;
            }
        }while(!correcto);
        continuar();
    }
}
