package ExamenEjercicio3;

import java.io.Serializable;

public class Oficina extends Local implements Impuesto, Serializable {

    protected boolean esOficial;

    Oficina(int idInmo, int area, String direccion, tipo tipolocal, boolean oficial) {
        super(idInmo, area, direccion, tipolocal);
        //TODO Auto-generated constructor stub
        this.esOficial = oficial;
        calcularPrecioVenta();
    }

    public boolean isEsOficial() {
        return esOficial;
    }

    @Override
    public double calcularImpuesto() {
        double imp = getPrecioVenta() * 0.06;
        if (!esOficial) imp -= 3000;
        return imp;
    }

    @Override
    public String toString() {
        return super.toString() + "\nOficina [esOficial=" + isEsOficial() + "]";
    }

    void calcularPrecioVenta() {
        this.precioVenta = getArea() * getValorUnitario().get("Oficina");
    }
}
