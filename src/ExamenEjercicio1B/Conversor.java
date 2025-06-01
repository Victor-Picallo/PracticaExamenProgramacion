package ExamenEjercicio1B;

public class Conversor {

    public static double convertir(int pies, int pulgadas) throws IllegalArgumentException {
        if (pulgadas < 0 || pulgadas > 11) {
            throw new IllegalArgumentException("No puede haber mas de 11 pulgadas");
        }
        return pies * 30.48 + pulgadas * 2.54;
    }
}