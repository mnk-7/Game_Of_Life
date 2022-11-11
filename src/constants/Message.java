package constants;

public class Message {

    public static final String MSG_WELCOME = "\nWelcome to Conway’s Game Of Life!";
    public static final String MSG_START = "\nThe game is launched!\n";
    public static final String MSG_END = "The end!";
    public static final String MSG_PERSONALIZED = createPersonalizedMsg();
    public static final String MSG_ROUNDS = "\nHow many rounds would you like to play?";
    public static final String MSG_ROUNDS_WRONG_NOT_NUMBER = "Wrong input, please enter a number:";
    public static final String MSG_ROUNDS_WRONG_NOT_POSITIVE = "Wrong input, please enter a number greater than 0:";
    public static final String MSG_CHAR_DIFFERENT = createCharsDifferentMsg();
    public static final String MSG_CHAR_DIFFERENT_WRONG = createCharsDifferentWrongMsg();
    public static final String MSG_FILE_PATH = "\nEnter file path:";
    public static final String MSG_GET_ALIVE_FILE = "\nEnter alive-character used in the file:";
    public static final String MSG_GET_DEAD_FILE = "\nEnter dead-character used in the file:";
    public static final String MSG_GET_ALIVE_DISPLAY = "\nEnter character for alive cell:";
    public static final String MSG_GET_DEAD_DISPLAY = "\nEnter character for dead cell:";
    public static final char CH_PERSONALIZED = 'M';
    public static final char CH_YES = 'Y';
    public static final char CH_NO = 'N';

    private static String createPersonalizedMsg() {
        return "Enter '" + CH_PERSONALIZED + "' to launch the game using your own core.board or any other " +
                "key to launch the game with default settings:";
    }

    private static String createCharsDifferentMsg() {
        return "\nWould you like to display different characters for alive and dead cells in the game? " + CH_YES + "/" + CH_NO;
    }

    private static String createCharsDifferentWrongMsg() {
        return "Incorrect input. Please enter '" + CH_YES + "' or '" + CH_NO + "':";
    }

}