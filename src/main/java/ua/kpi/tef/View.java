package ua.kpi.tef;

public class View {
    public static final String ASCII_ART_INTRO =
            "                                              /             \n" +
            " ___       ___  ___  ___       ___       _ _ (___  ___  ___ \n" +
            "|   )|   )|___)|___ |___      |   )|   )| | )|   )|___)|   )\n" +
            "|__/ |__/ |__   __/  __/      |  / |__/ |  / |__/ |__  |    \n" +
            "__/\n";
    public static final String ASCII_ART_OUTRO =
            "     :\n" +
            " '.  _  .'\n" +
            "-<  (~)  >-   \n" +
            " .'  #  '.\n";
    public static final String INTRO_MESSAGE =  "***    Welcome to Guess Number! - a fun game with numbers  ***\n" +
                                                "***    Try to guess what number I've picked (%d to %d) ;)  ***\n\n";
    public static final String INPUT_INT = "Input your integer guess: ";
    public static final String WRONG_TYPE_INPUT = "Aww shucks! It seems that your input wasn't an integer! \n" +
                                                  "Try again please. ";
    public static final String WRONG_INPUT_INT_RANGE = "Oops! Seems like your input didn't fit the game range (%d to %d)!\n" +
                                                 "Try again please. ";
    public static final String CURRENT_RANGE_ATTEMPT = "Attempt #%d. Current range -- (%d to %d)\n";
    public static final String PREVIOUS_RANGE = "Attempt #%d (%d to %d)\n";
    public static final String PREVIOUS_TRY = "Previous try -- ";
    public static final String GUESS_WAS_LOWER = "Your guess was too low!\n";
    public static final String GUESS_WAS_HIGHER = "Your guess was too high!\n";
    public static final String USER_WON = "Congratulations, you won! \n";
    public static final String HISTORY_OF_TRIES = "***  Your history of tries:  ***";


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
}
