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
     */
    public Parser() {

        this.scanner = new Scanner(System.in);

    }

    /**
     *
     * @return 
     */
    public Queue<ValidCommands> getCommand() {

        Queue<ValidCommands> commands = new LinkedList<>();
        String userCommand = scanner.nextLine().toUpperCase();
        String[] foundWords = userCommand.split(" ");

        for (String word : foundWords) {

            try {
                
                ValidCommands value = ValidCommands.valueOf(word);
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
