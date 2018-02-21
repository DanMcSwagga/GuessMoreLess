package ua.kpi.tef;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final int generatedNumber;
    private int guessedNumber;
    private boolean bGameIsWon;
    private List<IntMap> gameRange;
    private static int currentTry;

    Model() {
        this.generatedNumber = rand(Controller.START_MIN, Controller.START_MAX);
        this.guessedNumber = 0;
        this.bGameIsWon = false;
        this.gameRange = new ArrayList<IntMap>();
        currentTry = 0;
    }

    /**
     * Basic getters which return values of all of the model's components
     */
    public int          getGuess() { return guessedNumber; }
    public int          getNumber() { return generatedNumber; }
    public int          getCurrentTry() { return currentTry; }
    public boolean      getGameWon() { return bGameIsWon; }
    public List<IntMap> getGameRange() { return gameRange; }

    /**
     * Basic setters which set values of user's guess and game's status
     */
    public void setGuess(int value) { this.guessedNumber = value; }
    public void setGameWon(boolean value) { this.bGameIsWon = value; }

    public void incrementCurrentTry() { currentTry++; }
    public void decrementCurrentTry() { currentTry--; }

    /**
     * Generate pseudo-random integer value within the game range, described via params
     * @param min lower limit
     * @param max higher limit
     * @return pseudo-random integer within the game range
     */
    private int rand(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
    /**
     * @deprecated Same method as the one before it, but takes in no params and is generated within [0 to MAX_RAND]
     * @return pseudo-random integer within the [0 to MAX_RAND]
     */
    private int rand() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }

    /**
     * Adds a node to the List of Integer Pairs, which set the game range
     * @param firstValue minimum value of game range
     * @param secondValue maximum value of game range
     */
    public void addNodeToIntMap(int firstValue, int secondValue) {
        this.gameRange.add(new IntMap(firstValue, secondValue));
    }
}

