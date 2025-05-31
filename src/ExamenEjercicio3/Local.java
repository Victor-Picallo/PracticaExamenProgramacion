package ExamenEjercicio3;

public class Local extends Inmueble {

    enum tipo {
        INTERNO, CALLE
    }

    protected tipo tipolocal;

    Local(int idInmo, int area, String direccion, tipo tipolocal) {
        super(idInmo, area, direccion);
        this.tipolocal = tipolocal;
        // TODO Auto-generated constructor stub
    }

    public tipo getTipolocal() {
        return tipolocal;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLocal [tipolocal=" + getTipolocal() + "]";
    }


}