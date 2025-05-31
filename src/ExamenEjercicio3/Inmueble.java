package ExamenEjercicio3;

import java.util.HashMap;

public class Inmueble {

    protected HashMap<String, Double> ValorUnitario;

    public void pueblaValores() {

        ValorUnitario = new HashMap<String, Double>();

        this.ValorUnitario.put("Casa rural", 1525d);
        this.ValorUnitario.put("Casa en conjunto cerrado", 2225d);
        this.ValorUnitario.put("Casa independiente", 3400d);
        this.ValorUnitario.put("Apartaestudio", 1875d);
        this.ValorUnitario.put("Apartamento familiar", 2500d);
        this.ValorUnitario.put("Local comercial", 3575d);
        this.ValorUnitario.put("Oficina", 3975d);
        this.ValorUnitario.put("zero", 0d);
    }
    
    protected int idInmo;
    protected int area;
    protected String direccion;
    protected double precioVenta;



    Inmueble(int idInmo, int area, String direccion) {
        this.idInmo = idInmo;
        this.area = area;
        this.direccion = direccion;
        this.precioVenta = 0d;
        pueblaValores();
    }

    public HashMap<String, Double> getValorUnitario() {
        return ValorUnitario;
    }

    public int getIdInmo() {
        return idInmo;
    }

    public int getArea() {
        return area;
    }

    public String getDireccion() {
        return direccion;
    }

    void ValorPrecioVenta(String NombreInmueble) {
        this.precioVenta = area * ValorUnitario.get(NombreInmueble);
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    void calcularPrecioVenta () {
        this.precioVenta = area * ValorUnitario.get("zero");
    }

    @Override
    public String toString() {
        return "Inmueble [idInmo=" + getIdInmo() + ", area=" + getArea() + ", direccion=" + getDireccion() + ", precioVenta="
                + getPrecioVenta() + "]";
    }

}
