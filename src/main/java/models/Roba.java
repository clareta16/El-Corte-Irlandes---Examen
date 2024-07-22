package models;

public class Roba extends Producte{
    private char talla;
    private String teixit;
    private String tipusRoba;

    public Roba(String nom, String marca, double preu, int quantitatStock, String dataCompra, double descompte, char talla, String teixit, String tipusRoba) {
        super(nom, marca, preu, quantitatStock, dataCompra, descompte);
        this.talla = talla;
        this.teixit = teixit;
        this.tipusRoba = tipusRoba;
    }

    public char getTalla() {
        return talla;
    }

    public void setTalla(char talla) {
        this.talla = talla;
    }

    public String getTeixit() {
        return teixit;
    }

    public void setTeixit(String teixit) {
        this.teixit = teixit;
    }

    public String getTipusRoba() {
        return tipusRoba;
    }

    public void setTipusRoba(String tipusRoba) {
        this.tipusRoba = tipusRoba;
    }

    @Override
    public String caracteristiquesProducte() {
        return "El producte Roba té una talla " + talla + " un teixit " + teixit + " i un tipus de roba " +tipusRoba;
    }



}
