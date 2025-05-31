package ExamenEjercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Testeo {
    static ArrayList<Equipo> equipos = new ArrayList<>();

    public static void main(String[] args) {
        Equipo equipo1 = new Equipo("Equipo 1", "España");
        Equipo equipo2 = new Equipo("Equipo 2", "Francia");
        Equipo equipo3 = new Equipo("Equipo 3", "Italia");

        equipo1.addCiclista(new Velocista(1, "Velocista 1", 8, 45));
        equipo1.addCiclista(new Escalador(2, "Escalador 1", 2.8, 12));
        equipo1.addCiclista(new Contrarrelojista(3, "Contrarrelojista 1", 50));

        equipo2.addCiclista(new Velocista(4, "Velocista 2", 7.5, 44));
        equipo2.addCiclista(new Escalador(5, "Escalador 2", 3.2, 11));
        equipo2.addCiclista(new Contrarrelojista(6, "Contrarrelojista 2", 48));

        equipo3.addCiclista(new Velocista(7, "Velocista 3", 8.2, 46));
        equipo3.addCiclista(new Escalador(8, "Escalador 3", 2.5, 13));
        equipo3.addCiclista(new Contrarrelojista(9, "Contrarrelojista 3", 52));

        equipos.add(equipo1);
        equipos.add(equipo2);
        equipos.add(equipo3);

        for (int i = 1; i <= 3; i++) {
            Etapa etapa = new Etapa(i);
            etapa.disputar(equipos);

            // Calcula el tiempo parcial de la etapa para cada equipo
            for (Equipo eq : equipos) {
                eq.calcularTiempoParcialEtapa();
            }

            System.out.println("\nClasificacion por equipos tras la etapa " + i + ": ");
            System.out.println("----------------------------------");
            mostrarClasificacionEquiposEtapa();

            System.out.println("\nClasificación individual tras la etapa " + i + ": ");
            System.out.println("----------------------------------");
            mostrarClasificacionIndividualEtapa();
        }

        // Calcula el tiempo total para la clasificación final
        for (Equipo eq : equipos) {
            eq.calcularTiempoTotal();
        }

        System.out.println("\nCLASIFICACIÓN FINAL POR EQUIPOS");
        System.out.println("----------------------------------");
        mostrarClasificacionEquipos();

        System.out.println("\nCLASIFICACIÓN FINAL INDIVIDUAL");
        System.out.println("----------------------------------");
        mostrarClasificacionIndividual();
    }

    // Clasificación por equipos de la etapa
    public static void mostrarClasificacionEquiposEtapa() {
        for (Equipo eq : equipos) {
            eq.setTotalTiempo(eq.getUltimoTiempoParcial());
        }
        Collections.sort(equipos);
        for (Equipo eq : equipos) {
            System.out.printf(eq.getNombre() + " -> " + "%.2f\n", eq.getUltimoTiempoParcial());
        }
    }

    //Clasificacion individual de la etapa
    public static void mostrarClasificacionIndividualEtapa() {
        ArrayList<Ciclista> todos = new ArrayList<Ciclista>();
        for (Equipo eq : equipos) {
            todos.addAll(eq.getListaCiclistas());
        }
        Collections.sort(todos, new Comparator<Ciclista>() {
            public int compare(Ciclista c1, Ciclista c2) {
                return Double.compare(c1.getUltimoTiempoParcial(), c2.getUltimoTiempoParcial());
            }
        });
        for (Ciclista c : todos) {
            System.out.printf(c.getNombre() + " -> " + "%.2f\n", c.getUltimoTiempoParcial());
        }
    }


    // Clasificación final por equipos
    public static void mostrarClasificacionEquipos() {
        Collections.sort(equipos);
        for (Equipo eq : equipos) {
            System.out.printf(eq.getNombre() + " -> " + "%.2f\n", eq.getTotalTiempo());
        }
    }

    // Clasificación final individual
    public static void mostrarClasificacionIndividual() {
        ArrayList<Ciclista> todos = new ArrayList<>();
        for (Equipo eq : equipos) {
            todos.addAll(eq.getListaCiclistas());
        }
        Collections.sort(todos);
        for (Ciclista c : todos) {
            System.out.printf(c.getNombre() + " -> " + "%.2f\n", c.getTiempoAcumulado());
        }
    }
}
