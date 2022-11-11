package service;

import constants.Error;
import exceptions.FileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileService {

    public static List<String> readFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new FileException(Error.FILE_PROCESSING);
        }
        return lines;
    }

}