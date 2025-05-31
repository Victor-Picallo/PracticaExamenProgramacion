package ExamenEjercicio4;

import java.util.ArrayList;
import java.util.Collections;

public class Testeo {

    static ArrayList<Equipo> equipos = new ArrayList<>();
    public static void main(String[] args) {

        //6.Creamos 3 equipos con cada tipo de ciclista
        Equipo equipo1 = new Equipo("Equipo 1", "España");
        Equipo equipo2 = new Equipo("Equipo 2", "Francia");
        Equipo equipo3 = new Equipo("Equipo 3", "Italia");

        // Añadir un ciclista de cada tipo a cada equipo
        equipo1.addCiclista(new Velocista(1, "Velocista 1", 8, 45));
        equipo1.addCiclista(new Escalador(2, "Escalador 1", 7, 12));
        equipo1.addCiclista(new Contrarrelojista(3, "Contrarrelojista 1", 50));

        equipo2.addCiclista(new Velocista(4, "Velocista 2", 7.5, 44));
        equipo2.addCiclista(new Escalador(5, "Escalador 2", 6.5, 11));
        equipo2.addCiclista(new Contrarrelojista(6, "Contrarrelojista 2", 48));

        equipo3.addCiclista(new Velocista(7, "Velocista 3", 8.2, 46));
        equipo3.addCiclista(new Escalador(8, "Escalador 3", 7.3, 13));
        equipo3.addCiclista(new Contrarrelojista(9, "Contrarrelojista 3", 52));


        equipos.add(equipo1);
        equipos.add(equipo2);
        equipos.add(equipo3);

        //Creamos las 3 estapas
        for(int i = 1; i <= 3; i++) {
            Etapa etapa = new Etapa(i);
            //Disputamos las etapas
            etapa.disputar(equipos);
            //7.Calculamos tiempo parcial despues de cada etapa
            System.out.println("\nClasificacion por equipos tras la etapa " + i + ": ");
            System.out.println("----------------------------------");
            mostrarClasificacionEquipos();

            System.out.println("\nClasificación individual tras la etapa " + i + ": ");
            System.out.println("----------------------------------");
            mostrarClasificacionIndividual();
        }

        //8.Clasificación final
        System.out.println("\nCLASIFICACIÓN FINAL POR EQUIPOS");
        System.out.println("----------------------------------");
        mostrarClasificacionEquipos();

        System.out.println("\nCLASIFICACIÓN FINAL INDIVIDUAL");
        System.out.println("----------------------------------");
        mostrarClasificacionIndividual();
    }

    // Métodos para mostrar clasificaciones
    public static void mostrarClasificacionEquipos() {
        Collections.sort(equipos); // Ordena por tiempo total
        for (Equipo eq : equipos) {
            System.out.println(eq.getNombre() + " " + eq.getTotalTiempo());
        }
    }

    public static void mostrarClasificacionIndividual() {
        ArrayList<Ciclista> todos = new ArrayList<>();
        for (Equipo eq : equipos) {
            todos.addAll(eq.getListaCiclistas());
        }
        Collections.sort(todos); // Ordena por tiempo acumulado
        for (Ciclista c : todos) {
            System.out.println(c.getNombre() + " " + c.getTiempoAcumulado());
        }
    }
}