package ExamenEjercicio3;

public class Vivienda extends Inmueble {

    protected int nHabitaciones;
    protected int nBanos;

    Vivienda(int idInmo, int area, String direccion, int nHab, int nBan) {
        super(idInmo, area, direccion);
        this.nHabitaciones = nHab;
        this.nBanos = nBan;
    }

    public int getnHabitaciones() {
        return nHabitaciones;
    }

    public int getnBanos() {
        return nBanos;
    }

    @Override
    public String toString() {
        return super.toString() + "\nVivienda [nHabitaciones=" + getnHabitaciones() + ", nBanos=" + getnBanos() + "]";
    }

    
}
