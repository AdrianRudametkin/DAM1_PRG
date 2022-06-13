/*--------------------------
 This code was created for 
 educational purposes only!
 
 If any legal problems en-
 coutered, please contact
 the author, thank you \(^o^)/ 
--------------------------*/

 /*
 *
 * MundoFiguras.java
 *
 * Created on Feb 28, 2022 At 11:00:14 AM
 * 
 * Developed by Rogelio Rodriguez for IES El Grao
 *
 * Contact me through e-mail : 10377573@ieselgrao.org
 *
 */
package examenprogramacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Rogelio Rodriguez
 * @date Feb 28, 2022
 * @version 1.0
 *
 */
public class MundoFiguras {

    // ***ATRIBUTOS***
    private static ArrayList<Figura> figuras;
    private static Scanner sc;

    // ***METODOS***
    public static void init() {
        Figura.rellenarFiguras();
        figuras = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public static void loop() {
        int option = 0;
        do {
            try {
                printMenu();
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        agregarFigura();
                        break;
                    case 2:
                        System.out.print("\nTotal creadas: " + Figura.getNumFiguras()
                                +"\nTotal en la lista: " + figuras.size() +"\n");
                        pausa();
                        break;
                    case 3:
                        mostrarTodasFiguras();
                        break;
                    case 4:
                        mostrarFigura();
                        break;
                    case 5:
                        modificarDatos();
                        break;
                    case 6:
                        eliminarFigura();
                        break;
                    case 7:
                        vaciarLista();
                        break;
                    case 8:
                        System.out.println("Hasta la proxima!!");
                        break;
                    default:
                        System.out.println("Opcion no valida...");
                }
            } catch (NullPointerException e) {
                System.out.println("Porfavor, introduzca un numero valido...");
                option = 0;
                sc.next();
            }
        } while (option != 8);

    }

    private static void printMenu() {
        System.out.print("\n\n***MUNDO DE FIGURAS***"
                + "\n[1] Agregar figura."
                + "\n[2] Consltar numero de figuras creadas."
                + "\n[3] Mostrar TODAS las figuras."
                + "\n[4] Mostrar figura especifica."
                + "\n[5] Modificar datos de una figura."
                + "\n[6] Eliminar una figura."
                + "\n[7] Vaciar la lista de figuras."
                + "\n[8] Salir."
                + "\n Eliga una opcion: ");
    }

    private static void agregarFigura() {
        // Variables
        String option;
        int base, altura;
        // Bucle que se repite hasta que se añada una figura con exito
        do {
            // Coger errores del Scanner y del Trapecio
            try {
                // Pedir el tipo de figura
                sc.nextLine();
                System.out.print("\nQue tipo de figura quiere agregar?(triangulo, rectangulo, trapecio, hexagono)"
                        + "\nElija uno: ");
                option = sc.nextLine();
                // Comprobar que existe ese tipo de figura
                if (option.equalsIgnoreCase("triangulo")
                        || option.equalsIgnoreCase("rectangulo")
                        || option.equalsIgnoreCase("trapecio")
                        || option.equalsIgnoreCase("hexagono")) {
                    // Pedir datos de figuras
                    System.out.print("Indique la base de la figura: ");
                    base = sc.nextInt();
                    System.out.print("Indique la altura de la figura: ");
                    altura = sc.nextInt();

                    // Dependiendo del tipo, añadir a la lista
                    if (option.equalsIgnoreCase("triangulo")) {
                        figuras.add(new Triangulo(base, altura));
                    } else if (option.equalsIgnoreCase("rectangulo")) {
                        figuras.add(new Rectangulo(base, altura));
                    } else if (option.equalsIgnoreCase("trapecio")) {
                        // En el caso del trapecio, pedir base grande
                        System.out.print("Indique la Base (grande) de la figura: ");
                        figuras.add(new Trapecio(base, altura, sc.nextInt()));
                    } else if (option.equalsIgnoreCase("hexagono")) {
                        figuras.add(new Hexagono(base, altura));
                    }
                    System.out.print("\n--Figura Creada y Añadida--");
                } else {
                    // En caso de que no sea una figura valida
                    System.out.print("\nPorfavor, elija entre las opciones validas...");
                    option = "";        // Para seguir en el bucle
                }
            } catch (InputMismatchException e) {
                msgExcpNumero();
                option = "";            // Para seguir en el bucle
            } catch (IllegalArgumentException e) {
                System.out.print("\nLa base grande del trapecio, como su nombre indica, tiene que ser mas grande que la base.");
                option = "";            // Para seguir en el bucle
            }
        } while (option.equals(""));
        pausa();
    }

    private static void mostrarTodasFiguras() {
        System.out.print("\n--MOSTRANDO TODAS LAS FIGURAS--");
        int i = 0;
        // Iterar la lista
        for (Figura e : figuras) {
            System.out.print("\n\nFigura " + i + ": ");
            System.out.print(e.toString());
            System.out.print("\nPosicion: " + figuras.indexOf(e));
            i++;
        }
        pausa();
    }

