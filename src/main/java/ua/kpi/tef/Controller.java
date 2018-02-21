package ua.kpi.tef;

import java.util.Scanner;

public class Controller {

    public static final int START_MIN = 0;
    public static final int START_MAX = 100;
    private static final int LOWEST_INDEX = 0;

    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     * Creates a single instance of the game
     */
    public void startGame(){
        view.printMessage(View.INTRO_ASCII_ART);
        view.printMessageAndTwoInts(View.INTRO_MESSAGE, START_MIN, START_MAX);

        //TODO clear later -- testing purposes only
        System.out.println(" --- Psst. Your hidden number is " + model.getNumber() + ". Don't tell anyone --- ");

        gameProcess();
        view.printMessage(View.USER_WON);

        outputHistoryOfTries();
    }

    /**
     * Describes the game's process (most of the game's logic and user interaction)
     */
    private void gameProcess() {
        model.addNodeToIntMap(START_MIN, START_MAX);
        do {
            if (model.getCurrentTry() > 0) view.printMessage(View.PREVIOUS_TRY + model.getGuess());
            Scanner sc = new Scanner(System.in);

            model.getGameRange().get(model.getCurrentTry()).outputSingleNode(View.CURRENT_RANGE, model.getCurrentTry());

            model.setGuess(validateInputInt(sc));
            changeGameRangeWithUserInput();

            model.incrementCurrentTry();
        } while (!model.getGameWon());
    }

    /**
     * Changes the game's range via user's <strong>validated</strong> integer input
     */
    private void changeGameRangeWithUserInput() {
        if (model.getGuess() < model.getNumber()) {
            model.getGameRange().get(model.getCurrentTry()).min = model.getGuess();
            model.addNodeToIntMap(model.getGuess(), model.getGameRange().get(model.getCurrentTry()).max);
        } else if (model.getGuess() > model.getNumber()) {
            model.getGameRange().get(model.getCurrentTry()).max = model.getGuess();
            model.addNodeToIntMap(model.getGameRange().get(model.getCurrentTry()).min, model.getGuess());
        } else {
            model.setGameWon(true);
        }
    }

    /**
     * Outputs a history of user's attempts (tries) by iterating with current try
     * and outputting a single node each iteration
     */
    private void outputHistoryOfTries() {
        view.printMessage(View.HISTORY_OF_TRIES);
        for (; model.getCurrentTry() > LOWEST_INDEX; model.decrementCurrentTry()) {
            model.getGameRange().get(model.getCurrentTry() - 1).outputSingleNode(View.PREVIOUS_RANGE, model.getCurrentTry() - 1);
        }
    }

    /**
     * Validates user's integer input
     * @param scanner simple text scanner which can parse primitive types and strings using regular expressions
     * @return validated and parsed user's integer input
     */
    private int validateInputInt(Scanner scanner) {
        view.printMessage(View.INPUT_INT);
        while(!scanner.hasNextInt()) {

            view.printMessage(View.WRONG_INT_INPUT + View.INPUT_INT);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
