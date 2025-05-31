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

    // 3. Sobreescribimos el método calcularTiempoParcial en Velocista
    @Override
    void calcularTiempoParcial() {
        Random rd = new Random();
        double tiempoParcial = 20 + rd.nextDouble() * 20;
        tiempoParcial += 5 * velocidadPromedio - 2 * potenciaPromedio;
        setUltimoTiempoParcial(tiempoParcial);
        setTiempoAcumulado(getTiempoAcumulado() + tiempoParcial);
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nVelocista [potenciaPromedio=" + getPotenciaPromedio() +
                ", velocidadPromedio=" + getVelocidadPromedio() + "]";
    }
}
