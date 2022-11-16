import java.util.Scanner;
public class DiceGameRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DiceGame game = new DiceGame();
        final String PURPLE = "\u001B[35m";
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String BLUE = "\u001B[34m";
        final String RED = "\u001B[31m";
        String choice;
        double bet;
        System.out.println(PURPLE + "Welcome To Dice Higher Or Lower Game!\nEarn $500 To Win The Game!" + RESET);
        System.out.println(game.printDice(game.getD1()) + "\n" + game.printDice(game.getD2()));
        while ((game.getMoney() > 0) && (game.getMoney() < 500)){
            System.out.println("Current Roll: " + BLUE + game.getPrev() + RESET + "   Money: " + GREEN + String.format("%.02f",game.getMoney()) + RESET + "   Turns: " + GREEN + game.getTurns() + RESET);
            System.out.print("Higher Or Lower: ");
            choice = s.next();
            while (!game.choiceChecker(choice)){
                System.out.print(RED + "Please Enter \"Higher\" Or \"Lower\": " + RESET);
                choice = s.next();
            }
            System.out.print("Bet: ");
            bet = s.nextDouble();
            while (!game.betChecker(bet)){
                if ((bet != Math.round(bet * 100)/100.00) || (bet < 0)){
                    System.out.println(RED + "Please Input A Valid Bet!" + RESET);
                }
                else{
                    System.out.println(RED + "Bet Exceeds Current Balance!" + RESET);
                }
                System.out.print("Bet: ");
                bet = s.nextDouble();
            }
            game.game(choice, bet);
            System.out.println(game.toString());
        }
        if (game.getMoney() >= 500){
            System.out.println(GREEN + "Congratulations! You Beat The Game In " + game.getTurns() + " Turns!");
        }
        else{
            System.out.println(RED + "You Lost All Your Money!");
        }
    }
}