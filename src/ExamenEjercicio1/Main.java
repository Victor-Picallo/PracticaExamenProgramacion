package ExamenEjercicio1;

/*Preparar una GUI que recoja en dos cajas de texto dos números enteros (stones y libras) y
al pulsar un botón CONVERTIR realizara la operación de conversión de dichos valores a Kg y su suma,
que se colocara en un label para mostrar el resultado de dicha operación.
Ejemplo 5 stones y 8 libras son 62,133 Kg. 5 por 6,35 Kg + 8 por 0,453 Kg = 31,75 + 3,624 = 35,374 Kg Nota: 1 stone son 14 libras,
luego la cantidad máxima de libras admitidas será 13 (filtre el dato).*/
public class Main {

    public static void main(String[] args) {
        VentanaConversor vc = new VentanaConversor();
        vc.setVisible(true);
    }
}