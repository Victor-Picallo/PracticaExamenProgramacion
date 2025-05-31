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

    // Métodos de lógica
    @Override
    protected String imprimirTipo() {
        return "Es un escalador";
    }

    @Override
    void generarTiempo() {
        double tiempo = 55.0 + Math.random() * 20;
        tiempo = tiempo - this.aceleracionPromedio * 1.2 - this.gradoRampa * 0.35;
        setTiempoAcumulado(tiempo);
    }

    //4.Sobreescribimos el metodo calcularTiempoParcial en escalador
    @Override
    void calcularTiempoParcial() {
        Random rd = new Random();
        double tiempoParcial = 20 + rd.nextDouble() * 20;
        tiempoParcial += 3 * getAceleracionPromedio();
        tiempoParcial -= 5 * getGradoRampa();
        setTiempoAcumulado(getTiempoAcumulado() + tiempoParcial);
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nEscalador [aceleracionPromedio=" + getAceleracionPromedio() +
                ", gradoRampa=" + getGradoRampa() + "]";
    }
}
