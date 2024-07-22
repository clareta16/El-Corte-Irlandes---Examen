package models;

public class Bellesa extends Producte{
    private boolean vega;
    private String temporada;


    public Bellesa(String nom, String marca, double preu, int quantitatStock, String dataCompra, double descompte, boolean vega, String temporada) {
        super(nom, marca, preu, quantitatStock, dataCompra, descompte);
        this.vega = vega;
        this.temporada = temporada;
    }

    public boolean isVega() {
        return vega;
    }

    public void setVega(boolean vega) {
        this.vega = vega;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Override
    public String caracteristiquesProducte() {
        return "El producte Bellesa és" + vega + " i de " + temporada;
    }
}
