package models;

import java.util.Objects;

public abstract class Producte {
    private static int codiProducte = 1;
    private String nom;
    private String marca;
    private double preu;
    private int quantitatStock;
    private String dataCompra;
    private double descompte;

    public Producte(String nom, String marca, double preu, int quantitatStock, String dataCompra, double descompte) {
        this.codiProducte = ++codiProducte;
        this.nom = nom;
        this.marca = marca;
        this.preu = preu;
        this.quantitatStock = quantitatStock;
        this.dataCompra = dataCompra;
        this.descompte = descompte;
    }

    public static int getCodiProducte() {
        return codiProducte;
    }

    public static void setCodiProducte(int codiProducte) {
        Producte.codiProducte = codiProducte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public int getQuantitatStock() {
        return quantitatStock;
    }

    public void setQuantitatStock(int quantitatStock) {
        this.quantitatStock = quantitatStock;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getDescompte() {
        return descompte;
    }

    public void setDescompte(float descompte) {
        this.descompte = descompte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producte producte = (Producte) o;
        return Double.compare(preu, producte.preu) == 0 && quantitatStock == producte.quantitatStock && Double.compare(descompte, producte.descompte) == 0 && Objects.equals(nom, producte.nom) && Objects.equals(marca, producte.marca) && Objects.equals(dataCompra, producte.dataCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, marca, preu, quantitatStock, dataCompra, descompte);
    }

    public abstract String caracteristiquesProducte();
}


