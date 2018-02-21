package ua.kpi.tef;

public class View {
    public static final String INTRO_ASCII_ART = "                                              /             \n" +
                                            " ___       ___  ___  ___       ___       _ _ (___  ___  ___ \n" +
                                            "|   )|   )|___)|___ |___      |   )|   )| | )|   )|___)|   )\n" +
                                            "|__/ |__/ |__   __/  __/      |  / |__/ |  / |__/ |__  |    \n" +
                                            "__/";
    public static final String INTRO_MESSAGE =  "Welcome to Guess Number - a fun game with numbers\n" +
                                                "Try to guess what number I've picked [%d to %d] ;)\n\n";
    public static final String USER_WON = "Congratulations, you've won!";
    public static final String INPUT_INT = "Input your INT guess: ";
    public static final String WRONG_INT_INPUT = "It seems that your input was out of boundaries.\n" +
                                                 "Try again please";
    public static final String CURRENT_RANGE = "Current range is [%d to %d]\n";
    public static final String PREVIOUS_RANGE = "Range was [%d to %d]\n";
    public static final String HISTORY_OF_TRIES = "Your history of tries";


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageWithInt(String message, int value) {
        System.out.println(message + value);
    }

    public void printMessageAndTwoInts(String message, int firstValue, int secondValue) {
        System.out.format(message, firstValue, secondValue);
    }
}
