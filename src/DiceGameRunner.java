import java.util.Scanner;
public class DiceGameRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DiceGame game = new DiceGame();
        String choice;
        double bet;
        System.out.println("Welcome To Dice Higher Or Lower Game!");
        while ((game.getMoney() > 0) && (game.getMoney() < 500)){
            System.out.println("Current Roll: " + game.getPrev() + "   Money: " + String.format("%.02f",game.getMoney()));
            System.out.print("Higher Or Lower: ");
            choice = s.next();
            while (game.choiceChecker(choice) == false){
                System.out.print("Please Enter \"Higher\" Or \"Lower\": ");
                choice = s.next();
            }
            System.out.print("Bet: ");
            bet = s.nextDouble();
            while (game.betChecker(bet) == false){
                if (bet != Math.round(bet * 100)/100.00){
                    System.out.println("Please Input A Valid Bet!");
                }
                else{
                    System.out.println("Bet Exceeds Current Balance!");
                }
                System.out.print("Bet: ");
                bet = s.nextDouble();
            }
            game.game(choice, bet);
            System.out.println(game.toString());
        }
        if (game.getMoney() >= 500){
            System.out.println("Congratulations! You Beat The Game In " + game.getTurns() + " Turns!");
        }
        else{
            System.out.println("You Lost All Your Money!");
        }
    }
}