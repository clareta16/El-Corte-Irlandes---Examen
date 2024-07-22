import models.Roba;

import java.util.Scanner;

public class Menu {
    private static final byte MIN_OPCIO = 1;
    private static final byte MAX_OPCIO = 10;

    private Scanner teclat;

    public Menu() {
        teclat = new Scanner(System.in);
    }

    public void iniciar() {
        byte tria;

        do {
            tria = mostrarMenu();

            switch (tria) {
                case 1:
                    ElCorteIrlandes.crearProducte(teclat); //falten tots els paràmetres
                    break;
                case 2:
                    ElCorteIrlandes.llistarProductesMenAMaj();
                    break;
                case 3:
                    ElCorteIrlandes.eliminarProducte();
                    break;
                case 4:
                    ElCorteIrlandes.calcularDataVencimentGarantia();
                    break;
                case 5:
                    ElCorteIrlandes.aplicarRebaixesProducte();
                    break;
                case 6:
                    ElCorteIrlandes.mostrarProductesEnRebaixes();
                    break;
                case 7:
                    consultarStockProducte();
                    break;
                case 8:
                    augmentarStockProducte();
                    break;
                case 9:
                    treureStockProducte();
                    break;
                case 10:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Has d'escriure una opció vàlida");
            }
        } while (tria != 10);

        teclat.close();
    }

    private byte mostrarMenu() {
        byte opcio;

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Crear un producte");
            System.out.println("2. Llistar productes ordenats de menor a major");
            System.out.println("3. Eliminar un producte");
            System.out.println("4. Calcular data venciment de la garantia");
            System.out.println("5. Aplicar rebaixes al producte");
            System.out.println("6. Mostrat productes en rebaixes");
            System.out.println("7. Consultar stock d'un producte");
            System.out.println("8. Augmentar stock d'un producte");
            System.out.println("9. Treure stock d'un producte");


            while (!teclat.hasNextByte()) {
                System.out.println("Escull una opció vàlida");
                teclat.next();
            }
            opcio = teclat.nextByte();

            if (opcio < MIN_OPCIO || opcio > MAX_OPCIO) {
                System.out.println("Escull una opció vàlida");
            }
        } while (opcio < MIN_OPCIO || opcio > MAX_OPCIO);

        return opcio;
    }

}

