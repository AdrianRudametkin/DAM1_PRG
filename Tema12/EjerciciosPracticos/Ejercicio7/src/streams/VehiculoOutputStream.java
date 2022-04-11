package streams;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class VehiculoOutputStream extends ObjectOutputStream{

    public VehiculoOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected VehiculoOutputStream() throws IOException, SecurityException {
    }

    protected void writeStreamHeader() throws IOException{
        // No hacer nada
    }
}
