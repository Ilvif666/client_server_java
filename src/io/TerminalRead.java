/**
 * Считывает комманды из терминала
 */

package io;

import java.util.Scanner;


public class TerminalRead implements io.IOInterface {
    private String currentInput;

    @Override
    public String getNextInput() {
        Scanner terminal = new Scanner(System.in);
        currentInput = terminal.nextLine();
        return currentInput;
    }

}
