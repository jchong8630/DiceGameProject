import java.util.Scanner;
public class DiceGameRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DiceGame game = new DiceGame();
        String choice;
        int bet;
        int prev = game.rollDice();
        while ((game.getMoney() > 0) && (game.getMoney() < 500)){
            System.out.println(prev);
            System.out.print("Higher Or Lower: ");
            choice = s.next();
            System.out.print("Bet: ");
            bet = s.nextInt();
            game.game(choice, bet);
            System.out.println(game.toString());
        }
    }
}