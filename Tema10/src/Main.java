import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public  static Scanner sc;
    public static ArrayList<Dinero> lista;


    public static void main(String[] args) {
        init();
        loop();
    }

    public static void init(){
        lista = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public static void loop(){
        int option;
        do{
            try {
                printMenu();
                option = pedirOpcion();
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
                System.out.println("\nPorfavor, elija un numero valido.");
                option = -1;
            }
        }while(option!=9);
    }

    private static void eliminar() {
    }

    private static void modificar() {
    }

    private static void buscar() {
    }

    private static void copiar() {
    }

    private static void ordenar() {
    }

    private static void comprobar() {
    }

    private static void mostrarTodo() {
    }

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

    public static int pedirOpcion() {
        System.out.print("\nElija una opcion: ");
        return sc.nextInt();
    }

    private static void crearObjeto() {
        System.out.print(
                "\nCREACION DEL OBJETO" +
                "\n*******************");
        String option;
        System.out.print("\nQue quiere crear? Una moneda o un billete?");
        option = sc.nextLine();
        if(option.equalsIgnoreCase("moneda")){

        }
    }
}