    private static Figura buscarFigura() {
        int fig = -1;

        do {
            try {
                sc.nextLine();
                System.out.print("\nIndique la posicion de la figura: ");
                fig = sc.nextInt();
                return figuras.get(fig);
            } catch (InputMismatchException e) {
                msgExcpNumero();
            } catch (IndexOutOfBoundsException e) {
                msgExcpLista();
                fig = -1;
            }
        } while (fig == -1);

        return null;
    }

    private static void mostrarFigura() {
        Figura fig;
        // Coger errores de numeros invalidos y de numeros fuera de la lista
        try {
            fig = buscarFigura();
            System.out.print(fig.toString());
            fig.dibujar();
        } catch (IndexOutOfBoundsException e) {
            msgExcpLista();
        } catch (InputMismatchException e) {
            msgExcpNumero();
        }

        pausa();
    }

    private static void modificarDatos() {
        String option = "";
        Figura fig;
        // Bucle hasta que se modifque con exito
        do {
            try {
                fig = buscarFigura();

                // Pedir que quiere modificar
                System.out.print("\nQue desea modificar?(base o altura)\nElija uno: ");
                sc.nextLine();
                option = sc.nextLine();

                // Comprobar que la opcion sea correcta
                if (!(option.equalsIgnoreCase("altura") || option.equalsIgnoreCase("base"))) {
                    msgExcpOption();
                    option = "";
                } else {
                    // Para la altura
                    if (option.equalsIgnoreCase("altura")) {
                        System.out.print("Indique el tamaño: ");
                        fig.setAltura(sc.nextInt());
                        System.out.print("\n--Figura Modificada--");

                    } else if (option.equalsIgnoreCase("base")) {
                        // Para la base
                        // Comprobar que no sea un trapecio por la base distinta
                        if (!(fig.getClass().equals(Trapecio.class))) {
                            System.out.print("Indique el tamaño: ");
                            fig.setBase(sc.nextInt());
                            System.out.print("\n--Figura Modificada--");

                        } else {
                            option = "";
                            // Bucle hasta hasta que se ponga un numero correcto
                            do {
                                try {
                                    System.out.print("\nLa pequeña o la grande: ");
                                    option = sc.nextLine();
                                    if (option.equalsIgnoreCase("pequeña")) {
                                        System.out.print("Indique el tamaño: ");
                                        fig.setBase(sc.nextInt());
                                        System.out.print("\n--Figura Modificada--");

                                    } else if (option.equalsIgnoreCase("grande")) {
                                        System.out.print("Indique el tamaño: ");
                                        ((Trapecio) fig).setBASE(sc.nextInt());
                                        System.out.print("\n--Figura Modificada--");

                                    } else {
                                        msgExcpOption();
                                        option = "";
                                    }
                                } catch (InputMismatchException e) {
                                    msgExcpNumero();
                                    option = "";
                                }
                            } while (option.equals(""));
                        }
                    }
                }
            } catch (InputMismatchException e) {
                msgExcpNumero();
            } catch (IndexOutOfBoundsException e) {
                msgExcpLista();
                option = "";
            }
        } while (option.equals(""));
        pausa();
    }

    private static void eliminarFigura() {
        int option = -1;

        // Bucle hasta que se eliga una figura con exito
        do {
            // Coger errores de numeros invalidos y de numeros fuera de la lista
            try {
                System.out.print("\nEliga la figura que se quiere eliminar: ");
                option = sc.nextInt();
                figuras.remove(option);
                System.out.print("\n--Figura Eliminada--");
            } catch (IndexOutOfBoundsException e) {
                msgExcpLista();
            } catch (InputMismatchException e) {
                msgExcpNumero();
            }
        } while (option < 0);

        pausa();
    }

    private static void vaciarLista() {
        String option = "";
        do {
            System.out.print("\nEstas seguro de que quieres borrar TODA la lista??? (si/no)");
            if (option.equalsIgnoreCase("si")) {
                figuras.clear();
                System.out.print("\n--Lista Borrada--");
            } else if (option.equalsIgnoreCase("no")) {
                System.out.print("\n--Proceso de Borrado Cancelado--");
            } else {
                msgExcpOption();
                option = "";
            }
        } while (option.equals(""));

        pausa();
    }

    //  Metodos para mostar informacion miscelanea por pantalla
    private static void pausa() {
        System.out.print("\nPulse intro para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

    private static void msgExcpNumero() {
        System.out.print("\nEse numero no es un numero...");
    }

    private static void msgExcpLista() {
        System.out.print("\nEse numero no se encuetra en la lista...");
        System.out.print("\nSolo entre el 0 y el " + (figuras.size() - 1) + ".");
    }

    private static void msgExcpOption() {
        System.out.print("\nEsa opcion no es valida...");
    }

}
