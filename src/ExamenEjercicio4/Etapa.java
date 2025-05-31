package ExamenEjercicio4;

import java.util.List;

public class Etapa {
    private int numero;

    public Etapa(int numero) {
        this.numero = numero;
    }

    public void disputar(List<Equipo> equipos) {
        System.out.println("\n--- Etapa " + numero + " ---");
        for (Equipo eq : equipos) {
            for (Ciclista c : eq.getListaCiclistas()) {
                c.calcularTiempoParcial();
            }
            eq.calcularTiempoTotal();
        }

        for (Equipo eq : equipos) {
            eq.calcularTiempoParcialEtapa();
        }
    }
}
