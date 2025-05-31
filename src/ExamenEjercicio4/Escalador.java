package ExamenEjercicio4;

import java.util.Random;

public class Escalador extends Ciclista {
    private double aceleracionPromedio;
    private double gradoRampa;

    public Escalador(int identificador, String nombre, double aceleracionPromedio, double gradoRampa) {
        super(identificador, nombre);
        this.aceleracionPromedio = aceleracionPromedio;
        this.gradoRampa = gradoRampa;
    }

    // Getters y setters
    protected double getAceleracionPromedio() {
        return aceleracionPromedio;
    }

    protected void setAceleracionPromedio(double aceleracionPromedio) {
        this.aceleracionPromedio = aceleracionPromedio;
    }

    protected double getGradoRampa() {
        return gradoRampa;
    }

    protected void setGradoRampa(double gradoRampa) {
        this.gradoRampa = gradoRampa;
    }

    @Override
    protected String imprimirTipo() {
        return "Es un escalador";
    }

    // 4. Sobreescribimos el método calcularTiempoParcial en Escalador
    @Override
    void calcularTiempoParcial() {
        Random rd = new Random();
        double tiempoParcial = 20 + rd.nextDouble() * 20;
        tiempoParcial += 5 * getGradoRampa() - 3 * getAceleracionPromedio();
        setUltimoTiempoParcial(tiempoParcial);
        setTiempoAcumulado(getTiempoAcumulado() + tiempoParcial);
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nEscalador [aceleracionPromedio=" + getAceleracionPromedio() +
                ", gradoRampa=" + getGradoRampa() + "]";
    }
}
