package excepciones;

public class NameAlreadyUsedException extends Exception{
    @Override
    public String getMessage() {
        return "El nombre que ha elegido es inválido o ya ha sido utilizado.";
    }
}
