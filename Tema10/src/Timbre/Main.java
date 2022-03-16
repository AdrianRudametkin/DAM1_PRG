package Timbre;

import Exceptions.NegativeIntegerException;
import Exceptions.NotAGoodYearException;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class Main {
    public  static Scanner sc;
    public static ArrayList<Dinero> lista;

    /**
     * Metodo main del programa.
     * @param args
     */
    public static void main(String[] args) {
        init();
        test(4,1);
        loop();
    }

    /**
     * Para pruebas solo
     */
    public static void test(int m, int b){
        Random r = new Random();
        for(int i = 0; i<m; i++){
            lista.add(new Moneda(r.nextDouble(), 2020-i, 10+i, 5+i));
        }
        for(int i = 0; i<b; i++){
            lista.add(new Billete(10+i, 2020-i, 10*i, 10*i));
        }
    }
    /**
     * Inicializacion del programa.
     */
    public static void init(){
        lista = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    /**
     * Bucle principal del programa.
     */
    public static void loop(){
        int option;
        do{
            try {
                printMenu();
                option = pedirInt("\n Elejir una opción: ");
                switch (option){
                    case 1:
                        crearObjeto();
                        break;
                    case 2:
                        mostrarTodo();
                        break;
                    case 3:
                        comprobar();
                        break;
                    case 4:
                        ordenar();
                        break;
                    case 5:
                        copiar();
                        break;
                    case 6:
                        buscar();
                        break;
                    case 7:
                        modificar();
                        break;
                    case 8:
                        eliminar();
                        break;
                    case 9:
                        System.out.print("\n\nHasta la próxima!!");
                        break;
                    default:
                        System.out.print("\nPor favor, elija una opcion válida.");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.print("\nNo existe ese numero en la lista." +
                        "\nPulse INTRO para continuar.");
                sc.nextLine();
                option = -1;
            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.print("\nPor favor, elija un numero válido." +
                        "\nPulse INTRO para continuar.");
                sc.nextLine();
                option = -1;
            }
        }while(option!=9);
    }

    /**
     * Imprimir el menu principal en pantalla.
     */
    public static void printMenu(){
        System.out.print("\nMENU PRINCIPAL" +
                "\n**************" +
                "\n 1 - Crear objeto" +
                "\n 2 - Mostrar lista por pantalla" +
                "\n 3 - Comprobar si hay 2 objetos iguales en la lista" +
                "\n 4 - Ordenar la lista" +
                "\n 5 - Copiar un objeto" +
                "\n 6 - Buscar un objeto" +
                "\n 7 - Modificar un objeto" +
                "\n 8 - Eliminar un objeto" +
                "\n 9 - Salir");
    }

    /**
     * Pedir al usuario un entero.
     * @param msg mensaje para el usuario
     * @return entero
     */
    public static int pedirInt(String msg) {
        System.out.print(msg);
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }

    /**
     * Pedir al usuario un entero.
     * @param msg mensaje para el usuario
     * @return decimal
     */
    public static double pedirDouble(String msg) {
        System.out.print(msg);
        double d = sc.nextDouble();
        sc.nextLine();
        return d;
    }

    /**
     * Pedir una cadena.
     * @param msg mensaje para el usuario
     * @return cadena.
     */
    public static String pedirString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    /**
     * Crear un objeto de dinero y añadirlo a la lista.
     */
    public static void crearObjeto(){
        boolean correcto;
        System.out.print(
                "\nCREACION DEL OBJETO" +
                "\n*******************");

        String option;
        double valor;
        int anyo;
        // Pedir tipo de timbre
        do {
            option = pedirString("\nQue quiere crear? Una (M)oneda o un (B)illete? ");

            if(!(option.equalsIgnoreCase("m")|| option.equalsIgnoreCase("b"))){
                System.out.print("\nSolo puede elgir entre moneda y billete.");
                correcto = false;
            }else {
                correcto = true;
            }
        } while (!correcto);

        // Pedir el valor
        do {
            valor = pedirDouble("Que valor tiene (en €)? ");
            if (valor <= 0) {
                System.out.print("\nEl valor no puede ser ni negativo ni nulo.");
                correcto = false;
            }else{
                correcto = true;
            }
        }while (!correcto);

        // Pedir el año de emision
        do{
            anyo = pedirInt("En que año fue emitido? ");
            if(anyo > Calendar.getInstance().get(Calendar.YEAR) || anyo <= -680){
                System.out.print("\nEse año de emisión no es posible.");
                correcto = false;
            }else{
                correcto = true;
            }
        }while(!correcto);

        if(option.equalsIgnoreCase("m")){
            // Pedir peso
            double p,d;
            do {
                p = pedirDouble("Cuanto pesa su moneda (en gramos)? ");
                if (p <= 0) {
                    System.out.print("\nEl peso debe ser superior a 0.");
                    correcto = false;
                }else{
                    correcto = true;
                }
            }while(!correcto);

            // Pedir diametro
            do {
                d = pedirDouble("Cual es su diametro (en cm)? ");
                if (d <= 0) {
                    System.out.print("\nEl diametro debe ser superior a 0.");
                    correcto = false;
                }else{
                    correcto = true;
                }
            }while (!correcto);

            // Crear y añadir a la lista
            lista.add(new Moneda(valor, anyo, d, p));
            System.out.print("\nMoneda añadida añadido.");
        }else if(option.equalsIgnoreCase("b")){
            double ancho, alto;
            // Pedir ancho
            do{
                ancho = pedirDouble("Cual es la anchura del billete (en cm)? ");
                if(ancho <= 0){
                    System.out.println("\nEl ancho debe ser superior a 0.");
                    correcto = false;
                }else{
                    correcto = true;
                }
            }while(!correcto);

            // Pedir alto
            do {
                alto = pedirDouble("Cual es la altura del billete (en cm)? ");
                if (alto <= 0) {
                    System.out.println("\nEl alto debe ser superior a 0.");
                    correcto = false;
                }else{
                    correcto = true;
                }
            }while(!correcto);

            lista.add(new Billete(valor, anyo, alto, ancho));
            System.out.print("\nBillete añadido.");
        }
    }

    /**
     * Mostrar todas las monedas y billes de la lista.
     */
    public static void mostrarTodo() {
        System.out.print(
                "\nMOSTRANDO TODOS LOS OBJETOS" +
                "\n***************************");

        for(Dinero d: lista){
            System.out.print("\n\n--Objeto numero "+lista.lastIndexOf(d) +"--");
            System.out.print(d.toString());
        }
        System.out.println();
    }

    /**
     * Muestra por pantalla los objetos de la sublista.
     * @param l sublista
     */
    public static void mostrarSublista(ArrayList<Dinero> l){
        for(Dinero d: l){
            System.out.print("\n\n--Objeto numero "+lista.lastIndexOf(d) +"--");
            System.out.print(d.toString());
        }
        System.out.println();
    }

    /**
     * Comprobar si hay dos objetos iguales en la lista.
     */
    public static void comprobar() {
        System.out.print(
                "\nCOMPROBANDO OBJETOS IGUALES" +
                "\n***************************");
        boolean hayIgual = false;
        for(int i = 0; i < lista.size(); i++){
            for(int j = i +1; j < lista .size(); j++){
                if(lista.get(i).equals(lista.get(j))){
                    System.out.print("\nEl objeto "+lista.indexOf(lista.get(i))+" y el objeto "+lista.lastIndexOf(lista.get(j))+" son igules." +
                            "\nPuedes eliminar uno de ellos si quieres.\n");
                    hayIgual = true;
                }
            }
        }
        if(!hayIgual){
            System.out.print("\nNo hay objetos iguales.");
        }
    }

    /**
     * Ordenar la lista de monedas y billetes por valor y luego por año.
     */
    public static void ordenar() {
        System.out.print(
                "\nORDENANDO OBJETOS" +
                "\n*****************");
        Comparator<Dinero> din = new Comparator<Dinero>() {
            @Override
            public int compare(Dinero o1, Dinero o2) {
                return o1.compareTo(o2);
            }
        };

        lista.sort(din);
        System.out.print("\nObjetos ordenados.");
    }

    /**
     * Copia un objeto y lo añade a la lista.
     */
    public static void copiar() {
        System.out.print(
                "\nCOPIANDO OBJETOS" +
                "\n****************");

        int obj = pedirInt("\nIndique la posición del objeto a copiar: ");
        if(lista.get(obj) instanceof Moneda){
            lista.add(new Moneda((Moneda)lista.get(obj)));
            System.out.print("\nMoneda "+obj+" copiada.");
        }else if(lista.get(obj) instanceof Billete){
            lista.add(new Billete((Billete)lista.get(obj)));
            System.out.print("\nBillete "+obj+" copiado.");
        }
    }

    /**
     * Buscar un timbre.
     */
    public static void buscar() {
        System.out.print(
                "\nBUSCANDO OBJETOS" +
                "\n****************");

        // Lista de monedas o billetes, segun
        ArrayList<Dinero> timbres = new ArrayList<>();

        // Pedir que tipo de timbre
        String tipo = pedirString("\nEs un billete o una moneda? ");
        if(tipo.equalsIgnoreCase("moneda")){
            // Crear sublista de monedas
            for(Dinero d: lista){
                if(d instanceof Moneda){
                    timbres.add(d);
                }
            }
        }else if(tipo.equalsIgnoreCase("billete")){
            // Crear sublista de billetes
            for(Dinero d: lista){
                if(d instanceof Billete){
                    timbres.add(d);
                }
            }
        }else{
            // Salir del programa si no coincide.
            System.out.print("\nNo existe tal timbre.");
            return;
        }

        // Seguir buscando si existen
        if(timbres.isEmpty()){
            System.out.print("\nNo hay "+tipo+"s en la lista.");
        }else if(timbres.size() == 1){
            mostrarSublista(timbres);
        }else{
            int option = pedirInt("\nHay "+timbres.size()+" "+tipo+" en la lista:" +
                    "\n[1] Seguir buscando." +
                    "\n[2] Mostar los resultados." +
                    "\n[3] Salir" +
                    "\nElija una opcion: ");

            switch (option){
                case 1:
                    buscarTimbres(timbres);
                    break;
                case 2:
                    mostrarSublista(timbres);
                    break;
                case 3:
                    System.out.print("\nSaliendo...");
                    break;
                default:
                    System.out.print("\nOpcion no valida.");
            }
        }
    }

    /**
     * Busca un timbre de una sublista por año de emisión o valor.
     * @param l sublista de timbre
     */
    public static void buscarTimbres(ArrayList<Dinero> l){
        boolean hayTimbre = false;
        int option = pedirInt("\nContinuando: \n[1] Buscar por año de emisión.\n[2] Buscar por valor.\nElija una opcion: ");
        if(option == 1){
            int anyo = pedirInt("\nIndique el año de emisión: ");
            System.out.print("\nMostrando timbres: ");
            for(Dinero d: l){
                if(d.getAnyo()==anyo){
                    System.out.print("\n\n--Objeto numero "+lista.lastIndexOf(d) +"--");
                    System.out.print(d.toString());
                    hayTimbre = true;
                }
            }
            if(!hayTimbre){
                System.out.print("No hay timbres con ese año.");
            }
        }else if(option == 2){
            double valor = pedirDouble("\nIndique el valor: ");
            System.out.print("\nMostrando timbres: ");
            for(Dinero d: l){
                if(d.getValor()==valor){
                    System.out.print("\n\n--Objeto numero "+lista.lastIndexOf(d) +"--");
                    System.out.print(d.toString());
                    hayTimbre = true;
                }
            }
            if(!hayTimbre){
                System.out.print("No hay timbres con ese valor.");
            }
        }else{
            System.out.print("\nOpcion no valida.");
        }
    }

    /**
     * Eliminar un objeto por posición.
     */
    public static void eliminar() {
        System.out.print(
                "\nELIMINANDO OBJETOS" +
                "\n******************");
        int pos = pedirInt("\nIndique la posición del timbre que quiere eliminar: ");
        System.out.print("Eliminando Objeto");
        lista.remove(pos);
        System.out.print("\nTimbre eliminado.");
    }

    /**
     * Modificar un objeto por posición.
     */
    public static void modificar() {
        System.out.print(
                "\nMODIFICANDO OBJETOS" +
                "\n*******************");
        Dinero d = lista.get(pedirInt("\nIndique la posición del timbre que quiere modificar: "));
        if(d instanceof Billete){
            int option = pedirInt("\nQue quiere modificar: " +
                    "\n[1] Ancho" +
                    "\n[2] Altura" +
                    "\nIntroduzca una opcion: ");
            if(option==1){
                ((Billete) d).setAnchura(pedirDouble("\nIndique la nueva anchura: "));
                System.out.print("\nAnchura modificada.");
            }else if(option == 2){
                ((Billete) d).setAltura(pedirDouble("\nIndique la nueva altura: "));
                System.out.print("\nAltura modificada.");
            }else{
                System.out.print("\nOpción no valida.");
            }
        }else if(d instanceof Moneda){
            int option = pedirInt("\nQue quiere modificar: " +
                    "\n[1] Peso" +
                    "\n[2] Diametro");
            if(option==1){
                ((Moneda) d).setPeso(pedirDouble("\nIndique el nuevo peso: "));
                System.out.print("\nPeso modificado.");
            }else if(option == 2){
                ((Moneda) d).setDiametro(pedirDouble("\nIndique el nuevo diamentro: "));
                System.out.print("\nDiametro modificado.");
            }else{
                System.out.print("\nOpción no valida.");
            }
        }
    }
}
