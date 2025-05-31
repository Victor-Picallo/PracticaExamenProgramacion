package ExamenEjercicio3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InmoApp {

    public static void main(String[] args) {
        //1.Creamos la lista
        ArrayList<Inmueble> listaInm = new ArrayList<>();

        //1.Creamos un objeto de cada tipo concreto
        CasaRural casaRural = new CasaRural(1, 120, "Calle Campo 1", 3, 2, 2, 15, 500);
        CasaCerrado casaConjunto = new CasaCerrado(2, 95, "Av. Jardines 2", 4, 2, 2, 1, false, true);
        CasaIndependiente casaIndep = new CasaIndependiente(3, 110, "Calle Sol 3", 3, 2, 1);
        Apartaestudio apartaestudio = new Apartaestudio(4, 40, "Calle Centro 4", 1, 1);
        ApartamentoFamiliar aptoFamiliar = new ApartamentoFamiliar(5, 85, "Av. Familia 5", 3, 2, 1800);
        LocalComercial localCom = new LocalComercial(6, 70, "Calle Comercio 6", Local.tipo.INTERNO, "Alaxe");
        Oficina oficina = new Oficina(7, 60, "Edificio Oficinas 7", Local.tipo.INTERNO, true);

        //1.Añadimos a la lista
        listaInm.add(casaRural);
        listaInm.add(casaConjunto);
        listaInm.add(casaIndep);
        listaInm.add(apartaestudio);
        listaInm.add(aptoFamiliar);
        listaInm.add(localCom);
        listaInm.add(oficina);

        //1.Mostramos caracteristicas y precio
        System.out.println("Lista de inmuebles vendidos");
        for (Inmueble i : listaInm) {
            System.out.println("----------------------------------");
            System.out.println(i);
        }

        //2.Mistramos el total del valor de lo inmuebles vendidos
        double totalVenta = 0;
        for (Inmueble i : listaInm) {
            totalVenta += i.getPrecioVenta();
        }
        System.out.println("----------------------------------");
        System.out.printf("Total valor: %.2f", totalVenta);

        //3.Mostramos el promedio de valor por metro cuadrado
        int totalArea = 0;
        for (Inmueble i : listaInm) {
            totalArea += i.getArea();
        }
        double promedioValorMetro;
        if (totalArea == 0) {
            promedioValorMetro = 0;
        } else {
            promedioValorMetro = totalVenta / totalArea;
        }
        System.out.println("\n----------------------------------");
        System.out.printf("Precio promedio por m2: %.2f", promedioValorMetro);
        System.out.println("\n----------------------------------");

        //5.Mostramos el impuesto de cada uno de los inmuebles vendidos
        double totalImpuestos = 0;
        for (Inmueble i : listaInm) {
            if (i instanceof Impuesto) {
                double imp = ((Impuesto) i).calcularImpuesto();
                System.out.printf("Impuestos de %s: %.2f\n", i.getClass().getSimpleName(), imp);
                totalImpuestos += imp;
            }
        }

        //6.Mostrar totalPagar por impuesto
        System.out.println("----------------------------------");
        System.out.printf("Total pagar por impuesto: %.2f", totalImpuestos);
        System.out.println("\n----------------------------------");

        //7.Guardar en un ficher
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream
                ("inmobiliaria_PicalloRodriguez.dat"))) {
        oos.writeObject(listaInm);
        System.out.println("Coleccion guardada en inmobiliaria_PicalloRodriguez.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

