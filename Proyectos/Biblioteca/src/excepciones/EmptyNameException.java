package excepciones;

public class EmptyNameException extends Exception{
    @Override
    public String getMessage() {
        return "El fichero no existe o esta vacío.";
    }

}
