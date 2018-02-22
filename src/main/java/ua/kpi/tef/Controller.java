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
        view.printMessage(View.ASCII_ART_INTRO);
        view.printMessageAndTwoInts(View.INTRO_MESSAGE, START_MIN, START_MAX);

        view.printMessage("*Psst!* Secret value is " + model.getNumber());

        gameProcess();
        view.printMessage(View.ASCII_ART_OUTRO);
        view.printMessage(View.USER_WON);

        outputHistoryOfTries();
    }

    /**
     * Describes the game's process (most of the game's logic and user interaction)
     */
    private void gameProcess() {
        Scanner sc = new Scanner(System.in);
        model.addNodeToIntMap(START_MIN, START_MAX);
        do {
            if (model.getCurrentTry() > 0) view.printMessage(View.PREVIOUS_TRY + model.getGuess());

            model.getGameRange().get(model.getCurrentTry()).outputSingleNode(View.CURRENT_RANGE_ATTEMPT, model.getCurrentTry());

            model.setGuess(validateInput(sc));

            model.changeGameStatus(view);
            model.incrementCurrentTry();
        } while (!model.getGameWon());
    }

    /**
     * Validates user's input.
     * 1st (outer) check - for invalid type of input
     * 2nd (inner) check - for invalid int boundaries (out of game range)
     * @param scanner simple text scanner which can parse primitive types and strings using regular expressions
     * @return validated and parsed user's integer input
     */
    private int validateInput(Scanner scanner) {
        view.printMessage(View.INPUT_INT);

        boolean incorrectInput = true;
        int userGuess = -1;

        while (incorrectInput) {
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();

                if (!model.fitsRange(userGuess)) {
                    view.printMessageAndTwoInts(View.WRONG_INPUT_INT_RANGE,
                            model.getGameRange().get(model.getCurrentTry()).getMin(),
                            model.getGameRange().get(model.getCurrentTry()).getMax());
                    view.printMessage(View.INPUT_INT);
                } else {
                    incorrectInput = false;
                }
            } else {
                scanner.next();
                view.printMessage(View.WRONG_TYPE_INPUT + View.INPUT_INT);
            }
        }

        return userGuess;
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
}
