package ExamenEjercicio4;

import java.util.ArrayList;
import java.util.Collections;

public class Equipo implements Comparable<Equipo> {
    private String nombre;
    private double totalTiempo;
    private String pais;
    private ArrayList<Ciclista> listaCiclistas;

    // Constructores
    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.totalTiempo = 0;
        this.listaCiclistas = new ArrayList<>();
    }

    public Equipo() {
        this.listaCiclistas = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotalTiempo() {
        return totalTiempo;
    }
    public void setTotalTiempo(double totalTiempo) {
        this.totalTiempo = totalTiempo;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Ciclista> getListaCiclistas() {
        return listaCiclistas;
    }
    public void setListaCiclistas(ArrayList<Ciclista> listaCiclistas) {
        this.listaCiclistas = listaCiclistas;
    }

    // Métodos de gestión de ciclistas
    public void addCiclista(Ciclista ciclista) {
        getListaCiclistas().add(ciclista);
    }

    public void listarEquipo() {
        for (Ciclista c : getListaCiclistas()) {
            System.out.println(c);
        }
    }

    public Ciclista buscarCiclista(String nombre) {
        for (Ciclista c : getListaCiclistas()) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    public void ordenarCiclistasPorTiempo() {
        Collections.sort(getListaCiclistas());
    }

    // Métodos de cálculo
    public void calcularTiempoTotal() {
        totalTiempo = 0; // Asegura que no se acumule varias veces
        for (Ciclista c : getListaCiclistas()) {
            totalTiempo += c.getTiempoAcumulado();
        }
    }

    // Comparable por totalTiempo
    @Override
    public int compareTo(Equipo otroEquipo) {
        return Double.compare(this.totalTiempo, otroEquipo.totalTiempo);
    }

    @Override
    public String toString() {
        return "\nEquipo [nombre=" + getNombre() + ", totalTiempo=" + getTotalTiempo() + ", pais=" + getPais() + "]";
    }
}
