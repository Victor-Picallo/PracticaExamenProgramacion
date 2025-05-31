package ExamenEjercicio2;

public class LineaPedido {

    private int id;
    private int cantidad;
    private Producto producto;

    public LineaPedido(int id, int cantidad, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    private void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    private void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float calcularSubtotalLineaPedido() {
        return this.cantidad * this.producto.getPrecio();
    }

    @Override
    public String toString() {
        return "[ " +getCantidad() + " x " + getProducto().getNombre() +
                " (" + getProducto().getPrecio() + "€) = " +
                calcularSubtotalLineaPedido() + "€ ]";
    }
}
