package biblioteca;

public class Biblioteca {
    // ***ATRIBUTOS***
    Empleados empleadosObj;
    Usuarios usuariosObj;
    Libros librosObj;

    public void init(){
        empleadosObj = Empleados.get();
        usuariosObj = Usuarios.get();
        librosObj = Libros.get();
    }
}
