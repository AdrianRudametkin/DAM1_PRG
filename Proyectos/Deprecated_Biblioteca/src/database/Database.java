package database;

import java.io.Serializable;

public abstract class Database implements Serializable {

    public abstract <DB extends Database> DB get();

    protected abstract void readDB();
    protected abstract void writeDB();

    public abstract String toString();
}
