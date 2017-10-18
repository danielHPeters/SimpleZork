package zork.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import zork.Command;
import zork.enums.EItem;
import zork.enums.EPreposition;
import zork.enums.EVerbs;

/**
 * This class contains parsing methods to handle user submitted input. Still
 * work in progress.
 *
 * @author d.peters
 * @version 1.0.1
 */
public class Parser {
  /**
   * Scanner to get user input from command line.
   */
  private Scanner scanner;

  /**
   * Default constructor. Sets the scanner which is passed down.
   *
   * @param scanner the command line scanner
   */
  public Parser(Scanner scanner) {
    this.scanner = scanner;
  }

  /**
   * Get the user input words and match them with enum constants. Saves all
   * commands in a queue and returns the queue to the caller
   *
   * @return a queue of parsed commands
   */
  public Queue<EVerbs> getCommand() {
    Queue<EVerbs> commands = new LinkedList<>();
    String[] foundWords = handleInput();

    for (String word : foundWords) {
      try {
        EVerbs value = EVerbs.valueOf(word);
        commands.add(value);
      } catch (IllegalArgumentException e) {
        // Handle not defined topics
        commands.add(EVerbs.UNDEFINED);
      }
    }

    return commands;
  }

  /**
   * Gets user input and turn all characters to uppercase for later checking
   * with enum constants Split up the words and save them in an array which
   * then is return to the caller.
   *
   * @return array of words submitted by the user
   */
  private String[] handleInput() {
    return scanner.nextLine().toUpperCase().split(" ");
  }

  /**
   * New unfinished method to parse more elaborate commands.
   *
   * @return parsed command
   */
  public Command parse() {
    String[] input = handleInput();

    Command comm;

    // Select different constructor  for command based on the number of words.
    switch (input.length) {
      case 1:
        comm = new Command(EVerbs.valueOf(input[0]));
        break;
      case 2:
        comm = new Command(EVerbs.valueOf(input[0]), EItem.valueOf(input[1]));
        break;
      case 4:
        comm = new Command(
            EVerbs.valueOf(input[0]),
            EItem.valueOf(input[1]),
            EPreposition.valueOf(input[2]),
            EItem.valueOf(input[3])
        );
        break;
      default:
        comm = null;
        break;
    }

    return comm;
  }
}
