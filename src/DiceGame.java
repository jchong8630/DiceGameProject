public class DiceGame {
    private int money;
    private int turns;
    private int diceRoll;
    private String result;
    private int prev;

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

    public int getMoney(){
        return money;
    }
    public int getTurns(){
        return turns;
    }
    public int getPrev(){
        return prev;
    }
    public void decreaseMoney(int bet){
        money -= bet;
    }


    public void increaseMoney(int bet){
        money += bet;
    }

    public void game(String choice, int bet){
        String correct = "";
        diceRoll = rollDice();
        if (prev > diceRoll){
            correct = "lower";
        }
        else if (prev < diceRoll){
            correct = "Higher";
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
        String gameMessage = "Dice Roll: " + diceRoll + "\n" + result + "\nMoney: " + money + "   Turns: " + turns;
        return gameMessage;
    }
}

