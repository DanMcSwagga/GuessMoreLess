package ua.kpi.tef;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final int generatedNumber; // TODO make final later?
    private int guessedNumber;
    private boolean gameWon;
    public List<IntMap> gameRange;

    Model() {
        this.generatedNumber = rand(Controller.MIN, Controller.MAX);
        this.guessedNumber = 0;
        this.gameWon = false;
        this.gameRange = new ArrayList<IntMap>();
    }

    /**
     * Getters
     */
    public int getGuess() {
        return guessedNumber;
    }
    public int getGeneratedNumber() {
        return generatedNumber;
    }
    public boolean getGameWon() {
        return gameWon;
    }
    public List<IntMap> getGameRange() {
        return gameRange;
    }

    /**
     * Setters
     */
    public void setGuess(int value) {
        this.guessedNumber = value;
    }
    // TODO use later when give private to gameRange
    public void setGameRange(List<IntMap> gameRange) {
        this.gameRange = gameRange;
    }


    public void addNodeToIntMap(int firstValue, int secondValue) {
        this.gameRange.add(new IntMap(firstValue, secondValue));
    }

    /**
     * Map stuff
     */
    public class IntMap {
        int min;
        int max;

        IntMap(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public void outputSingleNode(String message) {
            System.out.format(message, this.min, this.max);
        }
    }

    /**
     * Utilities
     */
    public int rand(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public int rand() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }


}

