package ExamenEjercicio3;

import java.io.Serializable;

public class CasaCerrado extends CasaUrbana implements Impuesto, Serializable {

    protected int valorAdmin;
    protected boolean tienePiscina;
    protected boolean tieneCamposDeportivos;

    CasaCerrado(int idInmo, int area, String direccion, int nHab, int nBan, int nPis, int admin, boolean piscina, boolean campos) {
        super(idInmo, area, direccion, nHab, nBan, nPis);
        //TODO Auto-generated constructor stub
        this.valorAdmin = admin;
        this.tienePiscina = piscina;
        this.tieneCamposDeportivos = campos;
        calcularPrecioVenta();
    }

    public int getValorAdmin() {
        return valorAdmin;
    }

    public boolean isTienePiscina() {
        return tienePiscina;
    }

    public boolean isTieneCamposDeportivos() {
        return tieneCamposDeportivos;
    }

    //agregamos el metodo de la interfaz
    @Override
    public double calcularImpuesto() {
        double imp = getPrecioVenta() * 0.02;
        imp += 700 * getnHabitaciones() + 300 * getnBanos();
        if (!isTienePiscina()) imp -= 6000;
        if (!isTieneCamposDeportivos()) imp -= 3000;
        return imp;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCasaCerrado [valorAdmin=" + getValorAdmin() + ", tienePiscina=" + isTienePiscina() + ", tieneCamposDeportivos="
                + isTieneCamposDeportivos() + "]";
    }

    void calcularPrecioVenta() {
        this.precioVenta = getArea() * getValorUnitario().get("Casa en conjunto cerrado");
    }

}