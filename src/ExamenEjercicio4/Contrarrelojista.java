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

    @Override
    protected String imprimirTipo() {
        return "Es un contrarrelojista";
    }

    // 5. Sobreescribimos el método calcularTiempoParcial en Contrarrelojista
    @Override
    void calcularTiempoParcial() {
        Random rd = new Random();
        double tiempoParcial = 20 + rd.nextDouble() * 20;
        // Apartado 5: +4 * velocidadMaxima
        tiempoParcial += 4 * getVelocidadMaxima();
        setUltimoTiempoParcial(tiempoParcial);
        setTiempoAcumulado(getTiempoAcumulado() + tiempoParcial);
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nContrarrelojista [velocidadMaxima=" + getVelocidadMaxima() + "]";
    }
}
