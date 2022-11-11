package validators;

import exceptions.FileException;
import constants.Error;

import java.util.List;

public class FileValidator {

    public static void validateAliveAndDeadChars(char charForAlive, char charForDead) {
        if (charForAlive == charForDead) {
            throw new FileException(Error.FILE_WRONG_INPUT_CHARS);
        }
    }

    public static void validateRowsNumber(int rowsNumber) {
        if (rowsNumber == 0) {
            throw new FileException(Error.FILE_EMPTY);
        }
    }

    public static void validateColumnsNumber(List<String> lines) {
        int columnsNumber = lines.get(0).length();
        if (columnsNumber == 0) {
            throw new FileException(Error.FILE_EMPTY_COL);
        }
        for (String line : lines) {
            if (line.length() != columnsNumber) {
                throw new FileException(Error.FILE_WRONG_COL_NUM);
            }
        }
    }

    public static void validateChar(char charToBeChecked, char charForAlive, char charForDead) {
        if (charToBeChecked != charForAlive && charToBeChecked != charForDead) {
            throw new FileException(Error.FILE_WRONG_CHAR);
        }
    }

}