import sistema.Aplicacion;

public class Main {

    public static void main(String[] args) {
        Aplicacion app = new Aplicacion();
        app.init();
        app.start();
        app.close();
    }
}
