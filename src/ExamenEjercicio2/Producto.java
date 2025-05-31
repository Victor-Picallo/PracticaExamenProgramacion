package ExamenEjercicio2;

public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private float precio;

    public Producto(int id, String nombre, String descripcion, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    private void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "[ " + getId() + ": " + getNombre() + " -> " + getDescripcion() + " -> " +getPrecio() + "€ ]";
    }
}
