package models;

public class ComponentElectronic extends Producte{
    private String resolucio;
    private int capacitatBateria;
    private final int garantia = 9;

    public ComponentElectronic(String nom, String marca, double preu, int quantitatStock, String dataCompra, double descompte, String resolucio, int capacitatBateria) {
        super(nom, marca, preu, quantitatStock, dataCompra, descompte);
        this.resolucio = resolucio;
        this.capacitatBateria = capacitatBateria;
    }

    public String getResolucio() {
        return resolucio;
    }

    public void setResolucio(String resolucio) {
        this.resolucio = resolucio;
    }

    public int getCapacitatBateria() {
        return capacitatBateria;
    }

    public void setCapacitatBateria(int capacitatBateria) {
        this.capacitatBateria = capacitatBateria;
    }

    public int getGarantia() {
        return garantia;
    }

    @Override
    public String caracteristiquesProducte() {
        return "El producte Component Electrònic té una resolució de " + resolucio + ", una capacitat de bateria de " + capacitatBateria + " i una garantia de 9 mesos" ;
    }
}
