package Timbre;

import Exceptions.NegativeIntegerException;
import Exceptions.NotAGoodYearException;

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
        loop();
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
                option = pedirInt("\n Elejir una opcion: ");
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
                    case 9:
                        System.out.print("\n\nHasta la proxima!!");
                        break;
                    default:
                        System.out.print("\nPorfavor, elija una opcion valida.");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.print("\nNo existe ese numero en la lista.");
                option = -1;
            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.print("\nPorfavor, elija un numero valido.");
                option = -1;
            }catch(NotAGoodYearException e){
                System.out.print("\nEse no es un año valido.");
                option = -1;
            }catch (NegativeIntegerException e){
                System.out.print("\nEl valor no puede ser negativo.");
                option = -1;
            }finally{
                System.out.print("\nPulse Intro para continuar...\n\n");
                sc.nextLine();
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
     * @return entero
     */
    public static double pedirDouble(String msg) {
        System.out.print(msg);
        double d = sc.nextDouble();
        sc.nextLine();
        return d;
    }

    /**
     * Pedir una cadena.
     * @return cadena.
     */
    public static String pedirString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    /**
     * Crear un objeto de dinero y añadirlo a la lista.
     */
    private static void crearObjeto() throws NotAGoodYearException, NegativeIntegerException {
        System.out.print(
                "\nCREACION DEL OBJETO" +
                "\n*******************");

        String option;
        double valor;
        int anyo;
        // Pedir tipo de timbre
        option = pedirString("\nQue quiere crear? Una moneda o un billete? ");
        if(!(option.equalsIgnoreCase("moneda")|| option.equalsIgnoreCase("billete"))){
            System.out.print("\nSolo puede elgir entre moneda y billete.");
            return;
        }
        // Pedir el valor
        valor = pedirDouble("Que valor tiene? ");
        if(valor < 0){
            throw new NegativeIntegerException();
        }
        // Pedir el año de emision
        anyo = pedirInt("En que año fue emitido? ");
        if(anyo > Calendar.getInstance().get(Calendar.YEAR) || anyo <= 1200){
            throw new NotAGoodYearException();
        }
        if(option.equalsIgnoreCase("moneda")){
            double p = pedirDouble("Cuanto pesa su moneda? ");
            if(p < 0){
                throw new NegativeIntegerException();
            }
            double d = pedirDouble("Cual es su diametro? ");
            if(d < 0){
                throw new NegativeIntegerException();
            }

            lista.add(new Moneda(valor, anyo, d, p));
            System.out.print("\nTimbre añadido.");
        }else if(option.equalsIgnoreCase("billete")){
            double ancho = pedirDouble("Cual es la anchura del billete? ");
            if(ancho < 0){
                throw new NegativeIntegerException();
            }
            double alto = pedirDouble("Cual es la altura del billete? ");
            if(alto < 0){
                throw new NegativeIntegerException();
            }

            lista.add(new Billete(valor, anyo, alto, ancho));
            System.out.print("\nTimbre añadido.");
        }
    }

    /**
     * Mostrar todas las monedas y billes de la lista.
     */
    private static void mostrarTodo() {
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
     * Comprobar si hay dos objetos iguales en la lista.
     */
    private static void comprobar() {
        boolean hayIgual = false;
        for(Dinero d1 : lista){
            for(Dinero d2 : lista){
                if(d1.equals(d2)){
                    // Saltar si es la misma instancia del objeto
                    if(d1==d2){
                        continue;
                    }
                    System.out.print("\nEl objeto "+lista.indexOf(d1)+" y el objeto "+lista.lastIndexOf(d2)+" son igules." +
                            "\nPuedes eliminar uno de ellos si quieres.\n");
                    hayIgual = true;
                }
            }
        }
        if(!hayIgual){
            System.out.print("\nNo hay iguales.");
        }
    }

    /**
     * Ordenar la lista de monedas y billetes por valor y luego por año.
     */
    private static void ordenar() {
        Comparator<Dinero> din = new Comparator<Dinero>() {
            @Override
            public int compare(Dinero o1, Dinero o2) {
                return o1.compareTo(o2);
            }
        };

        lista.sort(din);
    }

    /**
     * Copia un objeto y lo añade a la lista.
     */
    private static void copiar() {
        int obj = pedirInt("\nQue objeto quiere copiar? ");
        if(lista.get(obj) instanceof Moneda){
            lista.add(new Moneda((Moneda)lista.get(obj)));
            System.out.print("\nMoneda "+obj+" copiada.");
        }else if(lista.get(obj) instanceof Billete){
            lista.add(new Billete((Billete)lista.get(obj)));
            System.out.print("\nBillete "+obj+" copiado.");
        }
    }

    private static void buscar() {

    }
    /**
     *
     */
    private static void eliminar() {
        System.out.print("Que ");
    }

    private static void modificar() {
    }


}
