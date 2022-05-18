package excepciones;

/**
 * Clase de excepción para controlar el estado de un fichero (existe, esta vacío,)
 */
public class EmptyFileException extends Exception{
    @Override
    public String getMessage() {
        return "El fichero no existe o esta vacío.";
    }

}
