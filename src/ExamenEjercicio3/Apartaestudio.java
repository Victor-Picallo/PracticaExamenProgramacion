package ExamenEjercicio3;

import java.io.Serializable;

public class Apartaestudio extends Apartamento implements Impuesto, Serializable {

    Apartaestudio(int idInmo, int area, String direccion, int nHab, int nBan) {
        super(idInmo, area, direccion, nHab, nBan);
        //TODO Auto-generated constructor stubs
        calcularPrecioVenta();
    }

    @Override
    public double calcularImpuesto() {
        double imp = getPrecioVenta() * 0.04;
        imp += 700 * getnHabitaciones() + 300 * getnBanos();
        return imp;
    }

    void calcularPrecioVenta() {
        this.precioVenta = getArea() * getValorUnitario().get("Apartaestudio");
    }


}
