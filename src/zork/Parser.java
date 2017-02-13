package zork;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
    public Queue<Command> getCommand() {

        Queue<Command> commands = new LinkedList<>();
        String userCommand = scanner.nextLine().toUpperCase();
        String[] foundWords = userCommand.split(" ");

        for (String word : foundWords) {

            try {
                
                Command value = Command.valueOf(word);
                commands.add(value);
                
            } catch (IllegalArgumentException e) {
                
            }

        }
        
        return commands;

    }

    /**
     *
     */
    public void parse() {

    }

}
