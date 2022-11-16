import java.util.Locale;

/**
 * The DiceGame class represents a game involving dices, guesses and bets.
 */
public class DiceGame {
    private double money;
    private int turns;
    private int diceRoll;
    private String result;
    private int prev = rollDice();
    private int d1;
    private int d2;

    /**
     * Constructor for the DiceGame class which sets money and turns to default values.
     */
    public DiceGame(){
        money = 50;
        turns = 0;
    }

    /**
     * rollDice method will set the values of d1 and d2, and returns the sum of both dices.
     * @return an integer that represents the value of the dice roll
     */
    public int rollDice(){
        d1 = (int) (Math.random() * 6) + 1;
        d2 = (int) (Math.random() * 6) + 1;
        int sum = d1 + d2;
        return sum;
    }

    /**
     * getD1 method will return the value of d1.
     * @return the value of d1
     */
    public int getD1(){
        return d1;
    }

    /**
     * getD2 method will return the value of d2.
     * @return the value of d2
     */
    public int getD2(){
        return d2;
    }

    /**
     * printDice method returns a visual representation of the dice.
     * @param dice an integer representing the value of the dice
     * @return a string that will represent the dice and its value
     */
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

    /**
     * turnCounter method will add 1 to the variable turns.
     */
    public void turnCounter(){
        turns++;
    }

    /**
     * getMoney method will return the value of money.
     * @return the value of money
     */
    public double getMoney(){
        return money;
    }

    /**
     * getTurns method will return the value of turns.
     * @return the value of turns
     */
    public int getTurns(){
        return turns;
    }

    /**
     * getPrev method will return the value of the previous dice roll.
     * @return the value of the variable prev
     */
    public int getPrev(){
        return prev;
    }

    /**
     * decreaseMoney method will decrease the variable money by the value of the parameter bet.
     * @param bet a double that represents the amount of money the user bet on the guess
     */
    public void decreaseMoney(double bet){
        money -= bet;
    }

    /**
     * increaseMoney method will increase the variable money by the value of the parameter bet.
     * @param bet a double that represents the amount of money the user bet on the guess
     */
    public void increaseMoney(double bet){
        money += bet;
    }

    /**
     * choiceChecker method will check if the user imputed a valid guess ("higher" or "lower).
     * @param choice a string that represents the user's guess
     * @return a boolean that shows if the user entered a valid guess
     */
    public boolean choiceChecker(String choice){
        choice = choice.toLowerCase();
        if ((choice.contains("higher")) || (choice.contains("lower"))){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * betChecker method will check if the user imputed a valid bet that is not greater than the user's money.
     * @param bet a double that represents the user's bet
     * @return a boolean that shows if the user entered a valid bet
     */
    public boolean betChecker(double bet){
        if (bet < 0){
            return false;
        }
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

    /**
     * game method runs the game by checking if the user's guess is correct and decreases/increases the user's money accordingly.
     * @param choice a string that represents the user's guess
     * @param bet a double that represents the user's bet
     */
    public void game(String choice, double bet){
        String correct = "";
        diceRoll = rollDice();
        if (prev > diceRoll){
            correct = "lower";
        }
        else if (prev < diceRoll){
            correct = "higher";
        }
        else{
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

    /**
     * toString method returns a message which includes a visual representation of the dice roll, the value of the dice roll,
     * and if the users guessed correctly or incorrectly.
     * @return a string that includes information about the dice roll and the outcome of the guess
     */
    public String toString() {
        String gameMessage = printDice(d1) + "\n" + printDice(d2) + "\nDice Roll: " + diceRoll + "\n" + result + "\n" ;
        return gameMessage;
    }
}

