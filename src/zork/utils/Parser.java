package zork.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import zork.enums.EVerbs;

/**
 *
 * @author d.peters
 */
public class Parser {

    /**
     *
     */
    public Scanner scanner;

    /**
     *
     * @param scanner
     */
    public Parser(Scanner scanner) {

        this.scanner = scanner;

    }

    /**
     *
     * @return
     */
    public Queue<EVerbs> getCommand() {

        Queue<EVerbs> commands = new LinkedList<>();
        String userCommand = scanner.nextLine().toUpperCase();
        String[] foundWords = userCommand.split(" ");

        for (String word : foundWords) {

            try {

                EVerbs value = EVerbs.valueOf(word);
                commands.add(value);

            } catch (IllegalArgumentException e) {
                commands.add(EVerbs.UNDEFINED);
            }

        }

        return commands;

    }

    /**
     *
     * @return
     */
    public String[] handleInput() {
        String userCommand = scanner.nextLine().toUpperCase();
        String[] foundWords = userCommand.split(" ");

        return foundWords;
    }

    public void parse() {
        String[] input = handleInput();

        
        try {
            
        } catch (IllegalArgumentException e) {
        }
    }

}
