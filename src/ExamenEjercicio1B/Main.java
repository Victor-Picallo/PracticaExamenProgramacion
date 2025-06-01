package ExamenEjercicio1B;

/*Preparar una GUI que recoja en dos cajas dos números enteros (pies y pulgadas) y
al pulsar un botón CONVERTIR realizará la operación de conversión de dichos valores a cm y su suma,
 que se colocara en un label para mostrar el resultado de dicha operación.
  Ejemplo 5 pies 11 pulgadas son 180,34 cm. 5 por 30,48 cm + 11 por 2,54 cm = 152,4 + 27,94 = 180,34 cm Nota: 1 pie son 12 pulgadas,
  luego la cantidad máxima de pulgadas admitidas será 11 (filtre el dato).*/
public class Main {

    public static void main(String[] args) {
        VentanaConversor vc = new VentanaConversor();
        vc.setVisible(true);
    }
}