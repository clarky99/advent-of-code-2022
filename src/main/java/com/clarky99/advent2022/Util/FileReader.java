package com.clarky99.advent2022.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.clarky99.advent2022.Util.Constants.FILE_PREFIX;

public class FileReader {

    public static String readFileAsString(String filePath){

        try {
            return new String(Files.readAllBytes(Paths.get(FILE_PREFIX + filePath)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
