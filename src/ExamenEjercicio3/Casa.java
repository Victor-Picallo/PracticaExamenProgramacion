package ExamenEjercicio3;

public class Casa extends Vivienda {

    protected int nPisos;

    Casa(int idInmo, int area, String direccion, int nHab, int nBan,int nPis) {
        super(idInmo, area, direccion, nHab, nBan);
        this.nPisos = nPis;
    }

    public int getnPisos() {
        return nPisos;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCasa [nPisos=" + getnPisos() + "]";
    }

    

}
