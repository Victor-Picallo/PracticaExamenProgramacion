package ExamenEjercicio4;

import java.util.Random;

public class Velocista extends Ciclista {
    private double potenciaPromedio;
    private double velocidadPromedio;

    public Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadPromedio) {
        super(identificador, nombre);
        this.potenciaPromedio = potenciaPromedio;
        this.velocidadPromedio = velocidadPromedio;
    }

    // Getters y setters
    protected double getPotenciaPromedio() {
        return potenciaPromedio;
    }

    protected void setPotenciaPromedio(double potenciaPromedio) {
        this.potenciaPromedio = potenciaPromedio;
    }

    protected double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    protected void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    // Métodos de lógica
    @Override
    protected String imprimirTipo() {
        return "Es un velocista";
    }

    @Override
    void generarTiempo() {
        super.generarTiempo();
        double tiempo = this.getTiempoAcumulado();
        tiempo = tiempo - this.potenciaPromedio * 2 - this.velocidadPromedio * 0.25;
        setTiempoAcumulado(tiempo);
    }

    //3.Sobreescribimos el metodo calcularTiempoParcial en velocita
    @Override
    void calcularTiempoParcial() {
        Random rd = new Random();
        double tiempoParcial = 20 + rd.nextDouble() * 20;
        tiempoParcial += 5 * getVelocidadPromedio();
        tiempoParcial += 2 * getPotenciaPromedio();
        setTiempoAcumulado(getTiempoAcumulado() + tiempoParcial);
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nVelocista [potenciaPromedio=" + getPotenciaPromedio() +
                ", velocidadPromedio=" + getVelocidadPromedio() + "]";
    }
}
