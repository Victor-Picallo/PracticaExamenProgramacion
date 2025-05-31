package ExamenEjercicio3;

import java.io.Serializable;

public class CasaIndependiente extends CasaUrbana implements Impuesto, Serializable {

    CasaIndependiente(int idInmo, int area, String direccion, int nHab, int nBan, int nPis) {
        super(idInmo, area, direccion, nHab, nBan, nPis);
        // TODO Auto-generated constructor stub
        calcularPrecioVenta();
    }

    @Override
    public double calcularImpuesto() {
        double imp = getPrecioVenta() * 0.02;
        imp += 700 * getnHabitaciones() + 300 * getnBanos();
        return imp;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCasaIndependiente []";
    }

    void calcularPrecioVenta() {
        this.precioVenta = getArea() * getValorUnitario().get("Casa independiente");
    }


}
