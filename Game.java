import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean gaming = true;
        String action;
        Card card = new Card();

        Scanner scanner = new Scanner(System.in);
        card.DealerKort();
        card.Deal();

        System.out.println(card.DitKort());
        System.out.println("Din total er: " + card.GetTotal());
        System.out.println();
        System.out.println(card.DealerKort());
        System.out.println("Dealerens total er: " + card.GetDTotal());

        do {

            System.out.println("\nHvad vil du nu? Hit eller Stand");
            action = scanner.next();
            action = action.toUpperCase();

            switch (action) {
                case "HIT":
                    System.out.println(card.Hit());
                    System.out.println("Din total er nu: " + card.GetTotal());
                    break;

                case "STAND":
                    card.Stand();
                    gaming = false;
                    break;

                default:
                    System.out.println("x");
                    break;
            }

        int theDTotal = card.GetDTotal();
        int thePTotal = card.GetTotal();
        check(gaming, thePTotal, theDTotal);
           

            // gaming = false;
        } while (gaming);
    }

    public static boolean check(boolean gaming, int pTotal, int dTotal) {
        Card card = new Card();
        //System.out.println("test"+pTotal);
        if (pTotal > 21) {
            System.out.println("Du tabte, dealeren vinder");
            gaming = false;
        } else if (pTotal == 21) {
            System.out.println("Du vandt med 21");
            gaming = false;
        } else if (dTotal >= 17) {
            card.Compare();
            gaming = false;
        } else {
            gaming = true;
        }

        return gaming;
    }

}
