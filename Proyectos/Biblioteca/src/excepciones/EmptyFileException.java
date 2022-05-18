package excepciones;

public class EmptyFileException extends Exception{
    @Override
    public String getMessage() {
        return "El fichero no existe o esta vacío.";
    }

}
