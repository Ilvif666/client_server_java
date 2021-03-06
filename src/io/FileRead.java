/**
 * Считывает команды из файла
 */

package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileRead implements IOInterface {

    private Scanner input;
    private String fileLine;

    /**
     *
     * @param fileName имя файла из которого производится чтение
     */
    public void FileInput(String fileName) throws FileNotFoundException {
        this.input = new Scanner(new File(fileName));
    }

    @Override
    public String getNextInput() {
        if (input.hasNext()) {
            fileLine = input.nextLine().toLowerCase();
            return fileLine;
        } else
            return null;
    }

    public String getFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}



