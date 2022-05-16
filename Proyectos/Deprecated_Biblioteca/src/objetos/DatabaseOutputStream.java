package objetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class DatabaseOutputStream extends ObjectOutputStream{

    public DatabaseOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected DatabaseOutputStream() throws IOException, SecurityException {
    }

    @Override
    protected void writeStreamHeader(){

    }

}
