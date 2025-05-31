package ExamenEjercicio3;

import java.io.Serializable;

public class CasaRural extends Casa implements Impuesto, Serializable {

    // protected static double valorArea = 1500000;
    protected int distanciaCap;
    protected int altitud;

    CasaRural(int idInmo, int area, String direccion, int nHab, int nBan, int nPis, int dis, int alt) {
        super(idInmo, area, direccion, nHab, nBan, nPis);
        //TODO Auto-generated constructor stub
        this.distanciaCap = dis;
        this.altitud = alt;
        calcularPrecioVenta();
    }

    public int getDistanciaCap() {
        return distanciaCap;
    }

    public int getAltitud() {
        return altitud;
    }

    //agregamos el metodo de la interfaz
    @Override
    public double calcularImpuesto() {
        double imp = getPrecioVenta() * 0.02;
        imp += 700 * getnHabitaciones() + 300 * getnBanos();
        imp += 4 * getAltitud();
        return imp;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCasaRural [distanciaCap=" + getDistanciaCap() + ", altitud=" + getAltitud() + "]";
    }

    void calcularPrecioVenta() {
        this.precioVenta = getArea() * getValorUnitario().get("Casa rural"); //Tiene que buscar la casa rural
    }

}
