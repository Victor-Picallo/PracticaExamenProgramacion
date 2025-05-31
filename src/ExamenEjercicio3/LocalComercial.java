package ExamenEjercicio3;

import java.io.Serializable;

public class LocalComercial extends Local implements Impuesto, Serializable {

    protected String centroComercial;

    LocalComercial(int idInmo, int area, String direccion, tipo tipolocal, String centro) {
        super(idInmo, area, direccion, tipolocal);
        // TODO Auto-generated constructor stub
        this.centroComercial = centro;
        calcularPrecioVenta();
    }

    public String getCentroComercial() {
        return centroComercial;
    }

    @Override
    public double calcularImpuesto() {
            return getPrecioVenta() * 0.06;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLocalComercial [centroComercial=" + getCentroComercial() + "]";
    }

    void calcularPrecioVenta () {
        this.precioVenta = getArea() * getValorUnitario().get("Local comercial");
    }
    

}
