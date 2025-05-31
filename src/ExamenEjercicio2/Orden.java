package ExamenEjercicio2;

import java.util.ArrayList;

public class Orden {
    private int id;
    private ArrayList<LineaPedido> productosPedido;

    // Constructor
    public Orden(int identificador) {
        this.id = id;
        this.productosPedido = new ArrayList<>();
    }

    // Getter y setter
    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public ArrayList<LineaPedido> getProductosPedido() {
        return productosPedido;
    }

    private void setProductosPedido(ArrayList<LineaPedido> productosPedido) {
        this.productosPedido = productosPedido;
    }

    // Metodo para calcular el total de la orden
    public int calculaTotalOrden() {
        int total = 0;
        for (LineaPedido lp : this.productosPedido) {
            total += lp.calcularSubtotalLineaPedido();
        }
        return total;
    }

    // Metodo para anadir un item de pedido
    public void anadirItem(int id, int cantidad, Producto producto) {
        LineaPedido lp = new LineaPedido(id, cantidad, producto);
        this.productosPedido.add(lp);
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + getId() +
                ", productosPedido=" + getProductosPedido() +
                '}';
    }
}