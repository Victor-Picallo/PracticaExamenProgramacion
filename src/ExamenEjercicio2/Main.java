package ExamenEjercicio2;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // 1. Generar 6 productos con precio aleatorio entre 1 y 200 (float)
        Producto[] productos = new Producto[6];
        for (int i = 0; i < 6; i++) {
            float precio = (float) (Math.random() * 199) + 1; // entre 1 y 200
            productos[i] = new Producto(i + 1, "Producto" + (i + 1), "Descripción " + (i + 1), precio);
        }

        // 2. Crear la orden y añadir 6 líneas de pedido con cantidad aleatoria entre 1 y 6
        Orden orden = new Orden(1);
        for (int i = 0; i < 6; i++) {
            int cantidad = (int) (Math.random() * 6) + 1; // entre 1 y 6
            orden.anadirItem(i + 1, cantidad, productos[i]);
        }

        // 3. Calcular el total del lote incluyendo un 17% de IVA y mostrarlo
        float totalSinIva = 0;
        for (LineaPedido lp : orden.getProductosPedido()) {
            totalSinIva += lp.calcularSubtotalLineaPedido();
        }
        float iva = totalSinIva * 0.17f;
        float totalConIva = totalSinIva + iva;

        System.out.printf("El precio sin IVA = %.2f\n", totalSinIva);
        System.out.printf("El precio con IVA = %.2f\n", totalConIva);

        // 4. Crear el ticket y guardarlo en un fichero
        String ticket = "TICKET " + orden.getId() + "\n";
        for (LineaPedido lp : orden.getProductosPedido()) {
            ticket += "\n" + lp.getCantidad() + " x " + lp.getProducto().getNombre()
                    + " - " + lp.getProducto().getDescripcion()
                    + " (" + String.format("%.2f", lp.getProducto().getPrecio()) + "€) = "
                    + String.format("%.2f", lp.calcularSubtotalLineaPedido()) + "€";
        }
        ticket += "\nTOTAL SIN IVA: " + String.format("%.2f", totalSinIva) + "€";
        ticket += "\nIVA (17%): " + String.format("%.2f", iva) + "€";
        ticket += "\nTOTAL CON IVA: " + String.format("%.2f", totalConIva) + "€";

        try (FileWriter fw = new FileWriter("VictorP.txt")) {
            fw.write(ticket);
            System.out.println("Ticket guardado en VictorP.txt");
        } catch (IOException e) {
            System.out.println("Error al guardar el ticket: " + e.getMessage());
        }
    }
}
