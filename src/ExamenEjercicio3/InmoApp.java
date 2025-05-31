package ExamenEjercicio3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InmoApp {

    /*Se pide 1/ crear una lista de al menos un objeto de estas siete clases citadas en la tabla mostrando sus características y el precio de venta de cada una.
    2/ Muestre el total del valor de los inmuebles vendidos.
    3/ Muestre el promedio del valor por metro cuadrado del total de inmuebles vendidos
    4/ Implementa la interfaz impuesto que implementa el método calcularImpuesto que se obtendrá de la siguiente forma:
    a/ todas las casas tienen un 2% de su valor de venta, los apartamentos el 4% y los locales el 6%.
    b/ las viviendas pagan 700 por el número de habitaciones y 300 por el número de baños
    c/ se añadirá en las rurales una cantidad de 4 veces su altitud
    d/ se añadirá en los apartamentos familiares una cantidad de 3 veces su valor de administración
    e/ se restará 3000 de impuesto a las oficinas que no sean del gobierno
    f/ en las casas conjunto cerrado se les restará 6000 si no son con piscina y otros 3000 si no tiene campo deportivo.
    5/ En la lista del testeo se mostrará el impuesto de cada uno de los inmuebles vendidos
    6/ Se mostrará el total de dinero a pagar por los impuestos
    7/ se guardará la colección de inmuebles en un fichero inmobiliaria_tus_apellidos.dat que se entregará con el examen.*/

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

