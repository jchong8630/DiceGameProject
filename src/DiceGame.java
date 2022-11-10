import java.util.Locale;

public class DiceGame {
    private double money;
    private int turns;
    private int diceRoll;
    private String result;
    private int prev = rollDice();

    public DiceGame(){
        money = 50;
        turns = 0;
    }

    public int rollDice(){
        int sum = (int) (Math.random() * 6) + 1 +  (int) (Math.random() * 6) + 1;
        return sum;
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
        String gameMessage = "Dice Roll: " + diceRoll + "\n" + result + "\nMoney: " + String.format("%.02f", money) + "   Turns: " + turns + "\n";
        return gameMessage;
    }
}

