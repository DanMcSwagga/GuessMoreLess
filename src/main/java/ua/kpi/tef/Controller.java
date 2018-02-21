package ua.kpi.tef;

import java.util.Scanner;
import java.util.List;

public class Controller {

    public static final int MIN = 0;
    public static final int MAX = 100;
    public static final int LOWEST_INDEX = 0; // TODO use to display all the nodes
    private static int currentTry = 0;

    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public void startGame(){
        view.printMessage(View.INTRO_ASCII_ART);
        view.printMessageAndTwoInts(View.INTRO_MESSAGE, MIN, MAX);

        gameProcess();
        view.printMessage(View.USER_WON);

        outputHistoryOfTries();
    }

    private void gameProcess() {
        do {
            Scanner sc = new Scanner(System.in);

            model.addNodeToIntMap(model.rand(0, 100), model.rand(0, 100)); // TODO change later to actual range
            model.gameRange.get(currentTry).outputSingleNode(View.CURRENT_RANGE);

            model.setGuess(validateIntValue(sc)); // set current user guess

            currentTry++;

        } while (!model.getGameWon());
    }

    private void outputHistoryOfTries() {
        view.printMessage(View.HISTORY_OF_TRIES);
        for (; currentTry > LOWEST_INDEX; currentTry--) {
            model.gameRange.get(currentTry - 1).outputSingleNode(View.PREVIOUS_RANGE);
        }
    }

    private int validateIntValue(Scanner scanner) {
        view.printMessage(View.INPUT_INT);
        while(!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INT_INPUT + View.INPUT_INT);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
