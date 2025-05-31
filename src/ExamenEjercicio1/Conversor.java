package ExamenEjercicio1;

public class Conversor {

    public static double convertir(int stones, int libras) throws IllegalArgumentException {
        if (libras < 0 || libras > 13) {
            throw new IllegalArgumentException("No puede haber mas de 13 librs");
        }
        return stones * 6.35 + libras * 0.453;
    }
}