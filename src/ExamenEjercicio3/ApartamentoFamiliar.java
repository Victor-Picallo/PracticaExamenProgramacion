package ExamenEjercicio3;

import java.io.Serializable;

public class ApartamentoFamiliar extends Apartamento implements Impuesto, Serializable {

    protected int valorAdmin;

    ApartamentoFamiliar(int idInmo, int area, String direccion, int nHab, int nBan, int valor) {
        super(idInmo, area, direccion, nHab, nBan);
        // TODO Auto-generated constructor stub
        this.valorAdmin = valor;
        calcularPrecioVenta();
    }

    public int getValorAdmin() {
        return valorAdmin;
    }

    @Override
    public double calcularImpuesto() {
        double imp = getPrecioVenta() * 0.04;
        imp += 700 * getnHabitaciones() + 300 * getnBanos();
        imp += 3 * getValorAdmin();
        return imp;
    }

    @Override
    public String toString() {
        return super.toString() + "\nApartamentoFamiliar [valorAdmin=" + getValorAdmin() + "]";
    }

    void calcularPrecioVenta() {
        this.precioVenta = getArea() * getValorUnitario().get("Apartamento familiar");
    }
}
