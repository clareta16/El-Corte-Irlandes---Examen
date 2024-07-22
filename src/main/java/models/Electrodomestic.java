package models;

public class Electrodomestic extends Producte{
    private String consumEnergetic;
    private String dataFabricacio;
    private int capacitat;
    private final int garantia = 18;

    public Electrodomestic(String nom, String marca, double preu, int quantitatStock, String dataCompra, double descompte, String consumEnergetic, String dataFabricacio, int capacitat) {
        super(nom, marca, preu, quantitatStock, dataCompra, descompte);
        this.consumEnergetic = consumEnergetic;
        this.dataFabricacio = dataFabricacio;
        this.capacitat = capacitat;
    }

    public String getConsumEnergetic() {
        return consumEnergetic;
    }

    public void setConsumEnergetic(String consumEnergetic) {
        this.consumEnergetic = consumEnergetic;
    }

    public String getDataFabricacio() {
        return dataFabricacio;
    }

    public void setDataFabricacio(String dataFabricacio) {
        this.dataFabricacio = dataFabricacio;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public int getGarantia() {
        return garantia;
    }

    @Override
    public String caracteristiquesProducte() {
        return "El producte Electrodomèstic té un consum energètic de " +consumEnergetic + " una data de fabricació de " + dataFabricacio + "una capacitat de " + capacitat + " i una garantia de 18 mesos";
    }
}
