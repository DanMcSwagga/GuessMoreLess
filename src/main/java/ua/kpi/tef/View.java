package ua.kpi.tef;

public class View {
    public static final String INTRO_ASCII_ART = "                                              /             \n" +
                                            " ___       ___  ___  ___       ___       _ _ (___  ___  ___ \n" +
                                            "|   )|   )|___)|___ |___      |   )|   )| | )|   )|___)|   )\n" +
                                            "|__/ |__/ |__   __/  __/      |  / |__/ |  / |__/ |__  |    \n" +
                                            "__/";
    public static final String INTRO_MESSAGE =  "Welcome to Guess Number - a fun game with numbers\n" +
                                                "Try to guess what number I've picked [%d to %d] ;) \n\n";
    public static final String USER_WON = "Congratulations, you've won! \n";
    public static final String INPUT_INT = "Input your integer guess: ";
    public static final String WRONG_INT_INPUT = "Aww shucks! It seems that your input was out of boundaries! \n" +
                                                 "Try again please. ";
    public static final String CURRENT_RANGE = "Attempt #%d. Current range -- [%d to %d]\n";
    public static final String PREVIOUS_RANGE = "Attempt #%d [%d to %d]\n";
    public static final String HISTORY_OF_TRIES = "Your history of tries: ";
    public static final String PREVIOUS_TRY = "Your previous try was -- ";


    /**
     * Prints a single message to the user
     * @param message one of the text constants used by a program.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints a message with <strong>two</strong> integers, passed as params
     * @param message to be outputted
     * @param firstValue first integer parameter
     * @param secondValue second integer parameter
     */
    public void printMessageAndTwoInts(String message, int firstValue, int secondValue) {
        System.out.format(message, firstValue, secondValue);
    }

    /**
     * Prints a message with <strong>three</strong> integers, passed as params (used in printing game range + attempts)
     * @param message to be outputted
     * @param firstValue first integer parameter (usually attempt of the user)
     * @param secondValue second integer parameter
     * @param thirdValue third integer parameter
     */
    public void printMessageAndThreeInts(String message, int firstValue, int secondValue, int thirdValue) {
        System.out.format(message, firstValue, secondValue, thirdValue);
    }
}
