import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean gaming = true;
        String action;
        Card card = new Card();
        Scanner scanner = new Scanner(System.in);
        card.DealerKort();

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
                    break;
                default:
                    gaming = false;
                    break;
            }


            // gaming = false;
        } while (gaming);
    }


}
