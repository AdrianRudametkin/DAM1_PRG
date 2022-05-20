package sistema;

import excepciones.EmptyFileException;
import excepciones.EmptyNameException;
import excepciones.NameAlreadyUsedException;
import objetos.Empleado;
import objetos.Libro;
import objetos.Usuario;

import java.io.*;
import java.util.ArrayList;

public class GestionDatos {
    private static ArrayList<Empleado> empleados;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Libro> libros;
    private static String fp = "datos.db";


    public GestionDatos() {
        init();
    }

    private void init() {
        empleados = new ArrayList<>();
        usuarios = new ArrayList<>();
        libros = new ArrayList<>();
    }

    public void cargarDatosPredeterminados(){
        try {
            altaLibro("El Quijote", "Miguel Cervantes", "SM", 12, "E1212412FK", 32.5);
            altaLibro("Romeo y Julieta", "William Shakespeare", "Anaya", 1, "LLO908234K", 14.09);
            altaLibro("1984", "George Orwell", "Libro de Bolsillo", 11, "P0890123123", 19.99);
            altaLibro("Fuente Ovejuna", "Lope de Vega", "Clásicos Españoles", 12, "E1213242FK", 32.5);
            altaLibro("Narrativa Completa", "H.P. Lovecraft", "Plutón Editores", -5, " ", 0);

            altaEmpleado("Alberto");
            altaEmpleado("Encarna");
            altaEmpleado("Estela");
            altaEmpleado("Manolo");
            altaEmpleado("Agustín");

            altaUsuario("usu1");
            altaUsuario("usu2");
            altaUsuario("usu3");
            altaUsuario("usu4");
            altaUsuario("usu5");
        }catch (NameAlreadyUsedException e){
            System.out.print("\n ***[ERROR INESPERADO (Creando predeterminados): \"" + e.getMessage() + "\"]***" +
                    "\n\t[SISTEMA: Abortando carga de valores predeterminados]");
        } catch (EmptyNameException e) {
            System.out.print("\n ***[ERROR INESPERADO (Creando predeterminados): \"" + e.getMessage() + "\"]***" +
                    "\n\t[SISTEMA: Abortando carga de valores predeterminados]");
        }
    }

    public void setFilePath(String fp){
        GestionDatos.fp = fp;
    }

    //*************************************
    //      GESTIÓN DE FICHEROS
    //*************************************
    public void cargarFichero() throws EmptyFileException {
        File f = new File(fp);
        try {
            if (f.exists() && f.length()>0) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fp));

                empleados = (ArrayList<Empleado>) ois.readObject();
                usuarios = (ArrayList<Usuario>) ois.readObject();
                libros = (ArrayList<Libro>) ois.readObject();

