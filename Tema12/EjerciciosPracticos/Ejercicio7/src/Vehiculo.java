import java.text.DecimalFormat;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private transient double deposito;
    private static final transient DecimalFormat df = new DecimalFormat(".##");

    public Vehiculo(String matricula, String marca, String modelo, double deposito) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.deposito = deposito;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    @Override
    public String toString() {
        return ("\nEl vehículo tiene una matrícula " + matricula + ", su marca es " + marca + ", " +
                "su modelo es " + modelo + " y el tamaño del depósito es de " + df.format(deposito) + " litros");
    }
}
