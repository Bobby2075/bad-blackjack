import java.util.Random;

public class Card {
    // int dKort1, dKort2, dTotal, pKort1, pKort2, pTotal;
    Random random = new Random();
    private int dKort1, dKort2, pKort1, pKort2;
    public int pTotal, dTotal;

    public Card() {
        System.out.println("Der bliver nu trukket fire kort \nTo til dig og to til dealeren");
        Deal();
        System.out.println(" test: kort" + this);
    }

    public void Deal() {

        dKort1 = random.nextInt(11) + 1;
        dKort2 = random.nextInt(11) + 1;

        pKort1 = random.nextInt(11) + 1;
        pKort2 = random.nextInt(11) + 1;
    }

    public String DitKort() {
        String kort;
        kort = "Du træk kortene\n" + pKort1 + "\n" + pKort2;
        pTotal = pKort1 + pKort2;
        return kort;
    }

    public String DealerKort() {
        String dealer;
        dealer = "Dealeren træk " + dKort1;
        dTotal = dKort1 + dKort2;
        return dealer;
    }

    public String Hit() {
        String nyKort;
        int kort = random.nextInt(11) + 1;
        pTotal += kort;
        nyKort = "Du træk: " + kort;
        return nyKort;
    }

    public void Stand() {
        int kort;
        boolean stand = true;

        do {

            kort = random.nextInt(11) + 1;
            dTotal += kort;

            System.out.println("\nDealeren træk: " + kort);
            System.out.println("Deres total er nu " + dTotal);

            if (dTotal >= 17) {
                stand = false;
            }

        } while (stand);
    }


    public int GetDTotal() {
        return dTotal;
    }

    public int GetTotal() {
        return pTotal;
    }

}
