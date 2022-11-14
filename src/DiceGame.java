import java.util.Locale;

public class DiceGame {
    private double money;
    private int turns;
    private int diceRoll;
    private String result;
    private int prev = rollDice();
    private int d1;
    private int d2;

    public DiceGame(){
        money = 50;
        turns = 0;
    }

    public int rollDice(){
        d1 = (int) (Math.random() * 6) + 1;
        d2 = (int) (Math.random() * 6) + 1;
        int sum = d1 + d2;
        return sum;
    }

    public int getD1(){
        return d1;
    }

    public int getD2(){
        return d2;
    }

    public String printDice(int dice){
        if (dice == 1) {
            return("* * * * *\n*       *\n*   O   *\n*       *\n* * * * *");
        }
        else if (dice == 2) {
            return("* * * * *\n*    O  *\n*       *\n*  O    *\n* * * * *");
        }
        else if (dice == 3) {
            return("* * * * *\n*    O  *\n*   O   *\n*  O    *\n* * * * *");
        }

        else if (dice == 4) {
            return("* * * * *\n*  O O  *\n*       *\n*  O O  *\n* * * * *");
        }

        else if (dice == 5) {
            return("* * * * *\n*  O O  *\n*   O   *\n*  O O  *\n* * * * *");
        }
        else{
            return("* * * * *\n*  O O  *\n*  O O  *\n*  O O  *\n* * * * *");
        }
    }

    public void turnCounter(){
        turns++;
    }

    public double getMoney(){
        return money;
    }
    public int getTurns(){
        return turns;
    }
    public int getPrev(){
        return prev;
    }
    public void decreaseMoney(double bet){
        money -= bet;
    }
    public boolean choiceChecker(String choice){
        choice = choice.toLowerCase();
        if ((choice.contains("higher")) || (choice.contains("lower"))){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean betChecker(double bet){
        if (bet != Math.round(bet * 100)/100.00){
            return false;
        }
        if (bet <= money){
            return true;
        }
        else {
            return false;
        }
    }


    public void increaseMoney(double bet){
        money += bet;
    }

    public void game(String choice, double bet){
        String correct = "";
        diceRoll = rollDice();
        if (prev > diceRoll){
            correct = "lower";
        }
        else if (prev < diceRoll){
            correct = "higher";
        }
        else if (prev == diceRoll){
            correct = choice;
        }
        if (choice.equals(correct)){
            increaseMoney(bet);
            result = "You Guessed Correctly!";
        }
        else{
            decreaseMoney(bet);
            result = "You Guessed Incorrectly!";
        }
        turnCounter();
        prev = diceRoll;
    }

    public String toString() {
        String gameMessage = "\nDice Roll: " + diceRoll + "\n" + result + "\n" + printDice(d1) + "\n" + printDice(d2);
        return gameMessage;
    }
}

