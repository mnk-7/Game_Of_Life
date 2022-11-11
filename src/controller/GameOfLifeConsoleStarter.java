package controller;

import constants.Default;
import constants.Message;

import java.util.Scanner;

public class GameOfLifeConsoleStarter implements ConsoleStarter {

    private String filePath;
    private char aliveCharInFile;
    private char deadCharInFile;
    private char aliveCharDisplayed;
    private char deadCharDisplayed;
    private int rounds;

    public String getFilePath() {
        return filePath;
    }

    public char getAliveCharInFile() {
        return aliveCharInFile;
    }

    public char getDeadCharInFile() {
        return deadCharInFile;
    }

    public char getAliveCharDisplayed() {
        return aliveCharDisplayed;
    }

    public char getDeadCharDisplayed() {
        return deadCharDisplayed;
    }

    public int getRounds() {
        return rounds;
    }

    @Override
    public void startInteraction() {
        initializeStartData(usePersonalizedData());
    }

    private boolean usePersonalizedData(){
        System.out.println(Message.MSG_WELCOME);
        System.out.println(Message.MSG_PERSONALIZED);
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().toUpperCase().charAt(0);
        return choice == Message.CH_PERSONALIZED;
    }

    private void initializeStartData(boolean usePersonalizedData){
        if (usePersonalizedData){
            rounds = determineNumberOfRounds();
            filePath = gatherFilePath();
            char[] chars = gatherCharacters();
            aliveCharInFile = chars[0];
            deadCharInFile = chars[1];
            aliveCharDisplayed = chars[2];
            deadCharDisplayed = chars[3];
        } else {
            rounds = Default.ROUNDS;
            filePath = Default.PATH;
            aliveCharInFile = Default.FILE_ALIVE_CHAR;
            deadCharInFile = Default.FILE_DEAD_CHAR;
            aliveCharDisplayed = Default.DISPLAYED_ALIVE_CHAR;
            deadCharDisplayed = Default.DISPLAYED_DEAD_CHAR;
        }
    }

    private int determineNumberOfRounds(){
        System.out.println(Message.MSG_ROUNDS);
        Scanner scanner = new Scanner(System.in);
        int rounds;
        do {
            while (!scanner.hasNextInt()){
                System.out.println(Message.MSG_ROUNDS_WRONG_NOT_NUMBER);
                scanner = new Scanner(System.in);
            }
            rounds = scanner.nextInt();
            if (rounds <= 0) {
                System.out.println(Message.MSG_ROUNDS_WRONG_NOT_POSITIVE);
            }
        } while (rounds <= 0);
        return rounds;
    }

    private String gatherFilePath(){
        System.out.println(Message.MSG_FILE_PATH);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private char[] gatherCharacters(){
        char[] charsInFile = gatherCharsUsedInFile();
        char[] charsToBeUsed;
        if (shouldDifferentCharsBeDisplayed()){
            charsToBeUsed = gatherCharsToBeDisplayed();
        } else {
            charsToBeUsed = new char[]{charsInFile[0], charsInFile[1]};
        }
        return new char[]{charsInFile[0], charsInFile[1], charsToBeUsed[0], charsToBeUsed[1]};
    }

    private char[] gatherCharsUsedInFile(){
        System.out.println(Message.MSG_GET_ALIVE_FILE);
        Scanner scanner = new Scanner(System.in);
        char fileAlive = scanner.next().charAt(0);

        System.out.println(Message.MSG_GET_DEAD_FILE);
        scanner = new Scanner(System.in);
        char fileDead = scanner.next().charAt(0);
        return new char[]{fileAlive, fileDead};
    }

    private boolean shouldDifferentCharsBeDisplayed(){
        System.out.println(Message.MSG_CHAR_DIFFERENT);
        Scanner scanner;
        char tempChar;
        do {
            scanner = new Scanner(System.in);
            tempChar = scanner.next().toUpperCase().charAt(0);
            if (tempChar != Message.CH_YES && tempChar != Message.CH_NO){
                System.out.println(Message.MSG_CHAR_DIFFERENT_WRONG);
            }
        } while (tempChar != Message.CH_YES && tempChar != Message.CH_NO);
        return tempChar == Message.CH_YES;
    }

    private char[] gatherCharsToBeDisplayed(){
        System.out.println(Message.MSG_GET_ALIVE_DISPLAY);
        Scanner scanner = new Scanner(System.in);
        char displayAlive = scanner.next().charAt(0);

        System.out.println(Message.MSG_GET_DEAD_DISPLAY);
        scanner = new Scanner(System.in);
        char displayDead = scanner.next().charAt(0);

        return new char[]{displayAlive, displayDead};
    }

}