package ExamenEjercicio4;
import java.util.Random;

public class Ciclista implements Comparable<Ciclista> {
    private int id;
    private String nombre;
    private double tiempoAcumulado = 0;
    private int posGeneral = -1;

    public Ciclista(int identificador, String nombre) {
        this.id = identificador;
        this.nombre = nombre;
        generarTiempo();
    }

    protected String imprimirTipo() {
        return "Ciclista genérico";
    }

    protected int getId() {
        return id;
    }

    protected void setIdentifcador(int id) {
        this.id = id;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected int getPosGeneral() {
        return this.posGeneral;
    }

    protected void setPosGeneral(int posGeneral) {
        this.posGeneral = posGeneral;
    }

    protected double getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    protected void setTiempoAcumulado(double tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }

    protected void imprimir() {
        System.out.println("Identificador = " + getId());
        System.out.println("Nombre = " + getNombre());
        System.out.println("Tiempo Acumulado = " + getTiempoAcumulado());
    }

    void generarTiempo() {
        Random rd = new Random();
        setTiempoAcumulado(rd.nextDouble(20.0, 30.0));
    }

    //2.Creamos el metodo calcularTiempoParcial
    void calcularTiempoParcial() {
        Random rd = new Random();
        double tiempoParcial = 20 + rd.nextDouble() * 20;
        setTiempoAcumulado(getTiempoAcumulado() + tiempoParcial);
    }

    @Override
    public int compareTo(Ciclista c) {
        return (int) Double.compare(this.getTiempoAcumulado(), c.getTiempoAcumulado());
    }

    @Override
    public String toString() {
        return "Ciclista [id=" + getId() + ", nombre=" + getNombre() + ", tiempoAcumulado=" + getTiempoAcumulado() + ", posGeneral=" + getPosGeneral() + "]";
    }
}
