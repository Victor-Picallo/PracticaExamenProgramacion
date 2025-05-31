package ExamenEjercicio4;

import java.util.Random;

public class Contrarrelojista extends Ciclista {
    private double velocidadMaxima;

    public Contrarrelojista(int identificador, String nombre, double velocidadMaxima) {
        super(identificador, nombre);
        this.velocidadMaxima = velocidadMaxima;
    }

    // Getters y setters
    protected double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    protected void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    // Métodos de lógica
    @Override
    protected String imprimirTipo() {
        return "Es un contrarrelojista";
    }

    @Override
    void generarTiempo() {
        super.generarTiempo();
        double tiempo = this.getTiempoAcumulado();
        tiempo = tiempo - this.velocidadMaxima * 0.33;
        setTiempoAcumulado(tiempo);
    }

    //5.Sobreescribimos el metodo calcularTiempoParcial en contrarrelojista
    @Override
    void calcularTiempoParcial() {
        Random rd = new Random();
        double tiempoParcial = 20 + rd.nextDouble() * 20;
        tiempoParcial += 4 * getVelocidadMaxima();
        setTiempoAcumulado(getTiempoAcumulado() + tiempoParcial);
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nContrarrelojista [velocidadMaxima=" + getVelocidadMaxima() + "]";
    }
}
