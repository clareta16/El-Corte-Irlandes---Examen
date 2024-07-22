import excepcions.EliminarProducteInexistentException;
import models.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ElCorteIrlandes {
    public static void main(String[] args) {

        Scanner teclat = new Scanner(System.in);

        List<Roba> llistaRoba = new ArrayList<>();
        List<Electrodomestic> electrodomestics = new ArrayList<>();
        List<ComponentElectronic> componentsElectronics = new ArrayList<>();
        List<Bellesa> productesBellesa = new ArrayList<>();
        Menu menu = new Menu();

        Producte producte = new Producte("sabata", "Nike", 33.40, 10, "24-10-2000", 30);
        Roba roba0 = new Roba("sabata", "Nike", 33.40, 10, "24-10-2000", 30, 's', "seda", "roba còmode");
        Bellesa bellesa = new Bellesa("makeup", "bath", 100, 20, 33, true, "estiu");

        llistaRoba.add(roba0);
        productesBellesa.add(bellesa);


    }

    public static void crearProducte(Scanner teclat, List<Roba> llistaRoba, List<Electrodomestic> electrodomestics, List<ComponentElectronic> componentsElectronics, List<Bellesa> productesBellesa) {
        int tipus = 0;
        while (tipus > 4 || tipus < 1) {
            System.out.println("Indica quin tipus de producte és: 1-Roba 2-Electrodomèstic 3-Component Electrònic 4-Bellesa");
            tipus = teclat.nextInt();
        }
        teclat.nextLine();

        System.out.println("Ara indica el nom del producte");
        String nom = teclat.nextLine();
        System.out.println("Indica la marca del producte");
        String marca = teclat.nextLine();
        System.out.println("Indica el preu del producte");
        double preu = teclat.nextDouble();
        System.out.println("Indica la quantitat en stock del producte");
        int stock = teclat.nextInt();
        teclat.nextLine();
        System.out.println("Indica la data de compra del producte en format DD-MM-AAAA");
        LocalDate ld = LocalDate.of(teclat.nextInt(), teclat.nextInt(), teclat.nextInt());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MMM. yyyy");
        String dataCompra = ld.format(dtf);
        System.out.println("Indica el % de rebaixa del producte");
        double descompte = teclat.nextDouble();
        teclat.nextLine();

        switch (tipus) {
            case 1: // roba
                System.out.println("Quina és la talla?");
                char talla = teclat.next().charAt(0);
                teclat.nextLine();  // Consume newline
                System.out.println("Quin és el teixit?");
                String teixit = teclat.nextLine();
                System.out.println("Quin tipus de roba és?");
                String tipusRoba = teclat.nextLine();

                Roba roba = new Roba(nom, marca, preu, stock, dataCompra, descompte, talla, teixit, tipusRoba);
                llistaRoba.add(roba);
                System.out.println("Producte de roba creat i afegit a la botiga");
                break;

            case 2: // electrodomestic
                System.out.println("Indica el consum energètic");
                String consumEnergetic = teclat.nextLine();
                System.out.println("Indica la data de fabricació en format DD-MM-AAAA");
                LocalDate ld2 = LocalDate.of(teclat.nextInt(), teclat.nextInt(), teclat.nextInt());
                DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd. MMM. yyyy");
                String dataFabricacio = ld2.format(dtf2);
                System.out.println("Indica la capacitat");
                int capacitat = teclat.nextInt();
                teclat.nextLine();

                Electrodomestic electrodomestic = new Electrodomestic(nom, marca, preu, stock, dataCompra, descompte, consumEnergetic, dataFabricacio, capacitat);
                electrodomestics.add(electrodomestic);
                System.out.println("Electrodomèstic creat i afegit a la botiga");
                break;

            case 3: // component electronic
                System.out.println("Indica la resolució de la imatge");
                String resolucioImatge = teclat.nextLine();
                System.out.println("Indica la capacitat de la bateria (mAh)");
                int capacitatBateria = teclat.nextInt();
                teclat.nextLine();

                ComponentElectronic componentElectronic = new ComponentElectronic(nom, marca, preu, stock, dataCompra, descompte, resolucioImatge, capacitatBateria);
                componentsElectronics.add(componentElectronic);
                System.out.println("Component electrònic creat i afegit a la botiga");
                break;

            case 4: // bellesa
                System.out.println("És vegà? (true/false)");
                boolean vega = teclat.nextBoolean();
                teclat.nextLine();
                System.out.println("Indica la temporada d'ús (primavera, estiu, etc.)");
                String temporadaUs = teclat.nextLine();

                Bellesa bellesa1 = new Bellesa(nom, marca, preu, stock, dataCompra, descompte, vega, temporadaUs);
                productesBellesa.add(bellesa1);
                System.out.println("Producte de bellesa creat i afegit a la botiga");
                break;
        }
    }

    public static void llistarProductesMenAMaj(List<Producte> productes, List<Roba> llistaRoba, List<Electrodomestic> electrodomestics, List<ComponentElectronic> componentsElectronics, List<Bellesa> productesBellesa) {
        productes.addAll(llistaRoba);
        productes.addAll(productesBellesa);
        productes.addAll(electrodomestics);
        productes.addAll(componentsElectronics);

        List<Producte> productesOrdenatsPerPreu = productes.stream()
                .sorted(Comparator.comparingDouble(Producte::getPreu))
                .collect(Collectors.toList());

        for (Producte producteA : productesOrdenatsPerPreu) {
            System.out.println(producteA.getNom() + ", "
                    + producteA.getMarca() + ", "
                    + producteA.getPreu() + " euros");
        }
    }

    public static void eliminarProducte(Producte producte, List<Producte> productes) throws EliminarProducteInexistentException {
        if (productes.remove(producte)) {
            System.out.println("S'ha eliminat el producte" + producte);
        } else {
            throw new EliminarProducteInexistentException("El producte que has escrit no existeix");
        }
    }

    public static void calcularDataVencimentGarantia(Scanner teclat, Electrodomestic electrodomestic, ComponentElectronic componentElectronic) {
        int resposta = 0;
        while (resposta > 2 || resposta < 1) {
            System.out.println("El teu producte és 1-electrodomèsic o 2-component electrònic");
            resposta = teclat.nextInt();
        }

        LocalDate dataActual = LocalDate.now();
        LocalDate dataVenciment;

        if (resposta == 1) {
            dataVenciment = dataActual.plusYears(electrodomestic.getGarantia());
        } else {
            dataVenciment = dataActual.plusYears(componentElectronic.getGarantia());
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataVencimentFormat = dataVenciment.format(format);
        System.out.println("La data de venciment és " + dataVencimentFormat);
    }

    public static void aplicarRebaixesProducte(Scanner teclat) {
        System.out.println("Indica el preu actual del producte");
        double preuActual = teclat.nextDouble();

        System.out.println("Indica el descompte que s'aplicarà");
        double descompte = teclat.nextDouble();

        double numeroDescompte = (preuActual * descompte) / 100;
        double preuFinal = preuActual - numeroDescompte;

        System.out.println("Després d'aplicar el descompte " +
                "el producte tindrà un preu de " + preuFinal);
    }

    public static void mostrarProductesEnRebaixes(List<Producte> productes) {
        for (Producte producte : productes) {
            if (producte.getDescompte() != 0) {
                System.out.println(producte);
            }
        }
    }


    //falten mètodes però no em dona temps


}