                ois.close();
            } else {
                System.out.print("\n [ERROR: No se encontró una base de datos adecuada]");
                throw new EmptyFileException();
            }
        } catch (ClassNotFoundException e) {
            System.out.print("\n ***[ERROR INESPERADO (Leyendo Fichero 1): \"" + e.getMessage() + "\"]***");
        } catch (FileNotFoundException e) {
            System.out.print("\n ***[ERROR INESPERADO (Leyendo Fichero 2): \"" + e.getMessage() + "\"]***");
        } catch (IOException e) {
            System.out.print("\n ***[ERROR INESPERADO (Leyendo Fichero 3): \"" + e.getMessage() + "\"]***");
        }
    }

    public void guardarFichero() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fp));

            oos.writeObject(empleados);
            oos.writeObject(usuarios);
            oos.writeObject(libros);

            oos.flush();
            oos.close();

            System.out.print("\n [SISTEMA: Datos guardados correctamente]");
        }catch (FileNotFoundException e){
            System.out.print("\n ***[ERROR INESPERADO (Guardando Fichero 1): \"" + e.getMessage() + "\"]***");
        }catch (IOException e){
            System.out.print("\n ***[ERROR INESPERADO (Guardando Fichero 2): \"" + e.getMessage() + "\"]***");
            String err = e.getMessage().toLowerCase();
            if(err.contains("denied") || err.contains("denegado")){
                System.out.println("aaaaa");
            }
        }
    }

    //*************************************
    //      GESTIÓN DE LIBROS
    //************************************
    public ArrayList<Libro> listaLibros(){
        return libros;
    }
    public void altaLibro(String titulo, String autor, String editorial, int ubicacion, String isbn, double precio){
        libros.add(new Libro(titulo, autor, editorial, ubicacion, isbn, precio));
    }

    public void bajaLibro(Libro l) {
        libros.remove(l);
    }

    public void alquilarLibro(Libro l, Empleado e, Usuario u) {
        libros.get(libros.lastIndexOf(l)).prestar(e, u);
    }

    public void devolverLibro(Libro l) {
        libros.get(libros.lastIndexOf(l)).devolver();
    }

    public ArrayList<Libro> busquedaLibroTitulo(String s) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getTitulo().toLowerCase().contains(s.toLowerCase())) {
                resultados.add(l);
            }
        }

        return resultados;
    }

    public ArrayList<Libro> busquedaLibroAutor(String s) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getAutor().toLowerCase().contains(s.toLowerCase())) {
                resultados.add(l);
            }
        }

        return resultados;
    }

    public ArrayList<Libro> busquedaLibroEditorial(String s) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getEditorial().toLowerCase().contains(s.toLowerCase())) {
                resultados.add(l);
            }
        }

        return resultados;
    }

    public ArrayList<Libro> busquedaLibroIsbn(String s) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(s)) {
                resultados.add(l);
            }
        }

        return resultados;
    }

    public ArrayList<Libro> busquedaLibroUbicacion(int i) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getPasillo() == i) {
                resultados.add(l);
            }
        }

        return resultados;
    }

    public ArrayList<Libro> busquedaLibroEmpleado(Empleado e) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getEmpleado() == e) {
                resultados.add(l);
            }
        }

        return resultados;
    }

    public ArrayList<Libro> busquedaLibroUsuario(Usuario u) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getUsuario() == u) {
                resultados.add(l);
            }
        }

        return resultados;
    }

    public ArrayList<Libro> busquedaLibroIsPrestado(boolean b) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.isPrestado() == b) {
                resultados.add(l);
            }
        }

        return resultados;
    }


    //*************************************
    //      GESTIÓN DE USUARIOS
    //*************************************

    public ArrayList<Usuario> listaUsuarios() {
        return usuarios;
    }

    public void altaUsuario(String nombre) throws NameAlreadyUsedException, EmptyNameException {
        if(nombre.trim().isEmpty())
            throw new EmptyNameException();
        for(Usuario u: usuarios){
            if(u.getNombre().equals(nombre))
                throw new NameAlreadyUsedException();
        }
        usuarios.add(new Usuario(nombre));
    }

    public void bajaUsuario(Usuario u) {
        usuarios.remove(u);
    }

    public Usuario buscarUsuario(String n){
        for(Usuario u: usuarios){
            if(u.getNombre().equals(n))
                return u;
        }
        return null;
    }

    //*************************************
    //      GESTIÓN DE EMPLEADOS
    //*************************************
    public ArrayList<Empleado> listaEmpleados() {
        return empleados;
    }

    public void altaEmpleado(String nombre) throws NameAlreadyUsedException, EmptyNameException {
        if(nombre.trim().isEmpty())
            throw new EmptyNameException();
        for(Empleado e: empleados){
            if(e.getNombre().equals(nombre))
                throw new NameAlreadyUsedException();
        }
        empleados.add(new Empleado(nombre));
    }

    public void bajaEmpleado(Empleado e) {
        empleados.remove(e);
    }

    public Empleado buscarEmpleado(String n){
        for(Empleado e: empleados){
            if(e.getNombre().equals(n))
                return e;
        }
        return null;
    }
}
