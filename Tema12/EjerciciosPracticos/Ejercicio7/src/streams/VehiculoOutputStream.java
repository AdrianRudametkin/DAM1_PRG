package streams;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class VehiculoOutputStream extends ObjectOutputStream implements Serializable {
    private static final long serialVersionUID = 1L;

    public VehiculoOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected VehiculoOutputStream() throws IOException, SecurityException {
    }

    protected void writeStreamHeader() throws IOException{
        // No hacer nada
    }
}
