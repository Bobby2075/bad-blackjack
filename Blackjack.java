/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marcus
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //opretter variabler
        boolean spil = true;
        int dKort1, dKort2, dTotal, pKort1, pKort2, pTotal;

        // initialisere objekter
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // trækker kort til dealeren
        dKort1 = random.nextInt(11) + 1;
        dKort2 = random.nextInt(11) + 1;
        dTotal = dKort1 + dKort2;

        System.out.println("Dealeren har: " + dKort1);

        // trækker kort til spilleren
        pKort1 = random.nextInt(11) + 1;
        pKort2 = random.nextInt(11) + 1;
        pTotal = pKort1 + pKort2;

        System.out.println("Dine kort er: " + pKort1 + " og: " + pKort2);
        System.out.println("Din total er: " + pTotal);

        // do-while løkke til at kunne vælge hvad man vil gøre.
        do {

            System.out.println("\nDu kan nu gøre følgende (HIT) eller (STAND)");
            //modtager input fra tastature af
            String action = keyboard.next();

            switch (action) {
                case "HIT":
                    //kalder på metoden Hit og sender pTotal ned som parametre
                    pTotal = Hit(pTotal);
                    break;
                case "STAND":
                    // kalder på metoden stand og sender dTotal og dKort2 ned som parametre
                    dTotal = Stand(dTotal, dKort2);
                    break;
                default:
                    //default casen beder brugeren om at prøve at indtaste deres svar igen
                    System.out.println("Den forstod jeg ikke prøv igen");
                    break;
            }

            if (pTotal > 21) {
                //tjekker om spilleren har over 21, hvis de har så taber de
                System.out.println("Du tabte");
                spil = false;
            } else if (pTotal == 21) {
                //tjekker om spilleren har 21, hvis de har så vinder de.
                System.out.println("Tillykke du vandt med 21");
                spil = false;
            } else if (dTotal >= 17) {
                //kalder på compare metoden som vil sammenligne spilleren og dealerens totaler for at finde vinderen
                compare(dTotal, pTotal);
                spil = false;
            }

        } while (spil);

    }

    public static int Hit(int Total) {
        int kort;

        Random random = new Random();
        
        //trækker et kort til spilleren
        kort = random.nextInt(11) + 1;

        //ligger værdien fra kortet til den total som spilleren allerede har
        Total += kort;
        //viser spilleren det kort som de har trukket plus den nye total som de har
        System.out.println("\ndu træk: " + kort + " din total er nu: " + Total);

        //retunere spillerens nye total
        return Total;
    }

    public static int Stand(int dTotal, int kort2) {
        Random random = new Random();
        int kort;
        boolean temp = true;

        do {
            //denne løkke bliver ved med at trække et kort til dealeren indtil de har 17 eller over
            kort = random.nextInt(11) + 1;
            dTotal += kort;
            System.out.println("\nDealeren træk: " + kort);
            System.out.println("hans total er nu: " + dTotal);

            //tjekker om dealeren har 17 eller over, hvis de har sætter den boolean til false for at stoppe løkken
            if (dTotal >= 17) {
                temp = false;
            }

        } while (temp);

        //retunere dealerens nye total
        return dTotal;
    }

    public static void compare(int dTotal, int pTotal) {
        
        //helle den her metode vil bare sammenligne spillerens total og dealerens total for at se hvem der vinder
        if (dTotal < pTotal || dTotal > 21) {
            System.out.println("\nDu vandt tillykke\ndu havde: " + pTotal + " Dealeren havde: " + dTotal);
        } else if (dTotal > pTotal) {
            System.out.println("\nDu tabte bedre held næste gang\ndu havde: " + pTotal + " Dealeren havde: " + dTotal);
        } else if (dTotal == pTotal) {
            System.out.println("Det blev uafgjort du tabte ikke men du vand heller ikke");
        }
    }
}
